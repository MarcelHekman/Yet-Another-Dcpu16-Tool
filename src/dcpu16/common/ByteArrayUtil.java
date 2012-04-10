package dcpu16.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ByteArrayUtil {
	private static final int READ_INITAL_READ_SIZE = 0x20000;
	
	public static byte[] inputStreamToByteArray(InputStream inputStream) throws IOException {
		int nrOfReadBytesTotal = 0;
		int nrOfReadBytes = 0;
		int currentArraySize = READ_INITAL_READ_SIZE;
		byte[] byteArray = new byte[currentArraySize];
		while(true) {
			nrOfReadBytes = inputStream.read(byteArray, nrOfReadBytesTotal, currentArraySize - nrOfReadBytesTotal);
			if(nrOfReadBytes == -1) {
				break;
			}
			nrOfReadBytesTotal += nrOfReadBytes;
			if(nrOfReadBytesTotal == currentArraySize) {
				//Double the array size.
				currentArraySize = currentArraySize * 2;
				byteArray = Arrays.copyOf(byteArray, currentArraySize);
			}
		}
		
		//Truncate to minimal size.
		return Arrays.copyOf(byteArray, nrOfReadBytesTotal);
	}
}
