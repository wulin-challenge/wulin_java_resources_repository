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

/**
 * 表格的列。
 * 
 * @author LeiWen@fansunion.cn,http://FansUnion.cn,
 *         http://blog.csdn.net/FansUnion
 */
public class Col {
	/**
	 * 列的值
	 */
	public String value;
	/**
	 * 几行合并为1行
	 */
	public int rowspan;
	/**
	 * 几列合并为1列
	 */
	public int colspan;

}
