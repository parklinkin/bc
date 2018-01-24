package blockchain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Block implements Serializable
{
	private long timeStamp;							// timestamp of this block
	private ArrayList <Transaction> transactions;	// transactions in this block
	private byte[] prevBockHash;			//hash of previous block
	private byte[] hash;					// hash of this block
	private long nonce;								//counter
	
	
	
	public byte[] serialize()
	{
		byte[] b = new Serialize().toByteArray((Object)this);
		return b;
	}
	
	public byte[] hashTransactions()
	{
		ArrayList <byte[]> transactionHashes = new ArrayList <byte[]>();
		byte[] transactionHash = null;
		
		for(Transaction tx: transactions)
		{
			transactionHashes.add(tx.getID());
		}
		transactionHash = SHA256.sum256(ByteTrans.concatByte(transactionHashes));
		return transactionHash;
	}
	
	public Block(ArrayList <Transaction> transactions, byte[] prevBlockHash)
	{
		this.timeStamp = new Date().getTime();
		this.transactions = new ArrayList <Transaction>();
		for(Transaction x:transactions)
			this.transactions.add(x);
		this.prevBockHash = prevBlockHash;
		hash = new byte[]{};
		nonce = 0;
		
		ProofOfWork pow = new ProofOfWork(this);		
		this.hash= pow.getRunHash();
		this.nonce = pow.getRunNonce();	
	}
	
	
	public static Block newGenesisBlock(Transaction coinbase)
	{
		ArrayList <Transaction> txs = new ArrayList <Transaction>();
		txs.add(coinbase);
		byte []b = {};
		Block block = new Block(txs, b);
		return block;
	}
	
	public static Block deserialize(byte[] b)
	{
		Block block = (Block) new Serialize().toObject(b);
		return block;		
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public byte[] getPrevBockHash() {
		return prevBockHash;
	}

	public long getNonce() {
		return nonce;
	}
	
}
