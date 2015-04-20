package Stockmarket;

import java.util.Timer;

public class Ticker extends Timer{    
    private static  Ticker firstInstance = null;	  
    /*
	 * Singleton pattern: Should make the construction of more than one object of this object-type impossible
	 */	
    
    private Ticker(){}
    
    public static Ticker getInstance(){			
		if(firstInstance == null){			
			firstInstance = new Ticker();				
		}		
		return firstInstance;		
	}	       	        
}
