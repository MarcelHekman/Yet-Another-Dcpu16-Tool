package dcpu16.disassembler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import dcpu16.common.ByteUtil;
import dcpu16.common.OpValueCode;
import dcpu16.common.OpCode;
import dcpu16.common.Operation;
import dcpu16.common.OperationValue;

public class Dcpu16Disassembler {
	
	private int currentWord;
	private int[] wordArray;
	
	public String disassembleFile(String fileName) throws Exception {
		File inputFile = new File(fileName);
		if(! inputFile.exists()) {
			throw new Exception("Input file '"+ fileName +"' does not exist.");
		}
		FileInputStream inputStream = new FileInputStream(fileName);
		return disassemleInputStream(inputStream);
	}
	
	public String disassemleInputStream(InputStream inputStream) throws Exception {
		byte[] inputBytes = null;
		try {
			inputBytes = ByteUtil.inputStreamToByteArray(inputStream);
		}
		finally {
			inputStream.close();
		}
		return disassemble(inputBytes);
	}
	
	public String disassemble(byte[] byteArray) throws Exception {
		wordArray = ByteUtil.byteArrayToUnsignedShorts(byteArray);
		currentWord = 0;
		
		StringBuilder output = new StringBuilder();
		while(hasNextWord()) {
			Operation operation = processWord(getNextWord());
			output.append(operation.toString());
			output.append('\n');
		}
		return output.toString();
	}

	private boolean hasNextWord() {
		return wordArray.length > currentWord;
	}
	
	private int getNextWord() throws Exception {
		if(!hasNextWord()) {
			throw new Exception("Input is invalid, unexpected end of input.");
		}
		int word = wordArray[currentWord];
		currentWord++;
		return word;
	}
	
	private Operation processWord(int word) throws Exception {
		OpCode opcode = OpCode.getOpcodeFromWord(word);
		Operation operation;
		if(opcode.isBasicOpcode()) {
			operation = new Operation(opcode);
			operation.setOpval1( processOpValue(OpValueCode.getOpval1(word)) );
			operation.setOpval2( processOpValue(OpValueCode.getOpval2(word)) );
		}
		else {
			opcode = OpCode.getNonBasicOpcodeFromWord(word);
			operation = new Operation(opcode);
			operation.setOpval1( processOpValue(OpValueCode.getOpval1(word)) );
		}
		return operation;
		/*
		output.append("        ");
		if(! opcode.equals(OpCode.NON_BASIC_INSTR)) {
			output.append(opcode.name());
			output.append(' ');
			processInstructionValue(output, OpValue.getOpval1(word));
			output.append(',');
			output.append(' ');
			processInstructionValue(output, OpValue.getOpval2(word));
		}
		else {
			opcode = OpCode.getNonBasicOpcodeFromWord(word);
			output.append(opcode.name());
			output.append(' ');
			processInstructionValue(output, OpValue.getOpval2(word));
		}
		output.append("\n");
		*/
	}
	
	private OperationValue processOpValue(int instructionCode) throws Exception {
		OpValueCode opValueCode = OpValueCode.getInstructionValue(instructionCode);
		if(opValueCode.usesLiteralValue()) {
			if(opValueCode.equals(OpValueCode.LITERAL_OFFSET)) {
				return new OperationValue(opValueCode, instructionCode - OpValueCode.LITERAL_OFFSET.code);
			}
			else {
				return new OperationValue(opValueCode, getNextWord());
			}
		}
		else {
			return new OperationValue(opValueCode);
		}
	}
	
	
	/*
	private void processWord(StringBuilder output, int word) throws Exception {
		OpCode opcode = OpCode.getOpcodeFromWord(word);

		output.append("        ");
		if(! opcode.equals(OpCode.NON_BASIC_INSTR)) {
			output.append(opcode.name());
			output.append(' ');
			processInstructionValue(output, OpValue.getOpval1(word));
			output.append(',');
			output.append(' ');
			processInstructionValue(output, OpValue.getOpval2(word));
		}
		else {
			opcode = OpCode.getNonBasicOpcodeFromWord(word);
			output.append(opcode.name());
			output.append(' ');
			processInstructionValue(output, OpValue.getOpval2(word));
		}
		output.append("\n");
	}
	
	private void processInstructionValue(StringBuilder output, int instructionCode) throws Exception {
		OpValue instructionValue = OpValue.getInstructionValue(instructionCode);
		switch(instructionValue) {
		case LITERAL_OFFSET: {
			output.append(toHex(instructionCode - OpValue.LITERAL_OFFSET.code));
			break;
		}
		case NEXT_WORD: {
			output.append(toHex(getNextWord()));
			break;
		}
		case NEXT_WORD_DEREF: {
			output.append('[');
			output.append(toHex(getNextWord()));
			output.append(']');
			break;
		}
		case A_DEREF: 
		case B_DEREF:
		case C_DEREF:
		case X_DEREF:
		case Y_DEREF:
		case Z_DEREF:
		case I_DEREF:
		case J_DEREF: {
			output.append('[');
			output.append(OpValue.getNonDerefOf(instructionValue).name());
			output.append(']');
			break;
		}
			
		case A_PLUS_NW_DEREF:
		case B_PLUS_NW_DEREF:
		case C_PLUS_NW_DEREF:
		case X_PLUS_NW_DEREF:
		case Y_PLUS_NW_DEREF:
		case Z_PLUS_NW_DEREF:
		case I_PLUS_NW_DEREF:
		case J_PLUS_NW_DEREF: {
			output.append('[');
			output.append(toHex(getNextWord()));
			output.append('+');
			output.append(OpValue.getNonDerefOf(instructionValue).name());
			output.append(']');
			break;
		}
		default: {
			output.append(instructionValue.name());
			if(instructionValue.usesNextWord()) {
				throw new RuntimeException("Unhandled 'next word' case, during disassembly, word: '"+ instructionValue.name() +"'.");
				//getNextWord();
			}
			break;
		}
		}
	}
	
	private String toHex(int number) {
		return "0x"+ Integer.toHexString(number);
	}
	*/
}
