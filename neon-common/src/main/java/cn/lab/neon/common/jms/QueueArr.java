package cn.lab.neon.common.jms;

import java.util.HashMap;
import java.util.Map;

public class QueueArr {
	private static final Map<String, String[]> queueArrMap = new HashMap<String, String[]>();

	static {
		init();
	}

	private static void init() {
		String[] activeMqOrder = new String[] { "ActiveMQ.neon.USER_LOGIN" };
		queueArrMap.put("ActiveMQ.neon.USER_LOGIN", activeMqOrder);
	}

	public static String[] getQueueArr(String key) {
		return queueArrMap.get(key);
	}

}
