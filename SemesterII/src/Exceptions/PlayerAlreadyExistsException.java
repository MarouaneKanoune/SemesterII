package Exceptions;

public class PlayerAlreadyExistsException extends RuntimeException {
	
	public PlayerAlreadyExistsException(){
		super();
	}
	
	public PlayerAlreadyExistsException(String s){
		super(s);
	}
	
	public String toString(){		
		return "A player with this name was already created -> aborting creation";
	}
}
