package cn.itcast.web.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import cn.itcast.web.ajax.dao.CityDao;
import cn.itcast.web.ajax.domain.City;

public class CityServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String province = request.getParameter("province");
		byte[] buf = province.getBytes("ISO8859-1");
		province = new String(buf,"UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String jsonString = null;
		try {
			CityDao cityDao = new CityDao();
			List<City> cityList = cityDao.findCityByProvince(province);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"id","province_name"});
			JSONArray jsonArray = JSONArray.fromObject(cityList,jsonConfig);
			jsonString = jsonArray.toString();
			System.out.println("jsonString="+jsonString);
			pw.write(jsonString);
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		
		/*
		List<City> cityList = new ArrayList<City>();
		if(province.equals("吉林省")){
			cityList.add(new City(1,"长春"));
			cityList.add(new City(2,"吉林市"));
			cityList.add(new City(3,"松原"));
			cityList.add(new City(4,"通化"));
		}else if(province.equals("辽宁省")){
			cityList.add(new City(1,"沈阳"));
			cityList.add(new City(2,"大连"));
			cityList.add(new City(3,"鞍山"));
			cityList.add(new City(4,"抚顺"));
			cityList.add(new City(5,"铁岭"));
		}else if(province.equals("山东省")){
			cityList.add(new City(1,"济南"));
			cityList.add(new City(2,"青岛"));
			cityList.add(new City(3,"威海"));
		}
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"id"});
		JSONArray jsonArray = JSONArray.fromObject(cityList,jsonConfig);
		jsonString = jsonArray.toString();
		System.out.println("jsonString="+jsonString);
		pw.write(jsonString);
		*/
		
		/*
		if(province.equals("吉林省")){
			jsonString="{'city':['长春','吉林市','松原','通化']}";	
		}else if(province.equals("辽宁省")){
			jsonString="{'city':['沈阳','大连','鞍山','抚顺','铁岭']}";	
		}else if(province.equals("山东省")){
			jsonString="{'city':['济南','青岛','威海']}";	
		}
		pw.write(jsonString);
		*/
		
		
		/*
		pw.write("<root>");
		if(province.equals("吉林省")){
			pw.write("<city>长春[吉林省]</city>");
			pw.write("<city>吉林市[吉林省]</city>");
			pw.write("<city>松原[吉林省]</city>");
			pw.write("<city>通化[吉林省]</city>");
		}else if(province.equals("辽宁省")){
			pw.write("<city>沈阳[辽宁省]</city>");
			pw.write("<city>大连[辽宁省]</city>");
			pw.write("<city>鞍山[辽宁省]</city>");
			pw.write("<city>抚顺[辽宁省]</city>");
			pw.write("<city>铁岭[辽宁省]</city>");
		}else if(province.equals("山东省")){
			pw.write("<city>济南[山东省]</city>");
			pw.write("<city>青岛[山东省]</city>");
			pw.write("<city>威海[山东省]</city>");
		}
		pw.write("</root>");
		*/
		
		
	}
}
