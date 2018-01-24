package blockchain;

import java.io.Serializable;

public class TransactionInput implements Serializable {
	
	byte[] transactionID;
	long vOut;
	String scriptSig;
	
	boolean CanUnlockOutputWith(String unlockingData)
	{
		return this.scriptSig == unlockingData;
	}
	
	public TransactionInput(byte[] transactionID, long vOut, String scriptSig)
	{
//		this.transactionID = ByteTrans.bytesCopy(transactionID);
		this.transactionID = transactionID;
		this.vOut = vOut;
		this.scriptSig = scriptSig;
		
		System.out.println("TransactionInput: "+ByteTrans.bytes2String(this.transactionID)+"  "
				+ this.vOut + " " +this.scriptSig);
	}
}
