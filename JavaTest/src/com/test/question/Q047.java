package com.test.question;
import java.util.*;
import java.io.*;

public class Q047 {  //자판기 프로그램을 구현하시오..
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; ; i++) {
			System.out.println("====================");
			System.out.println("           자판기             ");
			System.out.println("====================");
			System.out.println("1. 콜라 : 700원");
			System.out.println("2. 사이다 : 600원");
			System.out.println("3. 비타500 : 500원");
			System.out.println("----------------------------");
			System.out.print("금액 투입(원) (0입력시 종료) : ");
			int price=sc.nextInt();
			if(price==0) {
				System.out.println("자판기 종료"); 
				break;
			}
			System.out.println("----------------------------");
			System.out.print("음료 선택(번호) : ");
			int choice=sc.nextInt();
			
			if(choice==1) {
				System.out.println("+콜라를 제공합니다.");
				System.out.printf("+잔돈 %d원을 제공합니다.\n\n", price-700);
			}else if(choice==2) {
				System.out.println("+사이다를 제공합니다.");
				System.out.printf("+잔돈 %d원을 제공합니다.\n\n", price-600);
			}else if(choice==3) {
				System.out.println("+비타500을 제공합니다.");
				System.out.printf("+잔돈 %d원을 제공합니다.\n\n", price-500);
			}else {
				System.out.print("자판기를 종료합니다.");
				break;
			}
			System.out.println("계속하시려면 엔터를 입력하세요.");
			//pause(); 
			sc.nextLine();
			sc.nextLine();   //이렇게 sc.nextLine(); 2개만 입력해도 가능하다.
		}	
	}
	public static void pause() {  //엔터를 치기 전까지 일시정지 시키기
		try {
		      System.in.read();
		    } catch (IOException e) { }
	}
}
