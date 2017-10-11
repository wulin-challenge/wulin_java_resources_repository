package test;

import java.net.MalformedURLException;

import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import com.xaccp.domain.Person;
import com.xaccp.service.Ihello;

public class TestService {
	public static void main(String[] args) {
		//创建服务的元数据
		Service ServiceModel = new ObjectServiceFactory().create(Ihello.class);
		//创建服务代理
		XFire xfire = XFireFactory.newInstance().getXFire();
		XFireProxyFactory factory = new XFireProxyFactory(xfire);
		//服务地址
		String serviceURL = "http://localhost:8080/service/services/hello";
		try {
			//服务代理通过服务元数据和服务地址取得服务实例
			Ihello helloService = (Ihello) factory.create(ServiceModel,serviceURL);
			String serviceResponse = helloService.sayHello("你好");
			String you = helloService.sayThanks("wulin");
			Person person = helloService.getPerson("1", "wubo");
			Person p = new Person();
			p.setId("2");
			p.setName("hh");
			helloService.getPerson(p);
			System.out.println(you+","+serviceResponse);
			System.out.println("id:"+person.getId()+","+person.getName());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	
	}

}
