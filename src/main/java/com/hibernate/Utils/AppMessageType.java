package com.hibernate.Utils;

/**
 * B2C消息类型.
 */
public enum AppMessageType {
	ORDER("ORDER", "定单消息"),
	ORDER_STATUS_CHANGE("ORDER_STATUS_CHANGE", "订单状态变更"),
	ORDER_PAYMENT_LOG("ORDER_PAYMENT_LOG", "订单付款流水"),
	GROUP_CONFERENCE("GROUP_CONFERENCE", "出团说明会通知"),
	GROUP_NOTICE("GROUP_NOTICE", "通团通知消息"),
	GROUP_CONFIRM("GROUP_CONFIRM", "成团确认消息"),
	TICKET_ISSUE("TICKET_ISSUE", "单项出票消息"),
	GROUP_SHARE("GROUP_SHARE", "团分享"),
	GROUP_TOURIST_GUARANTEE("GROUP_TOURIST_GUARANTEE", "游客担保金录入"),
	GUIDE_ASSIGN("GUIDE_ASSIGN","导游指派消息"),
	GUIDE_CANCEL("GUIDE_CANCEL","导游指派取消"),
	GUIDE_GROUP_CONFERENCE("GUIDE_GROUP_CONFERENCE","出团说明会通知"),
	GUIDE_GROUP_NOTICE("GUIDE_GROUP_NOTICE","通团通知消息"),
	GUIDE_FINAL_ITINERARY_SUBMIT("GUIDE_FINAL_ITINERARY_SUBMIT","出团通知书提交消息"),
	WX_PUSH_MESSAGE("WX_PUSH_MESSAGE"," 微信推送消息"),
	TRIP_ASSISTANT("TRIP_ASSISTANT"," 行程助手导游消息"),
	PUSH_MESSAGE("PUSH_MESSAGE","推送消息"),
	WX_MESSAGE("WX_MESSAGE","微信端统一消息"),
	VISA_OPERA("VISA_OPERA","签证进度消息");

	private String code;
	private String value;

	public String toCode() {
		return value;
	}

	private AppMessageType(String code, String value) {
		this.code = code;
		this.value = value;
	}

	/**
	 * 获取code
	 * 
	 * @return code code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置code
	 * 
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取value
	 * 
	 * @return value value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 设置value
	 * 
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
