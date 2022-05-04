package com.tistory.itbaewom.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement(name = "boxOfficeResult")
@XmlType(propOrder = { "boxofficeType", "showRange","yearWeekTime", "weeklyBoxOffice"})
@XmlAccessorType(XmlAccessType.FIELD)
public class WeeklyBoxOfficeResult {
	@XmlElement
	private String boxofficeType;
	@XmlElement
	private String showRange;
	@XmlElement
	private String yearWeekTime;
	@XmlElement
	@XmlElementWrapper(name="weeklyBoxOfficeList")
	private List<WeeklyBoxOffice> weeklyBoxOffice;
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	@XmlRootElement
	@XmlType(propOrder = {"rnum","rank","rankInten","rankOldAndNew","movieCd","movieNm",
					      "openDt","salesAmt","salesShare","salesInten","salesChange","salesAcc",
					      "audiCnt","audiInten","audiChange","audiAcc","scrnCnt","showCnt"})
	public static class WeeklyBoxOffice{
		private int 	rnum;
		private int 	rank;
		private int 	rankInten;
		private String 	rankOldAndNew;
		private String 	movieCd;
		private String 	movieNm;
		private String 	openDt;
		private int 	salesAmt;
		private double 	salesShare;
		private int 	salesInten;
		private int 	salesChange;
		private int 	salesAcc;
		private int 	audiCnt;
		private int 	audiInten;
		private double 	audiChange;
		private int 	audiAcc;
		private int 	scrnCnt;
		private int 	showCnt;
	}
}
