package cn.wulin.service.impl;

import cn.wulin.base.impl.BaseServiceImpl;
import cn.wulin.dao.AddressDao;
import cn.wulin.domain.Address;
import cn.wulin.service.AddressService;

public class AddressServiceImpl extends BaseServiceImpl<Address,AddressDao> implements AddressService{

	public AddressDao addressDao;
	
	//------set and get-----------

	public AddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	
}
