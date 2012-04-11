package dcpu16.test.assembler;

//import static org.junit.Assert.*;

import java.io.InputStream;

import org.junit.Test;

import dcpu16.assembler.Dcpu16Assembler;

public class NotchAssemblerExample {

	@Test
	public void testNotchAssemblerExample() throws Exception {
		Dcpu16Assembler dcpuAssembler = new Dcpu16Assembler();
		InputStream input = ClassLoader.getSystemResourceAsStream("dcpu16/test/assembler/NotchExample.dasm");
		byte[] output = dcpuAssembler.assembleInputStream(input);
		dcpuAssembler.hexDump(output);
	}

}
