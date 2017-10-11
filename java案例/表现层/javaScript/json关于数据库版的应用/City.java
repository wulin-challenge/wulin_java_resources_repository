package cn.itcast.web.ajax.domain;

//³ÇÊÐ[JavaBean]
public class City {
	private int id;
	private String city_name;
	private String province_name;
	public City(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
}
