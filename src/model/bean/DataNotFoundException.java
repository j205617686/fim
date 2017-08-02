package model.bean;

public class DataNotFoundException extends Exception{
	
	public DataNotFoundException() // 自訂例外中的自訂方法 
	{
	    
		super("Cannot find data");
		
	}
	
	

}
