package cn.scxh.servlet.package2;


public class User{

	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public int compare(User o1, User o2) {
		
		return (int) (o1.getId()-o2.getId());
	}
	   
}
