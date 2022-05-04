package kr.human.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import kr.human.vo.PersonVO;
import kr.human.vo.Rss;

public class Ex04_JAXBUnMarchal {
	public static void main(String[] args) {
		
		try(FileWriter fw = new FileWriter("src/main/resources/IT.xml")) {
			URL url = new URL("https://rss.hankyung.com/feed/it.xml");
			// JAXB context객체 생성 : 클래스 타입을 인수로 지정
			JAXBContext context = JAXBContext.newInstance(Rss.class);
			
			//자바 객체를 XML로 변경하는 객체 생성
			Marshaller m = context.createMarshaller();
			Unmarshaller um = context.createUnmarshaller();
			
			//XML의 모양지정
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			//URL에서 읽기
			InputStreamReader isr = new InputStreamReader(url.openStream());
			Rss rss = (Rss) um.unmarshal(isr);
			
			//제목, 기사, 수정날짜 출력
			System.out.println(rss.getChannel().getTitle());
			System.out.println(rss.getChannel().getLink());
			System.out.println(rss.getChannel().getLastBuilDate());
			
			//기사출력
			for(Rss.Item item : rss.getChannel().getItem()) {
				System.out.println(item.getTitle() + " : " + item.getLink());
			}
			
			//파일로 저장
			m.marshal(rss, fw);//rss로 읽어서 fw에 저장
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
