package Stockmarket;
import java.util.Random;

import Assets.AssetViewer;

public class RandomStockPriceProvider extends StockPriceProvider {

	@Override
	public void updateSharePrice(Share share) {
		// TODO Auto-generated method stub		
    	Random rng = new Random();
    	long newRandomSharePrice;
    	if(rng.nextBoolean()){//add or subtract?
    		newRandomSharePrice = share.getSharePrice()+rng.nextInt(10);
    	}
    	else{
    		newRandomSharePrice = share.getSharePrice()-rng.nextInt(10);
    		if(newRandomSharePrice<1){
    			newRandomSharePrice = newRandomSharePrice*-1;// to prevent negative shareprices
    		}
    		if(newRandomSharePrice == 0){
    			newRandomSharePrice = 1;
    		}
    	}
//    	share = new Share(share.getName(), newRandomSharePrice); //doesn't work -> no array reference :(	
    	for(int i=0;i<shares.length;i++){
    		if(share.getName() == shares[i].getName()){
    			shares[i] = new Share(share.getName(), newRandomSharePrice);   			
    		}
    	}
	}
    	
}
