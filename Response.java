package kr.human.json.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlRootElement
@Data
public class Response {
	private Header 	header;
	private Body 	body;
	
	@Data
	@XmlRootElement
	public static class Header{
		private String resultCode;
		private String resultMsg;
	}
	@XmlRootElement
	@XmlAccessorType(XmlAccessType.FIELD)
	@Data
	public static class Body{
		@XmlElement
		private int  numOfRows;
		@XmlElement
		private int  pageNo;
		@XmlElement
		private int  totalCount;
		
		@XmlElement
		@XmlElementWrapper(name = "items")
		private List<Item> item;
		
	}
	@XmlRootElement
	@Data
	public static class Item{
		private String dateKind;
		private String dateName;
		private String isHoliday;
		private String locdate;
		private String seq;
	}
	
}
