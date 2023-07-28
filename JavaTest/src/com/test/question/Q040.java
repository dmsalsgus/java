package com.test.question;
import java.util.*;

public class Q040 {  //아래와 같이 출력하시오.
	//ex) 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = -5
	//ex) 3 - 4 + 5 = 4
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작 숫자 : ");
		int start_num=sc.nextInt();
		System.out.print("종료 숫자 : ");
		int end_num=sc.nextInt();
		
		int sum=0;
		String result="";  //문자와 숫자 한번에 저장해서 출력할 변수
		String operation="-";  //첫 시작 연산자 -로 저장.
		for(int i=start_num; i<=end_num; i++) {
			result+=i;  //숫자 저장
			if(operation=="-") {
				sum+=i;
				if(i!=end_num) result+=" - ";  //연산자 저장
				operation="+";  //번갈아찍기 위해 다시 재선언.
			}else {
				sum-=i;
				if(i!=end_num) result+=" + "; ////연산자 저장
				operation="-";  //번갈아찍기 위해 다시 재선언.
			}
		}
		System.out.printf("%s = %d\n",result,sum);
	}
}