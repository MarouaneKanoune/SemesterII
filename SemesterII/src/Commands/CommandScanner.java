package Commands;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommandScanner {

	private BufferedReader reader;
	private CommandTypeInfo[] commandTypeInfos = new CommandTypeInfo[10];
	
	public CommandScanner(CommandTypeInfo[] commandTypeInfos, BufferedReader reader){		
		this.commandTypeInfos = commandTypeInfos;
		this.reader = reader;
	}
	
	public void inputLine2CommandDescriptor(CommandDescriptor commandDescriptor)throws IOException{
		String[] line = this.reader.readLine().split(" ");
		for(int i=0;i<commandTypeInfos.length;i++){
			if(commandTypeInfos[i].getCommand() == line[0] ){
				commandDescriptor.setCommandType(commandTypeInfos[i]);
				break;
			}	
		}
		Object[] paramTypes = new Object[1];
		for(int i=0;i<commandTypeInfos.length;i++){
//			for(int j=0;j<)
//			if(commandTypeInfos[i].getParamTypes())
//		}
		
	}
//		Iterator<CommandTypeInfo> commandIterator = commandTypes.listIterator();
	
//		private ArrayList<CommandTypeInfo> commandTypes = new ArrayList<>();		
//		while(newIterator.hasNext()){
//			CommandTypeInfo commandTypeInfo = commandIterator.next();
//			commandDescriptor.setCommandType(commandTypes.get(0));
//			ArrayList<?> wut = commandTypes.get(2));
//			if(commandTypeInfo.getCommand().equals(line[0])){
//				commandDescriptor.setCommandType(commandTypeInfo);
//				break;
//			}
//		while(paramTypeIterator.hasNext()){
//			
//		}
//		}
		
}