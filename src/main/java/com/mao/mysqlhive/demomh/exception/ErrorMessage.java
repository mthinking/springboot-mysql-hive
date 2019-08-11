package com.mao.mysqlhive.demomh.exception;

/**
 * 异常类
 */
public enum ErrorMessage {

	m0("0", "操作成功"),
	msg_opt_fail("1","操作失败"),
	msg_sys_fail("2","系统服务异常，请稍后再试，后尝试联系管理员"),
	msg_opt_fail_null("3","输入参数不能为空");

	private String msgCode;
	
	private String msg;
	
	ErrorMessage(String msgCode, String msg) {
		this.msgCode = msgCode;
		this.msg = msg;
	}
	
	public String getMsgCode() {
		return this.msgCode;
	}
	
	public String getMsg() {
		return this.msg;
	}
}
