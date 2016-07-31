package com.skywaregroup.arenal;

public enum StatusCodes {
	
	PENDING ("P"),
	CAN_NOT_BE_COMPLETED ("N"),
	FINAL ("F");
	
	public final String code;
	
	StatusCodes(String code) {
		this.code = code;
	}
	
	@Override
    public String toString() {
        return this.code;
    }

}
