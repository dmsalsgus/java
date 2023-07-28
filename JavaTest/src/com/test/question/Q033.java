package com.test.question;
import java.util.*;

public class Q033 {  //년도를 입력받아 해당 년도가 '평년' 인지 '윤년' 인지 출력하시오.
	//a. 년도를 4로 나눈다. / 떨어지면 b 검사 / 떨어지지 않으면 "평년"
	//b. 년도를 100으로 나눈다. / 떨어지면 c 검사 / 떨어지지 않으면 "윤년"
	//c. 년도를 400으로 나눈다. / 떨어지면 "윤년" / 떨어지지 않으면 "평년"
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year=sc.nextInt();
		
		if(year%4==0) {
			if(year%100==0) {
				if(year%400==0) {
					 System.out.printf("%d년은 '윤년'입니다.", year);
				}else System.out.printf("%d년은 '평년'입니다.", year);
			}else System.out.printf("%d년은 '윤년'입니다.", year);
		}else System.out.printf("%d년은 '평년'입니다.", year);
		
	}
}