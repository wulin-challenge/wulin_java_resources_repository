package cn.wulin.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Author {
	private Long id; //作者的Id号
	private String name; //作者姓名
	private String gender; //作者性别
	private Integer age; //作者的年龄
	private Date birthday; //作者的出生年月
	private Address nationality; //作者的国籍
	private Set<Article> articleSet = new HashSet<Article>(); // 作者的文章
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Set<Article> getArticleSet() {
		return articleSet;
	}
	public void setArticleSet(Set<Article> articleSet) {
		this.articleSet = articleSet;
	}
	public Address getNationality() {
		return nationality;
	}
	public void setNationality(Address nationality) {
		this.nationality = nationality;
	}
}
