package spring2_5;

import java.util.Properties;

public class BeanFactory {
	
	private static Properties props;
	
	static{
		//模拟读取配置文件
		props=new Properties();
		props.setProperty("UserDao", "spring2_5.UserDaoImpl");
		System.out.println("a");
	}
	/**
	 * 根据配置生成对应实现类的实例
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T>T getBeanInstance(Class<T> clazz){
		String className=props.getProperty(clazz.getSimpleName());
		System.out.println("b");
		try {
		//	System.out.println("h="+(T) Class.forName(className).newInstance());
			return (T) Class.forName(className).newInstance();//使用反射调用了UserDaoImpl类的构造方法
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
