package com.test.question;
import java.util.*;

public class Q065 {
	public static void main(String[] args) {
		Random rd=new Random(); //랜덤 선언.
		int[] original = new int[20];  //배열 선언.
		Scanner sc = new Scanner(System.in);  //scanner 선언.
		for(int i=0; i<20; i++) {
			original[i]+=rd.nextInt(20)+1;  //1부터 20까지의 난수 20개 생성.
		}
		System.out.print("최대 범위 : ");
		int max=sc.nextInt();
		System.out.print("최소 범위 : ");
		int min=sc.nextInt();
		String result="";
		for(int i=0; i<20; i++) {
			for(int j=min; j<=max; j++) {
				if(j==original[i]) {
					result+=original[i];
					result+=", ";
				}
			}
		}
		System.out.println("원본 : "+Arrays.toString(original));
		System.out.println("결과 : "+result);
	}
}