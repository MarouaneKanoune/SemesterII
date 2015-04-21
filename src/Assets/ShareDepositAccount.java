package Assets;
import Exceptions.*;
import Stockmarket.Share;

public class ShareDepositAccount extends Asset {

	private ShareItem[] shareItems = new ShareItem[0];
	
	public ShareDepositAccount(String name)throws NullParameterException{	
		if(name == null){
			throw new NullParameterException();
		}
		this.name = name;
	}
	
	public ShareItem[] getShareItems(){
		return this.shareItems;
	}
	
	public void buyShare(Share s, int a){						
		for(int i = 0;i<this.shareItems.length;i++){
			if(s.getName().equals(shareItems[i].getShare().getName())){ // increase the amount of shares if a fitting ShareItem already exists
				this.shareItems[i].buyShare(a);
				return;				
			}
		}					
		ShareItem shareItem = new ShareItem(s.getName(),a, s);// create a new ShareItem if it doesn't exist
		shareItem.update();
		this.addShareItem(shareItem);
		this.update();
	}
	
	public void sellShare(Share s, int a)throws ShareNotFoundException{			
		for(int i = 0;i<shareItems.length;i++){			
			if(s.getName().equals(shareItems[i].getShare().getName())){				
				if((shareItems[i].getAmount()-a)<0){					
					System.out.println("You wanted to sell "+ a +" "+shareItems[i].getShare().getName()+ " shares. You own " +shareItems[i].getAmount()+" "+shareItems[i].getShare().getName()+" shares. Transaction aborted.");
					throw new ShareNotFoundException();
				}				
				this.shareItems[i].sellShare(a);
				this.shareItems[i].update();
				if(shareItems[i].getAmount() == 0){					
					deleteShareItem(shareItems[i]);					
				}
				this.update();
				return;
			}
		}		
		throw new ShareNotFoundException();					
	}
	
	public void update(){ //recalc the value of the ShareDepositAccount
		Long newValue = (long)0;
		for(int i=0;i<this.shareItems.length;i++){
			this.shareItems[i].update();
			newValue += this.shareItems[i].getValue();
		}
		this.value= newValue;
	}
	/*
	 * Metaprogrammierung BESTE java.CLATH
	 */
	private void addShareItem(ShareItem si){
		this.extendArr();
		for(int i=0;i<this.shareItems.length;i++){
			if(i == shareItems.length-1){
				this.shareItems[i] = si;	
			}	
		}
		this.update(); //recalc value of the ShareDepositAccount
	}
	
	private void extendArr(){
		ShareItem[] shareItems2 = new ShareItem[this.shareItems.length+1];
		for(int i=0;i<this.shareItems.length;i++){
			shareItems2[i] = this.shareItems[i];	
		}
		this.shareItems = shareItems2;
	}
	
	private void deleteShareItem(ShareItem si){
		for(int i=0;i<this.shareItems.length;i++){
			if(shareItems[i] == si){
				this.shareItems[i] = null;		
			}
		}
		this.deleteGap();
		this.update();		
	}
	
	private void deleteGap(){
		ShareItem[] shareItems2 = new ShareItem[this.shareItems.length-1];
		int j = 0;
		for(int i=0;i<shareItems.length;i++){	
			if(this.shareItems[i] == null){
				continue;}
			//skip the empty spot
			shareItems2[j] = shareItems[i];
			j++;			
		}	
		this.shareItems = shareItems2;		
	}
		
	public String toString(){
		this.update();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Owner of ShareDepositAccount: ");
		sBuilder.append(this.getName());
		sBuilder.append(" | Value of Shareitems: ");
		sBuilder.append(this.getValue());
		sBuilder.append(" | Shareitems: ");
		for(int i = 0; i<shareItems.length; i++){
			sBuilder.append(this.shareItems[i].getName());
			sBuilder.append(", value:"+this.shareItems[i].getValue());
			sBuilder.append(", amount:"+this.shareItems[i].getAmount());
			sBuilder.append("; ");					
		}
		return sBuilder.toString();		
	}
}