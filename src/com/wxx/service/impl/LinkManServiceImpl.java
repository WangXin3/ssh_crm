package com.wxx.service.impl;

import com.wxx.dao.LinkManDao;
import com.wxx.domain.LinkMan;
import com.wxx.service.LinkManService;

public class LinkManServiceImpl implements LinkManService{
	private LinkManDao lmd;
	
	
	@Override
	public void save(LinkMan linkMan) {
		lmd.save(linkMan);
	}


	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}
	

}
