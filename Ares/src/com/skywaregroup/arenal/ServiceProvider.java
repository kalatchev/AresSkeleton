package com.skywaregroup.arenal;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="ServiceProvider") 
@XmlAccessorType(XmlAccessType.NONE) 
public class ServiceProvider {
	
	@XmlElement(name="ID") 
	public Integer id;

	@XmlElement(name="Name") 
	public String name;
	
	@XmlElement(name="City")
	public String city;
	
	@XmlElement(name="PostalCode")
	public String postalCode;
	
	@XmlElement(name="Address")
	public String address;
	
	@XmlElement(name="PracticeCode") 
	public String practiceCode;
	
	@XmlElement(name="WebSite") 
	public String webSite;
	
	@XmlElement(name="Phone1") 
	public String phone1;
	
	@XmlElement(name="Phone2") 
	public String phone2;
	
	public static ServiceProvider demoObject() {
		ServiceProvider rv = new ServiceProvider();
		rv.id = -1; //Fake ID
		rv.name = "Демо лаборатория ООД";
		rv.city = "София";
		rv.postalCode = "1000";
		rv.address = "ул. Хармония № 5";
		rv.practiceCode = "2201141999";
		rv.webSite = "http://fake-demo-lab.com/";
		rv.phone1 = "+359 2 123123";
		rv.phone2 = "+359 2 123124";
		return rv;
	}

}





