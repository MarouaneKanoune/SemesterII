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
		if(line.length == 1){
			for(int i=0;i<commandTypeInfos.length;i++){
				if(commandTypeInfos[i].getCommand().equals(line[0])){
					commandDescriptor.setCommandType(commandTypeInfos[i]);
					break;
				}
			}
		}
		
		if(line.length >= 2){ // if a player is created
			
			for(int i=0;i<commandTypeInfos.length;i++){
				if(commandTypeInfos[i].getCommand().split(" ")[0].equals(line[0])){
					commandDescriptor.setCommandType(commandTypeInfos[i]);
					commandDescriptor.setParams(commandTypeInfos[i].getParamTypes());
					break;
				}
			}
		}
	}
}