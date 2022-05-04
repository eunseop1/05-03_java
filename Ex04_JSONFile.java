package kr.human.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import kr.human.json.vo.PersonVO;

// JSON 형식의 파일 저장/읽기
public class Ex04_JSONFile {
	public static void main(String[] args) {
		Gson gson = new Gson();
		PersonVO vo = new PersonVO("두사람", 21, true);
		// 객체를 JSON파일로 저장하기
		try(PrintWriter pw = new PrintWriter("src/main/resources/person.json")){
			gson.toJson(vo, pw); // (객체, 출력스트림)
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// JSON파일을 자바 객체로 읽기
		try(FileReader fr = new FileReader("src/main/resources/person.json")){
			PersonVO vo2 = gson.fromJson(fr, PersonVO.class);
			System.out.println("읽은값 : " + vo2 );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
