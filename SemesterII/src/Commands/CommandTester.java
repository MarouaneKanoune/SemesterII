package Commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandTester {
	public static void main(String[] args ){
		
		
		BufferedReader lol = new BufferedReader(new InputStreamReader(System.in));
		CommandScanner scannerBoi = new CommandScanner(StockGameCommandType.values(),lol);
		Class<?>[] arr = new Class<?>[4];
		Class<?>[] arr2 = new Class<?>[]{String.class, String.class , Integer.class};
		
		StockGameCommandType wtf = StockGameCommandType.BUYSHARE;
		System.out.println(wtf.getParamTypes().toString());
	}
}
