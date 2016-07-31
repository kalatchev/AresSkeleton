package com.skywaregroup.arenal;

import java.math.BigDecimal;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="Card") 
@XmlAccessorType(XmlAccessType.NONE) 
public class Card {
	
	@XmlElement(name="ID") 
	public Integer id;
	
	@XmlElement(name="Fulfilled")
	@XmlJavaTypeAdapter(XSDDateAdapter.class)
	public Date fulfilled;
	
	@XmlElement(name="VisitDate")
	@XmlJavaTypeAdapter(XSDDateAdapter.class)
	public Date visitDate;
	
	@XmlElement(name="PIDType")
	public Integer pidType;
	
	@XmlElement(name="PID") 
	public String pid;
	
	@XmlElement(name="GivenName")
	public String givenName;
	
	@XmlElement(name="MiddleName")
	public String middleName;
	
	@XmlElement(name="FamilyName")
	public String familyName;
	
	@XmlElement(name="Doctor")
	public Doctor doctor;
	
	@XmlElement(name="CardNo")
	public Integer cardNo;
	
	@XmlElement(name="Note")
	public String note;
	
	@XmlElement(name="Status")
	public String getStatus() {
		if (this.examinations == null) {return StatusCodes.FINAL.toString();} //Empty cards is Final
		if (this.examinations.stream().anyMatch(o -> o.getStatus().equals(StatusCodes.PENDING.toString()))) {
			return StatusCodes.PENDING.toString();}
		return StatusCodes.FINAL.toString();
	}
	
	@XmlElement(name="Examination")
	public Set<CardItem> examinations;
	
	public Boolean hasExams(){
		if (this.examinations == null) {return false;}
		return (!this.examinations.isEmpty());
	}
	
	public void addItemToExams(CardItem val) {
		if (this.examinations == null) {this.examinations = new HashSet<CardItem>();}
		val.card = this;
		this.examinations.add(val);
	}
	
	public void removeExamByCode(String val) {
		Iterator<CardItem> iter = this.examinations.iterator();
		while (iter.hasNext()) {
			CardItem currentCode = iter.next();
			if (currentCode.code == val) {
				iter.remove(); 
			}
		}
	}
		
