package cn.lab.neon.back.web.user;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.lab.neon.common.BaseAction;
import cn.lab.neon.common.jms.EmulateTopicMessageProducer;
import cn.lab.neon.common.jms.Message;
import cn.lab.neon.common.jms.MessageFactory;

@Controller
public class UserAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2314016829014364681L;
	
//	@Autowired
//	private EmulateTopicMessageProducer userLoginMessageProducer;
	
	@Action("/user/login")
	public void login(){
		throw new NullPointerException();
//		Message message = MessageFactory.newUserLogginMessage(1213L, "");
//		userLoginMessageProducer.sendMsg(message);
		//responseMsg("ok");
		//return;
	}

}
