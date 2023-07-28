package com.test.question;
import java.util.*;

public class Q031 {  //숫자 5개를 입력받아 짝수와 홀수의 개수를 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt=0,cnt_odd=0;
		
		System.out.print("숫자 입력 : ");
		int a1=sc.nextInt();
		if(a1%2==0) ++cnt; else ++cnt_odd;
		System.out.print("숫자 입력 : ");
		int a2=sc.nextInt();
		if(a2%2==0) ++cnt; else ++cnt_odd;
		System.out.print("숫자 입력 : ");
		int a3=sc.nextInt();
		if(a3%2==0) ++cnt; else ++cnt_odd;
		System.out.print("숫자 입력 : ");
		int a4=sc.nextInt();
		if(a4%2==0) ++cnt; else ++cnt_odd;
		System.out.print("숫자 입력 : ");
		int a5=sc.nextInt();
		if(a5%2==0) ++cnt; else ++cnt_odd;
		
		System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\n", cnt,cnt_odd);
		if(cnt>cnt_odd) {
			System.out.printf("짝수가 홀수보다 %d개 더 많습니다.",cnt-cnt_odd);
		}else System.out.printf("홀수가 짝수보다 %d개 더 많습니다.",cnt_odd-cnt);
		
	}
}