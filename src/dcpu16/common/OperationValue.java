package dcpu16.common;

public class OperationValue {

	private OpValueCode opvalCode;
	private int literal;
	

	public OperationValue(OpValueCode code) {
		set(code);
	}
	
	public OperationValue(OpValueCode code, int literal) {
		set(code, literal);
	}
	
	
	public void set(OpValueCode code) {
		this.opvalCode = code;
		this.literal = -1;
		if(hasLiteralValue()) {
			throw new RuntimeException("This OpValueCode '"+ opvalCode +"' uses a literal value and should use a different constructor, THIS SHOULD NEVER HAPPEN!");
		}
	}
	
	public void set(OpValueCode code, int literal) {
		this.opvalCode = code;
		if(hasLiteralValue()) {
			this.literal = literal;
		}
		else {
			this.literal = -1;
		}
	}
	

	public String toString() {
		switch(opvalCode) {
		case LITERAL_OFFSET:
		case NEXT_WORD: {
			return ByteUtil.toHex(literal);
		}
		case NEXT_WORD_DEREF: {
			return '['+ ByteUtil.toHex(literal) +']';
		}
		case A_DEREF: 
		case B_DEREF:
		case C_DEREF:
		case X_DEREF:
		case Y_DEREF:
		case Z_DEREF:
		case I_DEREF:
		case J_DEREF: {
			return '['+ OpValueCode.getNonDerefOf(opvalCode).name() +']';
		}
		case A_PLUS_NW_DEREF:
		case B_PLUS_NW_DEREF:
		case C_PLUS_NW_DEREF:
		case X_PLUS_NW_DEREF:
		case Y_PLUS_NW_DEREF:
		case Z_PLUS_NW_DEREF:
		case I_PLUS_NW_DEREF:
		case J_PLUS_NW_DEREF: {
			return '['+ ByteUtil.toHex(literal) +'+'+ OpValueCode.getNonDerefOf(opvalCode).name() +']';
		}
		default: {
			if(opvalCode.usesNextWord()) {
				throw new RuntimeException("Unhandled 'next word' case, during disassembly, word: '"+ opvalCode.name() +"'.");
				//getNextWord();
			}
			return opvalCode.name();
		}
		}
	}
	
	public int getBinaryFormatCode() {
		if(opvalCode == OpValueCode.LITERAL_OFFSET) {
			return OpValueCode.LITERAL_OFFSET.code + literal;
		}
		else {
			return opvalCode.code;
		}
	}
	
	public int wordCount() {
		if(opvalCode.usesNextWord()) {
			return 1;
		}
		return 0;
	}
	
	public boolean usesNextWord() {
		return opvalCode.usesNextWord();
	}
	
	public boolean hasLiteralValue() {
		return opvalCode.usesLiteralValue();
	}

	public OpValueCode getOpvalCode() {
		return opvalCode;
	}

	public int getLiteral() {
		if(!hasLiteralValue()) {
			throw new RuntimeException("This OpValueCode '"+ opvalCode +"' does not have an associated literal value, THIS SHOULD NEVER HAPPEN!");
		}
		return literal;
	}
}
