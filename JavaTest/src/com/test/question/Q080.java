package com.test.question;
import java.util.*;

public class Q080 {  //문장을 입력받아 역순으로 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문장 입력 : ");
		String str=sc.nextLine();  //nextLine()으로 해야 공백포함해서 받음.
		
		System.out.print("역순 결과 : ");
		StringBuilder sb=new StringBuilder(str);  //StringBuilder로 문자열 받기
		System.out.print("\""+sb.reverse().toString()+"\"");
		
	}
}