package kr.human.xml;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import kr.human.json.vo.Response;

public class ApiExplorer3 {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getAnniversaryInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=Z4uCridIALZt7Mtx3%2Fp2iKR3FCCLa1kLaCW2pLceTr%2F41ibB6PO3BZt4vfFJHLRrj7v0ACBEwptVEJV9bny1iA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("30", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("solYear","UTF-8") + "=" + URLEncoder.encode("2022", "UTF-8")); /*연*/
        urlBuilder.append("&" + URLEncoder.encode("solMonth","UTF-8") + "=" + URLEncoder.encode("05", "UTF-8")); /*월*/
        URL url = new URL(urlBuilder.toString());
        try {
			JAXBContext context = JAXBContext.newInstance(Response.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Response response = (Response) unmarshaller.unmarshal(url.openStream());
			System.out.println("2022년 5월 특일 정보");
			for(Response.Item item : response.getBody().getItem()) {
				System.out.println(item.getDateName() + " : " + item.getLocdate());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
    }
}