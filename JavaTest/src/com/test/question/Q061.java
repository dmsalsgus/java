package com.test.question;
import java.util.*;

public class Q061 {  //숫자를 5개 입력받아 배열에 담은 뒤 역순으로 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums=new int[5];  //nums 배열 선언.
		for(int i=0; i<5; i++) {
			System.out.print("숫자 : ");
			nums[i]=sc.nextInt();
		}
		for(int j=4; j>=0; j--) {
			System.out.printf("nums[%d] = %d\n",j,nums[j]);
		}
	}
}
