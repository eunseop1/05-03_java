package kr.human.xml;

import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import kr.human.vo.PersonVO;
import kr.human.vo.Tests;

public class Ex02_JAXBUnMarchal {
	public static void main(String[] args) {
		try(FileReader fr = new FileReader("src/main/resources/test.xml")) {
			// JAXB context객체 생성 : 클래스 타입을 인수로 지정
			JAXBContext context = JAXBContext.newInstance(Tests.class);
			
			//XML을 자바 객체로 변경하는 객체 생성
			Unmarshaller um = context.createUnmarshaller();
			
			//읽기
			Tests vo = (Tests) um.unmarshal(fr);
			// um는 어떤 것이든 읽어들이는 것이기에 어떤 클래스로 읽어야 하는지 형변환이 필요하다
			
			//읽은 객체 출력
			System.out.println(vo);
			
			for(Tests.Test test : vo.getTest()) {
				System.out.println(test.getTestId() + " : " + test.getTestType());
			}
			
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}