package com.BC.dao;

import com.BC.beans.Message;

public class MessageDao extends DaoHibernateFactory<Message>{

	public MessageDao() {
		super(Message.class);
	}

}
