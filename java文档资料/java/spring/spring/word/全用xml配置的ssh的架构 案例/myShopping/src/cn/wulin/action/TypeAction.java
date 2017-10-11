package cn.wulin.action;

import java.util.List;

import cn.wulin.base.ModelDrivenBaseAction;
import cn.wulin.domain.Type;
import cn.wulin.service.TypeService;

public class TypeAction extends ModelDrivenBaseAction<Type> {

	private static final long serialVersionUID = 3691747684499355866L;
	
	
	public String save() throws Exception {
		String[] typeArray = new String[]{"文集","纪实文学","文学理论","中国古诗词","中国现当代诗歌","中国古代随笔","中国现当代随笔","戏剧","民间文学"};
		
		Type parent = typeService.findEntity(15l);
		for (String at : typeArray) {
			Type type = new Type();
			type.setName(at);
			type.setViewAlias("articleView");
			type.setParent(parent);
			typeService.saveEntity(type);
		}
		return null;
	}	
	
	public String list() throws Exception{
		List<Type> typeList = typeService.findAll();
		for (Type type : typeList) {
			String name = null;
			if(type.getParent() != null){
				name = type.getParent().getName();
			}
			System.out.println(type.getName()+" : "+type.getId()+" : "+name);
		}
		return null;
	}
	
	//-------set and get------
	
	public TypeService getTypeService() {
		return typeService;
	}
	
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
}
