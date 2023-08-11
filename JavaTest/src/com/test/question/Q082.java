package com.test.question;
import java.util.*;

public class Q082 {  //숫자를 입력받아 각 자릿수의 수의 합을 구하시오.
	//314 -> 3+1+4=8
	//substring 이나 charAt사용
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		String number=sc.nextLine();
		int sum=0;
		System.out.print("결과 : ");
		for(int i=0; i<number.length(); i++) {
			sum+=number.charAt(i)-'0';  //문자에 숫자0을 빼줌으로써 결과값을 숫자로 변환.(반대도 가능)
			System.out.print(number.charAt(i)-'0');
			if(i==number.length()-1)	break;  //마지막 숫자에는 부호 안붙이겠다.
			System.out.print(" + ");
		}
		System.out.printf(" = %d\n",sum);
	}
}