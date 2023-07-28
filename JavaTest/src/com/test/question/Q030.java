package com.test.question;
import java.util.*;

public class Q030 {  //영문자 1개를 입력받아 대/소문자 변환을 한 뒤 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 : ");
		char alpha=sc.nextLine().charAt(0);
		
		if(alpha>=65&&alpha<=90) {
			System.out.printf("\'%c\'의 소문자는 \'%c\'입니다.",alpha, alpha+32);
		}else if(alpha>=97&&alpha<=122) {
			System.out.printf("\'%c\'의 대문자는 \'%c\'입니다.",alpha, alpha-32);
		}else System.out.print("영문자만 입력하시오.");
	
	}
}