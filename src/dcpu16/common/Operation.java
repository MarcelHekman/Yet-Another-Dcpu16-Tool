package dcpu16.common;

public class Operation {
	private final OpCode opcode;
	private OperationValue opval1;
	private OperationValue opval2;
	private String label = null;
	
	
	public Operation(OpCode opcode) {
		this.opcode = opcode;
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(hasLabel()) {
			sb.append(':');
			sb.append(label);
		}
		else {
			sb.append("      ");
		}
		sb.append("  ");
		sb.append(opcode.name());
		sb.append(' ');
		if(isBasicOpcode()) {
			if(opval1 != null && opval2 != null) {
				sb.append(opval1.toString());
				sb.append(',');
				sb.append(' ');
				sb.append(opval2.toString());
			}
		}
		else {
			if(opval1 != null) {
				sb.append(opval1.toString());
			}
		}
		return sb.toString();
	}
	
	public void setOpval1(OperationValue opval1) {
		this.opval1 = opval1;
	}
	
	public void setOpval2(OperationValue opval2) {
		if(!isBasicOpcode()) {
			throw new RuntimeException("setOpval2() is not valid for non-basic instructions, THIS SHOULD NEVER HAPPEN!");
		}
		this.opval2 = opval2;
	}
	
	public boolean hasLabel() {
		return label != null;
	}
	
	public String getLabel() {
		return label;
	}

	public boolean isBasicOpcode() {
		return opcode.isBasicOpcode();
	}
	
	public OpCode getOpcode() {
		return opcode;
	}
	
	public OperationValue getOpval1() {
		return opval1;
	}
	
	public OperationValue getOpval2() {
		if(!isBasicOpcode()) {
			throw new RuntimeException("getOpval2() is not valid for non-basic instructions, THIS SHOULD NEVER HAPPEN!");
		}
		return opval2;
	}
}
