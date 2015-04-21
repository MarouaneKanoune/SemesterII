package Commands;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandScanner {

	private ArrayList<CommandTypeInfo> commandTypes = new ArrayList<>();
	
	public CommandScanner(CommandTypeInfo[] commandTypeInfo, BufferedReader reader){
		commandTypes.addAll(Arrays.asList(commandTypeInfo));	//factory method which allows arrays to be viewed as lists.		
	}

	
	
	
}
