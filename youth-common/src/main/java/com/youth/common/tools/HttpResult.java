package com.youth.common.tools;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * 功能描述: 
 *
 *  @Author xupeng
 *  @Description //TODO 
 *  @Date 9:57 2018/9/19
 *  @Param 
 *  @return 
 **/

public class HttpResult {

	// 响应状态码
	private Integer code;

	// 响应体
	private String body;

	public HttpResult() {

	}
	
	public HttpResult(Integer code, String body) {
		super();
		this.code = code;
		if (StringUtils.isNotEmpty(body)) {
			this.body = body;
		}

	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "HttpResult [code=" + code + ", body=" + body + "]";
	}

}
