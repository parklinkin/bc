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
	private int nouce;								//counter
	
	
	
	public byte[] serialize()
	{
		byte[] b = new Serialize().toByteArray((Object)this);
		return b;
	}
	
	
	
	
void f(){
	new Date().getTime();}
}
