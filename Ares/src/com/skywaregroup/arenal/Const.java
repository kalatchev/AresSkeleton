package com.skywaregroup.arenal;

public class Const {
	
	public static final String HEADER_TOKEN_NAME = "arenal-token";
	
	public static final String COMPEX_TOKEN = "^\\p{Digit}+-\\p{Alnum}+$";
	
	public static final String COMPLEX_OR_SIMPLE_TOKEN = "^(\\p{Digit}+-)?\\p{Alnum}+$";
	
	public static final String SIMPLE_TOKEN = "^\\p{Alnum}+$";
	
	public static final int STALE_PERIOD_DAYS = 30;
}
