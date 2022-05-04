package kr.human.vo;

import java.util.List;

import lombok.Data;

@Data
public class ItemVO {
	private String id;
	   private String name;
	   private List<History>histoty;
	   
	@Data   
	   public static class History{
	      private String date;
	      private String item;
	      
	   }

	public History[] getHistory() {
		// TODO Auto-generated method stub
		return null;
	}
}
