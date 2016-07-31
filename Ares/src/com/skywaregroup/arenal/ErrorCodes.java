package com.skywaregroup.arenal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ErrorInfo")
public enum ErrorCodes {
	
	//Unknown
	UNKNOWN_ERROR (-1, "Неизвестна грешка."),
	
	//No error
	OK (0, "ОК."),
	
	//Authorization
	INVALID_TOKEN (100, "Липсващ или невалиден токен."),
	INVALID_COMPLEX_TOKEN (103,"Липсвщ комплексен токен или невалиден формат."),
	INVALID_TOKEN_ID (102, "Невалиден токен или грешна комбинация с идентификатор."),
	INVALID_OPERATION (103, "Забранена операция."),
	
	//Resource availability
	NO_SUCH_RESOURCE (200, "Обект с посочения ИД не е намерен."),
	
	//System and database related
	DB_EXCEPTION (300, "Грешка при комуникация с БД."),
	
	//Data presence and quality
	NO_DATA_PROVIDED (400, "Няма предоставени данни за операцията или те не са във валиден формат."),
	INVALID_DATA(401, "Невалидни данни.");
	
	@XmlElement(name="Code")
	public Integer code;
	
	@XmlElement(name="Description")
	public String message;
	
	ErrorCodes(Integer errorCode, String errorMessage) {
		this.code = errorCode;
		this.message = errorMessage;
	}
	
}
