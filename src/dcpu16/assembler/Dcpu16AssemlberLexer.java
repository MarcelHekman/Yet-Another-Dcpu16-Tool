// $ANTLR 3.4 E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g 2012-04-10 20:00:30

package dcpu16.assembler;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Dcpu16AssemlberLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public Dcpu16AssemlberLexer() {} 
    public Dcpu16AssemlberLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Dcpu16AssemlberLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g"; }

    // $ANTLR start "A"
    public final void mA() throws RecognitionException {
        try {
            int _type = A;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:11:3: ( 'A' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:11:5: 'A'
            {
            match('A'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "A"

    // $ANTLR start "ADD"
    public final void mADD() throws RecognitionException {
        try {
            int _type = ADD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:12:5: ( 'ADD' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:12:7: 'ADD'
            {
            match("ADD"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ADD"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:13:5: ( 'AND' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:13:7: 'AND'
            {
            match("AND"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "B"
    public final void mB() throws RecognitionException {
        try {
            int _type = B;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:14:3: ( 'B' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:14:5: 'B'
            {
            match('B'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "B"

    // $ANTLR start "BOR"
    public final void mBOR() throws RecognitionException {
        try {
            int _type = BOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:15:5: ( 'BOR' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:15:7: 'BOR'
            {
            match("BOR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOR"

    // $ANTLR start "C"
    public final void mC() throws RecognitionException {
        try {
            int _type = C;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:16:3: ( 'C' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:16:5: 'C'
            {
            match('C'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "C"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:17:5: ( 'DIV' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:17:7: 'DIV'
            {
            match("DIV"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "I"
    public final void mI() throws RecognitionException {
        try {
            int _type = I;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:18:3: ( 'I' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:18:5: 'I'
            {
            match('I'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "I"

    // $ANTLR start "IFB"
    public final void mIFB() throws RecognitionException {
        try {
            int _type = IFB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:19:5: ( 'IFB' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:19:7: 'IFB'
            {
            match("IFB"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IFB"

    // $ANTLR start "IFE"
    public final void mIFE() throws RecognitionException {
        try {
            int _type = IFE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:20:5: ( 'IFE' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:20:7: 'IFE'
            {
            match("IFE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IFE"

    // $ANTLR start "IFG"
    public final void mIFG() throws RecognitionException {
        try {
            int _type = IFG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:21:5: ( 'IFG' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:21:7: 'IFG'
            {
            match("IFG"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IFG"

    // $ANTLR start "IFN"
    public final void mIFN() throws RecognitionException {
        try {
            int _type = IFN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:22:5: ( 'IFN' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:22:7: 'IFN'
            {
            match("IFN"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IFN"

    // $ANTLR start "J"
    public final void mJ() throws RecognitionException {
        try {
            int _type = J;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:23:3: ( 'J' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:23:5: 'J'
            {
            match('J'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "J"

    // $ANTLR start "JSR"
    public final void mJSR() throws RecognitionException {
        try {
            int _type = JSR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:24:5: ( 'JSR' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:24:7: 'JSR'
            {
            match("JSR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "JSR"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:25:5: ( 'MOD' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:25:7: 'MOD'
            {
            match("MOD"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "MUL"
    public final void mMUL() throws RecognitionException {
        try {
            int _type = MUL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:26:5: ( 'MUL' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:26:7: 'MUL'
            {
            match("MUL"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MUL"

    // $ANTLR start "O"
    public final void mO() throws RecognitionException {
        try {
            int _type = O;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:27:3: ( 'O' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:27:5: 'O'
            {
            match('O'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "O"

    // $ANTLR start "PC"
    public final void mPC() throws RecognitionException {
        try {
            int _type = PC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:28:4: ( 'PC' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:28:6: 'PC'
            {
            match("PC"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PC"

    // $ANTLR start "PEEK"
    public final void mPEEK() throws RecognitionException {
        try {
            int _type = PEEK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:29:6: ( 'PEEK' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:29:8: 'PEEK'
            {
            match("PEEK"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PEEK"

    // $ANTLR start "POP"
    public final void mPOP() throws RecognitionException {
        try {
            int _type = POP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:30:5: ( 'POP' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:30:7: 'POP'
            {
            match("POP"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "POP"

    // $ANTLR start "PUSH"
    public final void mPUSH() throws RecognitionException {
        try {
            int _type = PUSH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:31:6: ( 'PUSH' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:31:8: 'PUSH'
            {
            match("PUSH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PUSH"

    // $ANTLR start "SET"
    public final void mSET() throws RecognitionException {
        try {
            int _type = SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:32:5: ( 'SET' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:32:7: 'SET'
            {
            match("SET"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SET"

    // $ANTLR start "SHL"
    public final void mSHL() throws RecognitionException {
        try {
            int _type = SHL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:33:5: ( 'SHL' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:33:7: 'SHL'
            {
            match("SHL"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHL"

    // $ANTLR start "SHR"
    public final void mSHR() throws RecognitionException {
        try {
            int _type = SHR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:34:5: ( 'SHR' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:34:7: 'SHR'
            {
            match("SHR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHR"

    // $ANTLR start "SP"
    public final void mSP() throws RecognitionException {
        try {
            int _type = SP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:35:4: ( 'SP' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:35:6: 'SP'
            {
            match("SP"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SP"

    // $ANTLR start "SUB"
    public final void mSUB() throws RecognitionException {
        try {
            int _type = SUB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:36:5: ( 'SUB' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:36:7: 'SUB'
            {
            match("SUB"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SUB"

    // $ANTLR start "X"
    public final void mX() throws RecognitionException {
        try {
            int _type = X;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:37:3: ( 'X' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:37:5: 'X'
            {
            match('X'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "X"

    // $ANTLR start "XOR"
    public final void mXOR() throws RecognitionException {
        try {
            int _type = XOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:38:5: ( 'XOR' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:38:7: 'XOR'
            {
            match("XOR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "XOR"

    // $ANTLR start "Y"
    public final void mY() throws RecognitionException {
        try {
            int _type = Y;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:39:3: ( 'Y' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:39:5: 'Y'
            {
            match('Y'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Y"

    // $ANTLR start "Z"
    public final void mZ() throws RecognitionException {
        try {
            int _type = Z;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:40:3: ( 'Z' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:40:5: 'Z'
            {
            match('Z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Z"

    // $ANTLR start "HEX_NUMBER"
    public final void mHEX_NUMBER() throws RecognitionException {
        try {
            int _type = HEX_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:335:5: ( '0x' ( '0' .. '9' | 'A' .. 'F' )+ )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:335:9: '0x' ( '0' .. '9' | 'A' .. 'F' )+
            {
            match("0x"); 



            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:335:14: ( '0' .. '9' | 'A' .. 'F' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'F')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_NUMBER"

    // $ANTLR start "DEC_NUMBER"
    public final void mDEC_NUMBER() throws RecognitionException {
        try {
            int _type = DEC_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:339:5: ( ( '0' .. '9' ) ( '0' .. '9' )* )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:339:9: ( '0' .. '9' ) ( '0' .. '9' )*
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:339:20: ( '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEC_NUMBER"

    // $ANTLR start "MULTI_LINE_COMMENT"
    public final void mMULTI_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTI_LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:343:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:343:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:344:9: ( options {greedy=false; } : . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='*') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='/') ) {
                        alt3=2;
                    }
                    else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '.')||(LA3_1 >= '0' && LA3_1 <= '\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= ')')||(LA3_0 >= '+' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:344:36: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match("*/"); 




                            skip();
                        

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULTI_LINE_COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:352:5: ( ( '//' | ';' | '#' ) (~ ( '\\n' | '\\r' ) )* )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:352:9: ( '//' | ';' | '#' ) (~ ( '\\n' | '\\r' ) )*
            {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:352:9: ( '//' | ';' | '#' )
            int alt4=3;
            switch ( input.LA(1) ) {
            case '/':
                {
                alt4=1;
                }
                break;
            case ';':
                {
                alt4=2;
                }
                break;
            case '#':
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:352:10: '//'
                    {
                    match("//"); 



                    }
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:352:15: ';'
                    {
                    match(';'); 

                    }
                    break;
                case 3 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:352:19: '#'
                    {
                    match('#'); 

                    }
                    break;

            }


            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:352:24: (~ ( '\\n' | '\\r' ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);



                            skip();
                        

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "LEFT_BLOCK_PARENTHESES"
    public final void mLEFT_BLOCK_PARENTHESES() throws RecognitionException {
        try {
            int _type = LEFT_BLOCK_PARENTHESES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:359:5: ( '[' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:359:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT_BLOCK_PARENTHESES"

    // $ANTLR start "RIGHT_BLOCK_PARENTHESES"
    public final void mRIGHT_BLOCK_PARENTHESES() throws RecognitionException {
        try {
            int _type = RIGHT_BLOCK_PARENTHESES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:363:5: ( ']' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:363:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT_BLOCK_PARENTHESES"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:367:5: ( ',' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:367:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:371:5: ( '+' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:371:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:375:5: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:375:9: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:375:9: ( '\\r\\n' | '\\r' | '\\n' )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='\n') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
            }
            else if ( (LA6_0=='\n') ) {
                alt6=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:375:10: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:375:17: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:375:22: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:379:5: ( ( ' ' | '\\t' )+ )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:379:9: ( ' ' | '\\t' )+
            {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:379:9: ( ' ' | '\\t' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "LABEL_DECLARATION"
    public final void mLABEL_DECLARATION() throws RecognitionException {
        try {
            int _type = LABEL_DECLARATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:383:5: ( ':' LABEL_IDENTIFIER )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:383:9: ':' LABEL_IDENTIFIER
            {
            match(':'); 

            mLABEL_IDENTIFIER(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LABEL_DECLARATION"

    // $ANTLR start "LABEL_IDENTIFIER"
    public final void mLABEL_IDENTIFIER() throws RecognitionException {
        try {
            int _type = LABEL_IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:387:5: ( ( 'a' .. 'z' )+ )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:387:9: ( 'a' .. 'z' )+
            {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:387:9: ( 'a' .. 'z' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:
            	    {
            	    if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LABEL_IDENTIFIER"

    public void mTokens() throws RecognitionException {
        // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:8: ( A | ADD | AND | B | BOR | C | DIV | I | IFB | IFE | IFG | IFN | J | JSR | MOD | MUL | O | PC | PEEK | POP | PUSH | SET | SHL | SHR | SP | SUB | X | XOR | Y | Z | HEX_NUMBER | DEC_NUMBER | MULTI_LINE_COMMENT | LINE_COMMENT | LEFT_BLOCK_PARENTHESES | RIGHT_BLOCK_PARENTHESES | COMMA | PLUS | NEWLINE | WS | LABEL_DECLARATION | LABEL_IDENTIFIER )
        int alt9=42;
        switch ( input.LA(1) ) {
        case 'A':
            {
            switch ( input.LA(2) ) {
            case 'D':
                {
                alt9=2;
                }
                break;
            case 'N':
                {
                alt9=3;
                }
                break;
            default:
                alt9=1;
            }

            }
            break;
        case 'B':
            {
            int LA9_2 = input.LA(2);

            if ( (LA9_2=='O') ) {
                alt9=5;
            }
            else {
                alt9=4;
            }
            }
            break;
        case 'C':
            {
            alt9=6;
            }
            break;
        case 'D':
            {
            alt9=7;
            }
            break;
        case 'I':
            {
            int LA9_5 = input.LA(2);

            if ( (LA9_5=='F') ) {
                switch ( input.LA(3) ) {
                case 'B':
                    {
                    alt9=9;
                    }
                    break;
                case 'E':
                    {
                    alt9=10;
                    }
                    break;
                case 'G':
                    {
                    alt9=11;
                    }
                    break;
                case 'N':
                    {
                    alt9=12;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 31, input);

                    throw nvae;

                }

            }
            else {
                alt9=8;
            }
            }
            break;
        case 'J':
            {
            int LA9_6 = input.LA(2);

            if ( (LA9_6=='S') ) {
                alt9=14;
            }
            else {
                alt9=13;
            }
            }
            break;
        case 'M':
            {
            int LA9_7 = input.LA(2);

            if ( (LA9_7=='O') ) {
                alt9=15;
            }
            else if ( (LA9_7=='U') ) {
                alt9=16;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 7, input);

                throw nvae;

            }
            }
            break;
        case 'O':
            {
            alt9=17;
            }
            break;
        case 'P':
            {
            switch ( input.LA(2) ) {
            case 'C':
                {
                alt9=18;
                }
                break;
            case 'E':
                {
                alt9=19;
                }
                break;
            case 'O':
                {
                alt9=20;
                }
                break;
            case 'U':
                {
                alt9=21;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 9, input);

                throw nvae;

            }

            }
            break;
        case 'S':
            {
            switch ( input.LA(2) ) {
            case 'E':
                {
                alt9=22;
                }
                break;
            case 'H':
                {
                int LA9_42 = input.LA(3);

                if ( (LA9_42=='L') ) {
                    alt9=23;
                }
                else if ( (LA9_42=='R') ) {
                    alt9=24;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 42, input);

                    throw nvae;

                }
                }
                break;
            case 'P':
                {
                alt9=25;
                }
                break;
            case 'U':
                {
                alt9=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 10, input);

                throw nvae;

            }

            }
            break;
        case 'X':
            {
            int LA9_11 = input.LA(2);

            if ( (LA9_11=='O') ) {
                alt9=28;
            }
            else {
                alt9=27;
            }
            }
            break;
        case 'Y':
            {
            alt9=29;
            }
            break;
        case 'Z':
            {
            alt9=30;
            }
            break;
        case '0':
            {
            int LA9_14 = input.LA(2);

            if ( (LA9_14=='x') ) {
                alt9=31;
            }
            else {
                alt9=32;
            }
            }
            break;
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt9=32;
            }
            break;
        case '/':
            {
            int LA9_16 = input.LA(2);

            if ( (LA9_16=='*') ) {
                alt9=33;
            }
            else if ( (LA9_16=='/') ) {
                alt9=34;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 16, input);

                throw nvae;

            }
            }
            break;
        case '#':
        case ';':
            {
            alt9=34;
            }
            break;
        case '[':
            {
            alt9=35;
            }
            break;
        case ']':
            {
            alt9=36;
            }
            break;
        case ',':
            {
            alt9=37;
            }
            break;
        case '+':
            {
            alt9=38;
            }
            break;
        case '\n':
        case '\r':
            {
            alt9=39;
            }
            break;
        case '\t':
        case ' ':
            {
            alt9=40;
            }
            break;
        case ':':
            {
            alt9=41;
            }
            break;
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt9=42;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 9, 0, input);

            throw nvae;

        }

        switch (alt9) {
            case 1 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:10: A
                {
                mA(); 


                }
                break;
            case 2 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:12: ADD
                {
                mADD(); 


                }
                break;
            case 3 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:16: AND
                {
                mAND(); 


                }
                break;
            case 4 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:20: B
                {
                mB(); 


                }
                break;
            case 5 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:22: BOR
                {
                mBOR(); 


                }
                break;
            case 6 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:26: C
                {
                mC(); 


                }
                break;
            case 7 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:28: DIV
                {
                mDIV(); 


                }
                break;
            case 8 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:32: I
                {
                mI(); 


                }
                break;
            case 9 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:34: IFB
                {
                mIFB(); 


                }
                break;
            case 10 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:38: IFE
                {
                mIFE(); 


                }
                break;
            case 11 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:42: IFG
                {
                mIFG(); 


                }
                break;
            case 12 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:46: IFN
                {
                mIFN(); 


                }
                break;
            case 13 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:50: J
                {
                mJ(); 


                }
                break;
            case 14 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:52: JSR
                {
                mJSR(); 


                }
                break;
            case 15 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:56: MOD
                {
                mMOD(); 


                }
                break;
            case 16 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:60: MUL
                {
                mMUL(); 


                }
                break;
            case 17 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:64: O
                {
                mO(); 


                }
                break;
            case 18 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:66: PC
                {
                mPC(); 


                }
                break;
            case 19 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:69: PEEK
                {
                mPEEK(); 


                }
                break;
            case 20 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:74: POP
                {
                mPOP(); 


                }
                break;
            case 21 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:78: PUSH
                {
                mPUSH(); 


                }
                break;
            case 22 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:83: SET
                {
                mSET(); 


                }
                break;
            case 23 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:87: SHL
                {
                mSHL(); 


                }
                break;
            case 24 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:91: SHR
                {
                mSHR(); 


                }
                break;
            case 25 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:95: SP
                {
                mSP(); 


                }
                break;
            case 26 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:98: SUB
                {
                mSUB(); 


                }
                break;
            case 27 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:102: X
                {
                mX(); 


                }
                break;
            case 28 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:104: XOR
                {
                mXOR(); 


                }
                break;
            case 29 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:108: Y
                {
                mY(); 


                }
                break;
            case 30 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:110: Z
                {
                mZ(); 


                }
                break;
            case 31 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:112: HEX_NUMBER
                {
                mHEX_NUMBER(); 


                }
                break;
            case 32 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:123: DEC_NUMBER
                {
                mDEC_NUMBER(); 


                }
                break;
            case 33 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:134: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); 


                }
                break;
            case 34 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:153: LINE_COMMENT
                {
                mLINE_COMMENT(); 


                }
                break;
            case 35 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:166: LEFT_BLOCK_PARENTHESES
                {
                mLEFT_BLOCK_PARENTHESES(); 


                }
                break;
            case 36 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:189: RIGHT_BLOCK_PARENTHESES
                {
                mRIGHT_BLOCK_PARENTHESES(); 


                }
                break;
            case 37 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:213: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 38 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:219: PLUS
                {
                mPLUS(); 


                }
                break;
            case 39 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:224: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 40 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:232: WS
                {
                mWS(); 


                }
                break;
            case 41 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:235: LABEL_DECLARATION
                {
                mLABEL_DECLARATION(); 


                }
                break;
            case 42 :
                // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:1:253: LABEL_IDENTIFIER
                {
                mLABEL_IDENTIFIER(); 


                }
                break;

        }

    }


 

}