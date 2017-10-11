package cn.wulin.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestBase64 {
	public static void main(String[] args) {  
		  
		      
		    // 测试从图片文件转换为Base64编码  
		   String imageStr =  GetImageStr("d:\\dress8.png");  
		   System.out.println(imageStr);
		      
		    // 测试从Base64编码转换为图片文件  
		      
		    //String strImg = "这里放64位编码";  
		    GenerateImage(imageStr, "D:\\dress88.jpg");  
		    
	}
	
	/**
	 * 将图片转换为base64编码
	 * @param imgFilePath 图片的输出路径
	 * @return
	 */
	public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		byte[] data = null;

		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * 将经base64编码字符串转换为图片
	 * @param imgStr 经base64编码过后的字符串
	 * @param imgFilePath 图片输出路径
	 * @return
	 */
	public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//通过byte[]数组得到流
	public static InputStream byteTOInputStream(byte[] in) throws Exception{  
        ByteArrayInputStream is = new ByteArrayInputStream(in);  
        return is;  
    }
	
	//通过base64码字符串得到byte数组
	public static byte[] decoderBase64File(String base64Code)throws Exception {
		 return new BASE64Decoder().decodeBuffer(base64Code);
	}
	
	//通过base64字符串得到流
	public static InputStream decoderBase64FileToInputStream(String base64Code)throws Exception {
		 return new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(base64Code));
	}

}
