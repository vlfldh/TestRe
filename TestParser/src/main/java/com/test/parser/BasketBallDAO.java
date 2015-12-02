package com.test.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.internal.matchers.SubstringMatcher;
import org.springframework.beans.factory.parsing.ReaderEventListener;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import ch.qos.logback.classic.turbo.MatchingFilter;

public class BasketBallDAO {
	private BasketBallVO vo;
	public static void main(String[] args) {
		
		try {
			
			String html = "http://www.kbl.or.kr/stats/record_comparison.asp?scode=27&gcode=01&tcode1=06&tcode2=65";
			// ¿øÇÏ´Â url ÆÄ½Ì --
			Document doc = Jsoup.connect(html).get();
			Elements tab = doc.select(".tbltype_record tr td");
			//System.out.println(tab);

			String tab1= tab.toString();
			String tab2 = tab1.substring(tab1.lastIndexOf("½ÃÁðÆò±Õ"), tab1.length());
			List<String> list= new ArrayList<String>();
			String tab3 = tab2.replaceAll("\\<.*?>","");
			System.out.println(tab3);
			System.out.println("//////////////////////////////////");
			StringTokenizer st =new StringTokenizer(tab3, "\n");
			while(st.hasMoreTokens()){
				list.add(st.nextToken());
				List<BasketBallVO> list1=new ArrayList<BasketBallVO>();
				for(BasketBallVO vo:list1){
					vo.setPts(list.get(1));
					vo.setReb(list.get(2));
					vo.setAst(list.get(3));
					vo.setStl(list.get(4));
					vo.setBs(list.get(5));
					vo.setB2p(list.get(6));
					vo.setB2s(list.get(7));
					vo.setB3p(list.get(8));
					vo.setB3s(list.get(9));
					vo.setFt(list.get(10));
					vo.setFts(list.get(11));
					list1.add(vo);
				}
			}
			
			System.out.println("1ÆÀ ÀüÀû");
			List<String> list2=null;
			for(int i =2;i<list.size();i=i+4){
			list.get(i);
			list2.add(list.get(i));
			System.out.println(list.get(i));
			}
			System.out.println("========================");
			System.out.println("2ÆÀ ÀüÀû");
			for(int i=3;i<list.size();i+=4){
			list.get(i);
			System.out.println(list.get(i));
			}
			//System.out.println(list);
			//System.out.println(replay(tab2));
			
			/*System.out.println(scc);
			Elements teamimage1 = doc.select("div.fst div.thumb_team img");
			Elements teamimage2 = doc.select("div.box_history div.thumb_team img");
			String timg1=teamimage1.attr("src");
			String timg2=teamimage2.attr("src");
			Elements teamimg = doc.select(".img_g");

			MatchingFilter mf;
	         Elements img=doc.select("img.img_g");
	        
	         Iterator<Element> data;
	         List list = new ArrayList();
	         for(Element i:img){
	            data=i.getElementsByAttribute("src").iterator();
	            list.add(data.next().attr("src"));
	         }
	        StringTokenizer st= new StringTokenizer(list.toString().substring(1), ",");
	        while(st.hasMoreTokens()){*/
	        	
	        	/*System.out.println(st.nextToken());*/
	     
	        
	         
	         
			//div.daumWrap (body_content)// div.cMain // div.section_schedule kbl  section_basketvolley //wrap_schedule
			// div.wrap_compare wrap_grade ½ÃÁð¼ºÀû // div.fst box_history // div.thumb_team ÆÀ±×¸² url //cont_team
			// div.top_info ÆÀÀÌ¸§
			// div.info_history // dl dt/ dl dd
			//					
			// class or id ¾È¿¡ ÀÖ´Â ¸ðµç °ª °¡Á®¿È
			// id¶ó¸é div#wrap_compare wrap_grade
			// class¶ó¸é div.wrap_compare wrap_grade
			
			/*
			 * pom.xml ÇÊ¿ä <!-- Jsoup --> <dependency>
			 * <groupId>org.jsoup</groupId> <artifactId>jsoup</artifactId>
			 * <version>1.8.3</version> </dependency>
			 * 
			 */
			/*Pattern SCRIPT = Pattern.compile("(no)?script[^>]*>.*?<(no)?script>", Pattern.DOTALL);
			Pattern STYLE = Pattern.compile("<style[^>]*>.*</style>", Pattern.DOTALL);
			Pattern TAGS = Pattern.compile("<(\"[^\"]*\"|\\|[^\'\">])*>");
			Pattern NTAGS = Pattern.compile("<\\w+\\s+[^<]*\\s>");
			Pattern ENTITY_REFS = Pattern.compile("&[&^;]+;");
			Pattern WHITESPACE = Pattern.compile("\\s\\s+");
			
			Matcher m;
			m = SCRIPT.matcher(newsHeadlines.toString());
			m = STYLE.matcher(newsHeadlines.toString());
			m = TAGS.matcher(newsHeadlines.toString());
			m = NTAGS.matcher(newsHeadlines.toString());
			m = ENTITY_REFS.matcher(newsHeadlines.toString());
			m = WHITESPACE.matcher(newsHeadlines.toString());*/
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String replay(String content) {
		Pattern SCRIPT = Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.DOTALL);
		Pattern STYLE = Pattern.compile("<style[^>]*>.*</style>", Pattern.DOTALL);
		Pattern TAGS = Pattern.compile("<(\"[^\"]*\"|\\|[^\'\">])*>");
		Pattern NTAGS = Pattern.compile("<\\w+\\s+[^<]*\\s>");
		Pattern ENTITY_REFS = Pattern.compile("&[&^;]+;");
		Pattern WHITESPACE = Pattern.compile("\\s\\s+");
		
		Matcher m;
		m = SCRIPT.matcher(content);
		content = m.replaceAll("");
		m = STYLE.matcher(content);
		content = m.replaceAll("");
		m = TAGS.matcher(content);
		content = m.replaceAll("");
		m = NTAGS.matcher(content);
		content = m.replaceAll("");
		m = ENTITY_REFS.matcher(content);
		content = m.replaceAll("");
		m = WHITESPACE.matcher(content);
		content = m.replaceAll("");

		return content;
	}
}
