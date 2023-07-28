package com.test.question;
import java.util.*;

public class Q042 {  //서기 1년 1월 1일(월)부터 오늘까지 며칠째인지 합을 구하시오.
	//Calendar 클래스 사용 금지
	//2023년 7월 24일은 738,725일째 되는 날이고 월요일입니다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("연도 : ");
		int year=sc.nextInt();
		System.out.print("월 : ");
		int month=sc.nextInt();
		System.out.print("일 : ");
		int date=sc.nextInt();
		String day="";  //요일 담는 변수
		int sum=0;
		
		//1년 1월 1일(월요일) ~ 22년 12월 31일까지 날짜
		for(int i=1; i<year; i++) {
			if(isLeafYear(i)) {
				sum+=366;  //윤년이면 하루 더해주기
			}else sum+=365;
		}
		//2023.1.1 ~ 2020.6.30까지
		for(int i=1; i<month; i++) {
			sum+=getMaxDate(i,year);  //윤년에 따라 2월이 29일인지 28일인지
		}
		sum+=date;  //일을 구하는 방법
		//요일 구하는 방법.
		day=getDay(sum);  //합계일을 7로 나눈 나머지는 요일마다 동일하다.
		System.out.printf("%d년 %d월 %d일은 %,d일째 되는 날이고, %s요일입니다.", year, month, date, sum, day);
	}
	private static String getDay(int sum) {  //기준일의 요일을 알아야 한다.
		if(sum%7==1) {
			return "월";
		}else if(sum%7==2) {
			return "화";
		}else if(sum%7==3) {
			return "수";
		}else if(sum%7==4) {
			return "목";
		}else if(sum%7==5) {
			return "금";
		}else if(sum%7==6) {
			return "토";
		}else if(sum%7==0) {
			return "일";
		}
		return null;
	}
	private static int getMaxDate(int year, int month) {  //달에 따른 날짜
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			return 31;
		case 2:
			return isLeafYear(year)? 29:28;  //윤년이면 29, 아니면 28.
		case 4: case 6: case 9: case 11:
			return 30;
		}
		return 0;
	}
	private static boolean isLeafYear(int year) {  //윤년검사
		if(year%4==0) {
			if(year%100==0) {
				if(year%400==0) {
					return true;  //윤년
				}else return false;  //평년
			}else return true;  //윤년
		}else 
		return false;	  //평년
	}
}