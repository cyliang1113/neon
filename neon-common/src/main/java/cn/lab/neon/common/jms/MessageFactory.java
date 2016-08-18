package cn.lab.neon.common.jms;

/**
 * 消息工厂
 * 
 */
public class MessageFactory {

	/**
	 * 用户登录消息
	 * 
	 * @param orderId
	 * @param addition
	 * @return
	 */
	public static Message newUserLogginMessage(Long objectId, String addition) {
		Message message = new Message(objectId, "USER_LOGIN", EventType.USER_LOGIN.name());
		message.setAddition(addition);
		return message;
	}

}
