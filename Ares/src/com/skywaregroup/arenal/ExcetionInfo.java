package com.skywaregroup.arenal;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="ErrorInfo")
public class ExcetionInfo {
	
	@XmlElement(name="Code")
	public Integer code;

	@XmlElement(name="Description")
	public String message;
	
	@XmlElement(name="Details")
	public String details;
	
	public ExcetionInfo() {
		this(ErrorCodes.UNKNOWN_ERROR);
	}
	
	public ExcetionInfo(ErrorCodes ec) {
		this.code = ec.code;
		this.message = ec.message;
	}
	
	public ExcetionInfo(Integer errorCode, String errorMessage) {
		this.code = errorCode;
		this.message = errorMessage;
	}
	
	public ExcetionInfo(ErrorCodes ec, String details) {
		this(ec);
		this.details = details;
	}
	
}
