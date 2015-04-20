package Exceptions;

public class ProviderNotFoundException extends RuntimeException {
	
	public ProviderNotFoundException(){
		super();
	}
	
	public ProviderNotFoundException(String s){
		super(s);
	}
	
	public String toString(){
		return "ProviderNotFound";
	}

}
