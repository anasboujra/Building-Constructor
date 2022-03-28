package com.BC.dao;

import com.BC.beans.Consomation;

public class ConsomationDao extends DaoHibernateFactory<Consomation>{
	public ConsomationDao() {
		super(Consomation.class);
	}

}
