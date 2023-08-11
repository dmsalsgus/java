package com.test.question;
import java.util.*;

public class Q065 {  //난수를 담고 있는 배열을 생성한 뒤 아래와 같이 출력하시오.
	//난수를 20개 발생 후 배열에 넣는다.
	//난수는 1 ~ 20 사이
	//배열을 탐색하여 범위에 만족하는 숫자만 출력한다.
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