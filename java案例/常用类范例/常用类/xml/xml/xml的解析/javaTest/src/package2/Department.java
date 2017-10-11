package package2;

import java.util.HashMap;
import java.util.Map;

public class Department {
	private int departmentId;
	private int name;
	private Map<String,Student> studentMap=new HashMap<String,Student>();
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public Map<String, Student> getStudentMap() {
		return studentMap;
	}
	public void setStudentMap(Map<String, Student> studentMap) {
		this.studentMap = studentMap;
	} 

}
