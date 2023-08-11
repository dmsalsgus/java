package com.test.question;
import java.util.*;

public class Q069 {  //배열의 요소를 순차적으로 2개씩 더한 결과를 배열로 생성한 뒤 출력하시오.
	//ex) 원본: [ 1, 5, 3, 6, 2, 7, 8, 2, 2, 9 ]
	//     결과: [ 6, 9, 9, 10, 11 ]
	public static void main(String[] args) {
		Random rd=new Random(); //랜덤 선언(난수).
		Scanner sc = new Scanner(System.in);  //Scanner 선언.
		System.out.print("배열 길이 : ");
		int input=sc.nextInt();
		int[] original=new int[input];  //원본 배열 선언.
		
		int odd=input/2+1;
		int[] result1=new int[odd];  //홀수 결과 배열 선언.
		int[] result2=new int[input/2]; //짝수 결과 배열 선언.
		
		for(int i=0; i<input; i++) {
			original[i]+=rd.nextInt(9)+1; //랜덤으로 값 집어넣기
		}
		System.out.print(Arrays.toString(original));  //원본 출력
		System.out.println();
		
		if(input%2!=0) {  //결과 배열 길이가 홀수이면
			for(int i=0; i<odd; i++) {  //i=0,1,2  //odd=3
				if(i==odd-1) {  //odd=2
					result1[i]+=original[i*2];
				}else result1[i]+=original[i*2]+original[i*2+1];
			}
			System.out.print(Arrays.toString(result1));
		}else {  //결과 배열 길이가 짝수이면
			for(int i=0; i<input/2; i++) {
				result2[i]+=original[i*2]+original[i*2+1];
			}
			System.out.print(Arrays.toString(result2));
		}
	}
}