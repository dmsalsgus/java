package com.test.question;
import java.util.*;

public class Q028 {  //근무 년수를 입력받아 아래와 같이 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("근무 년수 : ");
		int career=sc.nextInt();
		
		if(career<1) {
			System.out.print("입력한 값이 올바르지 않습니다. 1이상의 값을 입력하시오");
		}else if(career<=4) {
			System.out.printf("%d년차 초급 개발자입니다.\n",career);
			System.out.printf("앞으로 %d년 더 근무를 하면 중급 개발자가 됩니다.",5-career);
		}else if(career<=9) {
			System.out.printf("%d년차 중급 개발자입니다.\n",career);
			System.out.printf("당신은 %d년전까지 초급 개발자였습니다.\n",career-4);
			System.out.printf("앞으로 %d년 더 근무를 하면 고급 개발자가 됩니다.",10-career);
		}else System.out.printf("%d년차 고급 개발자입니다.\n당신은 %d년전까지 중급 개발자였습니다.",career,career-9);
		
	}
}