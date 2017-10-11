package cn.lh.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lh.domain.Export1;
import cn.lh.domain.Export2;
import cn.lh.domain.Export3;
import cn.lh.domain.Export4;
import cn.lh.domain.UserLogin;
import cn.lh.service.Export1Service;
import cn.lh.service.Export2Service;
import cn.lh.service.Export3Service;
import cn.lh.service.Export4Service;
import cn.lh.service.UserLoginService;
import cn.lh.service.impl.Export1ServiceImpl;
import cn.lh.service.impl.Export2ServiceImpl;
import cn.lh.service.impl.Export3ServiceImpl;
import cn.lh.service.impl.Export4ServiceImpl;
import cn.lh.service.impl.UserLoginServiceImpl;
import cn.lh.util.CommonUtil;
import cn.lh.util.DataUtil;
import cn.lh.util.WordUtil;

public class ExportAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String export = request.getParameter("export_");
		String suid = request.getParameter("uid");
		String sess = request.getParameter("sess");
		String spid = request.getParameter("spid");
		try{
			if("export1".equals(export)){
				UserLoginService loginService = new UserLoginServiceImpl();
				UserLogin login = loginService.findUserLogin1(suid, sess, spid);
				if(login != null && !"0000".equals(login.getMsgno())){
					response.getWriter().write("${msg:\""+login.getMsg()+"\"}");
				}
				Export1Service service = new Export1ServiceImpl();
				Export1 export1 = service.findExport1(suid, sess, spid);
				export1.setHeadPicture(DataUtil.getImageStr(CommonUtil.getRealPath(request, CommonUtil.IMAGE_PATH,"dress8.png")));
				WordUtil.startExport1(request, response,export1);// 资阳市医疗保险特殊疾病申报审批表
			}else if("export2".equals(export)){
				UserLoginService loginService = new UserLoginServiceImpl();
				UserLogin login = loginService.findUserLogin2(suid, sess, spid);
				if(login != null && !"0000".equals(login.getMsgno())){
					response.getWriter().write("${msg:\""+login.getMsg()+"\"}");
				}
				Export2Service service = new Export2ServiceImpl();
				Export2 export2 = service.findExpor2(suid, sess, spid);
				WordUtil.startExport2(request, response,export2);// 3个医院异地登记审批表
			}else if("export3".equals(export)){
				UserLoginService loginService = new UserLoginServiceImpl();
				UserLogin login = loginService.findUserLogin3(suid, sess, spid);
				if(login != null && !"0000".equals(login.getMsgno())){
					response.getWriter().write("${msg:\""+login.getMsg()+"\"}");
				}
				Export3Service service = new Export3ServiceImpl();
				Export3 export3 = service.findExpor3(suid, sess, spid);
				WordUtil.startExport3(request, response,export3);// 单病申报审批表欧
			}else if("export4".equals(export)){
				UserLoginService loginService = new UserLoginServiceImpl();
				UserLogin login = loginService.findUserLogin4(suid, sess, spid);
				if(login != null && !"0000".equals(login.getMsgno())){
					response.getWriter().write("${msg:\""+login.getMsg()+"\"}");
				}
				Export4Service service = new Export4ServiceImpl();
				Export4 export4 = service.findExpor4(suid, sess, spid);
				WordUtil.startExport4(request, response,export4);// 社会保障卡申领登记表(新版20140716)
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
