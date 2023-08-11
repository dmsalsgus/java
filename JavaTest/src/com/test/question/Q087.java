package com.test.question;
import java.util.*;

public class Q087 {  //영단어를 입력받아 분리하시오.
	//임의의 위치에서 시작하다가 대문자 만나면 그 앞을 space.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단어 : ");
		String word=sc.nextLine();
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0; i<word.length(); i++) {
			if(i>0&&word.charAt(i)>=65&&word.charAt(i)<=90) {
				sb.append(" ");
			}
			sb.append(word.charAt(i));
		}
		System.out.println(sb);
	}
}