package com.test.question;
import java.util.*;

public class Q052 {  //아래와 같이 출력하시오.  //문자형 삼각형 모양
	/*
	   	  aa
     	abba
       abccba
      abcddbca
     abcdeedcba
    abcdeffedcba
   abcdefggfedcba
	 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행 : ");
		int line=sc.nextInt();
		char alpha='a';
		
		for(int i=line; i>0; i--) {
			for(int j=1; j<i; j++) {   //공백 출력하기
				System.out.print(" ");
			}
			for(int j=line; j>=i; j--) {  //문자 중간
				System.out.printf("%c",alpha);
				alpha++;
			}
			for(int j=line; j>=i; j--) {  //나머지 문자 반대
				alpha--;
				System.out.printf("%c",alpha);	
			}
			System.out.println();
		}
	}
}