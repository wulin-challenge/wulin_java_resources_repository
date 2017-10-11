package test;

import java.net.URL;
import org.codehaus.xfire.client.Client;

public class Test {

	public static void main(String[] args) throws Exception {
		DataInterface.DataInterface dd = new DataInterface.DataInterface();
		String url1="http://218.200.197.233:2122/InsureWebService/services/ybyzm?wsdl";
		String[] params1=new String[]{"13982967980"};//"511023198901177332"};
		URL sURL1=new URL(url1);
		Client c1=new Client(sURL1);
		System.out.println(sURL1);
		Object[] result1=c1.invoke("Yzm", params1);
		System.out.println(result1[0]);
	}
}
