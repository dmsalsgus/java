package com.test.question;
import java.util.*;

public class Q032 { //주차 요금을 계산하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[들어온시간]\n시 : ");
		int in_hour=sc.nextInt();
		System.out.print("분 : ");
		int in_min=sc.nextInt();
		System.out.print("[나간시간]\n시 : ");
		int out_hour=sc.nextInt();
		System.out.print("분 : ");
		int out_min=sc.nextInt();
		
		int money=0;
		int in_total=(in_hour*60)+in_min;  //들어온 시간 분으로 계산하기
		int out_total=(out_hour*60)+out_min;  //나간 시간 분으로 계산하기
		
		if(out_total-in_total<=30) {
			System.out.println("무료 주차입니다");
		}else {
			money=(out_total-in_total-30)/10*2000;
			System.out.printf("주차 요금은 %,d원입니다.",money);
		}
	}
}