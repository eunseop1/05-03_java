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

/*
요청 변수		값				설명
key				문자열(필수)	발급받은키 값을 입력합니다.
targetDt		문자열(필수)	조회하고자 하는 날짜를 yyyymmdd 형식으로 입력합니다.
itemPerPage		문자열			결과 ROW 의 개수를 지정합니다.(default : “10”, 최대 : “10“)
multiMovieYn	문자열			다양성 영화/상업영화를 구분지어 조회할 수 있습니다.
								“Y” : 다양성 영화 “N” : 상업영화 (default : 전체)
repNationCd		문자열			한국/외국 영화별로 조회할 수 있습니다.
								“K: : 한국영화 “F” : 외국영화 (default : 전체)
wideAreaCd		문자열			상영지역별로 조회할 수 있으며, 지역코드는 공통코드 조회 서비스에서 “0105000000” 로서 조회된 지역코드입니다. (default : 전체)

응답 구조
응답 필드		값		설명
boxofficeType	문자열	박스오피스 종류를 출력합니다.
showRange		문자열	박스오피스 조회 일자를 출력합니다.
rnum			문자열	순번을 출력합니다.
rank			문자열	해당일자의 박스오피스 순위를 출력합니다.
rankInten		문자열	전일대비 순위의 증감분을 출력합니다.
rankOldAndNew	문자열	랭킹에 신규진입여부를 출력합니다.
						“OLD” : 기존 , “NEW” : 신규
movieCd			문자열	영화의 대표코드를 출력합니다.
movieNm			문자열	영화명(국문)을 출력합니다.
openDt			문자열	영화의 개봉일을 출력합니다.
salesAmt		문자열	해당일의 매출액을 출력합니다.
salesShare		문자열	해당일자 상영작의 매출총액 대비 해당 영화의 매출비율을 출력합니다.
salesInten		문자열	전일 대비 매출액 증감분을 출력합니다.
salesChange		문자열	전일 대비 매출액 증감 비율을 출력합니다.
salesAcc		문자열	누적매출액을 출력합니다.
audiCnt			문자열	해당일의 관객수를 출력합니다.
audiInten		문자열	전일 대비 관객수 증감분을 출력합니다.
audiChange		문자열	전일 대비 관객수 증감 비율을 출력합니다.
audiAcc			문자열	누적관객수를 출력합니다.
scrnCnt			문자열	해당일자에 상영한 스크린수를 출력합니다.
showCnt			문자열	해당일자에 상영된 횟수를 출력합니다.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement(name = "boxOfficeResult")
@XmlType(propOrder = { "boxofficeType", "showRange", "dailyBoxOffice"})
@XmlAccessorType(XmlAccessType.FIELD)
public class DailyBoxOfficeResult {
	@XmlElement
	private String boxofficeType;
	@XmlElement
	private String showRange;
	@XmlElement
	@XmlElementWrapper(name="dailyBoxOfficeList")
	private List<DailyBoxOffice> dailyBoxOffice;
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	@XmlRootElement
	@XmlType(propOrder = {"rnum","rank","rankInten","rankOldAndNew","movieCd","movieNm",
					      "openDt","salesAmt","salesShare","salesInten","salesChange","salesAcc",
					      "audiCnt","audiInten","audiChange","audiAcc","scrnCnt","showCnt"})
	public static class DailyBoxOffice{
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
