package com.skywaregroup.arenal;

import javax.xml.bind.annotation.XmlElement;

public class Doctor {

	@XmlElement(name="UIN")
	public String uin;
	
	@XmlElement(name="SpecialityCode")
	public String specialityCode;
	
	@XmlElement(name="GivenName")
	public String givenName;
	
	@XmlElement(name="MiddleName")
	public String middleName;
	
	@XmlElement(name="FamilyName")
	public String familyName;

}
