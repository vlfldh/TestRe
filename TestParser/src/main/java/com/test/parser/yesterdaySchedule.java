package com.test.parser;

import java.io.IOException;
import java.text.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class yesterdaySchedule {
	
	public static void main(String[] args) throws IOException {
		int gno = 125;
		
		SimpleDateFormat sdf = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = sdf.format ( currentTime );
		int tdate = Integer.parseInt(dTime)-1;
		/*System.out.println(tdate);*/
		Document doc;
		/*String html = "http://www.kbl.or.kr/schedule/today/todaygame_detail.asp?scode=27&gcode=01&gno="+gno+"&tdate="+tdate;
		// scode 년도 1년에 2씩 증가함 gcode - 시즌코드 - 1=정규시즌 , 3=플레이오프 4=챔피온결정전
		// 
		
		doc = Jsoup.connect(html).get();
		Elements tab = doc.select(".gamebox2 .infobox");
		System.out.println(tab);*/
		/*
		 * String tab =(game(gno, tdate)).replaceAll("\\p{Z}", "");
		 * String str =(game(gno, tdate)).replaceAll("(^\\p{Z}+|\\p{Z}+$)", "");
		 */
		
		
		
		List<String> list = new ArrayList<String>();
		while(gno>1){
			String str =(game(gno, tdate)).replaceAll("(^\\p{Z}+|\\p{Z}+$)", "");
			String tab =str.replaceAll("\\p{Z}", "");
			tab = tab.replaceAll("\n", "");
			tab = tab.replaceAll("&nbsp", "");
			tab = tab.replaceAll(" ", "");
			tab = tab.replaceAll("", "");
			if(tab.trim()!=null){
				System.out.println(gno);
				for(int i=0;i<=3;i++){
					tab = game(gno-i,tdate);
					list.add(tab);
					System.out.println(tab);
				}
				
				
			}
			gno--;
		}
		
		
		
	}
	private static String game(int gno,int tdate){
		String tab1 = "";
		try {
			String html = "http://www.kbl.or.kr/schedule/today/todaygame_detail.asp?scode=27&gcode=01&gno="+gno+"&tdate="+tdate;
			Document doc;
			doc = Jsoup.connect(html).get();
			Elements tab = doc.select(".gamebox2 .infobox");
			tab1= tab.toString();
			
		}catch(Exception e){}
		return tab1;
		
}	
	public int decrease_gno(int gno){
		
		return gno;
	}
	
}
