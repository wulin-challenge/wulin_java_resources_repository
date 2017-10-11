package cn.itcast.java.proxy.exe2;

//Ä¿±ê¶ÔÏó
public class Liyuchun implements Star {
	public void sing(String money) {
		System.out.println("´º¸ç³ª¸è");
	}
	public void dance(String money, String what) {
		System.out.println("´º¸çÌøÎè£¬Ãû³ÆÎª" + what);
	}
	public void eat(String money) {
		System.out.println("´º¸çÅã³Ô");
	}
}
