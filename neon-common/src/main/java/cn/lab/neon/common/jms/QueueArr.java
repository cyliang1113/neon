package cn.lab.neon.common.jms;

import java.util.HashMap;
import java.util.Map;

public class QueueArr {
	private static final Map<String, String[]> queueArrMap = new HashMap<String, String[]>();

	static {
		init();
	}

	private static void init() {
		String[] queueArrUserLogin = new String[] { "QUEUE_NAME_NEON_USER_LOGIN" };
		queueArrMap.put("QUEUE_ARRAY_NAME_NEON_USER_LOGIN", queueArrUserLogin);
	}

	public static String[] getQueueArr(String key) {
		return queueArrMap.get(key);
	}

}
