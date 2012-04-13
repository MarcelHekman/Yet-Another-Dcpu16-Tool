grammar Dcpu16Assemlber;

options {
  language = Java;
}

tokens {
    //Instructions
    SET='SET';
    ADD='ADD';
    SUB='SUB';
    MUL='MUL';
    DIV='DIV';
    MOD='MOD';
    SHL='SHL';
    SHR='SHR';
    AND='AND';
    BOR='BOR';
    XOR='XOR';
    IFE='IFE';
    IFN='IFN';
    IFG='IFG';
    IFB='IFB';
    JSR='JSR';
    
    //Register names
    A='A';
    B='B';
    C='C';
    X='X';
    Y='Y';
    Z='Z';
    I='I';
    J='J';
    POP='POP';
    PEEK='PEEK';
    PUSH='PUSH';
    SP='SP';
    PC='PC';
    O='O';
}

@header {
package dcpu16.assembler;

import java.util.HashMap;
import java.util.Map;

import dcpu16.common.OpCode;
import dcpu16.common.Operation;
import dcpu16.common.OperationValue;
import dcpu16.common.OpValueCode;
} 
@lexer::header{
package dcpu16.assembler;
}
@members {
/* Map label name to OperationValue */
Map<String,OperationValue> unidentifiedLabels = new HashMap<String,OperationValue>();
Map<String,OperationValue> identifiedLabels = new HashMap<String,OperationValue>();
Map<String,Operation> labelOperationMap = new HashMap<String,Operation>();

/* For the label value */
int wordCount = 0;
}


/* ########## Parser section ########## */

assembler_file returns [List<Operation> outputList]
    :   stmts=statements EOF
            {
                //Determine the real values of the labels (somewhat complicated to use short form labels)
                boolean needsLabelSizeCheck = true;
                while(needsLabelSizeCheck) {
                    needsLabelSizeCheck = false;
                    int currentWordCount = 0;
                    for(Operation stmt : stmts) {
                        if(stmt.hasLabel()) {
                            String label = stmt.getLabel();
                            OperationValue operationValue = identifiedLabels.get(label);
                            int labelAdressValue = operationValue.getLiteral();
                            if(labelAdressValue != currentWordCount) {
                                System.err.println("Adjusting label: "+ label +" from "+ labelAdressValue +" to "+ currentWordCount);
                                if(labelAdressValue < OpValueCode.LITERAL_OFFSET.code) {
                                    operationValue.set(OpValueCode.LITERAL_OFFSET, currentWordCount);
                                }
                                else {
                                    operationValue.set(OpValueCode.NEXT_WORD, currentWordCount);
                                }
                                needsLabelSizeCheck = true;
                            }
                        }
                        currentWordCount += stmt.wordCount();
                    }
                }
                outputList = stmts;
            }
    ;

statements returns [List<Operation> valueList]
            @init {
                valueList = new ArrayList<Operation>();
            }
    :   (s1=statement { valueList.add(s1); } NEWLINE | WS? NEWLINE)+ s2=statement? { valueList.add(s2); }
    ;

statement returns [Operation value]
    :   WS? (lbl=label_declaration WS (NEWLINE+ WS)*)? op=operation WS?
            {
                if(lbl != null) {
                    op.setLabel(lbl);
                    labelOperationMap.put(lbl, op); 
                }
                value = op;
                wordCount += op.wordCount();
            }
    ;
    
operation returns [Operation value]
    :   basic_operation_code WS ov1=operation_value COMMA WS? ov2=operation_value
            {
                OpCode opcode = OpCode.valueOf($basic_operation_code.text);
                OperationValue opvalue1 = ov1;
                OperationValue opvalue2 = ov2;
                
                //Some assertions
                if(opcode.code > OpCode.BIT_MASK_BASIC) {
                    throw new RuntimeException("Opcode bigger than "+ OpCode.BIT_MASK_BASIC +", SHOULD NEVER HAPPEN!");
                }
                else if(opvalue1.getOpvalCode().code > OpValueCode.BIT_MASK) {
                    throw new RuntimeException("Opvalue1 bigger than "+ OpValueCode.BIT_MASK +", SHOULD NEVER HAPPEN!");
                }
                else if(opvalue2.getOpvalCode().code > OpValueCode.BIT_MASK) {
                    throw new RuntimeException("Opvalue2 bigger than "+ OpValueCode.BIT_MASK +", SHOULD NEVER HAPPEN!");
                }
                value = new Operation(opcode, opvalue1, opvalue2);
            }
    |   non_basic_operation_code WS ov=operation_value
            {
                OpCode opcode = OpCode.valueOf($non_basic_operation_code.text);
                OperationValue opvalue = ov;
                
                //Some assertions
                if(opcode.code > OpCode.BIT_MASK_NON_BASIC) {
                    throw new RuntimeException("Opcode bigger than "+ OpCode.BIT_MASK_NON_BASIC +" (in non-basic operation), SHOULD NEVER HAPPEN!");
                }
                else if(opvalue.getOpvalCode().code > OpValueCode.BIT_MASK) {
                    throw new RuntimeException("Opvalue1 bigger than "+ OpValueCode.BIT_MASK +" (in non-basic operation), SHOULD NEVER HAPPEN!");
                }
                value = new Operation(opcode, opvalue);
            }
    ;

basic_operation_code
    :   SET
    |   ADD
    |   SUB
    |   MUL
    |   DIV
    |   MOD
    |   SHL
    |   SHR
    |   AND
    |   BOR
    |   XOR
    |   IFE
    |   IFN
    |   IFG
    |   IFB
    ;

non_basic_operation_code
    :   JSR
    ;

