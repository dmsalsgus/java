package com.test.question;
import java.util.*;

public class Q029 {  ////숫자 2개와 연산자 1개를 입력받아 연산 과정과 결과를 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자 : ");
		int n1=sc.nextInt();
		System.out.print("두번째 숫자 : ");
		int n2=sc.nextInt();
		System.out.print("연산자 : ");
		String cal=sc.next();   //sc.nextLine()으로 하면 공백을 인식해서 안됨. 쓸거면 2번써야함.
		
		if(cal.equals("+")) {
			System.out.printf("%d + %d = %d",n1, n2, n1+n2);
		}else if(cal.equals("-")) {
			System.out.printf("%d - %d = %d",n1, n2, n1-n2);
		}else if(cal.equals("*")) {
			System.out.printf("%d * %d = %d",n1, n2, n1*n2);
		}else if(cal.equals("/")) {
			double total=(double)n1/n2;
			System.out.printf("%d / %d = %.1f",n1, n2, total);
		}else if(cal.equals("%")) {
			System.out.printf("%d %% %d = %d",n1, n2, n1%n2);
		}else System.out.print("연산이 불가능합니다");
		
	}
}