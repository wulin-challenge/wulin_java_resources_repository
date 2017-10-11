package cn.itcast.web.ajax.dao;

import cn.itcast.web.ajax.domain.Image;

public class ImageDao {
	//¸ù¾İ±àºÅ²éÑ¯Í¼Æ¬
	public Image findImageById(int id){
		Image image = new Image();
		image.setId(id);
		if(id==1){
			image.setName("Áõ±¸");
			image.setAuthor("¹ş¹ş");
		}else if(id==2){
			image.setName("ËïÈ¨");
			image.setAuthor("ºÇºÇ");
		}
		return image;
	}
}
