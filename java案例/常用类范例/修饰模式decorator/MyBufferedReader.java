package cn.itcast.web.decorator;

import java.io.BufferedReader;

//将BufferedReader进行必包的包装/装饰
public class MyBufferedReader {
	private BufferedReader br;
	private int no;
	public MyBufferedReader(BufferedReader br){
		this.br = br;
	}
	//重写父对象的方法
	public String readLine() throws Exception{
		String line = null;
		line = br.readLine();
		if(line!=null){
			no++;
			line = no + ":" + line;
		}
		return line;
	}
	//真接使用父对象的方法
	public void close() throws Exception{
		br.close();
	} 
}
