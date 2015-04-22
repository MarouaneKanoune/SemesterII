package Commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandTester {
	public static void main(String[] args )throws IOException {
		
		CommandDescriptor commandDescriptor = new CommandDescriptor();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		CommandScanner commandScanner = new CommandScanner(StockGameCommandType.values(),bufferedReader);
//		Class<?>[] arr = new Class<?>[4];
//		Class<?>[] arr2 = new Class<?>[]{String.class, String.class , Integer.class};
		
		StockGameCommandType wtf = StockGameCommandType.BUYSHARE;
		System.out.println(wtf.getParamTypes().toString());
		
		commandScanner.inputLine2CommandDescriptor(commandDescriptor);
	}
}
