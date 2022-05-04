package kr.human.vo;

import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class GenderAdapter extends XmlAdapter<String, Boolean>{
	@Override //String을 Boolean타입으로 바꿔서 리턴
	public Boolean unmarshal(String v) throws Exception {
		return v.equals("남자");//남자가 아니면 false반환
	}
	@Override // Boolean타입을 String타입으로 바꿔서 리턴
	public String marshal(Boolean v) throws Exception {
		return v ? "남자" : "여자";
	}	
}