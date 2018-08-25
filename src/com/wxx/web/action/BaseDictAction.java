package com.wxx.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.wxx.domain.BaseDict;
import com.wxx.service.BaseDictService;

public class BaseDictAction extends ActionSupport{
	private String dict_type_code;
	private BaseDictService baseDictService;
	

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	@Override
	public String execute() throws Exception {
		//1.调用service根据typeCode获得数据字典对象list
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		//2.将list转换为json格式
		Gson gson = new Gson();
		String json = gson.toJson(list);
		//3.将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		//不需要进行结果处理
		return null;
	}
	
	
}
