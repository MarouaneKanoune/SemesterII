package Stockmarket;


public interface StockPriceInfo {
	
	boolean isShareListed(String shareName);
	String sharesToString();
	long getSharePrice(String s);
	Share[] getAllSharesAsSnapshot();
	void updateSharePrice (Share share);
	void startUpdate();
	void updateSharePrices();
}