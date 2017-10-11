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
package cn.fansunion.excel2html.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * HTTP响应常用代码封装。
 * 
  * @author LeiWen@fansunion.cn,http://FansUnion.cn,
 *         http://blog.csdn.net/FansUnion
 */
public class ResponseUtils {

    private static final String ENCODING_UTF8 = "utf-8";
    public static final String MIME_APPLICATION_JSON = "application/json";

    public static void setResponseHeaders(HttpServletResponse response) {
        response.setHeader("cach-control", "no-cache");
        response.setContentType(MIME_APPLICATION_JSON);
        response.setCharacterEncoding(ENCODING_UTF8);
    }

    // 如果响应头设置为application/json,js自动将返回值解析为js对象。text/plain,js将返回值解析为字符串
    public static void sendJSONData(HttpServletResponse response, String jsonData) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(jsonData);
        out.close();
    }
}
