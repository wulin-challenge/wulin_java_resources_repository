package cn.wulin.exception;

public class JsonConversionException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public JsonConversionException(){}
	
	public JsonConversionException(String information){
		System.out.println(information);
	}


}
