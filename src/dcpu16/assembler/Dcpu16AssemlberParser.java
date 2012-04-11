// $ANTLR 3.4 E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g 2012-04-11 17:02:39

package dcpu16.assembler;

import java.util.HashMap;
import java.util.Map;

import dcpu16.common.OpCode;
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



    // $ANTLR start "assembler_file"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:78:1: assembler_file returns [byte[] binaryOutput] : s= statements EOF ;
    public final byte[] assembler_file() throws RecognitionException {
        byte[] binaryOutput = null;


        List<Integer> s =null;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:79:5: (s= statements EOF )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:79:9: s= statements EOF
            {
            pushFollow(FOLLOW_statements_in_assembler_file349);
            s=statements();

            state._fsp--;


            match(input,EOF,FOLLOW_EOF_in_assembler_file351); 


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
                                    //System.err.println("Replacing label '"+ labelName +"' value "+ value +" with "+ realValue +".");
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return binaryOutput;
    }
    // $ANTLR end "assembler_file"



    // $ANTLR start "statements"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:110:1: statements returns [List<Integer> valueList] : (s1= statement NEWLINE | ( WS )? NEWLINE )+ (s2= statement )? ;
    public final List<Integer> statements() throws RecognitionException {
        List<Integer> valueList = null;


        List<Integer> s1 =null;

        List<Integer> s2 =null;



                        valueList = new ArrayList<Integer>();
                    
        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:114:5: ( (s1= statement NEWLINE | ( WS )? NEWLINE )+ (s2= statement )? )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:114:9: (s1= statement NEWLINE | ( WS )? NEWLINE )+ (s2= statement )?
            {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:114:9: (s1= statement NEWLINE | ( WS )? NEWLINE )+
            int cnt2=0;
            loop2:
            do {
                int alt2=3;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:114:10: s1= statement NEWLINE
            	    {
            	    pushFollow(FOLLOW_statement_in_statements408);
            	    s1=statement();

            	    state._fsp--;


            	     valueList.addAll(s1); 

            	    match(input,NEWLINE,FOLLOW_NEWLINE_in_statements412); 

            	    }
            	    break;
            	case 2 :
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:114:59: ( WS )? NEWLINE
            	    {
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:114:59: ( WS )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==WS) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:114:59: WS
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


            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:114:75: (s2= statement )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0 >= ADD && LA3_0 <= AND)||LA3_0==BOR||LA3_0==DIV||(LA3_0 >= IFB && LA3_0 <= IFN)||(LA3_0 >= JSR && LA3_0 <= LABEL_DECLARATION)||(LA3_0 >= MOD && LA3_0 <= MUL)||(LA3_0 >= SET && LA3_0 <= SHR)||(LA3_0 >= SUB && LA3_0 <= WS)||LA3_0==XOR) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:114:75: s2= statement
                    {
                    pushFollow(FOLLOW_statement_in_statements425);
                    s2=statement();

                    state._fsp--;


                    }
                    break;

            }


             valueList.addAll(s2); 

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
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:117:1: statement returns [List<Integer> valueList] : ( WS )? ( label_declaration WS ( ( NEWLINE )+ WS )* )? opList= operation ( WS )? ;
    public final List<Integer> statement() throws RecognitionException {
        List<Integer> valueList = null;


        List<Integer> opList =null;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:118:5: ( ( WS )? ( label_declaration WS ( ( NEWLINE )+ WS )* )? opList= operation ( WS )? )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:118:9: ( WS )? ( label_declaration WS ( ( NEWLINE )+ WS )* )? opList= operation ( WS )?
            {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:118:9: ( WS )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==WS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:118:9: WS
                    {
                    match(input,WS,FOLLOW_WS_in_statement451); 

                    }
                    break;

            }


            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:118:13: ( label_declaration WS ( ( NEWLINE )+ WS )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LABEL_DECLARATION) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:118:14: label_declaration WS ( ( NEWLINE )+ WS )*
                    {
                    pushFollow(FOLLOW_label_declaration_in_statement455);
                    label_declaration();

                    state._fsp--;


                    match(input,WS,FOLLOW_WS_in_statement457); 

                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:118:35: ( ( NEWLINE )+ WS )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==NEWLINE) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:118:36: ( NEWLINE )+ WS
                    	    {
                    	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:118:36: ( NEWLINE )+
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
                    	    	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:118:36: NEWLINE
                    	    	    {
                    	    	    match(input,NEWLINE,FOLLOW_NEWLINE_in_statement460); 

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


                    	    match(input,WS,FOLLOW_WS_in_statement463); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }


            pushFollow(FOLLOW_operation_in_statement471);
            opList=operation();

            state._fsp--;


            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:118:69: ( WS )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==WS) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:118:69: WS
                    {
                    match(input,WS,FOLLOW_WS_in_statement473); 

                    }
                    break;

            }



                            valueList = opList;
                            wordCount += opList.size();
                        

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
    // $ANTLR end "statement"



    // $ANTLR start "operation"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:125:1: operation returns [List<Integer> valueList] : ( basic_operation_code WS ov1= operation_value COMMA ( WS )? ov2= operation_value | non_basic_operation_code WS ov= operation_value );
    public final List<Integer> operation() throws RecognitionException {
        List<Integer> valueList = null;


        List<Integer> ov1 =null;

        List<Integer> ov2 =null;

        List<Integer> ov =null;

        Dcpu16AssemlberParser.basic_operation_code_return basic_operation_code1 =null;

        Dcpu16AssemlberParser.non_basic_operation_code_return non_basic_operation_code2 =null;



                        valueList = new ArrayList<Integer>();
                    
        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:129:5: ( basic_operation_code WS ov1= operation_value COMMA ( WS )? ov2= operation_value | non_basic_operation_code WS ov= operation_value )
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
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:129:9: basic_operation_code WS ov1= operation_value COMMA ( WS )? ov2= operation_value
                    {
                    pushFollow(FOLLOW_basic_operation_code_in_operation532);
                    basic_operation_code1=basic_operation_code();

                    state._fsp--;


                    match(input,WS,FOLLOW_WS_in_operation534); 

                    pushFollow(FOLLOW_operation_value_in_operation538);
                    ov1=operation_value();

                    state._fsp--;


                    match(input,COMMA,FOLLOW_COMMA_in_operation540); 

                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:129:59: ( WS )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==WS) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:129:59: WS
                            {
                            match(input,WS,FOLLOW_WS_in_operation542); 

                            }
                            break;

                    }


                    pushFollow(FOLLOW_operation_value_in_operation547);
                    ov2=operation_value();

                    state._fsp--;



                                    int opcode = OpCode.valueOf((basic_operation_code1!=null?input.toString(basic_operation_code1.start,basic_operation_code1.stop):null)).code;
                                    int opvalue1 = ov1.get(0);
                                    int opvalue2 = ov2.get(0);
                                    
                                    //Some assertions
                                    if(opcode > OpCode.BIT_MASK_BASIC) {
                                        throw new RuntimeException("Opcode bigger than "+ OpCode.BIT_MASK_BASIC +", SHOULD NEVER HAPPEN!");
                                    }
                                    else if(opvalue1 > OpValueCode.BIT_MASK) {
                                        throw new RuntimeException("Opvalue1 bigger than "+ OpValueCode.BIT_MASK +", SHOULD NEVER HAPPEN!");
                                    }
                                    else if(opvalue2 > OpValueCode.BIT_MASK) {
                                        throw new RuntimeException("Opvalue2 bigger than "+ OpValueCode.BIT_MASK +", SHOULD NEVER HAPPEN!");
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
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:158:9: non_basic_operation_code WS ov= operation_value
                    {
                    pushFollow(FOLLOW_non_basic_operation_code_in_operation571);
                    non_basic_operation_code2=non_basic_operation_code();

                    state._fsp--;


                    match(input,WS,FOLLOW_WS_in_operation573); 

                    pushFollow(FOLLOW_operation_value_in_operation577);
                    ov=operation_value();

                    state._fsp--;



                                    int opcode = OpCode.valueOf((non_basic_operation_code2!=null?input.toString(non_basic_operation_code2.start,non_basic_operation_code2.stop):null)).code;
                                    int opvalue = ov.get(0);
                                    
                                    //Some assertions
                                    if(opcode > OpCode.BIT_MASK_NON_BASIC) {
                                        throw new RuntimeException("Opcode bigger than "+ OpCode.BIT_MASK_NON_BASIC +" (in non-basic operation), SHOULD NEVER HAPPEN!");
                                    }
                                    else if(opvalue > OpValueCode.BIT_MASK) {
                                        throw new RuntimeException("Opvalue1 bigger than "+ OpValueCode.BIT_MASK +" (in non-basic operation), SHOULD NEVER HAPPEN!");
                                    }
                                    
                                    opvalue = opvalue << 10;
                                    int operation = opcode + opvalue;
                                    valueList.add(operation);
                                    
                                    //Add remaining 'next word' values.
                                    for(int i = 1; i < ov.size(); i++) {
                                        valueList.add(ov.get(i));
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
        return valueList;
    }
    // $ANTLR end "operation"


    public static class basic_operation_code_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "basic_operation_code"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:182:1: basic_operation_code : ( SET | ADD | SUB | MUL | DIV | MOD | SHL | SHR | AND | BOR | XOR | IFE | IFN | IFG | IFB );
    public final Dcpu16AssemlberParser.basic_operation_code_return basic_operation_code() throws RecognitionException {
        Dcpu16AssemlberParser.basic_operation_code_return retval = new Dcpu16AssemlberParser.basic_operation_code_return();
        retval.start = input.LT(1);


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:183:5: ( SET | ADD | SUB | MUL | DIV | MOD | SHL | SHR | AND | BOR | XOR | IFE | IFN | IFG | IFB )
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
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:200:1: non_basic_operation_code : JSR ;
    public final Dcpu16AssemlberParser.non_basic_operation_code_return non_basic_operation_code() throws RecognitionException {
        Dcpu16AssemlberParser.non_basic_operation_code_return retval = new Dcpu16AssemlberParser.non_basic_operation_code_return();
        retval.start = input.LT(1);


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:201:5: ( JSR )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:201:9: JSR
            {
            match(input,JSR,FOLLOW_JSR_in_non_basic_operation_code769); 

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
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:204:1: operation_value returns [List<Integer> valueList] : (e1= register |e2= dereferenced_register |e3= dereferenced_register_with_offset |e4= literal_value |e5= dereferenced_literal_value | LABEL_IDENTIFIER );
    public final List<Integer> operation_value() throws RecognitionException {
        List<Integer> valueList = null;


        Token LABEL_IDENTIFIER3=null;
        OpValueCode e1 =null;

        OpValueCode e2 =null;

        int[] e3 =null;

        int e4 =0;

        int e5 =0;



                        valueList = new ArrayList<Integer>();
                    
        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:208:5: (e1= register |e2= dereferenced_register |e3= dereferenced_register_with_offset |e4= literal_value |e5= dereferenced_literal_value | LABEL_IDENTIFIER )
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
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:208:9: e1= register
                    {
                    pushFollow(FOLLOW_register_in_operation_value811);
                    e1=register();

                    state._fsp--;



                                    valueList.add(e1.code);
                                

                    }
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:212:9: e2= dereferenced_register
                    {
                    pushFollow(FOLLOW_dereferenced_register_in_operation_value837);
                    e2=dereferenced_register();

                    state._fsp--;



                                    valueList.add(e2.code);
                                

                    }
                    break;
                case 3 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:216:9: e3= dereferenced_register_with_offset
                    {
                    pushFollow(FOLLOW_dereferenced_register_with_offset_in_operation_value863);
                    e3=dereferenced_register_with_offset();

                    state._fsp--;



                                    valueList.add(e3[0]);
                                    valueList.add(e3[1]);
                                

                    }
                    break;
                case 4 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:221:9: e4= literal_value
                    {
                    pushFollow(FOLLOW_literal_value_in_operation_value889);
                    e4=literal_value();

                    state._fsp--;



                                    if(e4 < 0) {
                                        throw new RuntimeException("Negative literal value");
                                    }
                                    else if(e4 <= 0x1f) {
                                        valueList.add(e4 + OpValueCode.LITERAL_OFFSET.code);
                                    }
                                    else {
                                        valueList.add(OpValueCode.NEXT_WORD.code);
                                        valueList.add(e4);
                                    }
                                

                    }
                    break;
                case 5 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:234:9: e5= dereferenced_literal_value
                    {
                    pushFollow(FOLLOW_dereferenced_literal_value_in_operation_value915);
                    e5=dereferenced_literal_value();

                    state._fsp--;



                                    if(e5 < 0) {
                                        throw new RuntimeException("Negative dererenced literal value");
                                    }
                                    else {
                                        valueList.add(OpValueCode.NEXT_WORD_DEREF.code);
                                        valueList.add(e5);
                                    }
                                

                    }
                    break;
                case 6 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:244:9: LABEL_IDENTIFIER
                    {
                    LABEL_IDENTIFIER3=(Token)match(input,LABEL_IDENTIFIER,FOLLOW_LABEL_IDENTIFIER_in_operation_value939); 


                                    valueList.add(OpValueCode.NEXT_WORD.code);
                                    
                                    String labelName = (LABEL_IDENTIFIER3!=null?LABEL_IDENTIFIER3.getText():null);
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
                                        //System.err.println("Assigning placeholder '"+ placeHolder +"' to label '"+ labelName +"'.");
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
        return valueList;
    }
    // $ANTLR end "operation_value"



    // $ANTLR start "dereferenced_register"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:265:1: dereferenced_register returns [OpValueCode value] : LEFT_BLOCK_PARENTHESES e= dereferencable_register RIGHT_BLOCK_PARENTHESES ;
    public final OpValueCode dereferenced_register() throws RecognitionException {
        OpValueCode value = null;


        OpValueCode e =null;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:266:5: ( LEFT_BLOCK_PARENTHESES e= dereferencable_register RIGHT_BLOCK_PARENTHESES )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:266:9: LEFT_BLOCK_PARENTHESES e= dereferencable_register RIGHT_BLOCK_PARENTHESES
            {
            match(input,LEFT_BLOCK_PARENTHESES,FOLLOW_LEFT_BLOCK_PARENTHESES_in_dereferenced_register976); 

            pushFollow(FOLLOW_dereferencable_register_in_dereferenced_register980);
            e=dereferencable_register();

            state._fsp--;


            match(input,RIGHT_BLOCK_PARENTHESES,FOLLOW_RIGHT_BLOCK_PARENTHESES_in_dereferenced_register982); 


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
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:272:1: dereferenced_register_with_offset returns [int[] values] : LEFT_BLOCK_PARENTHESES e1= literal_value PLUS e2= dereferencable_register RIGHT_BLOCK_PARENTHESES ;
    public final int[] dereferenced_register_with_offset() throws RecognitionException {
        int[] values = null;


        int e1 =0;

        OpValueCode e2 =null;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:273:5: ( LEFT_BLOCK_PARENTHESES e1= literal_value PLUS e2= dereferencable_register RIGHT_BLOCK_PARENTHESES )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:273:9: LEFT_BLOCK_PARENTHESES e1= literal_value PLUS e2= dereferencable_register RIGHT_BLOCK_PARENTHESES
            {
            match(input,LEFT_BLOCK_PARENTHESES,FOLLOW_LEFT_BLOCK_PARENTHESES_in_dereferenced_register_with_offset1019); 

            pushFollow(FOLLOW_literal_value_in_dereferenced_register_with_offset1023);
            e1=literal_value();

            state._fsp--;


            match(input,PLUS,FOLLOW_PLUS_in_dereferenced_register_with_offset1025); 

            pushFollow(FOLLOW_dereferencable_register_in_dereferenced_register_with_offset1029);
            e2=dereferencable_register();

            state._fsp--;


            match(input,RIGHT_BLOCK_PARENTHESES,FOLLOW_RIGHT_BLOCK_PARENTHESES_in_dereferenced_register_with_offset1031); 


                            values = new int[2];
                            values[0] = OpValueCode.getRegPlusNextWordDerefOf(e2).code;
                            values[1] = e1;
                        

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return values;
    }
    // $ANTLR end "dereferenced_register_with_offset"



    // $ANTLR start "register"
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:281:1: register returns [OpValueCode value] : (e= dereferencable_register | POP | PEEK | PUSH | SP | PC | O );
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:282:5: (e= dereferencable_register | POP | PEEK | PUSH | SP | PC | O )
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
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:282:9: e= dereferencable_register
                    {
                    pushFollow(FOLLOW_dereferencable_register_in_register1070);
                    e=dereferencable_register();

                    state._fsp--;


                     value = e; 

                    }
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:283:9: POP
                    {
                    POP4=(Token)match(input,POP,FOLLOW_POP_in_register1082); 

                     value = OpValueCode.valueOf((POP4!=null?POP4.getText():null)); 

                    }
                    break;
                case 3 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:284:9: PEEK
                    {
                    PEEK5=(Token)match(input,PEEK,FOLLOW_PEEK_in_register1094); 

                     value = OpValueCode.valueOf((PEEK5!=null?PEEK5.getText():null)); 

                    }
                    break;
                case 4 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:285:9: PUSH
                    {
                    PUSH6=(Token)match(input,PUSH,FOLLOW_PUSH_in_register1106); 

                     value = OpValueCode.valueOf((PUSH6!=null?PUSH6.getText():null)); 

                    }
                    break;
                case 5 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:286:9: SP
                    {
                    SP7=(Token)match(input,SP,FOLLOW_SP_in_register1118); 

                     value = OpValueCode.valueOf((SP7!=null?SP7.getText():null)); 

                    }
                    break;
                case 6 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:287:9: PC
                    {
                    PC8=(Token)match(input,PC,FOLLOW_PC_in_register1130); 

                     value = OpValueCode.valueOf((PC8!=null?PC8.getText():null)); 

                    }
                    break;
                case 7 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:288:9: O
                    {
                    O9=(Token)match(input,O,FOLLOW_O_in_register1142); 

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
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:291:1: dereferencable_register returns [OpValueCode value] : ( A | B | C | X | Y | Z | I | J );
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:292:5: ( A | B | C | X | Y | Z | I | J )
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
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:292:9: A
                    {
                    A10=(Token)match(input,A,FOLLOW_A_in_dereferencable_register1167); 

                     value = OpValueCode.valueOf((A10!=null?A10.getText():null)); 

                    }
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:293:9: B
                    {
                    B11=(Token)match(input,B,FOLLOW_B_in_dereferencable_register1179); 

                     value = OpValueCode.valueOf((B11!=null?B11.getText():null)); 

                    }
                    break;
                case 3 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:294:9: C
                    {
                    C12=(Token)match(input,C,FOLLOW_C_in_dereferencable_register1191); 

                     value = OpValueCode.valueOf((C12!=null?C12.getText():null)); 

                    }
                    break;
                case 4 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:295:9: X
                    {
                    X13=(Token)match(input,X,FOLLOW_X_in_dereferencable_register1203); 

                     value = OpValueCode.valueOf((X13!=null?X13.getText():null)); 

                    }
                    break;
                case 5 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:296:9: Y
                    {
                    Y14=(Token)match(input,Y,FOLLOW_Y_in_dereferencable_register1215); 

                     value = OpValueCode.valueOf((Y14!=null?Y14.getText():null)); 

                    }
                    break;
                case 6 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:297:9: Z
                    {
                    Z15=(Token)match(input,Z,FOLLOW_Z_in_dereferencable_register1227); 

                     value = OpValueCode.valueOf((Z15!=null?Z15.getText():null)); 

                    }
                    break;
                case 7 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:298:9: I
                    {
                    I16=(Token)match(input,I,FOLLOW_I_in_dereferencable_register1239); 

                     value = OpValueCode.valueOf((I16!=null?I16.getText():null)); 

                    }
                    break;
                case 8 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:299:9: J
                    {
                    J17=(Token)match(input,J,FOLLOW_J_in_dereferencable_register1251); 

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
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:302:1: dereferenced_literal_value returns [int value] : LEFT_BLOCK_PARENTHESES e= literal_value RIGHT_BLOCK_PARENTHESES ;
    public final int dereferenced_literal_value() throws RecognitionException {
        int value = 0;


        int e =0;


        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:303:5: ( LEFT_BLOCK_PARENTHESES e= literal_value RIGHT_BLOCK_PARENTHESES )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:303:9: LEFT_BLOCK_PARENTHESES e= literal_value RIGHT_BLOCK_PARENTHESES
            {
            match(input,LEFT_BLOCK_PARENTHESES,FOLLOW_LEFT_BLOCK_PARENTHESES_in_dereferenced_literal_value1280); 

            pushFollow(FOLLOW_literal_value_in_dereferenced_literal_value1284);
            e=literal_value();

            state._fsp--;


            match(input,RIGHT_BLOCK_PARENTHESES,FOLLOW_RIGHT_BLOCK_PARENTHESES_in_dereferenced_literal_value1286); 


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
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:309:1: literal_value returns [int value] : ( HEX_NUMBER | DEC_NUMBER );
    public final int literal_value() throws RecognitionException {
        int value = 0;


        Token HEX_NUMBER18=null;
        Token DEC_NUMBER19=null;

        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:310:5: ( HEX_NUMBER | DEC_NUMBER )
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
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:310:9: HEX_NUMBER
                    {
                    HEX_NUMBER18=(Token)match(input,HEX_NUMBER,FOLLOW_HEX_NUMBER_in_literal_value1323); 


                                    value = Integer.parseInt((HEX_NUMBER18!=null?HEX_NUMBER18.getText():null).substring(2), 16);
                                

                    }
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:314:9: DEC_NUMBER
                    {
                    DEC_NUMBER19=(Token)match(input,DEC_NUMBER,FOLLOW_DEC_NUMBER_in_literal_value1347); 


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
    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:320:1: label_declaration : LABEL_DECLARATION ;
    public final void label_declaration() throws RecognitionException {
        Token LABEL_DECLARATION20=null;

        try {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:321:5: ( LABEL_DECLARATION )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:321:9: LABEL_DECLARATION
            {
            LABEL_DECLARATION20=(Token)match(input,LABEL_DECLARATION,FOLLOW_LABEL_DECLARATION_in_label_declaration1380); 


                            String labelName = (LABEL_DECLARATION20!=null?LABEL_DECLARATION20.getText():null).substring(1);
                            if(identifiedLabels.containsKey(labelName)) {
                                throw new RuntimeException("Label name '"+ labelName +"' already declared.");
                            }
                            identifiedLabels.put(labelName, wordCount);
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
        return ;
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
            return "()+ loopback of 114:9: (s1= statement NEWLINE | ( WS )? NEWLINE )+";
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
    public static final BitSet FOLLOW_label_declaration_in_statement455 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_WS_in_statement457 = new BitSet(new long[]{0x0000097016179160L});
    public static final BitSet FOLLOW_NEWLINE_in_statement460 = new BitSet(new long[]{0x0000020010000000L});
    public static final BitSet FOLLOW_WS_in_statement463 = new BitSet(new long[]{0x0000097016179160L});
    public static final BitSet FOLLOW_operation_in_statement471 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_WS_in_statement473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_basic_operation_code_in_operation532 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_WS_in_operation534 = new BitSet(new long[]{0x00003486E0C86A90L});
    public static final BitSet FOLLOW_operation_value_in_operation538 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_operation540 = new BitSet(new long[]{0x00003686E0C86A90L});
    public static final BitSet FOLLOW_WS_in_operation542 = new BitSet(new long[]{0x00003486E0C86A90L});
    public static final BitSet FOLLOW_operation_value_in_operation547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_non_basic_operation_code_in_operation571 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_WS_in_operation573 = new BitSet(new long[]{0x00003486E0C86A90L});
    public static final BitSet FOLLOW_operation_value_in_operation577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSR_in_non_basic_operation_code769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_register_in_operation_value811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dereferenced_register_in_operation_value837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dereferenced_register_with_offset_in_operation_value863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_value_in_operation_value889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dereferenced_literal_value_in_operation_value915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LABEL_IDENTIFIER_in_operation_value939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_BLOCK_PARENTHESES_in_dereferenced_register976 = new BitSet(new long[]{0x0000340000084290L});
    public static final BitSet FOLLOW_dereferencable_register_in_dereferenced_register980 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RIGHT_BLOCK_PARENTHESES_in_dereferenced_register982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_BLOCK_PARENTHESES_in_dereferenced_register_with_offset1019 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_literal_value_in_dereferenced_register_with_offset1023 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_PLUS_in_dereferenced_register_with_offset1025 = new BitSet(new long[]{0x0000340000084290L});
    public static final BitSet FOLLOW_dereferencable_register_in_dereferenced_register_with_offset1029 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RIGHT_BLOCK_PARENTHESES_in_dereferenced_register_with_offset1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dereferencable_register_in_register1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POP_in_register1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PEEK_in_register1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PUSH_in_register1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SP_in_register1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PC_in_register1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_O_in_register1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_A_in_dereferencable_register1167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_B_in_dereferencable_register1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_C_in_dereferencable_register1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_X_in_dereferencable_register1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Y_in_dereferencable_register1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Z_in_dereferencable_register1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_I_in_dereferencable_register1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_J_in_dereferencable_register1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_BLOCK_PARENTHESES_in_dereferenced_literal_value1280 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_literal_value_in_dereferenced_literal_value1284 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RIGHT_BLOCK_PARENTHESES_in_dereferenced_literal_value1286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_NUMBER_in_literal_value1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_NUMBER_in_literal_value1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LABEL_DECLARATION_in_label_declaration1380 = new BitSet(new long[]{0x0000000000000002L});

}