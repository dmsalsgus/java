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
		int a=97;
		char sum='a';
		for(int i=0; i<line; i++) {
			for(int j=line-1; j>i; j--) {   //공백  
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++) {  //문자 중간
				System.out.printf("%c",a+j);
			}
			
			for(int j=0; j<=i; j++) {  //나머지 문자 반대
				sum-=i;
				System.out.printf("%c",sum);	
			}
			
			System.out.println();
		}
		
		
		for(int i=0; i<line; i++) {  //입력한 행
			
			for(int j=line-1; j>i; j--) {  //공백 찍기 0,1,2,3,4...
				System.out.print(" ");
			}
			for(int j=line-i; j<=line; j++) {
				System.out.printf("%c",a+i);
			}
			//for(int j=line-i-1; j<line; j++) {
			//System.out.print("*");
			//}
			System.out.println();
		}
		
		
		String result="";
		//char sum='a';
		for(int i=0; i<line; i++) {
			for(int j=line-1; j>i; j--) {   //공백  
				result+=" ";
			}
			for(int j=0; j<=i; j++) {  //문자 중간
				result+=sum;
				sum++;
			}
			for(int j=0; j<=i; j++) {  //나머지 문자 반대
				sum--;
				result+=sum;
			}
			System.out.println();
		}
		System.out.printf("%s\n",result);
		
	}
}
