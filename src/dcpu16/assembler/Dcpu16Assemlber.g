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

import dcpu16.common.InstructionValue;
import dcpu16.common.Opcode;
}
@lexer::header{
package dcpu16.assembler;
}
@members {
/* Map label name to Integer */
Map<String,Integer> identifiedLabels = new HashMap<String,Integer>();
Map<String,Integer> unidentifiedLabels = new HashMap<String,Integer>();
Map<Integer,String> unidentifiedLabelsReverse = new HashMap<Integer,String>();

/* Use negative numbers for unidentified labels */
final int UNKOWN_LABEL_START_INDEX = -1;
int unknownLabelPlaceholder = UNKOWN_LABEL_START_INDEX;

private int getNewLabelPlaceHolder() {
    int temp = unknownLabelPlaceholder;
    unknownLabelPlaceholder--;
    return temp;
}

/* For the label value */
int wordCount = 0;
}


/* ########## Parser section ########## */

assembler_file returns [byte[\] binaryOutput]
    :   s=statements EOF
            {
                binaryOutput = new byte[s.size() * 2];
                
                /* Fix unidentified labels */
                for(int i = 0; i < s.size(); i++) {
                    int value = s.get(i);
                    int realValue;
                    if(value < 0) {
                        if(!unidentifiedLabelsReverse.containsKey(value)) {
                            throw new RuntimeException("Word value '"+ value +"' is not a valid value and is not a valid 'label placeholder', SHOULD NEVER HAPPEN!");
                        }
                        String labelName = unidentifiedLabelsReverse.get(value);
                        realValue = identifiedLabels.get(labelName);
                        System.err.println("Replacing value for "+ labelName +" from "+ value +" to "+ realValue +".");
                    }
                    else if(value > 0xFFFF) {
                        throw new RuntimeException("Word value '"+ value +"' exceeds maximum of '"+ 0xFFFF +"', SHOULD NEVER HAPPEN!");
                    }
                    else {
                        realValue = value;
                    }
                    
                    //Convert 'unsigned short' values to a Big-endian byte array.
                    byte[] output = new byte[ input.size() * 2 ];
                    binaryOutput[(i * 2)] = (byte)((realValue & 0xFF00) >> 8);
                    binaryOutput[(i * 2) + 1] = (byte)(realValue & 0x00FF);
                }
            }
    ;

statements returns [List<Integer> valueList]
            @init {
                valueList = new ArrayList<Integer>();
            }
    :   (s1=statement { valueList.addAll(s1); } NEWLINE | WS? NEWLINE)+ s2=statement? { valueList.addAll(s2); }
    ;

statement returns [List<Integer> valueList]
    :   WS? (label_declaration WS (NEWLINE+ WS)*)? opList=operation WS?
            {
                valueList = opList;
                wordCount += opList.size();
            }
    ;
    
