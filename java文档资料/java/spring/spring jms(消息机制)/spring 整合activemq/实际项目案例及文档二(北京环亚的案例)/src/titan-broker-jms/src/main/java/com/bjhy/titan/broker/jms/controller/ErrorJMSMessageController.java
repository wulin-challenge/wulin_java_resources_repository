package com.bjhy.titan.broker.jms.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjhy.platform.commons.i18n.Message;
import com.bjhy.platform.commons.i18n.MessageUtil;
import com.bjhy.platform.commons.jqgrid.QueryParams;
import com.bjhy.platform.commons.pager.Condition;
import com.bjhy.platform.commons.pager.Operation;
import com.bjhy.platform.commons.pager.PageBean;
import com.bjhy.platform.commons.pager.RelateType;
import com.bjhy.platform.util.jqgrid.JqGridUtil;
import com.bjhy.titan.broker.jms.domain.ErrorJMSMessage;
import com.bjhy.titan.broker.jms.service.ErrorJMSMessageService;

@Controller
@RequestMapping("/errorJMSMessage")
public class ErrorJMSMessageController {
	
	private final static String INDEX_URL = "errorJMSMessage_index";
	
	@Autowired
	private ErrorJMSMessageService ErrorJMSMessageService;
	
	
	/**
	 * 日期转换器
	 */
	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder)throws Exception {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	
		fmt.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	//首页
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		return INDEX_URL;
	}
	
	//列表查询
	@RequestMapping
	public @ResponseBody PageBean list(QueryParams queryParams){
		JqGridUtil.getPageBean(queryParams);
		PageBean pageBean = JqGridUtil.getPageBean(queryParams);
		ErrorJMSMessageService.pageQuery(pageBean);
		return pageBean;
	}
	
	//新增
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Message create(ErrorJMSMessage ErrorJMSMessage){
		ErrorJMSMessageService.save(ErrorJMSMessage);
		return MessageUtil.message("errorJMSMessage.create.success");
	}
	
	//更新
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody Message create(@PathVariable String id, ErrorJMSMessage ErrorJMSMessage){
		ErrorJMSMessage.setId(id);
		ErrorJMSMessageService.update(ErrorJMSMessage);
		return MessageUtil.message("errorJMSMessage.update.success");
	}
	
	//查看
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ErrorJMSMessage view(@PathVariable String id){
		return ErrorJMSMessageService.findById(id);
	}
	
	//删除
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Message delete(@PathVariable String id){
		ErrorJMSMessageService.deleteById(id);
		return MessageUtil.message("errorJMSMessage.delete.success");
	}
	
	//批量删除
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody Message batchDelete(@RequestParam("ids[]") String[] ids){
		ErrorJMSMessageService.deleteById(ids);
		return MessageUtil.message("errorJMSMessage.delete.success");
	}
	
	//查询全部数据
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<ErrorJMSMessage> getAll(){
		return ErrorJMSMessageService.findAll(new Sort(Direction.DESC, "createDate"));
	}
	
	//消息处理
	@RequestMapping(value = "/dispose", method = RequestMethod.POST)
	public @ResponseBody Message dispose(@RequestParam("ids[]") String [] ids) throws Exception{
		ErrorJMSMessageService.dispose(ids);
		return MessageUtil.message("errorJMSMessage.dispose.success");
	}
	
}
