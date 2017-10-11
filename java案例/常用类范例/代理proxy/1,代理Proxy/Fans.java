package cn.itcast.java.proxy.exe2;

//哥/歌迷
public class Fans {
	public static void main(String[] args) {
		//创建代理对象
		LiyuchunProxy liyuchunProxy = new LiyuchunProxy();
		//通过代理对象找目标对象
		Star star = liyuchunProxy.getProxy();
		//业务方法
		star.sing("3");
		//业务方法
		star.dance("5","恰恰舞");
		//业务方法
		star.eat("8");
	}
}
