package com.test.question;

public class Q075 {  //주어진 규칙에 따라 아래와 같이 출력하시오.
	/*
	1   2   3   4   10
    5   6   7   8   26
    9   10  11  12  42
    13  14  15  16  58
    28  32  36  40  136
    */
	public static void main(String[] args) {
		int[][] nums=new int[5][5];
		int n=1, sum;

		for(int i=0; i<4; i++) {
			sum=0;
			for(int j=0; j<4; j++) {
				nums[i][j]+=n;
				sum+=nums[i][j];
				n++;
			}
			nums[i][4]+=sum;
		}
		for(int i=0; i<5; i++) {
			sum=0;
			for(int j=0; j<5; j++) {
				sum+=nums[j][i];
			}
			nums[4][i]+=sum;
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