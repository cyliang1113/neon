package cn.lab.neon.back.web.user;

import org.apache.struts2.convention.annotation.Action;

import cn.lab.neon.common.BaseAction;

public class UserAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2314016829014364681L;
	
	@Action("/user/login")
	public void login(){
		responseMsg("ok");
		return;
	}

}
