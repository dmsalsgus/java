package com.test.question;
import java.util.*;

public class Q044 {  //숫자를 N개 입력받아 아래와 같이 출력하시오.
	//누적값이 100을 넘어가는 순간 루프를 종료하시오.
	//짝수는 더하고 홀수는 빼시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계산할 숫자의 개수를 입력하시오 : ");
		int input=sc.nextInt();
		int sum=0;
		String result="";
		
		for(int i=0; i<input; i++) {  
			System.out.print("숫자 : ");
			int num=sc.nextInt();
			
			if(num%2==0) {
				result+=" + ";
				result+=num;
				sum+=num;
			}else {
				result+=" - ";
				result+=num;
				sum-=num;
			}
		}
		System.out.printf("%s = %d\n",result,sum);
	}
}