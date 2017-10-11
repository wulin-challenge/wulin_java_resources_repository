package cn.xh.dao.intf;

import java.util.List;

import cn.xh.domain.Upload;
import cn.xh.domain.User;

public interface UploadDao {
	/**
	 * 增加上传
	 * @param upload
	 */
	public void addUpload(Upload upload);
	
	
	
	/**
	 * 查找该用户所有上传
	 * @return
	 */
	public List<Upload> findByUserUpload(User user);
	
	/**
	 * 根据id删除上传
	 * @param id
	 */
	public void remove(Long id);

	/**
	 * 根据Id查找上传 
	 * @param id
	 * @return
	 */
	public Upload getById(Long id);

}
