package kr.human.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "person")
//이름 지정도 가능하다
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name","age","gender","date"})
//순서정하기
public class PersonVO {
	@XmlElement
	private String name;
	@XmlElement
	private int age;
	
	@XmlElement
	@XmlJavaTypeAdapter(GenderAdapter.class) // 저장과 읽기 할때 사용될 클래스 지정 -> 모양 변경 가능
	private Boolean gender;//기본자료형은 안되고 객체 타입만 가능하다
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date;
}
