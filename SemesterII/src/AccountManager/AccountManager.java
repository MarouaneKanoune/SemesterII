package AccountManager;
import Stockmarket.*;
import Exceptions.ShareNotFoundException;
import Exceptions.NotEnoughMoneyException;
import Stockmarket.StockPriceProvider;

public interface AccountManager {

	void createPlayer(String s);
	void buyShare(String p, String s, int a)throws NotEnoughMoneyException, ShareNotFoundException;
	void sellShare(String p, String s, int a);
	long getAssetValue(String p, String a);
	long getAssetTotal(String p);
	String playerToString(String s); 
	StockPriceProvider getStockPriceProvider();
	String shareDepositAccountToString(String player);
	Player[] getPlayers();
	void updatePlayers();
	//mitdenboiZ
}
