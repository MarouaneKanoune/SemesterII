package Exceptions;

public class ShareNotFoundException extends RuntimeException {
	
	public ShareNotFoundException(){
		
		super();
		
	}
	
	public ShareNotFoundException(String s){
		
		super(s);
		
	}
	
	@Override
	public String toString(){
		
		return "Can not find Share";
		
	}
}
