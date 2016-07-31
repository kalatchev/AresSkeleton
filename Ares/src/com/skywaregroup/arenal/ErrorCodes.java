package com.skywaregroup.arenal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ErrorInfo")
public enum ErrorCodes {
	
	//Unknown
	UNKNOWN_ERROR (-1, "���������� ������."),
	
	//No error
	OK (0, "��."),
	
	//Authorization
	INVALID_TOKEN (100, "������� ��� ��������� �����."),
	INVALID_COMPLEX_TOKEN (103,"������ ���������� ����� ��� ��������� ������."),
	INVALID_TOKEN_ID (102, "��������� ����� ��� ������ ���������� � �������������."),
	INVALID_OPERATION (103, "��������� ��������."),
	
	//Resource availability
	NO_SUCH_RESOURCE (200, "����� � ��������� �� �� � �������."),
	
	//System and database related
	DB_EXCEPTION (300, "������ ��� ����������� � ��."),
	
	//Data presence and quality
	NO_DATA_PROVIDED (400, "���� ������������ ����� �� ���������� ��� �� �� �� ��� ������� ������."),
	INVALID_DATA(401, "��������� �����.");
	
	@XmlElement(name="Code")
	public Integer code;
	
	@XmlElement(name="Description")
	public String message;
	
	ErrorCodes(Integer errorCode, String errorMessage) {
		this.code = errorCode;
		this.message = errorMessage;
	}
	
}
