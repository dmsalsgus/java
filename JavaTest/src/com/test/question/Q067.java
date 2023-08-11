package com.test.question;
import java.util.*;

public class Q067 {  //배열에 요소를 삽입하시오.
	//배열 길이: 10 / 마지막 요소는 우측으로 옮겨질 공간이 없으면 삭제된다.
	/*
	ex)
	삽입 위치: 2 
	값: 100 
	
	● 출력 1
	원본: [5, 6, 1, 3, 2, 0, 0, 0, 0, 0]
	결과: [5, 6, 100, 1, 3, 2, 0, 0, 0, 0]
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //scanner선언.
		int[] original= {5,6,1,3,2,8,7,4,10,9};  //초기화된 배열 선언.
		
		System.out.print("삽입 위치 : ");
		int location=sc.nextInt();
		System.out.print("값 : ");
		int value=sc.nextInt();
		
		System.out.print(Arrays.toString(original));
		System.out.println();
		for(int i=0; i<original.length; i++) {
			if(i==location) { //삽입 위치와 배열의 위치가 같으면
				for(int j=original.length; j>location; j--) {  //for(int i=original.length-2; i>=location; i--)
					original[j-1]=original[j-2];   //original[i+1]=original[i]
				}
				original[i]=value;
			}else continue;
		}
		System.out.print(Arrays.toString(original));
	}
}
