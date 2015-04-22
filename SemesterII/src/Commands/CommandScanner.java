package Commands;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommandScanner {

	private BufferedReader reader;
	private ArrayList<CommandTypeInfo> commandTypes = new ArrayList<>();
	
	public CommandScanner(CommandTypeInfo[] commandTypeInfo, BufferedReader reader){
		commandTypes.addAll(Arrays.asList(commandTypeInfo));
		this.reader = reader;
	}
	
	public void inputLine2CommandDescriptor(CommandDescriptor commandDescriptor)throws IOException{
		String[] line = this.reader.readLine().split(" ");
		Iterator<CommandTypeInfo> newIterator = commandTypes.iterator();
		
		
		while(newIterator.hasNext()){
			CommandTypeInfo commandTypeInfo = newIterator.next();
			if(commandTypeInfo.getCommand().equals(line[0])){
				commandDescriptor.setCommandType(commandTypeInfo);
				break;
			}
		}
	}

	
	
	
}
