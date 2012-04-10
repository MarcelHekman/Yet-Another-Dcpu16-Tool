package dcpu16.disassembler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import dcpu16.common.ByteArrayUtil;

public class Dcpu16Disassembler {
	
	public String disassembleFile(String fileName) throws Exception {
		File inputFile = new File(fileName);
		if(! inputFile.exists()) {
			throw new Exception("Input file '"+ fileName +"' does not exist.");
		}
		FileInputStream inputStream = new FileInputStream(fileName);
		return disassemleInputStream(inputStream);
	}
	
	public String disassemleInputStream(InputStream inputStream) throws Exception {
		try {
			byte[] inputBytes = ByteArrayUtil.inputStreamToByteArray(inputStream);
			return disassemble(inputBytes);
		}
		finally {
			inputStream.close();
		}
	}
	
	public String disassemble(byte[] byteArray) throws Exception {
		
		return null;
	}
}
