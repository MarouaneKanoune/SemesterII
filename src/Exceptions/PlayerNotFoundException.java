package Exceptions;

public class PlayerNotFoundException extends RuntimeException {
	
	public PlayerNotFoundException(){
		super();
	}
	
	public PlayerNotFoundException(String s){
		super(s);		
	}
	
	@Override
	public String toString(){	
		return "Player not found";
	}

}
