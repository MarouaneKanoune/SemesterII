package Assets;
import Exceptions.*;

public class CashAccount extends Asset {
	
	public CashAccount(String n, long s)throws NullParameterException{
		
		if(n==null){
			throw new NullParameterException();
		}
		this.name = n;
		this.value = s;
		
	}
	
	public void deposit(long v){
		
		this.value+= v;
		
	}
	
	public void withdraw(long v){
		
		this.value-=v;
		
	}
	
	public String toString(){
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Owner of the account: ");
		sBuilder.append(this.getName());
		sBuilder.append(" | ");
		sBuilder.append("Money in the CashAccount: ");
		sBuilder.append(+this.getValue());
			
		return sBuilder.toString();	
	}
}