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
package cn.fansunion.excel2html.model;

import java.util.List;

/**
 * 展示界面用到的数据模型。
 * 
 * @author LeiWen@fansunion.cn,http://FansUnion.cn,
 *         http://blog.csdn.net/FansUnion
 */
public class DisplayDataModel {

	/**
	 * 多个表格
	 */
	private List<TableModel> tableModelList;

	public List<TableModel> getTableModelList() {
		return tableModelList;
	}

	public void setTableModelList(List<TableModel> tableModelList) {
		this.tableModelList = tableModelList;
	}

}
