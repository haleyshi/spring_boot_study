package com.sgh.demo.action;

//import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
//import com.sgh.demo.service.UserService;

public class HelloAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	// @Autowired
	// private UserService userService;

	private String name;

	@Override
	public String execute() throws Exception {
		// userService.doSomething();
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
