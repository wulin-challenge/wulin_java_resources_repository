package cn.wulin.test.other;

public class First {
	
	public String batchCommand(String data){
		
		System.out.println("这是传输过来的数据->"+data);
		
		data += data;
		
		return data;
	}
}
