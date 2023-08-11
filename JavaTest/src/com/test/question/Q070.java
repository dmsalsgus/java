package com.test.question;

public class Q070 {  //아래와 같이 출력하시오.
	/*
	1	  2  	3	  4  	5
	10	  9  	8  	  7   	6
	11	  12	13	  14	15
	20	  19	18  17	16
	21	  22	23  24	25
	*/
	public static void main(String[] args) {
		int[][] nums=new int[5][5];
		int n1=1, n2=10;
		
		for(int i=0; i<5; i++) {
			if(i%2==0) {  //i=0,2,4
				for(int j=0; j<5; j++) {
					nums[i][j]+=n1;
					n1++;
				}
				n1+=5;  //i가 짝수일 경우의 수의 규칙...
			} else {  //i=1,3
				for(int j=0; j<5; j++) {
					nums[i][j]+=n2;
					n2--;
				}	
				n2+=15;
			}
		}
		for(int i=0; i<5; i++) {  //출력
			for(int j=0; j<5; j++) {
				System.out.printf("%5d",nums[i][j]);
			}
			System.out.println();
		}
	}
}