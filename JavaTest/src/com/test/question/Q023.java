package com.test.question;
import java.util.*;

public class Q023 {  //아빠와 딸의 생일을 입력받아 아빠가 딸보다 며칠을 더 살았는지 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아빠 생일(년) : ");
		int dad_year=sc.nextInt();
		System.out.print("아빠 생일(월) : ");
		int dad_month=sc.nextInt();
		System.out.print("아빠 생일(일) : ");
		int dad_date=sc.nextInt();
		
		System.out.print("딸 생일(년) : ");
		int girl_year=sc.nextInt();
		System.out.print("딸 생일(월) : ");
		int girl_month=sc.nextInt();
		System.out.print("딸 생일(일) : ");
		int girl_date=sc.nextInt();
		
		Calendar dad = Calendar.getInstance();  //현재 시각 먼저 받고
		dad.set(dad_year, dad_month,dad_date);  // 입력받은 아빠 생일 설정하기
		long dadTick=dad.getTimeInMillis();  // 아빠가 살아온 일 수
		
		Calendar girl=Calendar.getInstance();  //현재 시각 먼저 받고
		girl.set(girl_year, girl_month, girl_date);  //설정으로 입력받은 딸 생일 지정해주기
		long girlTick=girl.getTimeInMillis();  // 딸이 살아온 일 수
		
		System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다.",(girlTick-dadTick)/1000/60/60/24);
		//.getTimeInMillis()는 ms(초)이므로 일을 출력하고 싶으면 계산해줘야 한다.
	}
}