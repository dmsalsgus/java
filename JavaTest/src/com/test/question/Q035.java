package com.test.question;
import java.util.*;

public class Q035 {  //사용자의 이름과 인사할 횟수를 입력 받아 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name=sc.next();
		System.out.print("횟수 : ");
		int num=sc.nextInt();
		
		for(int i=0; i<num; i++) {
			System.out.printf("%s님 안녕하세요~\n",name);
		}
	}
}