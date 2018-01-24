package blockchain;

public class ByteToString {

	 public static String bytes2String(byte[] src) {
	        if (src == null || src.length <= 0) {   
	            return null;   
	        } 

	        char[] res = new char[src.length * 2]; // ÿ��byte��Ӧ�����ַ�
	        final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	        for (int i = 0, j = 0; i < src.length; i++) {
	            res[j++] = hexDigits[src[i] >> 4 & 0x0f]; // �ȴ�byte�ĸ�4λ
	            res[j++] = hexDigits[src[i] & 0x0f]; // �ٴ�byte�ĵ�4λ
	        }

	        return new String(res);
	    }
}
