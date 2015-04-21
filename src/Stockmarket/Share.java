package Stockmarket;
import Exceptions.*;
public class Share {
	
	private final String name;
	private long sharePrice;

	public Share(String name, long sharePrice)throws NullParameterException{
		
		if(name == null){
			throw new NullParameterException();
		}
		this.name = name;
		this.sharePrice = sharePrice;
		
	}
	
	public long getSharePrice(){
		
		return this.sharePrice;		
	}	
	
	public String getName(){			
		return this.name;	
	}
	
	public String toString(){
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Name of share: ");
		sBuilder.append(this.name);
		sBuilder.append(" | Shareprice: ");
		sBuilder.append(this.sharePrice);
			
		return sBuilder.toString();
		
	}
	@Override
	public boolean equals(Object o){
			
		if (this == o){ //same objects? two references for one object?
			return true;
		}
		if (o == null){//parameter null?
			return false;
		}		
		if (o.getClass() != this.getClass()){ //same class?
			return false;
		}		
		if(this.getSharePrice() != ((Share)o).getSharePrice()){//same SharePrice? (primitive data type)
			return false;
		}		
		if (!(this.name.equals(((Share)o).getName()))){ //same name? (reference-type)				
				return false;				
				}									
		return true;		
	}

}