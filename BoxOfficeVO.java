package kr.human.json.vo;

import lombok.Data;

@Data
public class BoxOfficeVO {
	private BoxOfficeResult boxOfficeResult;
	
	@Data
	static class BoxOfficeResult{
		private String boxofficeType;
		private String showRange;
		private DailyBoxOfficeList[] dailyBoxOfficeList;
	}
	
	@Data
	static class DailyBoxOfficeList{
		private String rank;
		private String movieNm;
		private String openDt;
	}
}
