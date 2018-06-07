package cn.lab.neon.back.web.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Controller;

import cn.lab.neon.common.BaseAction;

@Controller
public class UserAction extends BaseAction {
	private Log log = LogFactory.getLog(UserAction.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -2314016829014364681L;
	
//	@Autowired
//	private EmulateTopicMessageProducer userLoginMessageProducer;
	
	@Action("/user/login")
	public void login(){
        log.info("登录.");
        log.error("登录异常", new RuntimeException("登录异常"));
//		Message message = MessageFactory.newUserLogginMessage(1213L, "");
//		userLoginMessageProducer.sendMsg(message);
		responseMsg("ok");
		return;
	}

}
