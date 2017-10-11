package cn.wulin.base;

import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public class ModelDrivenBaseAction<T> extends BaseAction<T> implements ModelDriven<T> {
	private static final long serialVersionUID = 2246785649060468430L;
	protected T model;
	protected HttpServletResponse response;
	public ModelDrivenBaseAction() {
		try {
			// 得到model的类型信息
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];

			// 通过反射生成model的实例
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
	}

	public T getModel() {
		return model;
	}

}
