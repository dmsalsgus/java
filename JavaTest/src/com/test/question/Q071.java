package com.test.question;

public class Q071 {  //아래와 같이 출력하시오.
	/*
	25	 24  23	22	  21
	20	 19  18	17  16
	15	 14  13	12  11
	10  9	    8	 7	   6
	5	  4   	3    2	   1
	*/
	public static void main(String[] args) {
		int[][] nums=new int[5][5];
		int n=25;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				nums[i][j]=n;
				n--;
			}
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("%5d",nums[i][j]);
			}
			System.out.println();
		}
	}
}