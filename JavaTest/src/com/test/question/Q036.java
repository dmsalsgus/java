package com.test.question;
import java.util.*;

public class Q036 {  //시작 숫자, 종료 숫자, 증감치를 입력받아 숫자를 순차적으로 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작 숫자 : ");
		int start_num=sc.nextInt();
		System.out.print("종료 숫자 : ");
		int end_num=sc.nextInt();
		System.out.print("증감치 : ");
		int high=sc.nextInt();
		
		for(int i=start_num; i<=end_num; i++) {
			System.out.println(start_num);
			start_num+=high;
			i+=high;
			--i;
		}
	}
}