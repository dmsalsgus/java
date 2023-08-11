package com.test.question;
import java.io.*;
import java.util.*;

public class Q114 {
	public static void main(String[] args) {
		//목록
		File dir=new File("C:\\Users\\leeje\\OneDrive\\바탕 화면\\학원\\확장자별 카운트");
		File[] list=dir.listFiles();   //데이터 확보
		
		//키->확장자 / 값->카운트
		HashMap<String,Integer> cnt=new HashMap<String,Integer>();
		
		for(File f:list) {
			//System.out.println(f.getName());
			String ext=getExtension(f.getName());
			if(!cnt.containsKey(ext)) {   //지금 확장자가 맵에 존재하는지?
				cnt.put(ext,1);   //새로운 확장자 등록
			}else cnt.put(ext,cnt.get(ext)+1);    //cnt=cnt+1 누적. 메소드라서 어쩔수 없이 저렇게 적어야 함.
		}
		System.out.println(cnt);
	}
	private static String getExtension(String name) {
		//System.out.println(name);  //마우스01.jpg
		String[] temp=name.split("\\.");    //정규표현식이 존재하므로 그냥"."이 아니라 
		
		//System.out.println(temp.length);
		
		String ext=temp[temp.length-1].toLowerCase();    //대문자나 소문자로 통일하기.
		
		//System.out.println(Arrays.toString(temp));
		//System.out.println(ext);
		
		return ext;    //return name.split("\\.")[temp.length-1].toLowerCase(); -> 한번에 쓰는 거 가능
	}
	
}
