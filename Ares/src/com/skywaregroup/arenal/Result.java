package com.skywaregroup.arenal;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Result") 
@XmlAccessorType(XmlAccessType.NONE)
public class Result {
	
//	<LoincID>112-5</LoincID>
//	<DisplyName>Хемоглубин</DisplyName>
//	<TextResult>140</TextResult>
//	<DecimalResult>140</DecimalResult>
//	<Units>mmol/L</Units>
//	<Range>95-285</Range>
//	<Flag></Flag>
//	<Status>F</Status>
//	<Note></Note>
	
	@XmlElement(name="ID") 
	public Integer id;
	
	@XmlElement(name="LoincID")
	public String loincId;
	
	@XmlElement(name="Name")
	public String name;
	
	@XmlElement(name="TextResult")
	public String textResult;
	
	@XmlElement(name="DecimalResult")
	public BigDecimal decimalResult;
	
	@XmlElement(name="Units")
	public String units;
	
	@XmlElement(name="Range")
	public String range;
	
	@XmlElement(name="Flag")
	public String flag;
	
	@XmlElement(name="Status")
	public String status;
	
	@XmlElement(name="Note")
	public String note;
	
	@XmlElement(name="Rank")
	public int rank;

	public Result() {
		this.status = StatusCodes.PENDING.toString(); //By default results are Preliminary
	}
}
