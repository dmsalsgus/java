package com.test.question;

public class Q074 {  //아래와 같이 출력하시오.
	/*
	0	0	1	0	0
	0	2	3	4	0
	5	6	7	8	9
	0 10 11	12 0
	0	0 13	0	0
	*/
	public static void main(String[] args) {
		int[][] nums=new int[5][5];
		int n=1;
		for(int i=0; i<5; i++) {
			if(i<3) {  //i=0,1,2
				for(int j=2-i; j<=i+2; j++) {
					nums[i][j]+=n;
					n++;
				}
			}else {  //i=3, 4
				for(int j=i-2; j<7-i; j++) {
					nums[i][j]+=n;
					n++;
				}
			}
		}
		//출력
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("%5d",nums[i][j]);
			}
			System.out.println();
		}
	}
}
