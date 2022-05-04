package kr.human.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import kr.human.vo.PersonVO;

public class Ex01_JAXBMarchal {
	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter("src/main/resources/personVO.xml")) {
			// JAXB context객체 생성 : 클래스 타입을 인수로 지정
			JAXBContext context = JAXBContext.newInstance(PersonVO.class);
			
			//자바 객체를 XML로 변경하는 객체 생성
			Marshaller m = context.createMarshaller();
			
			//XML의 모양지정(여백을 지정하겠다는 뜻으로 true만 적어도 된다)
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			//화면에 출력
			PersonVO vo = new PersonVO("한사람",22,true, new Date());
			m.marshal(vo, System.out);//화면에 출력하라
			//붉은 경고가 뜰텐데 무시해도 좋다
			
			//파일로 저장
			m.marshal(vo, fw);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
