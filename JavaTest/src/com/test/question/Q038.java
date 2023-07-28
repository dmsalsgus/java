package com.test.question;
import java.util.*;

public class Q038 {  //입력 횟수(N)와 숫자 N개를 입력받아 짝수의 합과 홀수의 합을 각각 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 횟수 : ");
		int input=sc.nextInt();
		
		int odd=0,even=0;
		int cnt1=0,cnt2=0;
		for(int i=0; i<input; i++) {
			System.out.print("숫자 : ");
			int num=sc.nextInt();
			
			if(num%2==0) {
				even+=num;
				cnt1++;
			}else {
				odd+=num; 
				cnt2++;
			}
		}
		System.out.printf("짝수 %d개의 합 : %d\n",cnt1,even);
		System.out.printf("홀수 %d개의 합 : %d\n",cnt2,odd);
	}
}