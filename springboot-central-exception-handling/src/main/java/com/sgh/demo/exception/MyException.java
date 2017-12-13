package com.sgh.demo.exception;

public class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private Integer code;

	public MyException(String message, Integer code) {
        super(message);
        this.code = code;
    }

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
