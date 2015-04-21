package Commands;

public enum StockGameCommandType implements CommandTypeInfo {
	
	HELP("help", "*list all commands"),
	EXIT("exit", "exit program"),
	CREATEPLAYER("crp <playername>", "create a player", String.class),
	BUYSHARE("buyshare <playername> <sharename> <amount>", "buy a share", String.class, String.class, Integer.class),
	SELLSHARE("sellshare <playername> <sharename> <amount>", "sell a share", String.class, String.class, Integer.class);
	
	private final String command;
	private final String description;
	private final Class<?>[] paramTypes;
	
	StockGameCommandType(String command, String description, Class<?>... paramTypes){
		
		this.command = command;
		this.description = description;
		this.paramTypes = paramTypes;
		
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
	public Class<?>[] getParamTypes() {
		// TODO Auto-generated method stub
		return this.paramTypes;
	}
}