package com.test.question;

public class Q057 {
	public static void main(String[] args) {
		
		int sum=0, j;
		for(int i=1; i<=10; i++) {   //행
			sum=0;
			for(j=1; j<=i*10; j++){
				sum+=j;
			}
			System.out.printf("1 ~ %d : %4d", j-1,sum);
			System.out.println();
		}
	}
}
