package com.skywaregroup.arenal;

public class BgPID {
	
	public static final String ALL_PATTERN = "^\\d{10}|[\\dA-Za-z\\/\\-\\.]{5,20}$";
	public static final String EGN_ENCH_PATTERN = "^\\d{10}$";
	public static final String SPECIAL_NUM_PATTERN = "^\\d{10}$";
	public static final String EU_CITIZEN_PATTERN = "^[\\da-zA-Z\\/\\-\\.]{5,20}$";

	private static final int[] egnWeights = { 2, 4, 8, 5, 10, 9, 7, 3, 6 };
	private static final int[] lnchWeights = { 21, 19, 17, 13, 11, 9, 7, 3, 1 };

	private int year, month, day;
	private boolean isValid;

	public int getYear() {
		return this.year;
	}

	public int getMonth() {
		return this.month;
	}

	public int getDay() {
		return this.day;
	}

	public boolean getIsValid() {
		return this.isValid;
	}

	private void initVarsInvalid() {
		this.year = -1;
		this.month = -1;
		this.day = -1;
		this.isValid = false;
	}

	public BgPID(boolean isEgn, String pid) {

		this.initVarsInvalid();
		if (pid == null || !pid.matches(BgPID.EGN_ENCH_PATTERN)) {
			return;
		}

		int maxDay = 0;
		int checkSum = 0;

		if (isEgn) {
			// EGN
			this.year = Integer.parseInt(pid.substring(0, 2));
			this.month = Integer.parseInt(pid.substring(2, 4));
			if (this.month >= 1 && this.month <= 12) {
				this.year += 1900;
			} else if (this.month >= 21 && this.month <= 32) {
				this.month -= 20;
				this.year += 1800;
			} else if (this.month >= 41 && this.month <= 52) {
				this.month -= 40;
				this.year += 2000;
			} else {
				this.initVarsInvalid();
				return;
			}
			this.day = Integer.parseInt(pid.substring(4, 6));
			switch (this.month) {
			case 1:	case 3:	case 5:	case 7:	case 8:	case 10: case 12:
				maxDay = 31;
				break;
			case 4: case 6:	case 9:	case 11:
				maxDay = 30;
				break;
			case 2:
				if (((this.year % 4) == 0 && ((this.year % 100) != 0) || (this.year % 400) == 0)) {
					// Leap year
					maxDay = 29;
				} else {
					maxDay = 28;
				}
				break;
			default:
				this.initVarsInvalid();
				return;
			}
			if (day > maxDay) {
				this.initVarsInvalid();
				return;
			}

			for (int i = 0; i < 9; i++) {
				checkSum += Integer.parseInt(pid.substring(i, i + 1))
						* BgPID.egnWeights[i];
			}
			checkSum = (checkSum % 11) % 10;

			this.isValid = (checkSum == Integer.parseInt(pid.substring(9, 10)));

		} else {
			// ENCh
			for (int i = 0; i < 9; i++) {
				checkSum += Integer.parseInt(pid.substring(i, i + 1))
						* BgPID.lnchWeights[i];
			}
			checkSum %= 10;
			this.isValid = (checkSum == Character
					.getNumericValue(pid.charAt(9)));
		}

	}

}
