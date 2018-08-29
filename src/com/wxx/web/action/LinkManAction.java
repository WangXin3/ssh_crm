package com.wxx.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wxx.domain.LinkMan;
import com.wxx.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkMan linkMan = new LinkMan();
	private LinkManService lms;
	
	public String add() throws Exception {
		//1.调用service
		lms.save(linkMan);
		//2.重定向到联系人列表
		return "toList";
	}
	
	@Override
	public LinkMan getModel() {
		return linkMan;
	}

	public void setLms(LinkManService lms) {
		this.lms = lms;
	}
}
