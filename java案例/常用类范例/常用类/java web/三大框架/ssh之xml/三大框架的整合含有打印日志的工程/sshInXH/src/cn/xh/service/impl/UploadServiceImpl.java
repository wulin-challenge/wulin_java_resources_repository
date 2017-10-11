package cn.xh.service.impl;

import java.util.List;

import cn.xh.dao.intf.UploadDao;
import cn.xh.domain.Upload;
import cn.xh.domain.User;
import cn.xh.service.intf.UploadService;

public class UploadServiceImpl implements UploadService{
	private UploadDao uploadDao;

	public void addUpload(Upload upload) {
		uploadDao.addUpload(upload);
	}

	public List<Upload> findByUserUpload(User user) {
		return uploadDao.findByUserUpload(user);
	}

	public Upload getById(Long id) {
		return uploadDao.getById(id);
	}

	public void remove(Long id) {
		uploadDao.remove(id);
	}

	//--------------
	
	public UploadDao getUploadDao() {
		return uploadDao;
	}

	public void setUploadDao(UploadDao uploadDao) {
		this.uploadDao = uploadDao;
	}

	
}
