package cn.itcast.java.annotation;

public class Demo2 {
	@MyAnnotation(who="jack",age=30,gender="male")
	public void jump(){
	}
	
	@YouAnnotation
	public void sleep(){
	}
	
	@TheyAnnotation(value={"电视","洗衣机"})
	public void buy(){
		
	}
	
	@TheyAnnotation({"电脑","游戏"})
	public void play(){
		
	} 
	
	public static void main(String[] args) {
		Demo2 demo = new Demo2();
		demo.jump();
	}
}
