package Stockmarket;
import Assets.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Exceptions.ShareNotFoundException;

public abstract class StockPriceProvider implements StockPriceInfo {
	
	private StockPriceViewer stockPriceViewer;
	protected Share[] shares = new Share[4];
	
	public StockPriceProvider() {
		
		Share s1 = new Share("Siemens",3);
		Share b1 = new Share("BMW",5);
		Share k1 = new Share("Kappa",10);
		Share db1 = new Share("DB",1);
		
		this.shares[0] = s1;
		this.shares[1] = b1;
		this.shares[2] = k1;
		this.shares[3] = db1;	
		
		this.stockPriceViewer = new StockPriceViewer(this);		
	}
	
	public Share searchShare(String shareName){ // do other classes need this method?		
		for(int i=0;i<shares.length;i++){	// looking for a Share with the name String s		
			if(shares[i].getName().equals(shareName)){
				return shares[i];
			}
		}
		throw new ShareNotFoundException();
	}
	
	@Override
	public String sharesToString() {			
			StringBuilder sBuilder = new StringBuilder();
			for(int i=0;i<shares.length;i++){				
				sBuilder.append("<br>| Name of the share: ");
				sBuilder.append(this.shares[i].getName());
				sBuilder.append("; ");
				sBuilder.append("Shareprice: ");
				sBuilder.append(this.shares[i].getSharePrice());
				sBuilder.append(" |");
			}		
			return sBuilder.toString();
	}	

	@Override
	public long getSharePrice(String shareName)throws ShareNotFoundException {		
		return searchShare(shareName).getSharePrice();		
	}
	
	@Override
	public Share[] getAllSharesAsSnapshot() {//array erstellen
		Share[] snapshot = new Share[this.shares.length];
		for (int i = 0;i<this.shares.length;i++){
			snapshot[i] = this.shares[i];
		}
		return snapshot;
	}
	
	@Override
	public boolean isShareListed(String shareName) {		
		for(int i=0;i<shares.length;i++){	// looking for a Share with the name String s		
			if(shares[i].getName().equals(shareName)){
				return true;
			}					
		}
		return false;
	}
	
	@Override
	public void startUpdate(){
		Ticker singleTicker = Ticker.getInstance();
		singleTicker.scheduleAtFixedRate(new TickerTask(this),0,200); //updateSharePrices()
		singleTicker.scheduleAtFixedRate(new TimerTask() {//anonymous class
	    	public void run() {
	            stockPriceViewer.process(); //update StockPriceViewr GUI          
	    	}
	    }, 0, 100);	    
	}
	
	@Override
	public void updateSharePrices(){   	
    	for(int i=0;i<shares.length;i++){   	
	    	updateSharePrice(shares[i]);	
    	}
	}	
	public abstract void updateSharePrice(Share share);
}