package com.test.question;
import java.util.*;

public class Q064 {
	public static void main(String[] args) {
		Random rd=new Random(); //랜덤 선언.
		int[] original = new int[20];
		for(int i=0; i<20; i++) {
			int random=rd.nextInt(20)+1;  //1부터 20까지의 난수 20개 생성.
			original[i]+=random;
		}
		System.out.println("원본 : "+Arrays.toString(original));
		Arrays.sort(original);
		/*
		int max=0,min=21;
		for(int i=0; i<original.length; i++) {
			if(original[i]>max) max=original[i];
			if(original[i]<min) min=original[i];
		}
		*/
		System.out.println("최댓값 : "+original[19]);  //max값
		System.out.println("최솟값 : "+original[0]);	//min값
	}
}
