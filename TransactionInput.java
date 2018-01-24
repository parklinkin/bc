package blockchain;

public class TransactionInput {
	
	byte[] TransactionID;
	int VOut;
	String ScriptSig;
	
	boolean CanUnlockOutputWith(String unlockingData)
	{
		return this.ScriptSig == unlockingData;
	}
}
