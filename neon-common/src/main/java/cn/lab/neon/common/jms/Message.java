package cn.lab.neon.common.jms;

import java.io.Serializable;

/**
 * jms消息
 * 
 * @author chenyouliang
 * 
 */
public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 431832907272899851L;

	private Long objectId; // 根据消息类型,会有不同的含义

	private String objectType;

	private String eventType; // 消息类型

	private String addition; // 无特定，可以灵活跟随信息

	private String systemType;

	private String trackNumber;

	private String parentAppName;

	private String distributedContextJson;

	protected Message(Long objectId, String objectType, String eventType) {
		this.objectId = objectId;
		this.objectType = objectType;
		this.eventType = eventType;
	}

	/**
	 * 消息类型和objectId同时相等
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Message) {
			Message cc = (Message) obj;
			return eventType.equals(cc.getEventType()) && objectId.equals(cc.getObjectId());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Message{" + "objectId='" + objectId + "', objectType='" + objectType + "', eventType='" + eventType + "', addition='"
				+ addition + "', systemType='" + systemType + "', trackNumber='" + trackNumber + "', parentAppName='" + parentAppName
				+ "', distributedContextJson='" + distributedContextJson + "'}";
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getAddition() {
		return addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}

	public String getParentAppName() {
		return parentAppName;
	}

	public void setParentAppName(String parentAppName) {
		this.parentAppName = parentAppName;
	}

	public String getDistributedContextJson() {
		return distributedContextJson;
	}

	public void setDistributedContextJson(String distributedContextJson) {
		this.distributedContextJson = distributedContextJson;
	}
}
