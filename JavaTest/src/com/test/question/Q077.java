package com.test.question;

public class Q077 {
	public static void main(String[] args) {
		/*
		int[][] nums=new int[5][5];
		int n=1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				nums[i][j]+=n;
				n++;
				
			}
		}
		*/
		int[][] nums=new int[5][5];
		int n=1, high=2;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				nums[j][i]+=n;
				n+=2;
				n=high++;
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
