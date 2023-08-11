package com.test.question;

public class Q057 {  //아래와 같이 출력하시오.
	/*
	1 ~  10:   55
	1 ~  20:  210
	1 ~  30:  465
	1 ~  40:  820
	1 ~  50: 1275
	1 ~  60: 1830
	1 ~  70: 2485
	1 ~  80: 3240
	1 ~  90: 4095
	1 ~ 100: 5050
	*/
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
