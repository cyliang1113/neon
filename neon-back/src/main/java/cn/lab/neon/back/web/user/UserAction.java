package cn.lab.neon.back.web.user;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Controller;

import cn.lab.neon.common.BaseAction;

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
//		Message message = MessageFactory.newUserLogginMessage(1213L, "");
//		userLoginMessageProducer.sendMsg(message);
		responseMsg("ok");
		return;
	}

}
