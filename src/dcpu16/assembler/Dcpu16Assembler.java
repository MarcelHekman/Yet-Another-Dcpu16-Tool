package dcpu16.assembler;

import java.io.InputStream;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;

public class Dcpu16Assembler {
	
	public byte[] assembleFile(String fileName) throws Exception {
		CharStream cs = new ANTLRFileStream(fileName);
		return assemble(cs);
	}
	
	public byte[] assembleString(String input) throws Exception {
		CharStream cs = new ANTLRStringStream(input);
		return assemble(cs);
	}
	
	public byte[] assembleInputStream(InputStream input) throws Exception {
		CharStream cs = new ANTLRInputStream(input);
		return assemble(cs);
	}
	
	private byte[] assemble(CharStream cs) throws Exception {
		Dcpu16AssemlberLexer lexer = new Dcpu16AssemlberLexer(cs);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		Dcpu16AssemlberParser parser = new Dcpu16AssemlberParser(tokens);
		return parser.assembler_file();
	}
	
	public void hexDump(byte[] machineCode) {
		for(int i = 0; i < machineCode.length; i+=2) {
			String hexString1 = Integer.toHexString(((int)machineCode[i]) & 0xFF);
			String hexString2 = Integer.toHexString(((int)machineCode[i+1]) & 0xFF);
			while(hexString1.length() < 2) {
				hexString1 = "0" + hexString1;
			}
			while(hexString2.length() < 2) {
				hexString2 = "0" + hexString2;
			}
			System.out.println(hexString1 + hexString2);
		}
	}
}
