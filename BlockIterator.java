package blockchain;

public class BlockIterator {
	String lastBlockHashToString = null;
	public BlockIterator(String s)
	{
		lastBlockHashToString = s;
	}
	
	public Block next()
	{
		byte[] encodedBlock = DB.find(lastBlockHashToString);
		if (encodedBlock == null)
			return null;
		Block block = (Block) Serialize.toObject(encodedBlock);
		lastBlockHashToString = ByteTrans.bytes2String(block.getPrevBlockHash());
		return block;
	}
}
