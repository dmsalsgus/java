package com.test.question;
import java.util.*;

public class Q048 {  //최대 9자리 정수를 입력받아 각자리의 홀수 숫자합과 짝수 숫자합을 구하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int num=sc.nextInt();
		int even=0,odd=0;
		for(int i=1; i<=9; i++) {
			int  result=num%10;  //나머지를 저장하는 변수
			num=num/10;  // 몫을 저장하는 변수
			if(result%2==0) {
				even+=result;
			}else odd+=result;
		}
		System.out.printf("짝수의 합 : %d\n홀수의 합 : %d\n",even,odd);
	}
}