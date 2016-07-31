package com.skywaregroup.arenal;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Examination") 
@XmlAccessorType(XmlAccessType.NONE) 
public class CardItem implements Comparable<CardItem> {
		
	public Integer id;
	
	public Card card;
	
	@XmlElement(name="Code")
	public String code;
	
	public String getStatus() {
		if (this.results == null) {return StatusCodes.PENDING.toString();} //If no results - Preliminary
		if (this.results.stream().anyMatch(o -> 
			{
				String s = o.status; 
				return s == null || s == StatusCodes.PENDING.toString(); // Nulls are treated as Preliminary
			}
				)) {return StatusCodes.PENDING.toString();}
		return StatusCodes.FINAL.toString();
	}
	
	@XmlElement(name="Result")
	public Set<Result> results;

	
	public void addItemToResults(Result val) {
		if (this.results == null) {this.results = new HashSet<Result>();}
		this.results.add(val);
	}
	
	@Override
	public int compareTo(CardItem SomeItem) {
		return this.code.compareTo(SomeItem.code);
	}
	
	public CardItem(String code) {
		this.code = code;
	}
	
	public CardItem() {}
	
}
