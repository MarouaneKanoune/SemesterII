package Exceptions;

public class NotEnoughMoneyException extends Exception {
	
	public NotEnoughMoneyException(){
		super();
	}
	public NotEnoughMoneyException(String s) {
		super(s); 
	}
	@Override
	public String toString(){
		
		return "You can not afford this item";
		
	}
	
}
