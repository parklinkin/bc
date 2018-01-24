package blockchain;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Transaction implements Serializable{



	private byte[] ID;
	private TransactionInput[] vIn;
	private TransactionOutput[] vOut;
	
	public void setID()
	{
		byte[] hash = null;// = new byte[32];
		byte[] b = new Serialize().toByteArray(this);
		
//		System.out.println(ByteToString.bytes2String(b));
		
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			hash = digest.digest(b);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		this.ID = hash;
//		System.out.println(ByteToString.bytes2String(this.ID));
//		System.out.println(ByteToString.bytes2String(this.ID).length());
	}
	
	
}