operation returns [List<Integer> valueList]
            @init {
                valueList = new ArrayList<Integer>();
            }
    :   basic_operation_code WS ov1=operation_value COMMA WS? ov2=operation_value
            {
                int opcode = Opcode.valueOf($basic_operation_code.text).code;
                int opvalue1 = ov1.get(0);
                int opvalue2 = ov2.get(0);
                
                //Some assertions
                if(opcode > 0xF) {
                    throw new RuntimeException("Opcode bigger than "+ 0xF +", SHOULD NEVER HAPPEN!");
                }
                else if(opvalue1 > 0x3F) {
                    throw new RuntimeException("Opvalue1 bigger than "+ 0x3F +", SHOULD NEVER HAPPEN!");
                }
                else if(opvalue2 > 0x3F) {
                    throw new RuntimeException("Opvalue2 bigger than "+ 0x3F +", SHOULD NEVER HAPPEN!");
                }
                opvalue1 = opvalue1 << 4;
                opvalue2 = opvalue2 << 10;
                int operation = opcode + opvalue1 + opvalue2;
                valueList.add(operation);
                
                //Add remaining 'next word' values.
                for(int i = 1; i < ov1.size(); i++) {
                    valueList.add(ov1.get(i));
                }
                for(int i = 1; i < ov2.size(); i++) {
                    valueList.add(ov2.get(i));
                }
            }
    |   non_basic_operation_code WS ov=operation_value
            {
                int opcode = Opcode.valueOf($non_basic_operation_code.text).code;
                int opvalue = ov.get(0);
                
                //Some assertions
                if(opcode > 0x3FF) {
                    throw new RuntimeException("Opcode bigger than "+ 0x3FF +" (in non-basic operation), SHOULD NEVER HAPPEN!");
                }
                else if(opvalue > 0x3F) {
                    throw new RuntimeException("Opvalue1 bigger than "+ 0x3F +" (in non-basic operation), SHOULD NEVER HAPPEN!");
                }
                
                opvalue = opvalue << 10;
                int operation = opcode + opvalue;
                valueList.add(operation);
                
                //Add remaining 'next word' values.
                for(int i = 1; i < ov.size(); i++) {
                    valueList.add(ov.get(i));
                }
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

operation_value returns [List<Integer> valueList]
            @init {
                valueList = new ArrayList<Integer>();
            }
    :   e1=register
            {
                valueList.add(e1.code);
            }
    |   e2=dereferenced_register
            {
                valueList.add(e2.code);
            }
    |   e3=dereferenced_register_with_offset
            {
                valueList.add(e3[0]);
                valueList.add(e3[1]);
            }
    |   e4=literal_value
            {
                if(e4 < 0) {
                    throw new RuntimeException("Negative literal value");
                }
                else if(e4 <= 0x1f) {
                    valueList.add(e4 + InstructionValue.LITERAL_OFFSET.code);
                }
                else {
                    valueList.add(InstructionValue.NEXT_WORD.code);
                    valueList.add(e4);
                }
            }
    |   e5=dereferenced_literal_value
            {
                if(e5 < 0) {
                    throw new RuntimeException("Negative dererenced literal value");
                }
                else {
                    valueList.add(InstructionValue.NEXT_WORD_DEREF.code);
                    valueList.add(e5);
                }
            }
    |   LABEL_IDENTIFIER
            {
                valueList.add(InstructionValue.NEXT_WORD.code);
                
                String labelName = $LABEL_IDENTIFIER.text;
                if(identifiedLabels.containsKey(labelName)) {
                    valueList.add(identifiedLabels.get(labelName));
                }
                else if(unidentifiedLabels.containsKey(labelName)) {
                    valueList.add(unidentifiedLabels.get(labelName));
                }
                else {
                    int placeHolder = getNewLabelPlaceHolder();
                    unidentifiedLabels.put(labelName, placeHolder);
                    unidentifiedLabelsReverse.put(placeHolder, labelName);
                    valueList.add(placeHolder);
                    System.err.println("Assigning placeholder '"+ placeHolder +"' to "+ labelName);
                }
            }
    ;

dereferenced_register returns [InstructionValue value]
    :   LEFT_BLOCK_PARENTHESES e=dereferencable_register RIGHT_BLOCK_PARENTHESES
            {
                $value = InstructionValue.getDerefOf(e);
            }
    ;

dereferenced_register_with_offset returns [int[\] values]
    :   LEFT_BLOCK_PARENTHESES e1=literal_value PLUS e2=dereferencable_register RIGHT_BLOCK_PARENTHESES
            {
                $values = new int[2];
                $values[0] = InstructionValue.getRegPlusNextWordDerefOf(e2).code;
                $values[1] = e1;
            }
    ;

register returns [InstructionValue value]
    :   e=dereferencable_register { $value = e; }
    |   POP { $value = InstructionValue.valueOf($POP.text); }
    |   PEEK { $value = InstructionValue.valueOf($PEEK.text); }
    |   PUSH { $value = InstructionValue.valueOf($PUSH.text); }
    |   SP { $value = InstructionValue.valueOf($SP.text); }
    |   PC { $value = InstructionValue.valueOf($PC.text); }
    |   O { $value = InstructionValue.valueOf($O.text); }
    ;

dereferencable_register returns [InstructionValue value]
    :   A { $value = InstructionValue.valueOf($A.text); }
    |   B { $value = InstructionValue.valueOf($B.text); }
    |   C { $value = InstructionValue.valueOf($C.text); }
    |   X { $value = InstructionValue.valueOf($X.text); }
    |   Y { $value = InstructionValue.valueOf($Y.text); }
    |   Z { $value = InstructionValue.valueOf($Z.text); }
    |   I { $value = InstructionValue.valueOf($I.text); }
    |   J { $value = InstructionValue.valueOf($J.text); }
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

label_declaration
    :   LABEL_DECLARATION
            {
                String labelName = $LABEL_DECLARATION.text.substring(1);
                if(identifiedLabels.containsKey(labelName)) {
                    throw new RuntimeException("Label name '"+ labelName +"' already declared.");
                }
                identifiedLabels.put(labelName, wordCount);
                System.err.println("Assigning '"+ wordCount +"' to labelname '"+ labelName +"'.");
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
    