package blockchain;

import java.io.Serializable;
import java.util.ArrayList;

public class Blockchain implements Serializable{

	final static String genesisCoinbaseData = "The Times 03/Jan/2009 Chancellor on brink of second bailout for banks";
	
	String lastBlockHashToString = null;
	BlockIterator blockIterator;

	public void MineBlock( ArrayList <Transaction> transactions)
	{
		byte[] lastHash =  DB.find("l");
		Block block = new Block(transactions, lastHash);
		String strHash = ByteTrans.bytes2String(block.getHash());
		DB.insert(strHash, block.serialize());
		DB.update("l", block.getHash());
		this.lastBlockHashToString = strHash;				
	}
	
	
	public ArrayList <Transaction> FindUnspentTransactions(String address )  
	{
		ArrayList <Transaction> unspentTXs = new ArrayList <Transaction>();
		Iterator();
		Block block = blockIterator.next();
		while (block != null)
		{
			for(Transaction tx:block.getTransactions())
			{
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
			block = blockIterator.next();
		}
		
		return unspentTXs;
	}
	
	
//	func (bc *Blockchain) FindSpendableOutputs(String address , int amount ) (int, map[string][]int) {
	
	
	
	public void Iterator()
	{
		blockIterator = new BlockIterator(lastBlockHashToString);
	}
	public static Blockchain NewBlockchain(String address )
	{
		Blockchain blockchain=new Blockchain();
		byte[] bytes = DB.find("l");
		blockchain.lastBlockHashToString = ByteTrans.bytes2String(bytes);
		return blockchain;
	}
	
	public static Blockchain createBlockChain(String address)
	{
		Blockchain blockchain=new Blockchain();
		Transaction cbtx = Transaction.newCoinbaseTransaction(address, genesisCoinbaseData);
		Block genesis = Block.newGenesisBlock(cbtx);
		String genesisHashString= ByteTrans.bytes2String(genesis.getHash());
		DB.insert(genesisHashString, genesis.serialize());
		DB.insert("l", genesis.getHash());
		blockchain.lastBlockHashToString = genesisHashString;		
		return blockchain;
	}
	
}
