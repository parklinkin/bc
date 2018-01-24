package blockchain;

import java.math.BigInteger;
import java.util.ArrayList;

public class ProofOfWork {

	static final long maxNonce = Long.MAX_VALUE;
	static final int targetbits = 24;

	private byte[] runHash;
	private long runNonce;
	
	Block block;
	BigInteger target;
	
	public ProofOfWork(Block block)
	{
		this.block = block;
		target = new BigInteger("1");
		target = target.shiftLeft(256-targetbits);
	}
	public byte[] prepareData(long nonce)
	{
		byte[] preDataPrevBlockHash = block.getPrevBlockHash();
		byte[] preDataHashTransactions = block.hashTransactions();
		byte[] preDataTimeStamp = ByteTrans.long2bytes(block.getTimeStamp());
		byte[] preDataTargetBitsByte = ByteTrans.int2bytes(targetbits);
		byte[] preDataNonceByte = ByteTrans.long2bytes(nonce);
		
		ArrayList<byte[]> ab = new ArrayList<byte[]>();
		ab.add(preDataPrevBlockHash);
		ab.add(preDataHashTransactions);
		ab.add(preDataTimeStamp);
		ab.add(preDataTargetBitsByte);
		ab.add(preDataNonceByte);
		
		byte[] data = ByteTrans.concatByte(ab);	
		return data;		
	}
	
	public void run()
	{
		BigInteger hashInt;
		byte [] hash = null;
		long nonce = 0;
		while (nonce < maxNonce)
		{
			byte []data = prepareData(nonce);
			hash = SHA256.sum256(data);
			hashInt = new BigInteger(data);
			if (hashInt.compareTo(target) <0)
				break;
			else
				nonce++;
		}
		this.runNonce = nonce;
		this.runHash = hash;
	}
	
	public boolean validate()
	{
		byte[] data = prepareData(block.getNonce());
		byte[] hash = SHA256.sum256(data);
		BigInteger hashInt = new BigInteger(hash);
		return (hashInt.compareTo(target) < 0);
	}
	
	public byte[] getRunHash() {
		return runHash;
	}

	public long getRunNonce() {
		return runNonce;
	}
}
