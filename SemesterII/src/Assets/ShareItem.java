package Assets;
import Exceptions.*;
import Stockmarket.Share;

public class ShareItem extends Asset {

	private int amount;
	private long totalPurchasePrice;
	private Share share;
	
	public ShareItem(String n, int a, Share share)throws NullParameterException{
		
		if(n == null | share == null){
			throw new NullParameterException();
		}	
		this.name = n ;
		this.amount = a;
		this.share = share;
	}
	
	public Share getShare(){
		return this.share;
	}
	
	public void update(){ //recalc the value of the ShareItem
		this.value = ((long)(this.amount*this.share.getSharePrice()));
	}
	
	public void buyShare(int a){
		this.amount+=a;
		this.totalPurchasePrice += this.share.getSharePrice()*a;
		update();
	}
	
	public void sellShare(int a){
		this.amount-=a;
		update();
	}
	
	public int getAmount(){
		return this.amount;
	}

	public long getTotalPurchasePrice(){
		return totalPurchasePrice;	
	}
		
	public String toString(){
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Name of Shareitem: ");
		sBuilder.append(this.getName());
		sBuilder.append(" | Value: ");
		sBuilder.append(this.getValue());
		sBuilder.append(" | Amount: ");
		sBuilder.append(this.amount);
		
		return sBuilder.toString();
	}
}