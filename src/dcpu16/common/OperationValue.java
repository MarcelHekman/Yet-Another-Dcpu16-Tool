package dcpu16.common;

public class OperationValue {

	private final OpValueCode opvalCode;
	private final int opvalLiteral;
	

	public OperationValue(OpValueCode code) {
		this.opvalCode = code;
		this.opvalLiteral = -1;
		if(hasLiteralValue()) {
			throw new RuntimeException("This OpValueCode '"+ opvalCode +"' uses a literal value and should use a different constructor, THIS SHOULD NEVER HAPPEN!");
		}
	}
	
	public OperationValue(OpValueCode code, int literal) {
		this.opvalCode = code;
		if(hasLiteralValue()) {
			this.opvalLiteral = literal;
		}
		else {
			opvalLiteral = -1;
		}
	}
	
	
	public String toString() {
		switch(opvalCode) {
		case LITERAL_OFFSET:
		case NEXT_WORD: {
			return ByteUtil.toHex(opvalLiteral);
		}
		case NEXT_WORD_DEREF: {
			return '['+ ByteUtil.toHex(opvalLiteral) +']';
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
			return '['+ ByteUtil.toHex(opvalLiteral) +'+'+ OpValueCode.getNonDerefOf(opvalCode).name() +']';
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
	
	public boolean hasLiteralValue() {
		return opvalCode.usesLiteralValue();
	}

	public OpValueCode getOpvalCode() {
		return opvalCode;
	}

	public int getOpvalLiteral() {
		if(!hasLiteralValue()) {
			throw new RuntimeException("This OpValueCode '"+ opvalCode +"' does not have an associated literal value, THIS SHOULD NEVER HAPPEN!");
		}
		return opvalLiteral;
	}
}
