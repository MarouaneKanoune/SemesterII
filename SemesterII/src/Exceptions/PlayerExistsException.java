package Exceptions;

public class PlayerExistsException extends RuntimeException{
	
	public PlayerExistsException(){
		
		super();
		
	}
	public PlayerExistsException(String s){
		
		super(s);
		
	}
	
	public String toString(){
		
		return "Player has already been created -> aborting creation";
		
	}
	
}
