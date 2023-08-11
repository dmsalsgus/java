package com.test.question;

public class Q053 {  //구구단을 출력하시오.
	public static void main(String[] args) {
		
		for(int i=1; i<10; i++) {
			for(int j=2; j<6; j++) {
				System.out.printf("%3d x %3d = %3d    ",j,i,i*j);
			}
			System.out.println();
		}
		System.out.printf("\n\n");
		for(int i=1; i<10; i++) {
			for(int j=6; j<10; j++) {
				System.out.printf("%3d x %3d = %3d    ",j,i,i*j);
			}
			System.out.println();
		}
	}
}