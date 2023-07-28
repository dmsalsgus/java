package com.test.question;
import java.util.*;

public class Q066 {
	public static void main(String[] args) {
		Random rd=new Random();  //랜덤 선언.
		int[] lotto=new int[6];  //배열 선언.
		
		for(int i=0; i<6; i++) {
			lotto[i]+=rd.nextInt(45)+1; //1~45사이의 난수 생성
			/*
			int a=(int)(Math.random()*45)+1;
			lotto[i]=a;
			*///난수 생성의 또 다른 방법. 이렇게 사용하면 랜덤 선언이 불필요하다.
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {  
					i--; //난수가 같으면 for문 count안함.
				}
			}
		}
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
	}
}
