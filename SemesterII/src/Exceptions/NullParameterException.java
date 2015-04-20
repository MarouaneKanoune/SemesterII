package Exceptions;

public class NullParameterException extends RuntimeException {

	public NullParameterException(){
		super();
	}
	
	public NullParameterException(String s){
		super(s);
	}
	
	public String toString(){
		
		return "ShareNameIsNull";
		
	}
}
