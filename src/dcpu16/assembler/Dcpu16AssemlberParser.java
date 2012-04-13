// $ANTLR 3.4 E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g 2012-04-13 02:01:08

package dcpu16.assembler;

import java.util.HashMap;
import java.util.Map;

import dcpu16.common.OpCode;
import dcpu16.common.Operation;
import dcpu16.common.OperationValue;
import dcpu16.common.OpValueCode;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Dcpu16AssemlberParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "A", "ADD", "AND", "B", "BOR", "C", "COMMA", "DEC_NUMBER", "DIV", "HEX_NUMBER", "I", "IFB", "IFE", "IFG", "IFN", "J", "JSR", "LABEL_DECLARATION", "LABEL_IDENTIFIER", "LEFT_BLOCK_PARENTHESES", "LINE_COMMENT", "MOD", "MUL", "MULTI_LINE_COMMENT", "NEWLINE", "O", "PC", "PEEK", "PLUS", "POP", "PUSH", "RIGHT_BLOCK_PARENTHESES", "SET", "SHL", "SHR", "SP", "SUB", "WS", "X", "XOR", "Y", "Z"
    };

    public static final int EOF=-1;
    public static final int A=4;
    public static final int ADD=5;
    public static final int AND=6;
    public static final int B=7;
    public static final int BOR=8;
    public static final int C=9;
    public static final int COMMA=10;
    public static final int DEC_NUMBER=11;
    public static final int DIV=12;
    public static final int HEX_NUMBER=13;
    public static final int I=14;
    public static final int IFB=15;
    public static final int IFE=16;
    public static final int IFG=17;
    public static final int IFN=18;
    public static final int J=19;
    public static final int JSR=20;
    public static final int LABEL_DECLARATION=21;
    public static final int LABEL_IDENTIFIER=22;
    public static final int LEFT_BLOCK_PARENTHESES=23;
    public static final int LINE_COMMENT=24;
    public static final int MOD=25;
    public static final int MUL=26;
    public static final int MULTI_LINE_COMMENT=27;
    public static final int NEWLINE=28;
    public static final int O=29;
    public static final int PC=30;
    public static final int PEEK=31;
    public static final int PLUS=32;
    public static final int POP=33;
    public static final int PUSH=34;
    public static final int RIGHT_BLOCK_PARENTHESES=35;
    public static final int SET=36;
    public static final int SHL=37;
    public static final int SHR=38;
    public static final int SP=39;
    public static final int SUB=40;
    public static final int WS=41;
    public static final int X=42;
    public static final int XOR=43;
    public static final int Y=44;
    public static final int Z=45;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public Dcpu16AssemlberParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public Dcpu16AssemlberParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return Dcpu16AssemlberParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g"; }


    /* Map label name to OperationValue */
    Map<String,OperationValue> unidentifiedLabels = new HashMap<String,OperationValue>();
    Map<String,OperationValue> identifiedLabels = new HashMap<String,OperationValue>();
    Map<String,Operation> labelOperationMap = new HashMap<String,Operation>();

    /* For the label value */
    int wordCount = 0;



    // $ANTLR start "assembler_file"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:70:1: assembler_file returns [List<Operation> outputList] : stmts= statements EOF ;
    public final List<Operation> assembler_file() throws RecognitionException {
        List<Operation> outputList = null;


        List<Operation> stmts =null;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:71:5: (stmts= statements EOF )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:71:9: stmts= statements EOF
            {
            pushFollow(FOLLOW_statements_in_assembler_file349);
            stmts=statements();

            state._fsp--;


            match(input,EOF,FOLLOW_EOF_in_assembler_file351); 


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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return outputList;
    }
    // $ANTLR end "assembler_file"



    // $ANTLR start "statements"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:101:1: statements returns [List<Operation> valueList] : (s1= statement NEWLINE | ( WS )? NEWLINE )+ (s2= statement )? ;
    public final List<Operation> statements() throws RecognitionException {
        List<Operation> valueList = null;


        Operation s1 =null;

        Operation s2 =null;



                        valueList = new ArrayList<Operation>();
                    
        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:105:5: ( (s1= statement NEWLINE | ( WS )? NEWLINE )+ (s2= statement )? )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:105:9: (s1= statement NEWLINE | ( WS )? NEWLINE )+ (s2= statement )?
            {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:105:9: (s1= statement NEWLINE | ( WS )? NEWLINE )+
            int cnt2=0;
            loop2:
            do {
                int alt2=3;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:105:10: s1= statement NEWLINE
            	    {
            	    pushFollow(FOLLOW_statement_in_statements408);
            	    s1=statement();

            	    state._fsp--;


            	     valueList.add(s1); 

            	    match(input,NEWLINE,FOLLOW_NEWLINE_in_statements412); 

            	    }
            	    break;
            	case 2 :
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:105:56: ( WS )? NEWLINE
            	    {
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:105:56: ( WS )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==WS) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:105:56: WS
            	            {
            	            match(input,WS,FOLLOW_WS_in_statements416); 

            	            }
            	            break;

            	    }


            	    match(input,NEWLINE,FOLLOW_NEWLINE_in_statements419); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:105:72: (s2= statement )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0 >= ADD && LA3_0 <= AND)||LA3_0==BOR||LA3_0==DIV||(LA3_0 >= IFB && LA3_0 <= IFN)||(LA3_0 >= JSR && LA3_0 <= LABEL_DECLARATION)||(LA3_0 >= MOD && LA3_0 <= MUL)||(LA3_0 >= SET && LA3_0 <= SHR)||(LA3_0 >= SUB && LA3_0 <= WS)||LA3_0==XOR) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:105:72: s2= statement
                    {
                    pushFollow(FOLLOW_statement_in_statements425);
                    s2=statement();

                    state._fsp--;


                    }
                    break;

            }


             valueList.add(s2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return valueList;
    }
    // $ANTLR end "statements"



    // $ANTLR start "statement"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:108:1: statement returns [Operation value] : ( WS )? (lbl= label_declaration WS ( ( NEWLINE )+ WS )* )? op= operation ( WS )? ;
    public final Operation statement() throws RecognitionException {
        Operation value = null;


        String lbl =null;

        Operation op =null;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:109:5: ( ( WS )? (lbl= label_declaration WS ( ( NEWLINE )+ WS )* )? op= operation ( WS )? )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:109:9: ( WS )? (lbl= label_declaration WS ( ( NEWLINE )+ WS )* )? op= operation ( WS )?
            {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:109:9: ( WS )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==WS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:109:9: WS
                    {
                    match(input,WS,FOLLOW_WS_in_statement451); 

                    }
                    break;

            }


            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:109:13: (lbl= label_declaration WS ( ( NEWLINE )+ WS )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LABEL_DECLARATION) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:109:14: lbl= label_declaration WS ( ( NEWLINE )+ WS )*
                    {
                    pushFollow(FOLLOW_label_declaration_in_statement457);
                    lbl=label_declaration();

                    state._fsp--;


                    match(input,WS,FOLLOW_WS_in_statement459); 

                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:109:39: ( ( NEWLINE )+ WS )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==NEWLINE) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:109:40: ( NEWLINE )+ WS
                    	    {
                    	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:109:40: ( NEWLINE )+
                    	    int cnt5=0;
                    	    loop5:
                    	    do {
                    	        int alt5=2;
                    	        int LA5_0 = input.LA(1);

                    	        if ( (LA5_0==NEWLINE) ) {
                    	            alt5=1;
                    	        }


                    	        switch (alt5) {
                    	    	case 1 :
                    	    	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:109:40: NEWLINE
                    	    	    {
                    	    	    match(input,NEWLINE,FOLLOW_NEWLINE_in_statement462); 

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt5 >= 1 ) break loop5;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(5, input);
                    	                throw eee;
                    	        }
                    	        cnt5++;
                    	    } while (true);


                    	    match(input,WS,FOLLOW_WS_in_statement465); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }


            pushFollow(FOLLOW_operation_in_statement473);
            op=operation();

            state._fsp--;


            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:109:69: ( WS )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==WS) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:109:69: WS
                    {
                    match(input,WS,FOLLOW_WS_in_statement475); 

                    }
                    break;

            }



                            if(lbl != null) {
                                op.setLabel(lbl);
                                labelOperationMap.put(lbl, op); 
                            }
                            value = op;
                            wordCount += op.wordCount();
                        

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "statement"



    // $ANTLR start "operation"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:120:1: operation returns [Operation value] : ( basic_operation_code WS ov1= operation_value COMMA ( WS )? ov2= operation_value | non_basic_operation_code WS ov= operation_value );
    public final Operation operation() throws RecognitionException {
        Operation value = null;


        OperationValue ov1 =null;

        OperationValue ov2 =null;

        OperationValue ov =null;

        Dcpu16AssemlberParser.basic_operation_code_return basic_operation_code1 =null;

        Dcpu16AssemlberParser.non_basic_operation_code_return non_basic_operation_code2 =null;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:121:5: ( basic_operation_code WS ov1= operation_value COMMA ( WS )? ov2= operation_value | non_basic_operation_code WS ov= operation_value )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0 >= ADD && LA10_0 <= AND)||LA10_0==BOR||LA10_0==DIV||(LA10_0 >= IFB && LA10_0 <= IFN)||(LA10_0 >= MOD && LA10_0 <= MUL)||(LA10_0 >= SET && LA10_0 <= SHR)||LA10_0==SUB||LA10_0==XOR) ) {
                alt10=1;
            }
            else if ( (LA10_0==JSR) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:121:9: basic_operation_code WS ov1= operation_value COMMA ( WS )? ov2= operation_value
                    {
                    pushFollow(FOLLOW_basic_operation_code_in_operation517);
                    basic_operation_code1=basic_operation_code();

                    state._fsp--;


                    match(input,WS,FOLLOW_WS_in_operation519); 

                    pushFollow(FOLLOW_operation_value_in_operation523);
                    ov1=operation_value();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_operation525); 

                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:121:59: ( WS )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==WS) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:121:59: WS
                            {
                            match(input,WS,FOLLOW_WS_in_operation527); 

                            }
                            break;

                    }


                    pushFollow(FOLLOW_operation_value_in_operation532);
                    ov2=operation_value();

                    state._fsp--;



                                    OpCode opcode = OpCode.valueOf((basic_operation_code1!=null?input.toString(basic_operation_code1.start,basic_operation_code1.stop):null));
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
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:139:9: non_basic_operation_code WS ov= operation_value
                    {
                    pushFollow(FOLLOW_non_basic_operation_code_in_operation556);
                    non_basic_operation_code2=non_basic_operation_code();

                    state._fsp--;


                    match(input,WS,FOLLOW_WS_in_operation558); 

                    pushFollow(FOLLOW_operation_value_in_operation562);
                    ov=operation_value();

                    state._fsp--;



                                    OpCode opcode = OpCode.valueOf((non_basic_operation_code2!=null?input.toString(non_basic_operation_code2.start,non_basic_operation_code2.stop):null));
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
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "operation"


    public static class basic_operation_code_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "basic_operation_code"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:155:1: basic_operation_code : ( SET | ADD | SUB | MUL | DIV | MOD | SHL | SHR | AND | BOR | XOR | IFE | IFN | IFG | IFB );
    public final Dcpu16AssemlberParser.basic_operation_code_return basic_operation_code() throws RecognitionException {
        Dcpu16AssemlberParser.basic_operation_code_return retval = new Dcpu16AssemlberParser.basic_operation_code_return();
        retval.start = input.LT(1);


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:156:5: ( SET | ADD | SUB | MUL | DIV | MOD | SHL | SHR | AND | BOR | XOR | IFE | IFN | IFG | IFB )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:
            {
            if ( (input.LA(1) >= ADD && input.LA(1) <= AND)||input.LA(1)==BOR||input.LA(1)==DIV||(input.LA(1) >= IFB && input.LA(1) <= IFN)||(input.LA(1) >= MOD && input.LA(1) <= MUL)||(input.LA(1) >= SET && input.LA(1) <= SHR)||input.LA(1)==SUB||input.LA(1)==XOR ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "basic_operation_code"


    public static class non_basic_operation_code_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "non_basic_operation_code"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:173:1: non_basic_operation_code : JSR ;
    public final Dcpu16AssemlberParser.non_basic_operation_code_return non_basic_operation_code() throws RecognitionException {
        Dcpu16AssemlberParser.non_basic_operation_code_return retval = new Dcpu16AssemlberParser.non_basic_operation_code_return();
        retval.start = input.LT(1);


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:174:5: ( JSR )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:174:9: JSR
            {
            match(input,JSR,FOLLOW_JSR_in_non_basic_operation_code754); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "non_basic_operation_code"



    // $ANTLR start "operation_value"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:177:1: operation_value returns [OperationValue value] : (e1= register |e2= dereferenced_register |e3= dereferenced_register_with_offset |e4= literal_value |e5= dereferenced_literal_value | LABEL_IDENTIFIER );
    public final OperationValue operation_value() throws RecognitionException {
        OperationValue value = null;


        Token LABEL_IDENTIFIER3=null;
        OpValueCode e1 =null;

        OpValueCode e2 =null;

        OperationValue e3 =null;

        int e4 =0;

        int e5 =0;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:178:5: (e1= register |e2= dereferenced_register |e3= dereferenced_register_with_offset |e4= literal_value |e5= dereferenced_literal_value | LABEL_IDENTIFIER )
            int alt11=6;
            switch ( input.LA(1) ) {
            case A:
            case B:
            case C:
            case I:
            case J:
            case O:
            case PC:
            case PEEK:
            case POP:
            case PUSH:
            case SP:
            case X:
            case Y:
            case Z:
                {
                alt11=1;
                }
                break;
            case LEFT_BLOCK_PARENTHESES:
                {
                switch ( input.LA(2) ) {
                case A:
                case B:
                case C:
                case I:
                case J:
                case X:
                case Y:
                case Z:
                    {
                    alt11=2;
                    }
                    break;
                case HEX_NUMBER:
                    {
                    int LA11_6 = input.LA(3);

                    if ( (LA11_6==PLUS) ) {
                        alt11=3;
                    }
                    else if ( (LA11_6==RIGHT_BLOCK_PARENTHESES) ) {
                        alt11=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 6, input);

                        throw nvae;

                    }
                    }
                    break;
                case DEC_NUMBER:
                    {
                    int LA11_7 = input.LA(3);

                    if ( (LA11_7==PLUS) ) {
                        alt11=3;
                    }
                    else if ( (LA11_7==RIGHT_BLOCK_PARENTHESES) ) {
                        alt11=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 7, input);

                        throw nvae;

                    }
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;

                }

                }
                break;
            case DEC_NUMBER:
            case HEX_NUMBER:
                {
                alt11=4;
                }
                break;
            case LABEL_IDENTIFIER:
                {
                alt11=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:178:9: e1= register
                    {
                    pushFollow(FOLLOW_register_in_operation_value779);
                    e1=register();

                    state._fsp--;



                                    value = new OperationValue(e1);
                                

                    }
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:182:9: e2= dereferenced_register
                    {
                    pushFollow(FOLLOW_dereferenced_register_in_operation_value805);
                    e2=dereferenced_register();

                    state._fsp--;



                                    value = new OperationValue(e2);
                                

                    }
                    break;
                case 3 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:186:9: e3= dereferenced_register_with_offset
                    {
                    pushFollow(FOLLOW_dereferenced_register_with_offset_in_operation_value831);
                    e3=dereferenced_register_with_offset();

                    state._fsp--;



                                    value = e3;
                                

                    }
                    break;
                case 4 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:190:9: e4= literal_value
                    {
                    pushFollow(FOLLOW_literal_value_in_operation_value857);
                    e4=literal_value();

                    state._fsp--;



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
                    break;
                case 5 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:202:9: e5= dereferenced_literal_value
                    {
                    pushFollow(FOLLOW_dereferenced_literal_value_in_operation_value883);
                    e5=dereferenced_literal_value();

                    state._fsp--;



                                    if(e5 < 0) {
                                        throw new RuntimeException("Negative dererenced literal value");
                                    }
                                    else {
                                        value = new OperationValue(OpValueCode.NEXT_WORD_DEREF, e5);
                                    }
                                

                    }
                    break;
                case 6 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:211:9: LABEL_IDENTIFIER
                    {
                    LABEL_IDENTIFIER3=(Token)match(input,LABEL_IDENTIFIER,FOLLOW_LABEL_IDENTIFIER_in_operation_value907); 


                                    String labelName = (LABEL_IDENTIFIER3!=null?LABEL_IDENTIFIER3.getText():null);
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
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "operation_value"



    // $ANTLR start "dereferenced_register"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:228:1: dereferenced_register returns [OpValueCode value] : LEFT_BLOCK_PARENTHESES e= dereferencable_register RIGHT_BLOCK_PARENTHESES ;
    public final OpValueCode dereferenced_register() throws RecognitionException {
        OpValueCode value = null;


        OpValueCode e =null;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:229:5: ( LEFT_BLOCK_PARENTHESES e= dereferencable_register RIGHT_BLOCK_PARENTHESES )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:229:9: LEFT_BLOCK_PARENTHESES e= dereferencable_register RIGHT_BLOCK_PARENTHESES
            {
            match(input,LEFT_BLOCK_PARENTHESES,FOLLOW_LEFT_BLOCK_PARENTHESES_in_dereferenced_register944); 

            pushFollow(FOLLOW_dereferencable_register_in_dereferenced_register948);
            e=dereferencable_register();

            state._fsp--;


            match(input,RIGHT_BLOCK_PARENTHESES,FOLLOW_RIGHT_BLOCK_PARENTHESES_in_dereferenced_register950); 


                            value = OpValueCode.getDerefOf(e);
                        

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "dereferenced_register"



    // $ANTLR start "dereferenced_register_with_offset"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:235:1: dereferenced_register_with_offset returns [OperationValue value] : LEFT_BLOCK_PARENTHESES e1= literal_value PLUS e2= dereferencable_register RIGHT_BLOCK_PARENTHESES ;
    public final OperationValue dereferenced_register_with_offset() throws RecognitionException {
        OperationValue value = null;


        int e1 =0;

        OpValueCode e2 =null;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:236:5: ( LEFT_BLOCK_PARENTHESES e1= literal_value PLUS e2= dereferencable_register RIGHT_BLOCK_PARENTHESES )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:236:9: LEFT_BLOCK_PARENTHESES e1= literal_value PLUS e2= dereferencable_register RIGHT_BLOCK_PARENTHESES
            {
            match(input,LEFT_BLOCK_PARENTHESES,FOLLOW_LEFT_BLOCK_PARENTHESES_in_dereferenced_register_with_offset987); 

            pushFollow(FOLLOW_literal_value_in_dereferenced_register_with_offset991);
            e1=literal_value();

            state._fsp--;


            match(input,PLUS,FOLLOW_PLUS_in_dereferenced_register_with_offset993); 

            pushFollow(FOLLOW_dereferencable_register_in_dereferenced_register_with_offset997);
            e2=dereferencable_register();

            state._fsp--;


            match(input,RIGHT_BLOCK_PARENTHESES,FOLLOW_RIGHT_BLOCK_PARENTHESES_in_dereferenced_register_with_offset999); 


                            value = new OperationValue(OpValueCode.getRegPlusNextWordDerefOf(e2), e1);
                        

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "dereferenced_register_with_offset"



    // $ANTLR start "register"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:242:1: register returns [OpValueCode value] : (e= dereferencable_register | POP | PEEK | PUSH | SP | PC | O );
    public final OpValueCode register() throws RecognitionException {
        OpValueCode value = null;


        Token POP4=null;
        Token PEEK5=null;
        Token PUSH6=null;
        Token SP7=null;
        Token PC8=null;
        Token O9=null;
        OpValueCode e =null;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:243:5: (e= dereferencable_register | POP | PEEK | PUSH | SP | PC | O )
            int alt12=7;
            switch ( input.LA(1) ) {
            case A:
            case B:
            case C:
            case I:
            case J:
            case X:
            case Y:
            case Z:
                {
                alt12=1;
                }
                break;
            case POP:
                {
                alt12=2;
                }
                break;
            case PEEK:
                {
                alt12=3;
                }
                break;
            case PUSH:
                {
                alt12=4;
                }
                break;
            case SP:
                {
                alt12=5;
                }
                break;
            case PC:
                {
                alt12=6;
                }
                break;
            case O:
                {
                alt12=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:243:9: e= dereferencable_register
                    {
                    pushFollow(FOLLOW_dereferencable_register_in_register1038);
                    e=dereferencable_register();

                    state._fsp--;


                     value = e; 

                    }
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:244:9: POP
                    {
                    POP4=(Token)match(input,POP,FOLLOW_POP_in_register1050); 

                     value = OpValueCode.valueOf((POP4!=null?POP4.getText():null)); 

                    }
                    break;
                case 3 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:245:9: PEEK
                    {
                    PEEK5=(Token)match(input,PEEK,FOLLOW_PEEK_in_register1062); 

                     value = OpValueCode.valueOf((PEEK5!=null?PEEK5.getText():null)); 

                    }
                    break;
                case 4 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:246:9: PUSH
                    {
                    PUSH6=(Token)match(input,PUSH,FOLLOW_PUSH_in_register1074); 

                     value = OpValueCode.valueOf((PUSH6!=null?PUSH6.getText():null)); 

                    }
                    break;
                case 5 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:247:9: SP
                    {
                    SP7=(Token)match(input,SP,FOLLOW_SP_in_register1086); 

                     value = OpValueCode.valueOf((SP7!=null?SP7.getText():null)); 

                    }
                    break;
                case 6 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:248:9: PC
                    {
                    PC8=(Token)match(input,PC,FOLLOW_PC_in_register1098); 

                     value = OpValueCode.valueOf((PC8!=null?PC8.getText():null)); 

                    }
                    break;
                case 7 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:249:9: O
                    {
                    O9=(Token)match(input,O,FOLLOW_O_in_register1110); 

                     value = OpValueCode.valueOf((O9!=null?O9.getText():null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "register"



    // $ANTLR start "dereferencable_register"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:252:1: dereferencable_register returns [OpValueCode value] : ( A | B | C | X | Y | Z | I | J );
    public final OpValueCode dereferencable_register() throws RecognitionException {
        OpValueCode value = null;


        Token A10=null;
        Token B11=null;
        Token C12=null;
        Token X13=null;
        Token Y14=null;
        Token Z15=null;
        Token I16=null;
        Token J17=null;

        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:253:5: ( A | B | C | X | Y | Z | I | J )
            int alt13=8;
            switch ( input.LA(1) ) {
            case A:
                {
                alt13=1;
                }
                break;
            case B:
                {
                alt13=2;
                }
                break;
            case C:
                {
                alt13=3;
                }
                break;
            case X:
                {
                alt13=4;
                }
                break;
            case Y:
                {
                alt13=5;
                }
                break;
            case Z:
                {
                alt13=6;
                }
                break;
            case I:
                {
                alt13=7;
                }
                break;
            case J:
                {
                alt13=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }

            switch (alt13) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:253:9: A
                    {
                    A10=(Token)match(input,A,FOLLOW_A_in_dereferencable_register1135); 

                     value = OpValueCode.valueOf((A10!=null?A10.getText():null)); 

                    }
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:254:9: B
                    {
                    B11=(Token)match(input,B,FOLLOW_B_in_dereferencable_register1147); 

                     value = OpValueCode.valueOf((B11!=null?B11.getText():null)); 

                    }
                    break;
                case 3 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:255:9: C
                    {
                    C12=(Token)match(input,C,FOLLOW_C_in_dereferencable_register1159); 

                     value = OpValueCode.valueOf((C12!=null?C12.getText():null)); 

                    }
                    break;
                case 4 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:256:9: X
                    {
                    X13=(Token)match(input,X,FOLLOW_X_in_dereferencable_register1171); 

                     value = OpValueCode.valueOf((X13!=null?X13.getText():null)); 

                    }
                    break;
                case 5 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:257:9: Y
                    {
                    Y14=(Token)match(input,Y,FOLLOW_Y_in_dereferencable_register1183); 

                     value = OpValueCode.valueOf((Y14!=null?Y14.getText():null)); 

                    }
                    break;
                case 6 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:258:9: Z
                    {
                    Z15=(Token)match(input,Z,FOLLOW_Z_in_dereferencable_register1195); 

                     value = OpValueCode.valueOf((Z15!=null?Z15.getText():null)); 

                    }
                    break;
                case 7 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:259:9: I
                    {
                    I16=(Token)match(input,I,FOLLOW_I_in_dereferencable_register1207); 

                     value = OpValueCode.valueOf((I16!=null?I16.getText():null)); 

                    }
                    break;
                case 8 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:260:9: J
                    {
                    J17=(Token)match(input,J,FOLLOW_J_in_dereferencable_register1219); 

                     value = OpValueCode.valueOf((J17!=null?J17.getText():null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "dereferencable_register"



    // $ANTLR start "dereferenced_literal_value"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:263:1: dereferenced_literal_value returns [int value] : LEFT_BLOCK_PARENTHESES e= literal_value RIGHT_BLOCK_PARENTHESES ;
    public final int dereferenced_literal_value() throws RecognitionException {
        int value = 0;


        int e =0;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:264:5: ( LEFT_BLOCK_PARENTHESES e= literal_value RIGHT_BLOCK_PARENTHESES )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:264:9: LEFT_BLOCK_PARENTHESES e= literal_value RIGHT_BLOCK_PARENTHESES
            {
            match(input,LEFT_BLOCK_PARENTHESES,FOLLOW_LEFT_BLOCK_PARENTHESES_in_dereferenced_literal_value1248); 

            pushFollow(FOLLOW_literal_value_in_dereferenced_literal_value1252);
            e=literal_value();

            state._fsp--;


            match(input,RIGHT_BLOCK_PARENTHESES,FOLLOW_RIGHT_BLOCK_PARENTHESES_in_dereferenced_literal_value1254); 


                            value = e;
                        

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "dereferenced_literal_value"



    // $ANTLR start "literal_value"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:270:1: literal_value returns [int value] : ( HEX_NUMBER | DEC_NUMBER );
    public final int literal_value() throws RecognitionException {
        int value = 0;


        Token HEX_NUMBER18=null;
        Token DEC_NUMBER19=null;

        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:271:5: ( HEX_NUMBER | DEC_NUMBER )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==HEX_NUMBER) ) {
                alt14=1;
            }
            else if ( (LA14_0==DEC_NUMBER) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:271:9: HEX_NUMBER
                    {
                    HEX_NUMBER18=(Token)match(input,HEX_NUMBER,FOLLOW_HEX_NUMBER_in_literal_value1291); 


                                    value = Integer.parseInt((HEX_NUMBER18!=null?HEX_NUMBER18.getText():null).substring(2), 16);
                                

                    }
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:275:9: DEC_NUMBER
                    {
                    DEC_NUMBER19=(Token)match(input,DEC_NUMBER,FOLLOW_DEC_NUMBER_in_literal_value1315); 


                                    value = Integer.parseInt((DEC_NUMBER19!=null?DEC_NUMBER19.getText():null));
                                

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "literal_value"



    // $ANTLR start "label_declaration"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:281:1: label_declaration returns [String value] : LABEL_DECLARATION ;
    public final String label_declaration() throws RecognitionException {
        String value = null;


        Token LABEL_DECLARATION20=null;

        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:282:5: ( LABEL_DECLARATION )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:282:9: LABEL_DECLARATION
            {
            LABEL_DECLARATION20=(Token)match(input,LABEL_DECLARATION,FOLLOW_LABEL_DECLARATION_in_label_declaration1352); 


                            String labelName = (LABEL_DECLARATION20!=null?LABEL_DECLARATION20.getText():null).substring(1);
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "label_declaration"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS =
        "\u0088\uffff";
    static final String DFA2_eofS =
        "\1\5\34\uffff\16\5\1\uffff\3\5\14\uffff\1\5\14\uffff\16\5\1\uffff"+
        "\3\5\3\uffff\1\5\1\uffff\1\5\32\uffff\1\5\1\uffff\1\5\1\uffff\1"+
        "\5\10\uffff\1\5";
    static final String DFA2_minS =
        "\2\5\3\51\2\uffff\1\5\2\4\1\34\16\12\1\4\3\12\16\34\1\4\3\34\1\5"+
        "\1\4\10\43\2\40\1\34\1\uffff\10\43\2\40\1\4\16\34\1\4\3\34\1\12"+
        "\1\4\1\12\1\34\1\4\1\34\10\43\2\40\20\43\1\34\1\4\1\34\1\12\1\34"+
        "\10\43\1\34";
    static final String DFA2_maxS =
        "\2\53\3\51\2\uffff\1\53\2\55\1\51\16\12\1\55\3\12\16\51\1\55\3\51"+
        "\1\53\1\55\12\43\1\34\1\uffff\12\43\1\55\16\51\1\55\3\51\1\12\1"+
        "\55\1\12\1\51\1\55\1\51\32\43\1\51\1\55\1\51\1\12\1\51\10\43\1\51";
    static final String DFA2_acceptS =
        "\5\uffff\1\3\1\2\65\uffff\1\1\113\uffff";
    static final String DFA2_specialS =
        "\u0088\uffff}>";
    static final String[] DFA2_transitionS = {
            "\2\3\1\uffff\1\3\3\uffff\1\3\2\uffff\4\3\1\uffff\1\4\1\2\3\uffff"+
            "\2\3\1\uffff\1\6\7\uffff\3\3\1\uffff\1\3\1\1\1\uffff\1\3",
            "\2\3\1\uffff\1\3\3\uffff\1\3\2\uffff\4\3\1\uffff\1\4\1\2\3"+
            "\uffff\2\3\1\uffff\1\6\7\uffff\3\3\1\uffff\1\3\2\uffff\1\3",
            "\1\7",
            "\1\10",
            "\1\11",
            "",
            "",
            "\2\3\1\uffff\1\3\3\uffff\1\3\2\uffff\4\3\1\uffff\1\4\4\uffff"+
            "\2\3\1\uffff\1\12\7\uffff\3\3\1\uffff\1\3\2\uffff\1\3",
            "\1\13\2\uffff\1\14\1\uffff\1\15\1\uffff\1\33\1\uffff\1\32\1"+
            "\21\4\uffff\1\22\2\uffff\1\34\1\31\5\uffff\1\30\1\27\1\24\1"+
            "\uffff\1\23\1\25\4\uffff\1\26\2\uffff\1\16\1\uffff\1\17\1\20",
            "\1\35\2\uffff\1\36\1\uffff\1\37\1\uffff\1\55\1\uffff\1\54\1"+
            "\43\4\uffff\1\44\2\uffff\1\56\1\53\5\uffff\1\52\1\51\1\46\1"+
            "\uffff\1\45\1\47\4\uffff\1\50\2\uffff\1\40\1\uffff\1\41\1\42",
            "\1\12\14\uffff\1\57",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\61\2\uffff\1\62\1\uffff\1\63\1\uffff\1\72\1\uffff\1\71\1"+
            "\67\4\uffff\1\70\26\uffff\1\64\1\uffff\1\65\1\66",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\75\2\uffff\1\76\1\uffff\1\77\1\uffff\1\106\1\uffff\1\105"+
            "\1\103\4\uffff\1\104\26\uffff\1\100\1\uffff\1\101\1\102",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\2\3\1\uffff\1\3\3\uffff\1\3\2\uffff\4\3\1\uffff\1\4\4\uffff"+
            "\2\3\1\uffff\1\12\7\uffff\3\3\1\uffff\1\3\2\uffff\1\3",
            "\1\110\2\uffff\1\111\1\uffff\1\112\1\uffff\1\130\1\uffff\1"+
            "\127\1\116\4\uffff\1\117\2\uffff\1\131\1\126\5\uffff\1\125\1"+
            "\124\1\121\1\uffff\1\120\1\122\4\uffff\1\123\1\uffff\1\107\1"+
            "\113\1\uffff\1\114\1\115",
            "\1\132",
            "\1\132",
            "\1\132",
            "\1\132",
            "\1\132",
            "\1\132",
            "\1\132",
            "\1\132",
            "\1\133\2\uffff\1\134",
            "\1\133\2\uffff\1\134",
            "\1\74",
            "",
            "\1\135",
            "\1\135",
            "\1\135",
            "\1\135",
            "\1\135",
            "\1\135",
            "\1\135",
            "\1\135",
            "\1\136\2\uffff\1\137",
            "\1\136\2\uffff\1\137",
            "\1\110\2\uffff\1\111\1\uffff\1\112\1\uffff\1\130\1\uffff\1"+
            "\127\1\116\4\uffff\1\117\2\uffff\1\131\1\126\5\uffff\1\125\1"+
            "\124\1\121\1\uffff\1\120\1\122\4\uffff\1\123\2\uffff\1\113\1"+
            "\uffff\1\114\1\115",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\140\2\uffff\1\141\1\uffff\1\142\1\uffff\1\151\1\uffff\1"+
            "\150\1\146\4\uffff\1\147\26\uffff\1\143\1\uffff\1\144\1\145",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\74\14\uffff\1\73",
            "\1\60",
            "\1\152\2\uffff\1\153\1\uffff\1\154\4\uffff\1\160\4\uffff\1"+
            "\161\26\uffff\1\155\1\uffff\1\156\1\157",
            "\1\60",
            "\1\74\14\uffff\1\73",
            "\1\162\2\uffff\1\163\1\uffff\1\164\4\uffff\1\170\4\uffff\1"+
            "\171\26\uffff\1\165\1\uffff\1\166\1\167",
            "\1\74\14\uffff\1\73",
            "\1\172",
            "\1\172",
            "\1\172",
            "\1\172",
            "\1\172",
            "\1\172",
            "\1\172",
            "\1\172",
            "\1\173\2\uffff\1\174",
            "\1\173\2\uffff\1\174",
            "\1\175",
            "\1\175",
            "\1\175",
            "\1\175",
            "\1\175",
            "\1\175",
            "\1\175",
            "\1\175",
            "\1\176",
            "\1\176",
            "\1\176",
            "\1\176",
            "\1\176",
            "\1\176",
            "\1\176",
            "\1\176",
            "\1\74\14\uffff\1\73",
            "\1\177\2\uffff\1\u0080\1\uffff\1\u0081\4\uffff\1\u0085\4\uffff"+
            "\1\u0086\26\uffff\1\u0082\1\uffff\1\u0083\1\u0084",
            "\1\74\14\uffff\1\73",
            "\1\60",
            "\1\74\14\uffff\1\73",
            "\1\u0087",
            "\1\u0087",
            "\1\u0087",
            "\1\u0087",
            "\1\u0087",
            "\1\u0087",
            "\1\u0087",
            "\1\u0087",
            "\1\74\14\uffff\1\73"
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "()+ loopback of 105:9: (s1= statement NEWLINE | ( WS )? NEWLINE )+";
        }
    }
 

    public static final BitSet FOLLOW_statements_in_assembler_file349 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_assembler_file351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statements408 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_NEWLINE_in_statements412 = new BitSet(new long[]{0x00000B7016379162L});
    public static final BitSet FOLLOW_WS_in_statements416 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_NEWLINE_in_statements419 = new BitSet(new long[]{0x00000B7016379162L});
    public static final BitSet FOLLOW_statement_in_statements425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_statement451 = new BitSet(new long[]{0x0000097006379160L});
    public static final BitSet FOLLOW_label_declaration_in_statement457 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_WS_in_statement459 = new BitSet(new long[]{0x0000097016179160L});
    public static final BitSet FOLLOW_NEWLINE_in_statement462 = new BitSet(new long[]{0x0000020010000000L});
    public static final BitSet FOLLOW_WS_in_statement465 = new BitSet(new long[]{0x0000097016179160L});
    public static final BitSet FOLLOW_operation_in_statement473 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_WS_in_statement475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_basic_operation_code_in_operation517 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_WS_in_operation519 = new BitSet(new long[]{0x00003486E0C86A90L});
    public static final BitSet FOLLOW_operation_value_in_operation523 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_operation525 = new BitSet(new long[]{0x00003686E0C86A90L});
    public static final BitSet FOLLOW_WS_in_operation527 = new BitSet(new long[]{0x00003486E0C86A90L});
    public static final BitSet FOLLOW_operation_value_in_operation532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_non_basic_operation_code_in_operation556 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_WS_in_operation558 = new BitSet(new long[]{0x00003486E0C86A90L});
    public static final BitSet FOLLOW_operation_value_in_operation562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSR_in_non_basic_operation_code754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_register_in_operation_value779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dereferenced_register_in_operation_value805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dereferenced_register_with_offset_in_operation_value831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_value_in_operation_value857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dereferenced_literal_value_in_operation_value883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LABEL_IDENTIFIER_in_operation_value907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_BLOCK_PARENTHESES_in_dereferenced_register944 = new BitSet(new long[]{0x0000340000084290L});
    public static final BitSet FOLLOW_dereferencable_register_in_dereferenced_register948 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RIGHT_BLOCK_PARENTHESES_in_dereferenced_register950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_BLOCK_PARENTHESES_in_dereferenced_register_with_offset987 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_literal_value_in_dereferenced_register_with_offset991 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_PLUS_in_dereferenced_register_with_offset993 = new BitSet(new long[]{0x0000340000084290L});
    public static final BitSet FOLLOW_dereferencable_register_in_dereferenced_register_with_offset997 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RIGHT_BLOCK_PARENTHESES_in_dereferenced_register_with_offset999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dereferencable_register_in_register1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POP_in_register1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PEEK_in_register1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PUSH_in_register1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SP_in_register1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PC_in_register1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_O_in_register1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_A_in_dereferencable_register1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_B_in_dereferencable_register1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_C_in_dereferencable_register1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_X_in_dereferencable_register1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Y_in_dereferencable_register1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Z_in_dereferencable_register1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_I_in_dereferencable_register1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_J_in_dereferencable_register1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_BLOCK_PARENTHESES_in_dereferenced_literal_value1248 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_literal_value_in_dereferenced_literal_value1252 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RIGHT_BLOCK_PARENTHESES_in_dereferenced_literal_value1254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_NUMBER_in_literal_value1291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_NUMBER_in_literal_value1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LABEL_DECLARATION_in_label_declaration1352 = new BitSet(new long[]{0x0000000000000002L});

}