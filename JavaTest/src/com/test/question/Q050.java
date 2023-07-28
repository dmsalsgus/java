package com.test.question;
import java.util.*;

public class Q050 {  //아래와 같이 출력하시오.  //오른쪽 정렬 직각삼각형
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행 : ");
		int line=sc.nextInt();
		
		for(int i=0; i<line; i++) {  //입력한 행
			
			for(int j=line; j>i; j--) {  //공백 찍기 0,1,2,3,4...
				System.out.print(" ");
			}
			for(int j=line-i-1; j<line; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}