package Exceptions;

public class AssetNotFoundException extends RuntimeException {
	
	public AssetNotFoundException(){
		
		super();
		
	}
	
	public AssetNotFoundException(String s){
		
		super(s);
		
	}
	@Override
	public String toString(){
		
		return "AssetNotFound";
		
	}
}
