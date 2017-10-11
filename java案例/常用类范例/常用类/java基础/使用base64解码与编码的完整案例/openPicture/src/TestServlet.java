import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public static void main(String[] args) {

		// 测试从图片文件转换为Base64编码
		//String imageStr = GetImageStr("http://localhost:8080/openPicture/image/IMG_0073.JPG");

		///System.out.println(imageStr);

		// 测试从Base64编码转换为图片文件

		// String strImg = "这里放64位编码";
		///GenerateImage(imageStr, "D:\\dress88.jpg");
		getImageStr("http://localhost:8080/openPicture/image/IMG_0073.JPG","D:\\dress88.jpg");

	}

	/**
	 * 将图片转换为base64编码
	 * 
	 * @param imgFilePath
	 *            图片的输出路径
	 * @return
	 */
	public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		byte[] data = null;

		// 读取图片字节数组
		try {
			URL url = new URL(imgFilePath);
			InputStream in = url.openStream();
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
	 * 
	 * @param imgStr
	 *            经base64编码过后的字符串
	 * @param imgFilePath
	 *            图片输出路径
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
	
	public static void getImageStr (String _path, String _savePath) {
		String savePath = _savePath;
		String path = _path;
		int BYTE_SIZE = 1;
		int SAVE_SIZE = 1024;
		byte[] buff = new byte[BYTE_SIZE]; // 每次读的缓存
		byte[] save = new byte[SAVE_SIZE]; // 保存前缓存
		BufferedInputStream bf = null;
		FileOutputStream file;
		URL url = null;
		String imgBase64 = "";
		HttpURLConnection httpUrl;
		try {
			// 对字节数组Base64编码
			BASE64Encoder encoder = new BASE64Encoder();

			url = new URL(path);
			httpUrl = (HttpURLConnection) url.openConnection();
			bf = new BufferedInputStream(httpUrl.getInputStream());
			file = new FileOutputStream(savePath);
	
			int i = 0;
			while (bf.read(buff) != -1) { // 一个字节一个字节读
				save[i] = buff[0];
				if (i == SAVE_SIZE - 1) { // 达到保存长度时开始保存
					imgBase64 += encoder.encode(save);
					file.write(save, 0, SAVE_SIZE);
					save = new byte[SAVE_SIZE];
					i = 0;
				} else {
					i++;
				}
			}
			// 最后这段如果没达到保存长度，需要把前面的保存下来
			if (i > 0) {
				imgBase64 += encoder.encode(save);
				file.write(save, 0, i - 1);
			}
			httpUrl.disconnect();
			file.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				bf.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
