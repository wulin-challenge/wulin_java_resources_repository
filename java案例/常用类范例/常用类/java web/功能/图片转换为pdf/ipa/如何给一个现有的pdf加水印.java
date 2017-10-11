import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
/**
 * PDF生成
 */
public class PDFBuild {
	public static void buidPDF(String pdfFile, String imageFile,
			String waterMarkName, int permission) {
		try {
			File file = File.createTempFile("tempFile", ".pdf"); // 创建临时文件
			// 生成PDF
			if (createPDFFile(file)) {
				waterMark(file.getPath(), imageFile, pdfFile, waterMarkName,
						permission); // 添加水印
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 创建PDF文件
	 * 
	 * @param file
	 *            临时文件
	 * @return 成功/失败
	 */
	public static boolean createPDFFile(File file) {
		Rectangle rect = new Rectangle(PageSize.A4);
		Document doc = new Document(rect, 50.0F, 50.0F, 50.0F, 50.0F);
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(file));
			doc.open();
			BaseFont bf = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1",
					"Identity-H", true);// 使用系统字体
			Font font = new Font(bf, 14.0F, 0);
			font.setStyle(37); // 设置样式
			font.setFamily("宋体"); // 设置字体
			Paragraph p = new Paragraph("付 款 通 知 书\r\n", font);
			p.setAlignment(1);
			doc.add(p);
			doc.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void waterMark(String inputFile, String imageFile,
			String outputFile, String waterMarkName, int permission) {
		try {
			PdfReader reader = new PdfReader(inputFile);
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
					outputFile));
			BaseFont base = BaseFont.createFont(
					"C:/WINDOWS/Fonts/SIMSUN.TTC,1", "Identity-H", true);// 使用系统字体
			int total = reader.getNumberOfPages() + 1;
			Image image = Image.getInstance(imageFile);
			// 图片位置
			image.setAbsolutePosition(400, 480);
			PdfContentByte under;
			int j = waterMarkName.length();
			char c = 0;
			int rise = 0;
			for (int i = 1; i < total; i++) {
				rise = 400;
				under = stamper.getUnderContent(i);
				under.beginText();
				under.setFontAndSize(base, 30);
				if (j >= 15) {
					under.setTextMatrix(200, 120);
					for (int k = 0; k < j; k++) {
						under.setTextRise(rise);
						c = waterMarkName.charAt(k);
						under.showText(c + "");
					}
				} else {
					under.setTextMatrix(240, 100);
					for (int k = 0; k < j; k++) {
						under.setTextRise(rise);
						c = waterMarkName.charAt(k);
						under.showText(c + "");
						rise -= 18;
					}
				}
				// 添加水印文字
				under.endText();
				// 添加水印图片
				under.addImage(image);
				// 画个圈
				under.ellipse(250, 450, 350, 550);
				under.setLineWidth(1f);
				under.stroke();
			}
			stamper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String imageFilePath = "D:/itext2.png"; // 水印图片路径
		String pdfFilePath = "D:/itext.pdf"; // 文件生成路径
		buidPDF(pdfFilePath, imageFilePath, "正版授权", 16);
	}
}
