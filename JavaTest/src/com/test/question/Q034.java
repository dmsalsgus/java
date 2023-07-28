package com.test.question;
import java.util.*;

public class Q034 {  //날짜를 입력받아 아래의 조건에 맞게 결과를 출력하시오.
	//입력받은 날짜가 평일이면 해당 주의 토요일을 알아낸다.
	//입력받은 날짜가 토/일요일이면 아무것도 안한다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("년 : ");
		int year=sc.nextInt();
		System.out.print("월 : ");
		int month=sc.nextInt();
		System.out.print("일 : ");
		int date=sc.nextInt();
		
		Calendar week=Calendar.getInstance(); //현재 시각
		week.set(year, month-1, date); //내가 입력할 날짜로 설정하기.
		int week_num=week.get(Calendar.DAY_OF_WEEK);   //요일을 week_num에 저장
		/*
		switch(week_num) {  //1==일요일, 7==토요일
		case 2: case 3: case 4: case 5: case 6:
			System.out.println("입력하신 날짜는 '평일'입니다.");
			System.out.println("해당 주의 토요일로 이동합니다.");
		}
		if(week_num==2) {  //월
			week.add(Calendar.DATE,5 ); 
			System.out.printf("이동한 날짜는 '%tF'입니다.", week); 
		}else if(week_num==3) {  //화
			week.add(Calendar.DATE,4 ); 
			System.out.printf("이동한 날짜는 '%tF'입니다.", week);
		}else if(week_num==4) {  //수
			week.add(Calendar.DATE,3 ); 
			System.out.printf("이동한 날짜는 '%tF'입니다.", week);
		}else if(week_num==5){  //목
			week.add(Calendar.DATE,2 ); 
			System.out.printf("이동한 날짜는 '%tF'입니다.", week);
		}else if(week_num==6) {  //금
			week.add(Calendar.DATE,1 ); 
			System.out.printf("이동한 날짜는 '%tF'입니다.", week);
		}else System.out.println("입력하신 날짜는 '휴일(토/일)'입니다.\n결과가 없습니다.");
		*/
		
		//1==일요일, 2==월요일
		if(week_num>=2 && week_num<=6) {  //내가 입력한 날짜의 요일 숫자가 월-금이면
			week_num=7-week_num;   //week_num에 토요일 값을 계산해서 새로 저장하기.
			week.add(Calendar.DATE,week_num);   // 그 주 토요일로 날짜 설정하기.
			//set이 아니라 add로 날짜를 더해준다는 느낌으로.
			
			System.out.println("입력하신 날짜는 '평일'입니다.");
			System.out.println("해당 주의 토요일로 이동합니다.");
			System.out.printf("이동한 날짜는 '%tF'입니다.", week);   //위에 설정한 토요일이 출력되는 것.
		}else System.out.println("입력하신 날짜는 '휴일(토/일)'입니다.\n결과가 없습니다.");
	}
}