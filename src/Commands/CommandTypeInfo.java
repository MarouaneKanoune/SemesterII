package Commands;

public interface CommandTypeInfo {
	
	String getCommand();
	String getDescription();
 	Class <?> getParamTypes();

}
