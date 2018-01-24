package blockchain;

import java.util.ArrayList;

public class ByteTrans {

	 public static String bytes2String(byte[] src) {
	        if (src == null || src.length <= 0) {   
	            return null;   
	        } 

	        char[] res = new char[src.length * 2]; // 每个byte对应两个字符
	        final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	        for (int i = 0, j = 0; i < src.length; i++) {
	            res[j++] = hexDigits[src[i] >> 4 & 0x0f]; // 先存byte的高4位
	            res[j++] = hexDigits[src[i] & 0x0f]; // 再存byte的低4位
	        }
	        return new String(res);
	    }
	 
//	 public static byte[] bytesCopy(byte[] src) 
//	 {
//		 byte[] res = new byte[src.length];;
//		 System.arraycopy(src, 0, res, 0, src.length);
//		 return res;
//	 }
	 
	 	public static byte[] int2bytes(int num){  
	        byte[] result = new byte[4];  
	        result[0] = (byte)((num >>> 24) & 0xff);
	        result[1] = (byte)((num >>> 16)& 0xff );  
	        result[2] = (byte)((num >>> 8) & 0xff );  
	        result[3] = (byte)((num >>> 0) & 0xff );  
	        return result;  
	    } 
	 	
	 	public static byte[] long2bytes(long num){  
	        byte[] result = new byte[8];  
	        result[0] = (byte)((num >>> 56) & 0xff);
	        result[1] = (byte)((num >>> 48)& 0xff );  
	        result[2] = (byte)((num >>> 40) & 0xff );  
	        result[3] = (byte)((num >>> 32) & 0xff );
	        result[4] = (byte)((num >>> 24) & 0xff);
	        result[5] = (byte)((num >>> 16)& 0xff );  
	        result[6] = (byte)((num >>> 8) & 0xff );  
	        result[7] = (byte)((num >>> 0) & 0xff );
	        return result;  
	    }  
	 	
	 
	 	public static byte[] concatByte(ArrayList <byte[]> byteArray)
		{
			byte[] b = {};
			for(byte[] x:byteArray)
				b = combine(b, x);
			return b;
		}
		private static byte[] combine(byte[] a, byte[] b)
		{
	        int length = a.length + b.length;
	        byte [] result = new byte[length];
	        System.arraycopy(a, 0, result, 0, a.length);
	        System.arraycopy(b, 0, result, a.length, b.length);
	        return result;
	    }
}
