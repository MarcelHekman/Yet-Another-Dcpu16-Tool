package dcpu16.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ByteUtil {
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
	
	//Convert a byte array to an array of 'unsigned short', represented as 'int'.
	public static int[] byteArrayToUnsignedShorts(byte[] byteArray) throws Exception {
		if(byteArray.length % 2 != 0) {
			throw new Exception("Invalid number of bytes '"+ byteArray.length +"', the number of bytes should be divisible by 2");
		}
		
		int[] ushortArray = new int[byteArray.length / 2];
		for(int i = 0; i < ushortArray.length; i++) {
			int byte1 = (((int)byteArray[(i * 2)]) & 0xFF) << 8;
			int byte2 = ((int)byteArray[(i * 2) + 1]) & 0xFF;
			ushortArray[i] = byte1 + byte2;
		}
		
		return ushortArray;
	}
	
	//Convert a byte array to an array of 'unsigned short', represented as 'int'.
	public static byte[] unsignedShortsToByteArrayTo(List<Integer> ushortList) throws Exception {
		byte[] output = new byte[ ushortList.size() * 2 ];
		for(int i = 0; i < ushortList.size(); i++) {
			int word = ushortList.get(i);
			if(0 > word) {
				throw new RuntimeException("Negative 'unsigned short' detected '"+ word +"', THIS SHOULD NEVER HAPPEN!");
			}
			else if(word > 0xFFFF) {
				throw new RuntimeException("Out of range 'unsigned short' detected '"+ word +"', THIS SHOULD NEVER HAPPEN!");
			}
			
			output[(i * 2)] = (byte)((word & 0xFF00) >> 8);
	        output[(i * 2) + 1] = (byte)(word & 0x00FF);
		}
		return output;
	}
	
	public static String toHex(int number) {
		return "0x"+ Integer.toHexString(number);
	}
}
