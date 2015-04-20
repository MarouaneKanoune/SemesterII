package Commands;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import AccountManager.*;


public class StockGameCommandProcessor {
	
	BufferedReader shellReader = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter shellWriter = new PrintWriter(System.out);
	AccountManager accountManager;
	
	public StockGameCommandProcessor(AccountManager accountManager){
		this.accountManager = accountManager;
	}
	
	public void process(){
		
	}
	
	 StockGameCommandType commandType = (StockGameCommandType)commandDescriptor.getCommandType();
     switch (commandType)
        
	
}
