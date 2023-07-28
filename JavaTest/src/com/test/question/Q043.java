package com.test.question;  //모든 실패 추가하기
import java.util.*;

public class Q043 {  //컴퓨터가 1~10 사이의 숫자 1개를 생각하면 사용자가 맞추는 프로그램을 구현하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("컴퓨터가 1~10 사이의 숫자를 1개 생각했습니다.\n");
		int num=(int)(Math.random()*10)+1;  //1에서 10까지의 난수 생성
		int tried,i;
		
		for(i=1; i<10; i++) {
			System.out.print("숫자 : ");
			tried=sc.nextInt();
			if(tried==num) {
				System.out.printf("맞았습니다.\n\n");
				//i++;
				break;
			}else System.out.print("틀렸습니다.\n\n");
		}
		System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\n",num);
		if(i==10) {
			System.out.printf("모든 기회를 실패했습니다.\n\n");
		}else {
		System.out.printf("정답을 맞추는데 시도한 횟수는 %d회입니다.\n\n",i);
		}
		System.out.printf("프로그램을 종료합니다.");
	}	
}