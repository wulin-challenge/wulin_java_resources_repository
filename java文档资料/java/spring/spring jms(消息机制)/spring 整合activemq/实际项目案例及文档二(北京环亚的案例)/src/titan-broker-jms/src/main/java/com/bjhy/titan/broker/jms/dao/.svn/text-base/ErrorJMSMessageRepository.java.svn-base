package com.bjhy.titan.broker.jms.dao;

import org.springframework.data.jpa.repository.Query;

import com.bjhy.platform.persist.dao.CommonRepository;
import com.bjhy.titan.broker.jms.domain.ErrorJMSMessage;

public interface ErrorJMSMessageRepository extends CommonRepository<ErrorJMSMessage, String>{


	@Query("select id from ErrorJMSMessage where 1=1 ")
	public  String [] findAllId();
}
