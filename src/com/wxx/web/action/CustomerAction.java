package com.wxx.web.action;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wxx.domain.Customer;
import com.wxx.service.CustomerService;
import com.wxx.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	Customer customer = new Customer();
	
	private CustomerService customerService;
	
	//上传的文件会自动封装到File对象
	//在后台提供一个与前台input type=file组件name相同的属性
	private File photo;
	
	//再提交键名后加上固定后缀FileName，文件名称会自动封装到属性中
	private String photoFileName;
	
	//再提交键名后加上固定后缀ContentType，文件MIME类型会自动封装到属性中
	private String photoContentType;
	
	

	//属性驱动
	private Integer currentPage;
	private Integer pageSize;
	
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		//判断并封装参数
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			detachedCriteria.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}
		
		//1.调用Service查询分页数据（PageBean）
		PageBean pageBean = customerService.getPageBean(detachedCriteria, currentPage, pageSize);
		//2.将PageBean放入request域，转发到列表页面显示
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}


	public String add() throws Exception {
		//将文件上传到指定位置
		System.out.println("文件名称:" + photoFileName);
		System.out.println("文件类型:" + photoContentType);
		photo.renameTo(new File("C:\\Users\\Wang\\Desktop\\upload\\" + photoFileName));
		
		//--------------------------------------------------------
		//1.调用Service，保存Customer对象
		customerService.save(customer);
		//2.重定向到客户列表Action
		return "toList";
	}

	@Override
	public Customer getModel() {
		return customer;
	}
	
	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
