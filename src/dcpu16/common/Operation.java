package dcpu16.common;

import java.util.List;

public class Operation {
	private final OpCode opcode;
	private final OperationValue opval1;
	private final OperationValue opval2;
	private String label = null;
	
	
	public Operation(OpCode opcode, OperationValue opval) {
		this.opcode = opcode;
		if(isBasicOpcode()) {
			throw new RuntimeException("Opcode does not fit this constructor, use the other constructor, THIS SHOULD NEVER HAPPEN!");
		}
		this.opval1 = opval;
		this.opval2 = null;
	}
	
	public Operation(OpCode opcode, OperationValue opval1, OperationValue opval2) {
		this.opcode = opcode;
		if(!isBasicOpcode()) {
			throw new RuntimeException("Opcode does not fit this constructor, use the other constructor, THIS SHOULD NEVER HAPPEN!");
		}
		this.opval1 = opval1;
		this.opval2 = opval2;
	}

	
	public void getBinaryFormat(List<Integer> binaryFormat) {
		if(isBasicOpcode()) {
			binaryFormat.add(opcode.code + (opval1.getBinaryFormatCode() << 4) + (opval2.getBinaryFormatCode() << 10));
		}
		else {
			binaryFormat.add(opcode.code + (opval1.getBinaryFormatCode() << 10));
		}
		
		if(opval1.usesNextWord()) {
			binaryFormat.add(opval1.getLiteral());
		}
		if(isBasicOpcode() && opval2.usesNextWord()) {
			binaryFormat.add(opval2.getLiteral());
		}
	}
	
	public int wordCount() {
		if(isBasicOpcode()) {
			return opval1.wordCount() + opval2.wordCount() + 1;
		}
		else {
			return opval1.wordCount() + 1;
		}
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
	
	public boolean hasLabel() {
		return label != null;
	}
	
	public void setLabel(String label) {
		this.label = label;
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
