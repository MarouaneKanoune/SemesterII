package Commands;

public class  CommandDescriptor{

	
	private CommandTypeInfo commandType;
	private Object [] params;
	
	public CommandDescriptor(){
		
	}

	public CommandTypeInfo getCommandType() {
		return commandType;
	}

	public void setCommandType(CommandTypeInfo commandType) {
		this.commandType = commandType;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}
	
	
}
