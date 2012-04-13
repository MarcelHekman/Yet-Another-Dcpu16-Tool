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
			OperationValue opv1 = processOpValue(OpValueCode.getOpval1(word));
			OperationValue opv2 = processOpValue(OpValueCode.getOpval2(word));
			operation = new Operation(opcode, opv1, opv2);
		}
		else {
			opcode = OpCode.getNonBasicOpcodeFromWord(word);
			OperationValue opv = processOpValue(OpValueCode.getOpval2(word));
			operation = new Operation(opcode, opv);
		}
		return operation;
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
}
