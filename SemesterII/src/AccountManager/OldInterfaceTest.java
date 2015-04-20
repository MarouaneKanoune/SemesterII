package AccountManager;
import Exceptions.*;
import Stockmarket.StockPriceViewer;


public class OldInterfaceTest {
	public static void main(String[] args){
				
			AccountManager acc = new AccountManagerImpl("RandomStockPriceProvider");			
			
			System.out.println("*All available shares*");
			System.out.println(acc.getStockPriceProvider().sharesToString());
			System.out.println("*Shareprice of a Siemens share*");
			System.out.println(acc.getStockPriceProvider().getSharePrice("Siemens"));
			System.out.println("*Creating player David*");
			acc.createPlayer("David");
			System.out.println(acc.playerToString("David"));
			System.out.println("*Creating player David*");
		try{
			acc.createPlayer("David");
		}
		catch(PlayerAlreadyExistsException e){
			e.printStackTrace();
		}
		finally{
				System.out.println("*Creating player Franz*");
				acc.createPlayer("Franz");
				System.out.println(acc.playerToString("Franz"));
				System.out.println("David buys 7 Siemens shares at "+acc.getStockPriceProvider().getSharePrice("Siemens")+" cents each");
				try{ // 
					acc.buyShare("David","Siemens",7 );
					System.out.println(acc.playerToString("David"));
					System.out.println("*David buys 5 BMW shares at "+acc.getStockPriceProvider().getSharePrice("BMW")+" cents each");
					acc.buyShare("David", "BMW", 5);
					System.out.println(acc.playerToString("David"));
					acc.sellShare("David", "Siemens", 2);
					System.out.println("David sells 2 Siemens shares at "+acc.getStockPriceProvider().getSharePrice("Siemens")+" cents each");
					System.out.println(acc.playerToString("David"));
					System.out.println("*Buying 7000 Siemens Shares for David*");				
					acc.buyShare("David","Siemens",7000 );				
			} catch(NotEnoughMoneyException e){
					e.printStackTrace();
			}finally{					
					try{ 
						System.out.println("Getting value of David's Assets");
						System.out.println(acc.getAssetValue("David", "Siemens")+" (Value of David's Siemens Shareitem)");
						System.out.println(acc.getAssetValue("David", "CashAccount")+" (Content of David's cashaccount)");
						System.out.println(acc.getAssetValue("David", "ShareDepositAccount")+" (Content of David's Sharedepositaccount)");
						System.out.println("*Getting the total value of David's assets*");
						System.out.println(acc.getAssetTotal("David"));
						System.out.println("*Buying 5 Mercedes Shares*");
						acc.buyShare("David", "Mercedes", 5);												
					}
					catch(ShareNotFoundException e){
						e.printStackTrace();
					}
					catch(NotEnoughMoneyException e){
						e.printStackTrace();
					}
					finally{
							System.out.println("*End of the demo*");
							acc.getStockPriceProvider().startUpdate();						
					}					
			}
		}
	}
}