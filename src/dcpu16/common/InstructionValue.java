package dcpu16.common;

public enum InstructionValue {
	
	A(0x00),
	B(0x01),
	C(0x02),
	X(0x03),
	Y(0x04),
	Z(0x05),
	I(0x06),
	J(0x07),
	
	A_DEREF(0x08),
	B_DEREF(0x09),
	C_DEREF(0x0A),
	X_DEREF(0x0B),
	Y_DEREF(0x0C),
	Z_DEREF(0x0D),
	I_DEREF(0x0E),
	J_DEREF(0x0F),

	A_PLUS_NW_DEREF(0x10),
	B_PLUS_NW_DEREF(0x11),
	C_PLUS_NW_DEREF(0x12),
	X_PLUS_NW_DEREF(0x13),
	Y_PLUS_NW_DEREF(0x14),
	Z_PLUS_NW_DEREF(0x15),
	I_PLUS_NW_DEREF(0x16),
	J_PLUS_NW_DEREF(0x17),
	
	POP(0x18),
	PEEK(0x19),
	PUSH(0x1A),
	SP(0x1B),
	PC(0x1C),
	O(0x1D),
	NEXT_WORD_DEREF(0x1E),
	NEXT_WORD(0x1F),
	
	LITERAL_OFFSET(0x20);
	
	/*
	LITERAL_00(0x20),
	LITERAL_01(0x21),
	LITERAL_02(0x22),
	LITERAL_03(0x23),
	LITERAL_04(0x24),
	LITERAL_05(0x25),
	LITERAL_06(0x26),
	LITERAL_07(0x27),
	LITERAL_08(0x28),
	LITERAL_09(0x29),
	LITERAL_0A(0x2A),
	LITERAL_0B(0x2B),
	LITERAL_0C(0x2C),
	LITERAL_0D(0x2D),
	LITERAL_0E(0x2E),
	LITERAL_0F(0x2F),
	LITERAL_10(0x30),
	LITERAL_11(0x31),
	LITERAL_12(0x32),
	LITERAL_13(0x33),
	LITERAL_14(0x34),
	LITERAL_15(0x35),
	LITERAL_16(0x36),
	LITERAL_17(0x37),
	LITERAL_18(0x38),
	LITERAL_19(0x39),
	LITERAL_1A(0x3A),
	LITERAL_1B(0x3B),
	LITERAL_1C(0x3C),
	LITERAL_1D(0x3D),
	LITERAL_1E(0x3E),
	LITERAL_1F(0x3F);
	 */
    

	public final int code;
	
	private InstructionValue(int code) {
		this.code = code;
	}
	
	public static boolean isDerefencableRegister(InstructionValue register) {
		switch(register) {
		case A: 
		case B:
		case C:
		case X:
		case Y:
		case Z:
		case I:
		case J: {
			return true;
		}
		}
		return false;
	}
	
	public static boolean isDerefencedRegister(InstructionValue register) {
		switch(register) {
		case A_DEREF: 
		case B_DEREF:
		case C_DEREF:
		case X_DEREF:
		case Y_DEREF:
		case Z_DEREF:
		case I_DEREF:
		case J_DEREF: {
			return true;
		}
		}
		return false;
	}
	
	public static InstructionValue getDerefOf(InstructionValue register) {
		if(isDerefencableRegister(register)) {
			return InstructionValue.valueOf(register.name()+"_DEREF"); 
		}
		else {
			throw new RuntimeException(register +" is not a 'basic' register.");
		}
	}

	public static InstructionValue getNonDerefOf(InstructionValue register) {
		if(isDerefencedRegister(register)) {
			return InstructionValue.valueOf(register.name().substring(0, 1)); 
		}
		else {
			throw new RuntimeException(register +" is not a 'basic' register.");
		}
	}

	public static InstructionValue getRegPlusNextWordDerefOf(InstructionValue register) {
		if(isDerefencableRegister(register)) {
			return InstructionValue.valueOf(register.name()+"_PLUS_NW_DEREF"); 
		}
		else {
			throw new RuntimeException(register +" is not a 'basic' register.");
		}
	}
}
