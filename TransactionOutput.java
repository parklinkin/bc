package blockchain;

import java.io.Serializable;

public class TransactionOutput implements Serializable {
	private long value;
	String scriptPublicKey;
	
	boolean canBeUnlockedWith(String unlockingData)
	{
		return this.scriptPublicKey == unlockingData;
	}
	
	public TransactionOutput (long value, String scriptPublicKey)
	{
		this.value = value;
		this.scriptPublicKey = scriptPublicKey;
		System.out.println("TransactionOutput: "+this.value + " " +this.scriptPublicKey);
	}
}
