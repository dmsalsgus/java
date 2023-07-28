package com.test.question;
import java.util.*;

public class Q021 { //태어난 년도를 입력하면 나이를 출력하시오.
	public static void main(String[] args) {
		//올해 기준으로 나이를 계산하며, 내년에 실행해도 그때에 맞는 나이를 출력한다.
		Scanner sc = new Scanner(System.in);
		System.err.print("태어난 년도 : ");
		int year=sc.nextInt();
		
		Calendar now=Calendar.getInstance();  //현재 시각 생성.
		int age=now.get(Calendar.YEAR)-year+1;  //나이는 현재 연도에서 입력받은 연도를 빼면 나이다.
		
		System.out.printf("나이 : %d세이다.\n",age);
	}
}