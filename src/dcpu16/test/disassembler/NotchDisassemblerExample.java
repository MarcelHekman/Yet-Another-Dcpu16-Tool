package dcpu16.test.disassembler;

//import static org.junit.Assert.*;

import java.io.InputStream;

import org.junit.Test;

import dcpu16.disassembler.Dcpu16Disassembler;

public class NotchDisassemblerExample {

	@Test
	public void testNotchDisassemblerExample() throws Exception {
		Dcpu16Disassembler dcpuDisassembler = new Dcpu16Disassembler();
		InputStream input = ClassLoader.getSystemResourceAsStream("dcpu16/test/disassembler/NotchExample.bin");
		//dcpuDisassembler
		//dcpuAssembler.assemleInputStream(input);
		//dcpuAssembler.hexDump(input);
		//TODO
	}

}
