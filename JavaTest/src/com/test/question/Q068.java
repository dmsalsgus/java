package com.test.question;
import java.util.*;

public class Q068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //scanner선언.
		int[] original= {5,6,1,3,2,8,7,4,10,9};  //초기화된 배열 선언.
		
		System.out.print("삭제 위치 : ");
		int location=sc.nextInt();		
		
		System.out.print(Arrays.toString(original));  //원본
		System.out.println();
		for(int i=0; i<original.length; i++) {
			if(i==location) { //삭제 위치와 배열의 위치가 같으면
				for(int j=location+1; j<original.length; j++) {
					original[j-1]=original[j];
				}
			}else continue;
		}
		original[original.length-1]=0;
		System.out.print(Arrays.toString(original));
	}
}
