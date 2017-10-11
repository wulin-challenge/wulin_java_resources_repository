/**
 * 项目名称: Excel2HtmlTable
 * 版本号：1.0
 * 名字：雷文
 * 博客: http://FansUnion.cn
 * CSDN:http://blog.csdn.net/FansUnion
 * 邮箱: LeiWen@FansUnion.cn
 * QQ：240370818
 * 版权所有: 2013-2113,LeiWen
 */
package cn.fansunion.excel2html;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.fansunion.excel2html.model.DisplayDataModel;
import cn.fansunion.excel2html.model.TableModel;
import cn.fansunion.excel2html.util.JsonUtils;
import cn.fansunion.excel2html.util.ResponseUtils;
import cn.fansunion.excel2html.util.TemplateLoader;

/**
 * 查询Excel报表，转化为Html-Table格式的报表。
 * 
 * @author LeiWen@fansunion.cn,http://FansUnion.cn,
 *         http://blog.csdn.net/FansUnion
 */
@WebServlet(name = "queryReport", urlPatterns = { "/QueryReport" }, loadOnStartup = 1)
public class QueryReport extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String SIMPLE_REPORT_TEMPLATE_XLSX = "simpleReportTemplate.xlsx";
	static final String SIMPLE_REPORT_PAGE = "simpleReport.jsp";

	public static final String INDEX_PAGE = "index.jsp";

	public QueryReport() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		try {

			// 获得模版
			XSSFWorkbook dataWorkbook = getTemplateWorkbook();

			// 构造展示模型数据
			List<TableModel> tableModelList = buildTableModelList(dataWorkbook);

			DisplayDataModel model = new DisplayDataModel();
			model.setTableModelList(tableModelList);

			String beanToJSON = JsonUtils.beanToJSON(model);
			ResponseUtils.setResponseHeaders(response);
			ResponseUtils.sendJSONData(response, beanToJSON);

		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}

	}

	// 构造数据模型，在界面展示
	private List<TableModel> buildTableModelList(XSSFWorkbook dataWorkbook) {
		ExcelToHtmlTable excelToHtmlTable = new ExcelToHtmlTable(dataWorkbook);
		excelToHtmlTable.init();
		List<TableModel> tableModelList = excelToHtmlTable.getTableModelList();
		return tableModelList;
	}

	// 获得Excel模版
	private XSSFWorkbook getTemplateWorkbook() throws FileNotFoundException,
			IOException, InvalidFormatException {
		XSSFWorkbook workbook = TemplateLoader.buildSimpleWorkbook();

		return workbook;

	}

}
