package com.wxx.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wxx.domain.Customer;
import com.wxx.domain.LinkMan;
import com.wxx.service.LinkManService;
import com.wxx.utils.PageBean;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	private LinkMan linkMan = new LinkMan();
	private LinkManService lms;

	// 属性驱动
	private Integer currentPage;
	private Integer pageSize;

	public String list() throws Exception {
		// 封装离线查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		// 判断并封装参数
		if (StringUtils.isNotBlank(linkMan.getLkm_name())) {
			detachedCriteria.add(Restrictions.like("lkm_name", "%" + linkMan.getLkm_name() + "%"));
		}
		
		if (linkMan.getCustomer() != null && linkMan.getCustomer().getCust_id() != null) {
			detachedCriteria.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}
		

		// 1.调用Service查询分页数据（PageBean）
		PageBean pageBean = lms.getPageBean(detachedCriteria, currentPage, pageSize);
		// 2.将PageBean放入request域，转发到列表页面显示
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}
	
	

	public String toEdit() throws Exception {
		
		//1.调用Service
		LinkMan lm = lms.getById(linkMan.getLkm_id());
		
		//2.将查询的LinkMan对象放入request域
		ActionContext.getContext().put("linkMan", lm);
		return "add";
	}



	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String add() throws Exception {
		// 1.调用service
		lms.save(linkMan);
		// 2.重定向到联系人列表
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
