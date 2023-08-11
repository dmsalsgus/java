package com.test.question;

public class Q054 {  //2부터 100사이의 소수를 구하시오.
	public static void main(String[] args) {
		int cnt=0;
		for(int i=2; i<=100; i++) {
			cnt=0;  //소수 체크해준거 다시 초기화.
			for(int j=2; j<=i; j++) {
				if(i%j==0) {  //자기 자신으로만 나누어지는 수가 소수.
					cnt++;
				}
			}
			if(cnt==1) {
				System.out.printf("%d, ",i);
			}
		}
		
	}
}