package cn.lab.neon.common.jms;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 模拟Topic
 * 
 * 向一组Queue发送JMS，达到Topic效果
 * 
 * @author chenyouliang
 * 
 */
public class EmulateTopicConsumer {
	private static final Log log = LogFactory.getLog(EmulateTopicConsumer.class);

	private List<MessageProcesser> processerList;

	private String destName;

	public void receive(Message m) {

		log.info(m + " -- " + destName);

		for (int i = 0; i < processerList.size(); i++) {
			try {
				processerList.get(i).process(m);
			} catch (Exception e) {
				log.info("Message Info=" + m.toString(), e);
			}
		}
	}

	public List<MessageProcesser> getProcesserList() {
		return processerList;
	}

	public void setProcesserList(List<MessageProcesser> processerList) {
		this.processerList = processerList;
	}

	public String getDestName() {
		return destName;
	}

	public void setDestName(String destName) {
		this.destName = destName;
	}

}
