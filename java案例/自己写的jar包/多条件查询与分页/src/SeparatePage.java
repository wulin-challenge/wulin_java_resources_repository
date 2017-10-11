package wulin.information.domain;

import java.util.ArrayList;
import java.util.List;

public class SeparatePage<T> {
	private Integer currentPage; //当前页
	private Integer startPage; //开始页
	private Integer recordOfPer=5; //每页显示的记录数
	private Integer allPage;  //总页数
	private Integer allRecord; //总记录数
	private List<T> currentPageData=new ArrayList<T>(); //当前页的数据
	
	public SeparatePage() {
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getRecordOfPer() {
		return recordOfPer;
	}
	public void setRecordOfPer(Integer recordOfPer) {
		this.recordOfPer = recordOfPer;
	}
	
	public Integer getAllPage() {
		return allPage;
	}
	public void setAllPage(Integer allPage) {
		this.allPage = allPage;
	}
	public Integer getAllRecord() {
		return allRecord;
	}
	public void setAllRecord(Integer allRecord) {
		this.myAllPage(allRecord);
		this.allRecord = allRecord;
	}
	public List<T> getCurrentPageData() {
		return currentPageData;
	}
	public void setCurrentPageData(List<T> currentPageData) {
		this.currentPageData = currentPageData;
	}
	
	public Integer getStartPage() {
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	
	/**设置总页数*/
	private void myAllPage(Integer allRecord) {
		if(allRecord%this.recordOfPer==0){
			this.allPage=allRecord/this.recordOfPer;
		}else{
			this.allPage=allRecord/this.recordOfPer+1;
		}
		this.judgeMycurrent();
		this.setMyStartPage();
	}
	
	/**判断当前页*/
	private void judgeMycurrent() {
		if(this.currentPage<1){
			this.currentPage=1;
		}
		if(this.currentPage>this.allPage){
			this.currentPage=this.allPage;
		}
	}
	/**设置开始记录数*/
	private void setMyStartPage(){
		if(this.currentPage==1||this.currentPage==0){
			this.startPage=0;
		}else{
			this.startPage=(this.currentPage-1)*this.recordOfPer+1;
		}
		
	}
}
