package cn.lab.neon.common.jms;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author chenyouliang
 * 
 */
public class MessageProcesserContainer {
	private static final Log log = LogFactory.getLog(MessageProcesserContainer.class);

	private List<MessageProcesser> processerList;

	private String destName;

	public void receive(Message m) {
		log.info("queue: " + destName);
		log.info(m);

		if (processerList == null) {
			return;
		}

		for (int i = 0; i < processerList.size(); i++) {
			try {
				processerList.get(i).process(m);
			} catch (Exception e) {
				log.error(m + "\n", e);
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
