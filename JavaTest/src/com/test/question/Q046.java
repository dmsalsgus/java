package com.test.question;
import java.util.*;

public class Q046 {  //숫자를 10개 입력받아 한글로 변환 후 출력하시오.
	//1~9까지만 입력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String korean="일이삼사오육칠팔구";
		String result ="";
		for(int i=0; i<10; i++) {// 숫자 10개 입력바는 for문.
			System.out.print("숫자 : ");
			int num=sc.nextInt();
			
			for(int j=0; j<10; j++) {
				if(num==j+1) {result+=korean.charAt(j); }
				//String에 저장한 글자위치와 숫자가 매치되면 문자열 변수 result에 저장.
			}
		}
		System.out.printf("%s",result);
	}
}