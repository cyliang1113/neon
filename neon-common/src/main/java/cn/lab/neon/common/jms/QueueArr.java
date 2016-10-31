package cn.lab.neon.common.jms;

import java.util.HashMap;
import java.util.Map;

public class QueueArr {
	private static final Map<String, String[]> queueArrMap = new HashMap<String, String[]>();

	static {
		init();
	}

	private static void init() {
		String[] queueArrNeonUserLogin = new String[] { "Queue_NeonUserLogin" };
		queueArrMap.put("QueueArray_NeonUserLogin", queueArrNeonUserLogin);
	}

	public static String[] getQueueArr(String key) {
		return queueArrMap.get(key);
	}

}
