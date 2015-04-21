package AccountManager;
import Assets.*;
import Exceptions.*;
import Stockmarket.*;

public class AccountManagerImpl implements AccountManager {
	
	private Player[] players = new Player[0];
	private StockPriceProvider spp;
	
	private AssetViewer assetViewer;
	
	public AccountManagerImpl(String provider){		
		switch(provider){
		case("ConstStockPriceProvider"):
			this.assetViewer = new AssetViewer(this);
			this.spp = new ConstStockPriceProvider();			
			break;
		case("RandomStockPriceProvider"):
			this.assetViewer = new AssetViewer(this);
			this.spp = new RandomStockPriceProvider();			
			break;
		default: throw new ProviderNotFoundException();
		}
	}
	
	public StockPriceProvider getStockPriceProvider(){
		return this.spp;
	}
	
	public AssetViewer getAssetViewer(){
		return this.assetViewer;
	}
	
	public Player[] getPlayers(){
		return this.players;
	}
	
	private Player searchPlayer(String s)throws PlayerNotFoundException{
		for(int i = 0;i<players.length;i++){
			if(players[i].getName().equals(s)){				
				return players[i];
			}
		}
		throw new PlayerNotFoundException();		
	}
	
	private void extendPlayerArr(){
		Player[] players2 = new Player[this.players.length+1]; 	
		for(int i=0;i<this.players.length;i++){	
			players2[i] = this.players[i];	
		}
		this.players = players2;
	}
	
	private void addPlayer(Player p){
		for(int i=0;i<this.players.length;i++){			
			if(i == players.length-1){
				this.players[i] = p;
			}
		}
	}
	
	public void createPlayer(String s)throws PlayerAlreadyExistsException{		
		for(int i = 0;i<players.length;i++){
			if(s.equals(players[i].getName())){
				throw new PlayerAlreadyExistsException(); // player already in array stop				 				
			}
		}		
		Player p = new Player(s);	// construct the player	
		extendPlayerArr();
		addPlayer(p);
		this.assetViewer.process();
	}		
	
	@Override
	public void buyShare(String p, String s, int a) throws NotEnoughMoneyException, ShareNotFoundException, PlayerNotFoundException {
		Player player = searchPlayer(p);
		Share share = spp.searchShare(s);
		if((player.getCashAccount().getValue() - share.getSharePrice()*a)<0){
			throw new NotEnoughMoneyException();					
		}
		player.getShareDepositAccount().buyShare(share, a); //buyShare
		player.getCashAccount().withdraw(share.getSharePrice()*a); //subtract value from CashAccount				
		this.assetViewer.process();
	}

	@Override
	public void sellShare(String p, String s, int a)throws ShareNotFoundException, PlayerNotFoundException {
		Player player = searchPlayer(p);
		Share share = spp.searchShare(s);
		player.getShareDepositAccount().sellShare(share, a);//sellShare
		player.getCashAccount().deposit(share.getSharePrice()*a);//add value to CashAccount
		this.assetViewer.process();
	}
	
	public String shareDepositAccountToString(String playerName){
		Player player = searchPlayer(playerName);		
		return player.getShareDepositAccount().toString();
	}
	@Override
	public void updatePlayers(){
		for(int i=0;i<players.length;i++){
			players[i].getShareDepositAccount().update();
		}
	}
	
	@Override
	public long getAssetValue(String p, String a) throws AssetNotFoundException {		
		Player player = searchPlayer(p);
		if(a == "SDP"){			
			return player.getShareDepositAccount().getValue();			
		}
		if(a == "CA"){			
			return player.getCashAccount().getValue();	
		}
		else{
			ShareItem[] shareItems = player.getShareDepositAccount().getShareItems();
			for(int i = 0;i<shareItems.length;i++){
					if(shareItems[i].getName().equals(a)){
					return shareItems[i].getValue();
					}			
				}		
			}
		throw new AssetNotFoundException();
	}

	@Override
	public long getAssetTotal(String p) throws PlayerNotFoundException{		
		Player player = searchPlayer(p);
		player.getShareDepositAccount().update();
		return (player.getCashAccount().getValue()+player.getShareDepositAccount().getValue());		
	}	
	/**
	 * Testmethod
	 */
	@Override
	public String playerToString(String s){ // stats from player X		
		return searchPlayer(s).toString();		
	}
	
	public String toString(){
		StringBuilder sBuilder = new StringBuilder();
		for(int i=0;i<players.length;i++){
			sBuilder.append(" | "+players[i].toString()+" |<br>");
		}
		return sBuilder.toString();
	}
}