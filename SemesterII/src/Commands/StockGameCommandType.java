package Commands;

public enum StockGameCommandType implements CommandTypeInfo {
	
	HELP("help", "*list all commands"),
	EXIT("exit", "exit program"),
	CREATEPLAYER("crp <playername>", "create a player"),
	BUYSHARE("buyshare <playername> <sharename> <amount>", "buy a share"),
	SELLSHARE("sellshare <playername> <sharename> <amount>", "sell a share");
	
	private final String command;
	private final String description;
	
	StockGameCommandType(String command, String description){
		
		this.command = command;
		this.description = description;
		
	}
	
	@Override
	public String getCommand(){
		return this.command;
	}
	
	@Override
	public String getDescription(){
		return this.description;
	}

	@Override
	public String toString(){
		return this.name()+this.command+this.description;
	}

	@Override
	public Class<?> getParamTypes() {
		// TODO Auto-generated method stub
		return null;
	}
}
