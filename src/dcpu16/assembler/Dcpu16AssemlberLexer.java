// $ANTLR 3.4 E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g 2012-04-14 01:34:58

package dcpu16.assembler;

import java.util.HashMap;
import java.util.Map;


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

    Map<String, Integer> caseInsensitiveKeywords = new HashMap<String,Integer>() {{
            //Instructions
            put("SET", SET);
            put("ADD", ADD); 
            put("SUB", SUB); 
            put("MUL", MUL); 
            put("DIV", DIV);
            put("MOD", MOD);
            put("SHL", SHL);
            put("SHR", SHR);
            put("AND", AND);
            put("BOR", BOR);
            put("XOR", XOR);
            put("IFE", IFE);
            put("IFN", IFN);
            put("IFG", IFG);
            put("IFB", IFB);
            put("JSR", JSR);
                
            //Register names
            put("A", A);
            put("B", B);
            put("C", C);
            put("X", X);
            put("Y", Y);
            put("Z", Z);
            put("I", I);
            put("J", J);
            put("POP", POP);
            put("PEEK", PEEK);
            put("PUSH", PUSH);
            put("SP", SP);
            put("PC", PC);
            put("O", O);
      }};


    private int checkKeywordsTable(String lexeme)
    {
        lexeme = lexeme.toUpperCase();
        if(caseInsensitiveKeywords.containsKey(lexeme)) {
            return caseInsensitiveKeywords.get(lexeme);
        }
        else {
            return LABEL_IDENTIFIER;
        }
    }


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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:63:3: ( 'A' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:63:5: 'A'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:64:5: ( 'ADD' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:64:7: 'ADD'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:65:5: ( 'AND' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:65:7: 'AND'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:66:3: ( 'B' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:66:5: 'B'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:67:5: ( 'BOR' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:67:7: 'BOR'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:68:3: ( 'C' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:68:5: 'C'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:69:5: ( 'DIV' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:69:7: 'DIV'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:70:3: ( 'I' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:70:5: 'I'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:71:5: ( 'IFB' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:71:7: 'IFB'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:72:5: ( 'IFE' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:72:7: 'IFE'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:73:5: ( 'IFG' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:73:7: 'IFG'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:74:5: ( 'IFN' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:74:7: 'IFN'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:75:3: ( 'J' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:75:5: 'J'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:76:5: ( 'JSR' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:76:7: 'JSR'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:77:5: ( 'MOD' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:77:7: 'MOD'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:78:5: ( 'MUL' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:78:7: 'MUL'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:79:3: ( 'O' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:79:5: 'O'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:80:4: ( 'PC' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:80:6: 'PC'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:81:6: ( 'PEEK' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:81:8: 'PEEK'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:82:5: ( 'POP' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:82:7: 'POP'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:83:6: ( 'PUSH' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:83:8: 'PUSH'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:84:5: ( 'SET' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:84:7: 'SET'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:85:5: ( 'SHL' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:85:7: 'SHL'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:86:5: ( 'SHR' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:86:7: 'SHR'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:87:4: ( 'SP' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:87:6: 'SP'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:88:5: ( 'SUB' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:88:7: 'SUB'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:89:3: ( 'X' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:89:5: 'X'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:90:5: ( 'XOR' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:90:7: 'XOR'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:91:3: ( 'Y' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:91:5: 'Y'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:92:3: ( 'Z' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:92:5: 'Z'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:374:5: ( '0x' ( '0' .. '9' | 'A' .. 'F' )+ )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:374:9: '0x' ( '0' .. '9' | 'A' .. 'F' )+
            {
            match("0x"); 



            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:374:14: ( '0' .. '9' | 'A' .. 'F' )+
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:378:5: ( ( '0' .. '9' ) ( '0' .. '9' )* )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:378:9: ( '0' .. '9' ) ( '0' .. '9' )*
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:378:20: ( '0' .. '9' )*
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:382:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:382:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:383:9: ( options {greedy=false; } : . )*
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
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:383:36: .
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:391:5: ( ( '//' | ';' | '#' ) (~ ( '\\n' | '\\r' ) )* )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:391:9: ( '//' | ';' | '#' ) (~ ( '\\n' | '\\r' ) )*
            {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:391:9: ( '//' | ';' | '#' )
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
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:391:10: '//'
                    {
                    match("//"); 



                    }
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:391:15: ';'
                    {
                    match(';'); 

                    }
                    break;
                case 3 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:391:19: '#'
                    {
                    match('#'); 

                    }
                    break;

            }


            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:391:24: (~ ( '\\n' | '\\r' ) )*
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:398:5: ( '[' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:398:9: '['
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:402:5: ( ']' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:402:9: ']'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:406:5: ( ',' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:406:9: ','
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:410:5: ( '+' )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:410:9: '+'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:414:5: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:414:9: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:414:9: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:414:10: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:414:17: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:414:22: '\\n'
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:418:5: ( ( ' ' | '\\t' )+ )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:418:9: ( ' ' | '\\t' )+
            {
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:418:9: ( ' ' | '\\t' )+
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:422:5: ( ':' LABEL_IDENTIFIER )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:422:9: ':' LABEL_IDENTIFIER
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
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:426:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' )* )
            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:426:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:426:29: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // E:\\utwente\\eclipse\\funstuff\\DCPU16\\src\\dcpu16\\assembler\\Dcpu16Assemlber.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
            	    break loop8;
                }
            } while (true);



                            _type = checkKeywordsTable(getText());
                        

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
        alt9 = dfa9.predict(input);
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


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\1\34\1\36\1\37\1\31\1\42\1\44\1\31\1\47\2\31\1\61\1\62"+
        "\1\63\1\17\13\uffff\2\31\1\uffff\1\31\2\uffff\2\31\1\uffff\1\31"+
        "\1\uffff\2\31\1\uffff\1\101\5\31\1\110\2\31\5\uffff\1\113\1\114"+
        "\1\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\uffff\1"+
        "\31\1\127\1\31\1\131\1\132\1\133\1\uffff\1\134\1\135\13\uffff\1"+
        "\136\1\uffff\1\137\7\uffff";
    static final String DFA9_eofS =
        "\140\uffff";
    static final String DFA9_minS =
        "\1\11\3\101\1\111\2\101\1\117\1\101\1\103\1\105\3\101\1\170\1\uffff"+
        "\1\52\11\uffff\2\104\1\uffff\1\122\2\uffff\1\126\1\102\1\uffff\1"+
        "\122\1\uffff\1\104\1\114\1\uffff\1\101\1\105\1\120\1\123\1\124\1"+
        "\114\1\101\1\102\1\122\5\uffff\13\101\1\uffff\1\113\1\101\1\110"+
        "\3\101\1\uffff\2\101\13\uffff\1\101\1\uffff\1\101\7\uffff";
    static final String DFA9_maxS =
        "\4\172\1\111\2\172\1\125\1\172\2\125\3\172\1\170\1\uffff\1\57\11"+
        "\uffff\2\104\1\uffff\1\122\2\uffff\1\126\1\116\1\uffff\1\122\1\uffff"+
        "\1\104\1\114\1\uffff\1\172\1\105\1\120\1\123\1\124\1\122\1\172\1"+
        "\102\1\122\5\uffff\13\172\1\uffff\1\113\1\172\1\110\3\172\1\uffff"+
        "\2\172\13\uffff\1\172\1\uffff\1\172\7\uffff";
    static final String DFA9_acceptS =
        "\17\uffff\1\40\1\uffff\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1"+
        "\52\2\uffff\1\1\1\uffff\1\4\1\6\2\uffff\1\10\1\uffff\1\15\2\uffff"+
        "\1\21\11\uffff\1\33\1\35\1\36\1\37\1\41\13\uffff\1\22\6\uffff\1"+
        "\31\2\uffff\1\2\1\3\1\5\1\7\1\11\1\12\1\13\1\14\1\16\1\17\1\20\1"+
        "\uffff\1\24\1\uffff\1\26\1\27\1\30\1\32\1\34\1\23\1\25";
    static final String DFA9_specialS =
        "\140\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\27\1\26\2\uffff\1\26\22\uffff\1\27\2\uffff\1\21\7\uffff\1"+
            "\25\1\24\2\uffff\1\20\1\16\11\17\1\30\1\21\5\uffff\1\1\1\2\1"+
            "\3\1\4\4\31\1\5\1\6\2\31\1\7\1\31\1\10\1\11\2\31\1\12\4\31\1"+
            "\13\1\14\1\15\1\22\1\uffff\1\23\3\uffff\32\31",
            "\3\31\1\32\11\31\1\33\14\31\4\uffff\1\31\1\uffff\32\31",
            "\16\31\1\35\13\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\40",
            "\5\31\1\41\24\31\4\uffff\1\31\1\uffff\32\31",
            "\22\31\1\43\7\31\4\uffff\1\31\1\uffff\32\31",
            "\1\45\5\uffff\1\46",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\50\1\uffff\1\51\11\uffff\1\52\5\uffff\1\53",
            "\1\54\2\uffff\1\55\7\uffff\1\56\4\uffff\1\57",
            "\16\31\1\60\13\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\64",
            "",
            "\1\65\4\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\66",
            "\1\67",
            "",
            "\1\70",
            "",
            "",
            "\1\71",
            "\1\72\2\uffff\1\73\1\uffff\1\74\6\uffff\1\75",
            "",
            "\1\76",
            "",
            "\1\77",
            "\1\100",
            "",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106\5\uffff\1\107",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\111",
            "\1\112",
            "",
            "",
            "",
            "",
            "",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\1\126",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\130",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( A | ADD | AND | B | BOR | C | DIV | I | IFB | IFE | IFG | IFN | J | JSR | MOD | MUL | O | PC | PEEK | POP | PUSH | SET | SHL | SHR | SP | SUB | X | XOR | Y | Z | HEX_NUMBER | DEC_NUMBER | MULTI_LINE_COMMENT | LINE_COMMENT | LEFT_BLOCK_PARENTHESES | RIGHT_BLOCK_PARENTHESES | COMMA | PLUS | NEWLINE | WS | LABEL_DECLARATION | LABEL_IDENTIFIER );";
        }
    }
 

}