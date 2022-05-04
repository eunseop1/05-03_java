package kr.human.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement(name = "Tests") //루트 태그의 이름을 지정 -> name으로 변경가능(클래스 이름과 다르게 나올때 사용)
@XmlAccessorType(XmlAccessType.FIELD)//세부사항을 변수명에다 지정
public class Tests {
	@XmlElement(name="Test")//태그로 사용
	List<Test> test; //소문자가 아니라 대문자 태그로 쓰겠다
	
	@Data
	@XmlRootElement
	@XmlType(propOrder = {"name","commandLine","input","output"})//태그 순서 지정
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Test{
		@XmlAttribute(name="TestId")//속성이름
		private String testId;
		@XmlAttribute(name = "TestType")
		private String testType;
		
		@XmlElement(name = "Name")//태그이름
		private String name;
		@XmlElement(name = "CommandLine")
		private String commandLine;
		@XmlElement(name = "Input")
		private String input;
		@XmlElement(name = "Output")
		private String output;
		
	}
}
