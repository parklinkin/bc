package blockchain;

import java.io.Serializable;
import java.util.ArrayList;

public class Transaction implements Serializable{

	private byte[] ID;
	private ArrayList <TransactionInput> vIn;
	private ArrayList <TransactionOutput> vOut;
	
	final static long subsidy = 10;
	
	public void setID()
	{
		byte[] hash = null;
		byte[] b =Serialize.toByteArray(this);
		
//		System.out.println(ByteToString.bytes2String(b));

		hash = SHA256.sum256(b);
		this.ID = hash;
//		System.out.println(ByteToString.bytes2String(this.ID));
//		System.out.println(ByteToString.bytes2String(this.ID).length());
	}

	public static Transaction newCoinbaseTransaction(String to, String data)
	{
		Transaction tx = new Transaction();
		String tmp="";
		if (data.compareTo(tmp) == 0)
			data = "Reward to " + to;
		tx.ID = null;
	
		tx.vIn = new ArrayList <TransactionInput>();
		tx.vIn.add(new TransactionInput(null, -1, data));
		tx.vOut = new ArrayList <TransactionOutput>();
		tx.vOut.add(new TransactionOutput(subsidy, to));
		tx.setID();
		
		System.out.println("newCoinbaseTransaction: " + ByteTrans.bytes2String(tx.ID));
		return tx;
	}
	
	public static void newUTXOTransaction(String from, String to, long amount, Blockchain bc)
	{
		ArrayList <TransactionInput> inputs;
		ArrayList <TransactionOutput> Outputs;
		
		
		
		
		
		
		
		
		
		
		
	}
 
 
	public byte[] getID() {
		return ID;
	}
	
	
	
}
