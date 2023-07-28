package com.test.question;
import java.util.*;

public class Q049 {  //아래와 같이 출력하시오.  //오른쪽정렬 역직각삼각형
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행 : ");
		int star=sc.nextInt();
		
		for(int i=0; i<star; i++) {  //입력한 행
			
			for(int j=0; j<i; j++) {  //공백 찍기 0,1,2,3,4...
				System.out.print(" ");
			}
			for(int j=0; j<star-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}