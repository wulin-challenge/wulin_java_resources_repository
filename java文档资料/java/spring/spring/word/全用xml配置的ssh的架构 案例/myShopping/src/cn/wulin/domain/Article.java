package cn.wulin.domain;

import java.util.Date;

public class Article {
	private Long id; //主键Id
	private String title; //文章的标题
	private Author author; //文章的作者
	private Integer clickNumber; //文章的点击数
	private Date publishTime; //文章的发表时间
	private Address publishPlace; //文章发表的所属地
	private Boolean auditing; //审核
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Integer getClickNumber() {
		return clickNumber;
	}
	public void setClickNumber(Integer clickNumber) {
		this.clickNumber = clickNumber;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Boolean getAuditing() {
		return auditing;
	}
	public void setAuditing(Boolean auditing) {
		this.auditing = auditing;
	}
	public Address getPublishPlace() {
		return publishPlace;
	}
	public void setPublishPlace(Address publishPlace) {
		this.publishPlace = publishPlace;
	}
}
