package cn.lab.neon.back.jms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.lab.neon.common.jms.Message;
import cn.lab.neon.common.jms.MessageProcesser;

public class UserLoginProcesser implements MessageProcesser {
	private static final Log log = LogFactory.getLog(UserLoginProcesser.class);

	@Override
	public void process(Message message) {
		log.info(message);
	}

}
