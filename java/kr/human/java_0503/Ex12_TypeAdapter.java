package kr.human.java_0503;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Ex12_TypeAdapter {
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class Product{
		private int id;
		private String name;
		private transient String password;//직렬화에서 제외 -> 저장하지 말라 (객체를 오브젝트로 저장할때 직렬화 , 그 반대는 역직렬화)
		private Date date;
	}
	public static void main(String[] args) {
		/*
		Gson gson = new Gson();
		Product p = new Product(1, "컴퓨터", "1234" , new Date());
		System.out.println(p);
		System.out.println(gson.toJson(p));
		*/
		//내가 만든 어덥터를 작동시키려면 위의 코드를 작동시키면 안된다
		
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapter(Product.class, new ProductAdapter());
		//ProductAdapter를 이용하여서 Product를 저장하겠다고 등록
		b.setPrettyPrinting();
		Gson gson = b.create(); // gson객체를 생성
		
		Product p = new Product(1, "컴퓨터", "1234", new Date());
		System.out.println(gson.toJson(p));
		
		
		
	}
	//Type Adapter는 저장/읽기시 모양을 변경 줄 수 있다
	//Type Adapter 추상클래스를 제작하여 나오는 결과에 변화를 만들어 줄수 있다
	
	public static class ProductAdapter extends TypeAdapter<Product>{
		@Override //저장할때 작동되는 기능
		public void write(JsonWriter out, Product value) throws IOException {
			out.beginObject();
			
			out.name("id");
			out.value(value.getId());
			
			out.name("name");
			out.value(value.getName());
			
			out.name("date");
			//date의 모양을 바꾸자
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
			out.value(sdf.format(value.getDate()));
						
			out.endObject();
		}

		@Override //읽을때 작동하는 기능
		public Product read(JsonReader in) throws IOException {
			Product p = new Product();
			in.beginObject();
			
			String fieldName = "";
			while(in.hasNext()) {
				JsonToken token = in.peek(); // 태그 1개를 읽고
				if(token.equals(JsonToken.NAME)) {// 읽은게 만약 NAME이라는 Key(태그)를 가지고 있다면 
					fieldName = in.nextName(); // NAME Key에서 우리가 원하던 이름이라는 값을 읽고
					//token = in.peek();// NAME 태그의 밑에 있는 VALUE태그로 넘어간다. 다만 없어도 된다
					switch (fieldName) { // 읽은 값이 뭐니?
					case "id":
						p.setId(in.nextInt());//아이디에는 정수형으로
						break;
						
					case "name":
						p.setName(in.nextString());
						break;
						
					case "date":
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
						try {
							p.setDate(sdf.parse(in.nextString()));
						} catch (ParseException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				}
			}
			
			in.endObject();
			return p;
		}
	}
	
	
}
