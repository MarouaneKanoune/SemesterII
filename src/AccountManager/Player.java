package AccountManager;
import Exceptions.*;
import Assets.CashAccount;
import Assets.ShareDepositAccount;

public class Player{

	private String name;
	private ShareDepositAccount sdp;
	private CashAccount ca;
	
	public Player(String name)throws NullParameterException{
		
		if(name == null){
			throw new NullParameterException();
		}
		this.name = name;
		this.ca = new CashAccount("CashAccount : "+ name, (long)1000);
		this.sdp = new ShareDepositAccount("ShareDepositAccount: " + this.name);
		
	}
	
	public ShareDepositAccount getShareDepositAccount(){
		
		return this.sdp;
		
	}
	
	public String getName(){
		
		return this.name;
		
	}
	
	public CashAccount getCashAccount(){
		
		return ca;
		
	}
	
	public String toString(){
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Name of Player: ");
		sBuilder.append(this.name);
		sBuilder.append("; Value of Shareitems: ");
		sBuilder.append(this.sdp.getValue());
		sBuilder.append("; Your cashaccount contains: ");
		sBuilder.append(this.ca.getValue());
		
		return sBuilder.toString();				
	}
}