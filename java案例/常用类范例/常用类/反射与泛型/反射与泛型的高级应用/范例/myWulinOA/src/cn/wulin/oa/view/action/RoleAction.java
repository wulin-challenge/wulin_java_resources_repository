package cn.wulin.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.wulin.oa.domain.Role;
import cn.wulin.oa.service.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role> {

	@Resource
	private RoleService roleService;

	// private Long id;
	// private String name;
	// private String description;

	private Role model = new Role();

	public Role getModel() {
		return model;
	}

	/** 列表 */
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "addUI";
	}

	/** 添加 */
	public String add() throws Exception {
		// 得到参数，封装成对象，当使用实体做为Model时，也可以直接使用model
		// Role role = new Role();
		// role.setName(name);
		// role.setDescription(description);
		// roleService.save(role);

		// 保存到数据库中
		roleService.save(model);

		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		Role role = roleService.getById(model.getId());
		// this.name = role.getName();
		// this.description = role.getDescription();

		ActionContext.getContext().getValueStack().push(role); // 放到栈顶
		return "editUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 从数据库中取出原对象
		Role role = roleService.getById(model.getId());

		// 设置要修改的属性
		role.setName(model.getName());
		role.setDescription(model.getDescription());

		// 更新到数据库中
		roleService.update(role);

		return "toList";
	}

	// -----------------

}
