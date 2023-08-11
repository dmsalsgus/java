package com.test.question;

public class Q058 {  //아래와 같이 출력하시오.
	/*
	  	1 ~  10:  55
		11 ~  20: 155
		21 ~  30: 255
		31 ~  40: 355
		41 ~  50: 455
		51 ~  60: 555
		61 ~  70: 655
		71 ~  80: 755
		81 ~  90: 855
		91 ~ 100: 955
	 */
	public static void main(String[] args) {
		int sum=0,j;
		for(int i=0; i<10; i++) {  //행
			sum=0;
			for(j=i*10+1; j<=(i+1)*10; j++) {
				sum+=j;	
			}
			System.out.printf("%d ~ %d : %3d",j-10,j-1,sum);
			System.out.println();
		}
	}
}
