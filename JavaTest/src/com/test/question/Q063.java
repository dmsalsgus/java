package com.test.question;

public class Q063 {  //int 배열을 매개변수로 받아 내용을 문자열로 반환하는 dump 메소드를 구현하시오.
	public static void main(String[] args) {

		int[] list = new int[4];
		list[0]=10;
		list[1]=20;
		list[2]=30;
		list[3]=40;
		String result=dump(list);
		System.out.printf("nums = %s\n",result);

	}
	public static String dump(int[] list) {
		String txt="[";
		for(int i=0; i<4; i++) {
			txt+=list[i];
			if(i==3) continue;
			txt+=",";
		}
		txt+="]";
		
		// return Arrays.toString(list);  //int형 배열 -> 문자열로 변환해서 반환
		return txt;
	}
}
