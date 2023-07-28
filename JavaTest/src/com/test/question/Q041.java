package com.test.question;
import java.util.*;

public class Q041 {  //아래와 같이 출력하시오.
	//누적값이 1000을 넘어가는 순간 루프를 종료하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum=0;
		for(int i=1; ; i++) {
			System.out.print(i);
			System.out.print(" + ");
			sum+=i;
			if(sum>1000) {
				System.out.print(i);
				break;
			}
		}
		System.out.printf(" = %d\n",sum);
	}
}