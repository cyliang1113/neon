package cn.lab.neon.common.jms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * 模拟Topic，向一组Queue发送JMS，达到Topic效果
 * 
 * @author chenyouliang
 * 
 */
public class EmulateTopicMessageProducer {
	private static final Log log = LogFactory.getLog(EmulateTopicMessageProducer.class);

	private JmsTemplate template;

	private String destination; // 一组Queue(queue array name)

	public void sendMsg(Message msg) {
		log.info("queue array name: " + destination);
		log.info(msg);

		String[] queueArr = QueueArr.getQueueArr(destination);

		for (String queue : queueArr) {
			log.info("queue name: " + queue);
			template.convertAndSend(queue, msg);
		}

	}

	public JmsTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
