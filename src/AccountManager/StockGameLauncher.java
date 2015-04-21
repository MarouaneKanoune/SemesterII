package AccountManager;
import Exceptions.*;

import java.io.*;

public class StockGameLauncher {		
	public static void main(String[] args) throws IOException, NotEnoughMoneyException{
		
		System.out.println("Choose your StockGameMode");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		String[] input = s.split(";");
		
			if (s != null){			
				while(true){
					if(input.length == 1){
						if(input[0].equals("RandomStockPriceProvider")){
							AccountManager acc = new AccountManagerImpl(input[0]);
							startStableGame(acc);
						}
						if(input[0].equals("rspp")){
							AccountManager acc = new AccountManagerImpl("RandomStockPriceProvider");
							startStableGame(acc);
						}
						if(input[0].equals("ConstStockPriceProvider")){
							AccountManager acc = new AccountManagerImpl(input[0]);
							startStableGame(acc);
						}
						if(input[0].equals("cspp")){
							AccountManager acc = new AccountManagerImpl("ConstStockPriceProvider");
							startStableGame(acc);
						}
						if (input[0].equals ("q")){
							System.out.println("Shutting down");
							System.exit(0);						
						}
						if (input[0].equals("help")){
							System.out.println("ConstStockPriceProvider, shortcut: cspp");
							System.out.println("RandomStockPriceProvider, shortcut: rspp");
						}
					}
					s = reader.readLine();
				    input = s.split(";");
				}				
			}		
	}
	
	public static void startStableGame(AccountManager acc)throws IOException, NotEnoughMoneyException{
		try{
			System.out.println("*Starting new instance*");
			start(acc);
		}
		catch(NotEnoughMoneyException ex){ //player did something wrong :(
			ex.printStackTrace(); //print his mistake!
		}
		catch(ShareNotFoundException ex){
			ex.printStackTrace();
		}		
		catch(PlayerNotFoundException ex){
			ex.printStackTrace();
		}
		catch(PlayerAlreadyExistsException ex){
			ex.printStackTrace();
		}
		catch(NullParameterException ex ){
			ex.printStackTrace();
		}
		finally{
			startStableGame(acc); //continue the game!
		}		    		  
	}
	
	public static void start(AccountManager acc)throws IOException, NotEnoughMoneyException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String s = reader.readLine();
	    String[] input = s.split(";");
	
		if (s != null){			
			while(true){
				if(input.length == 1){
					if (input[0].equals ("q")){
						System.out.println("Shutting down");
						System.exit(0);						
					}
					if (input[0].equals ("p")){						
						System.out.println(acc.toString());					
					}
					if (input[0].equals("help")){
						System.out.println("Start the Shareticker: start;");
						System.out.println("show all players: p;");
						System.out.println("add player: p;add;PLAYERNAME;");
						System.out.println("Buy a Share: PLAYERNAME;buy;SHARENAME;AMOUNT;");
						System.out.println("Sell a Share: PLAYERNAME;sell;SHARENAME;AMOUNT;");
						System.out.println("ShareDepositAccount of a player: PLAYERNAME;SDA;");
						System.out.println("Total assetvalue of a player: PLAYERNAME;total;");
					}
					if (input[0].equals("start")){
						acc.getStockPriceProvider().startUpdate();
					}				 				
				}
				if(input.length == 2){
					if (input[1].equals("total")){
						System.out.println(acc.getAssetTotal(input[0]));
					}
					if (input[1].equals("SDA"));
					System.out.println(acc.shareDepositAccountToString(input[0]));
				}
				if(input.length == 3){
					if (input[0].equals ("p") & input[1].equals("add")){
						acc.createPlayer(input[2]);
						System.out.println("Created player: "+input[2]);
					}									
				}
				if(input.length == 4){
					if (input[1].equals("buy")){
						acc.buyShare(input[0], input[2], Integer.parseInt(input[3]));
					}
					if (input[1].equals("sell")){
						acc.sellShare(input[0], input[2], Integer.parseInt(input[3]));
					}					
				}							
				s = reader.readLine();
			    input = s.split(";");
			}
	    }
	
	}
}