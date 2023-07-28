package com.test.question;
import java.util.*;

public class Q024 {//여러 배달 음식을 같은 시간에 받기를 원하는 고객이 있다. 
	//고객이 각각의 매장에 몇시에 전화를 해야 모든 음식을 같은 시간에 받을 수 있는지 알려주시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("음식을 받기 원하는 시각");
		System.out.print("시 : ");
		int si=sc.nextInt();
		System.out.print("분 : ");
		int bun=sc.nextInt();
		
		Calendar food=Calendar.getInstance();  //현재 시각 먼저 받기
		food.set(Calendar.HOUR_OF_DAY,si);  //입력받은 시간으로 설정해주기
		food.set(Calendar.MINUTE,bun);  //입력받은 분으로 설정해주기
	
		food.add(Calendar.MINUTE,-10);  
		System.out.printf("짜장면 : %d시 %d분\n", food.get(Calendar.HOUR_OF_DAY),food.get(Calendar.MINUTE));
		food.add(Calendar.MINUTE,-8);  
		System.out.printf("치킨 : %d시 %d분\n", food.get(Calendar.HOUR_OF_DAY),food.get(Calendar.MINUTE));
		food.add(Calendar.MINUTE,-7);  
		System.out.printf("피자 : %d시 %d분", food.get(Calendar.HOUR_OF_DAY),food.get(Calendar.MINUTE));
		
	}
}