	public void FillDemoData(){
		this.pidType = 1;
		this.pid = "0123456789";
		this.cardNo = 12345;
		this.givenName = "Иван";
		this.middleName = "Петров";
		this.familyName = "Георгиев";
		this.fulfilled = new Date();
		this.visitDate = new Date();
		this.note = "Това е забележка към цялото направление.";
		
		this.doctor = new Doctor();
		this.doctor.uin = "2200099999";
		this.doctor.specialityCode = "09";
		this.doctor.givenName = "Мария";
		this.doctor.middleName = "Димитрова";
		this.doctor.familyName = "Йорданова";
		
		CardItem exam1 = new CardItem("01.03");
		exam1.id = 1;
		
		Result res11 = new Result();
		res11.loincId = "4537-7";
		res11.name = "СУЕ (ESR)";
		res11.textResult = "51";
		res11.decimalResult = BigDecimal.valueOf(51);
		res11.units = "mm/h";
		res11.flag = "H";
		res11.range = "Деца до 7г. <17, М: до 50 г. <28, над 50 г. <37; Ж: до 50 г. <37, над 50 г. <39";
		res11.note = "Да се поръча CRP.";
		res11.status = StatusCodes.FINAL.toString();
		res11.rank = 1;
		exam1.addItemToResults(res11);

		this.addItemToExams(exam1);
		
		CardItem exam2 = new CardItem("01.01");
		exam2.id = 2;
		
		Result res21 = new Result();
		res21.loincId = "718-7";
		res21.name = "Hgb (Хемоглобин)";
		res21.textResult = "147";
		res21.decimalResult = BigDecimal.valueOf(147);
		res21.units = "g/l";
		res21.range = "М: 135 - 180; Ж: 120 - 160";
		res21.status = StatusCodes.FINAL.toString();
		res21.rank = 10;
		exam2.addItemToResults(res21);
		
		Result res22 = new Result();
		res22.loincId = "789-8";
		res22.name = "RBC (Еритроцити)";
		res22.textResult = "4.7";
		res22.decimalResult = BigDecimal.valueOf(4.7);
		res22.units = "x10^12/l";
		res22.range = "M: 4.4 - 5.9; Ж: 3.7 - 5.3";
		res22.status = StatusCodes.FINAL.toString();
		res22.rank = 11;
		exam2.addItemToResults(res22);
		
		Result res23 = new Result();
		res23.loincId = "6690-2";
		res23.name = "WBC (Левкоцити)";
		res23.textResult = "4.45";
		res23.decimalResult = BigDecimal.valueOf(4.45);
		res23.units = "x10^9/l";
		res23.range = "3.50 - 10.50";
		res23.status = StatusCodes.FINAL.toString();
		res23.rank = 12;
		exam2.addItemToResults(res23);
		
		Result res24 = new Result();
		res24.loincId = "4544-3";
		res24.name = "Hct (Хематокрит)";
		res24.textResult = "0.436";
		res24.decimalResult = BigDecimal.valueOf(0.436);
		res24.units = "l/l";
		res24.range = "М: 0.400 - 0.530 Ж: 0.360 - 0.480";
		res24.status = StatusCodes.FINAL.toString();
		res24.rank = 13;
		exam2.addItemToResults(res24);
		
		Result res25 = new Result();
		res25.loincId = "777-3";
		res25.name = "Plt (Трoмбоцити)";
		res25.textResult = "200";
		res25.decimalResult = BigDecimal.valueOf(200);
		res25.units = "x10^9/l";
		res25.range = "130 - 420";
		res25.status = StatusCodes.FINAL.toString();
		res25.rank = 14;
		exam2.addItemToResults(res25);
		
		Result res26 = new Result();
		res26.loincId = "787-2";
		res26.name = "MCV (ср. обем на еритроцита)";
		res26.textResult = "92.8";
		res26.decimalResult = BigDecimal.valueOf(92.8);
		res26.units = "fl";
		res26.range = "Възрастни: 82.0 - 96.0; Деца: 77.0 - 92.0";
		res26.status = StatusCodes.FINAL.toString();
		res26.rank = 15;
		exam2.addItemToResults(res26);
		
		Result res27 = new Result();
		res27.loincId = "785-6";
		res27.name = "MCH (ср. Hgb съдърж. в еритр.)";
		res27.textResult = "31.3";
		res27.decimalResult = BigDecimal.valueOf(31.3);
		res27.units = "pg";
		res27.range = "Възрастни: 27.0 - 33.0; Деца: 21.0 - 38.0";
		res27.status = StatusCodes.FINAL.toString();
		res27.rank = 16;
		exam2.addItemToResults(res27);
		
		Result res28 = new Result();
		res28.loincId = "786-4";
		res28.name = "MCHC (ср. Hgb конц. в еритр.)";
		res28.textResult = "337";
		res28.decimalResult = BigDecimal.valueOf(337);
		res28.units = "g/l";
		res28.range = "300 - 360";
		res28.status = StatusCodes.FINAL.toString();
		res28.rank = 17;
		exam2.addItemToResults(res28);
		
		this.addItemToExams(exam2);
		
		
		CardItem exam3 = new CardItem("01.24");
		exam3.id = 3;
		
		Result res31 = new Result();
		res31.loincId = "1920-8";
		res31.name = "АсАТ (GOT; AST)";
		res31.textResult = "19.9";
		res31.decimalResult = BigDecimal.valueOf(19.9);
		res31.units = "U/l";
		res31.range = "М: <40.0; Ж: <32.0";
		res31.status = StatusCodes.FINAL.toString();
		res31.rank = 150;
		exam3.addItemToResults(res31);

		this.addItemToExams(exam3);
		
		
		CardItem exam4 = new CardItem("01.25");
		exam4.id = 4;
		
		Result res41 = new Result();
		res41.loincId = "1742-6";
		res41.name = "АлАТ (GPT; ALT)";
		res41.textResult = "22.9";
		res41.decimalResult = BigDecimal.valueOf(22.9);
		res41.units = "U/l";
		res41.range = "М: <41.0; Ж: <33.0";
		res41.status = StatusCodes.FINAL.toString();
		res41.rank = 160;
		exam4.addItemToResults(res41);

		this.addItemToExams(exam4);
			
	}
	
}


