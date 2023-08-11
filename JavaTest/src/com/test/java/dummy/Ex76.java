package com.test.java.dummy;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Ex76 {
	public static void main(String[] args) {
		// OpenAPI(Open Application Programming Interface) : 공개된 프로그래밍 기능, 공공 데이터 포털
		// ex) 구글, 아마존, 네이버, 다음, 지도 등등

		// OpenAPI로 데이터 확보하면 좋은점은 전부 진짜 데이터라는 점. -> 현실 기반 데이터 -> 프로젝트의 높은 완성도
		// 공공데이터 포털 : data.go.kr -> 회원가입

		m1();
		//m2();

	}

	private static void m2() {
		/*
		   {
		   		"name" : "홍길동",
		   		"age" : 20
		   		"tel" : [ "010-1111-1111", "010-2222-2222", "010-3333-3333" ]
		    }
		   
		 */
		
		String json = "{\r\n"
		   		+ "			\"name\" : \"홍길동\",\r\n"
		   		+ "			\"age\" : 20\r\n"
		   		+ "			\"tel\" : [ \"010-1111-1111\", \"010-2222-2222\", \"010-3333-3333\" ]\r\n"
		   		+ "			}";
		    		

		JSONParser parser = new JSONParser();   //위를 해석하는 것.
		try {
			JSONObject obj = (JSONObject)parser.parse(json);
			//System.out.println(obj);
			System.out.println(obj.get("name"));   //이름에 해당하는 값을 가져옴.
			System.out.println(obj.get("age"));
			
			JSONArray arr= (JSONArray)obj.get("tel");
			for(Object t : arr) {
				System.out.println(t);
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
}

	private static void m1() {

		Scanner sc = new Scanner(System.in);
		System.out.println("[지하철 정보 검색]");
		System.out.print("역 검색 : ");
		String name = sc.nextLine();

		// 1. 요청주소(URL) 만들기
		// 지하철역 목록을 키워드로 검색하여 지하철역 목록을 조회하는 기능
		String ur1 = "http://apis.data.go.kr/1613000/SubwayInfoService/getKwrdFndSubwaySttnList?"
				+ "ServiceKey=VSA%2FawJeuSgg7ban0eZSLYrUGls2EapZE9UGmpjVqDjERKXB4d9cAv6E4MmW3oThlECsPgamNebdpCCbSMKBxg%3D%3D&"
				+ "_type=json&numOfRows=10&pageNo=1&subwayStationName=" + URLEncoder.encode(name);

		// QueryString
		// 요청 주소 ? 키 = 값(일반 인코딩 인증키) & 받을 타입을 XML 또는 JSON중에 선택 & 몇개 줄씩 가져올 것인지 & 페이지
		// 위치(1이면 첫번째 페이지) &

		/*
		 * System.out.println(ur1); //콘솔에 나온 주소를 복사해서 빈페이지에 복붙.-> 그 나온 결과를 다시 복사해서 온라인
		 * 뷰어에 붙여넣기 //온라인 뷰어 : http://json.parser.online.fr/
		 */

		try {
			// URL 객체 생성
			URL obj_ur1 = new URL(ur1);

			//URL와 연결하는 객체 생성 -> 브라우저 대신 접속
			HttpURLConnection conn = (HttpURLConnection)obj_ur1.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			BufferedReader reader= null;
			
			if(conn.getResponseCode()>=200 && conn.getResponseCode() <=300) {
				reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}else {
				reader=new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			/*
			//reader가 검색한 결과를 가지고 있는다. -> 검색 결과 읽기 가능
			String line=null;
			while((reader.readLine())!=null) {
				System.out.println(line);
			}
			*/
			///밑에 2개가 위 주석을 대신한다.
			JSONParser parser = new JSONParser();
			JSONObject root=(JSONObject)parser.parse(reader);
			JSONObject response = (JSONObject)root.get("response");   //response라는 이름을 가진 애가 온다.
			JSONObject body = (JSONObject)response.get("body");
			JSONObject items = (JSONObject)body.get("items");
			
			ArrayList<String> temp = new ArrayList<String>();  //역의 고유 ID
			
			if(items.get("item") instanceof JSONObject) {    //역이 여러개일 경우를 생각해서.
				JSONObject item = (JSONObject)items.get("item");
				//족보타고 내려온 것.
				
				System.out.println("1. ");
				System.out.println("호선 : " + item.get("subwayRouteName"));
				System.out.println("역명 : " + item.get("subwayStationName"));
				
				temp.add(item.get("subwayStationId").toString());
			}else {
				JSONArray arr = (JSONArray)items.get("item");
				int n=1;
				
				for(Object obj : arr) {
					JSONObject item = (JSONObject)obj;
					System.out.println(n+". ");
					System.out.println("호선 : " + item.get("subwayRouteName"));
					System.out.println("역명 : " + item.get("subwayStationName"));
					System.out.println("------------------------------");
					n++;
					temp.add(item.get("subwayStationId").toString());
				}
			}
			
			reader.close();
			conn.disconnect();
			
			System.out.print("역 선택 : ");
			int sel=sc.nextInt();
			
			System.out.println(temp.get(sel-1));   //역 ID
			
			////////////////////////////////////////////////////////////////////////////////
			//덮어쓰기로 가자
			
			// 1. 요청주소(URL) 만들기
			// 지하철역 출구번호별로 주변시설의 목록을 조회하는 기능
			ur1 = "http://apis.data.go.kr/1613000/SubwayInfoService/getSubwaySttnExitAcctoCfrFcltyList?"
					+ "ServiceKey=VSA%2FawJeuSgg7ban0eZSLYrUGls2EapZE9UGmpjVqDjERKXB4d9cAv6E4MmW3oThlECsPgamNebdpCCbSMKBxg%3D%3D&"
					+ "_type=json&numOfRows=10&pageNo=1&subwayStationId=" + temp.get(sel-1);   //역 ID주변에 뭐가 있는지 알려다오.
			
			
			//2.
			obj_ur1 = new URL(ur1);

			//URL와 연결하는 객체 생성 -> 브라우저 대신 접속
			conn = (HttpURLConnection)obj_ur1.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			reader= null;
			
			if(conn.getResponseCode()>=200 && conn.getResponseCode() <=300) {
				reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}else {
				reader=new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			
			//3. 덮어쓰기
			root = (JSONObject)parser.parse(reader);
			response = (JSONObject)root.get("response");   //response라는 이름을 가진 애가 온다.
			body = (JSONObject)response.get("body");
			items = (JSONObject)body.get("items");
			
			if(items.get("item") instanceof JSONObject) {    //주변시설이 여러개일 경우를 생각해서.
				JSONObject item = (JSONObject)items.get("item");
				//족보타고 내려온 것.
				
				System.out.println("출구 : "+item.get("exitNo")+"번");
				System.out.println("주변시설명 : "+item.get("dirDesc"));
				
			}else {
				JSONArray arr = (JSONArray)items.get("item");
				
				for(Object obj : arr) {
					JSONObject item = (JSONObject)obj;
					
					System.out.println("출구 : "+item.get("exitNo")+"번");
					System.out.println("주변시설명 : "+item.get("dirDesc"));
				}
			}
			
			reader.close();
			conn.disconnect();
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
