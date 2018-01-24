package blockchain;

import java.util.ArrayList;

public class test {
	
	public static void main(String[] args)
	{
//		Transaction t = Transaction.newCoinbaseTransaction("ta", "s");
//		byte[] a = {2,3};
		byte[] b = {1,3};
//		byte[] c = {4,3};
//		ArrayList <byte[]> aa = new 	ArrayList <byte[]>();
//		aa.add(a);
//		aa.add(b);
//		aa.add(c);
//		byte[] d = ConcatenateByte.concatByte(aa);
//		trans(b);
//		System.out.println(ByteTrans.bytes2String(b));
		int x=1;
		x = (x<<32);
		System.out.println(x);
		
	}

	
	
	static void trans (byte[] b)
	{
		byte []a = {2,3};
		b=a;
		System.out.println("In "+ByteTrans.bytes2String(b));
	}
	

}