operation_value returns [OperationValue value]
    :   e1=register
            {
                value = new OperationValue(e1);
            }
    |   e2=dereferenced_register
            {
                value = new OperationValue(e2);
            }
    |   e3=dereferenced_register_with_offset
            {
                value = e3;
            }
    |   e4=literal_value
            {
                if(e4 < 0) {
                    throw new RuntimeException("Negative literal value");
                }
                else if(e4 <= 0x1f) {
                    value = new OperationValue(OpValueCode.LITERAL_OFFSET, e4);
                }
                else {
                    value = new OperationValue(OpValueCode.NEXT_WORD, e4);
                }
            }
    |   e5=dereferenced_literal_value
            {
                if(e5 < 0) {
                    throw new RuntimeException("Negative dererenced literal value");
                }
                else {
                    value = new OperationValue(OpValueCode.NEXT_WORD_DEREF, e5);
                }
            }
    |   LABEL_IDENTIFIER
            {
                String labelName = $LABEL_IDENTIFIER.text;
                if(identifiedLabels.containsKey(labelName)) {
                    value = identifiedLabels.get(labelName);
                }
                else if(unidentifiedLabels.containsKey(labelName)) {
                    value = unidentifiedLabels.get(labelName);
                }
                else {
                    //Place holder
                    value = new OperationValue(OpValueCode.LITERAL_OFFSET, 0);
                    unidentifiedLabels.put(labelName, value);
                }
            }
    ;

dereferenced_register returns [OpValueCode value]
    :   LEFT_BLOCK_PARENTHESES e=dereferencable_register RIGHT_BLOCK_PARENTHESES
            {
                $value = OpValueCode.getDerefOf(e);
            }
    ;

dereferenced_register_with_offset returns [OperationValue value]
    :   LEFT_BLOCK_PARENTHESES e1=literal_value PLUS e2=dereferencable_register RIGHT_BLOCK_PARENTHESES
            {
                $value = new OperationValue(OpValueCode.getRegPlusNextWordDerefOf(e2), e1);
            }
    ;

register returns [OpValueCode value]
    :   e=dereferencable_register { $value = e; }
    |   POP { $value = OpValueCode.valueOf($POP.text); }
    |   PEEK { $value = OpValueCode.valueOf($PEEK.text); }
    |   PUSH { $value = OpValueCode.valueOf($PUSH.text); }
    |   SP { $value = OpValueCode.valueOf($SP.text); }
    |   PC { $value = OpValueCode.valueOf($PC.text); }
    |   O { $value = OpValueCode.valueOf($O.text); }
    ;

dereferencable_register returns [OpValueCode value]
    :   A { $value = OpValueCode.valueOf($A.text); }
    |   B { $value = OpValueCode.valueOf($B.text); }
    |   C { $value = OpValueCode.valueOf($C.text); }
    |   X { $value = OpValueCode.valueOf($X.text); }
    |   Y { $value = OpValueCode.valueOf($Y.text); }
    |   Z { $value = OpValueCode.valueOf($Z.text); }
    |   I { $value = OpValueCode.valueOf($I.text); }
    |   J { $value = OpValueCode.valueOf($J.text); }
    ;
    
dereferenced_literal_value returns [int value]
    :   LEFT_BLOCK_PARENTHESES e=literal_value RIGHT_BLOCK_PARENTHESES
            {
                $value = e;
            }
    ;

literal_value returns [int value]
    :   HEX_NUMBER
            {
                $value = Integer.parseInt($HEX_NUMBER.text.substring(2), 16);
            }
    |   DEC_NUMBER
            {
                $value = Integer.parseInt($DEC_NUMBER.text);
            }
    ;

label_declaration returns [String value]
    :   LABEL_DECLARATION
            {
                String labelName = $LABEL_DECLARATION.text.substring(1);
                OperationValue operationValue;
                if(identifiedLabels.containsKey(labelName)) {
                    throw new RuntimeException("Label name '"+ labelName +"' already declared.");
                }
                
                //Determine short form or long form label values
                OpValueCode ovc;
                if(wordCount < OpValueCode.LITERAL_OFFSET.code) {
                    ovc = OpValueCode.LITERAL_OFFSET;
                }
                else {
                    ovc = OpValueCode.NEXT_WORD;
                }
                
                if(unidentifiedLabels.containsKey(labelName)) {
                    operationValue = unidentifiedLabels.get(labelName);
                    operationValue.set(ovc, 0);
                    unidentifiedLabels.remove(labelName);
                }
                else {
                    operationValue = new OperationValue(ovc, 0);
                }
                identifiedLabels.put(labelName, operationValue);
                value = labelName;
                //System.err.println("Assigning '"+ wordCount +"' to label '"+ labelName +"'.");
            }
    ;

/* ########## Lexer section ########## */

HEX_NUMBER
    :   '0x' ('0'..'9'|'A'..'F')+
    ;

DEC_NUMBER
    :   ('0'..'9') ('0'..'9')*
    ;

MULTI_LINE_COMMENT
    :   '/*'
        (options {greedy=false;} : . )*
        '*/'
            {
                skip();
            }
    ;

LINE_COMMENT
    :   ('//'|';'|'#') ~('\n'|'\r')*
            {
                skip();
            }
    ;

LEFT_BLOCK_PARENTHESES
    :   '['
    ;

RIGHT_BLOCK_PARENTHESES
    :   ']'
    ;

COMMA
    :   ','
    ;

PLUS
    :   '+'
    ;
    
NEWLINE
    :   ('\r\n'|'\r'|'\n')
    ;

WS
    :   (' '|'\t')+
    ;
    
LABEL_DECLARATION
    :   ':' LABEL_IDENTIFIER
    ;

LABEL_IDENTIFIER
    :   ('a'..'z')+
    ;
    