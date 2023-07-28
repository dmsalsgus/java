package com.test.question;

public class Q075 {
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