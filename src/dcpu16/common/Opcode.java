package dcpu16.common;

import java.util.HashMap;
import java.util.Map;

public enum OpCode {
	
	NON_BASIC_INSTR(0x0, "non-basic instruction"),
    SET(0x1, "SET a, b - sets a to b"),
    ADD(0x2, "ADD a, b - sets a to a+b, sets O to 0x0001 if there's an overflow, 0x0 otherwise"),
    SUB(0x3, "SUB a, b - sets a to a-b, sets O to 0xffff if there's an underflow, 0x0 otherwise"),
    MUL(0x4, "MUL a, b - sets a to a*b, sets O to ((a*b)>>16)&0xffff"),
    DIV(0x5, "DIV a, b - sets a to a/b, sets O to ((a<<16)/b)&0xffff. if b==0, sets a and O to 0 instead."),
    MOD(0x6, "MOD a, b - sets a to a%b. if b==0, sets a to 0 instead."),
    SHL(0x7, "SHL a, b - sets a to a<<b, sets O to ((a<<b)>>16)&0xffff"),
    SHR(0x8, "SHR a, b - sets a to a>>b, sets O to ((a<<16)>>b)&0xffff"),
    AND(0x9, "AND a, b - sets a to a&b"),
    BOR(0xa, "BOR a, b - sets a to a|b"),
    XOR(0xb, "XOR a, b - sets a to a^b"),
    IFE(0xc, "IFE a, b - performs next instruction only if a==b"),
    IFN(0xd, "IFN a, b - performs next instruction only if a!=b"),
    IFG(0xe, "IFG a, b - performs next instruction only if a>b"),
    IFB(0xf, "IFB a, b - performs next instruction only if (a&b)!=0"),
    
    //Non basic instruction
    JSR(0x10, "JSR a - pushes the address of the next instruction to the stack, then sets PC to a");

	
	public static final int BIT_MASK_BASIC = 0xF;		//4 bits
	public static final int BIT_MASK_NON_BASIC = 0x3FF;	//10 bits
	private static final Map<Integer,OpCode> OPCODE_MAP;
	static {
		OPCODE_MAP = new HashMap<Integer,OpCode>();
		for(OpCode o : OpCode.values()) {
			OPCODE_MAP.put(o.code, o);
		}
	}
	
	public int code;
	public String description;
	
	private OpCode(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public boolean isBasicOpcode() {
		return (!this.equals(NON_BASIC_INSTR) && !this.equals(JSR));
	}
	
	public static OpCode getOpcodeFromWord(int word) {
		int code = word & BIT_MASK_BASIC;
		if(OPCODE_MAP.containsKey(code)) {
			return OPCODE_MAP.get(code);
		}
		throw new RuntimeException("Unknown opcode '"+ code +"', SHOULD NEVER HAPPEN!");
	}
	
	public static OpCode getNonBasicOpcodeFromWord(int word) {
		int code = word & BIT_MASK_NON_BASIC;
		if(OPCODE_MAP.containsKey(code)) {
			return OPCODE_MAP.get(code);
		}
		throw new RuntimeException("Unknown non-basic opcode '"+ code +"', SHOULD NEVER HAPPEN!");
	}
	
	/*
	0x0: non-basic instruction - see below
    0x1: SET a, b - sets a to b
    0x2: ADD a, b - sets a to a+b, sets O to 0x0001 if there's an overflow, 0x0 otherwise
    0x3: SUB a, b - sets a to a-b, sets O to 0xffff if there's an underflow, 0x0 otherwise
    0x4: MUL a, b - sets a to a*b, sets O to ((a*b)>>16)&0xffff
    0x5: DIV a, b - sets a to a/b, sets O to ((a<<16)/b)&0xffff. if b==0, sets a and O to 0 instead.
    0x6: MOD a, b - sets a to a%b. if b==0, sets a to 0 instead.
    0x7: SHL a, b - sets a to a<<b, sets O to ((a<<b)>>16)&0xffff
    0x8: SHR a, b - sets a to a>>b, sets O to ((a<<16)>>b)&0xffff
    0x9: AND a, b - sets a to a&b
    0xa: BOR a, b - sets a to a|b
    0xb: XOR a, b - sets a to a^b
    0xc: IFE a, b - performs next instruction only if a==b
    0xd: IFN a, b - performs next instruction only if a!=b
    0xe: IFG a, b - performs next instruction only if a>b
    0xf: IFB a, b - performs next instruction only if (a&b)!=0
    */
}
