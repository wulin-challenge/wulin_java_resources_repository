package cn.scxh.ittx.util;

import java.awt.Dimension;
import java.awt.Toolkit;


public class ConstantUtils {
	public static final int HEIGHT;
	public static final int WIDTH;
	public static final String LOGIN="./images/login.png";
	public static final String _1700="./images/1700.jpg";
	
	public static final String IMG01="./images/tool_img01.JPG";
	public static final String IMG02="./images/tool_img02.JPG";
	public static final String IMG03="./images/tool_img03.JPG";
	public static final String IMG04="./images/tool_img04.JPG";
	public static final String IMG05="./images/tool_img05.JPG";
	public static final String IMG06="./images/tool_img06.JPG";
	public static final String IMG07="./images/tool_img07.JPG";
	
	public static final String _001="./images/001.png";
	public static final String _002="./images/002.png";
	public static final String _003="./images/003.png";
	public static final String _004="./images/004.png";
	public static final String _005="./images/005.png";
	public static final String _006="./images/006.png";
	
	public static final String M1="./images/m1.PNG";
	public static final String M2="./images/m2.PNG";
	public static final String M3="./images/m3.PNG";
	
	
	static{
		Toolkit toolket=Toolkit.getDefaultToolkit();
		Dimension dimension=toolket.getScreenSize();
		HEIGHT=(int)dimension.getHeight();
		WIDTH=(int)dimension.getWidth();
	}

}
