package com.test.question;
import java.util.*;

public class Q025 {  //숫자 2개를 입력받아 큰수와 작은수를 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자 : ");
		int a=sc.nextInt();
		System.out.print("두번째 숫자 : ");
		int b=sc.nextInt();
		
		if(a>b) {
			System.out.printf("큰 수는 %d이고, 작은 수는 %d입니다. 두 숫자는 %d가(이) 차이납니다.",a,b,a-b);
		}else if(a<b) {
			System.out.printf("큰 수는 %d이고, 작은 수는 %d입니다. 두 숫자는 %d가(이) 차이납니다.",b,a,b-a);
		}else System.out.print("두 숫자는 동일합니다.");
		
	}
}