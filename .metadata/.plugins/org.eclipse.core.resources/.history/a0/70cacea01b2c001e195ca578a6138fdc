package com.test.question;
import java.util.*;

public class Q039 {  //아래와 같이 출력하시오.
	//ex) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
	//ex) 3 + 4 + 5 = 12
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작 숫자 : ");
		int start_num=sc.nextInt();
		System.out.print("종료 숫자 : ");
		int end_num=sc.nextInt();
		int sum=0;
		for(int i=start_num; i<=end_num; i++) {
			sum+=i;
			
			/* 내가 한거
			System.out.printf("%d",i);
			if(i==end_num) continue;
			System.out.print(" + ");
			*/
			//강사님 버전
			if(i!=end_num) {
				System.out.printf("%d +",i);
			}else System.out.print(i);
		}
		//System.out.printf(" = %d\n",sum);
		System.out.printf("\b\b = %d\n",sum);  //+ = 을 지워주는 방법 → backspace를 입력해주면됨.
		//이클립스는 지원안해줌. 인텔리제이는 가능
		
	}
}