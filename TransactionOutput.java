package blockchain;

public class TransactionOutput {
	private int value;
	String ScriptPublicKey;
	
	boolean canBeUnlockedWith(String unlockingData)
	{
		return this.ScriptPublicKey == unlockingData;
	}
}
