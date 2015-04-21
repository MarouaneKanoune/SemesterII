package Stockmarket;

import java.util.TimerTask;

public class TickerTask extends TimerTask {

	private StockPriceInfo stockPriceInfo;
	
	public TickerTask(StockPriceInfo stockPriceInfo){
		this.stockPriceInfo = stockPriceInfo;
	}
	
	@Override
	public void run() {
		stockPriceInfo.updateSharePrices();
	}	
}