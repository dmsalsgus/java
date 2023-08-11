package com.test.question;

public class Q060 {  //마지막 숫자가 100이 넘기 전까지 출력하시오.
	// 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 +  = 232
	//피보나치 수열
	public static void main(String[] args) {
		int sum=0, fibo_last;
		for(int i=1; ; i++) {
			sum+=fibo(i);
			if(fibo(i)>100) {
				fibo_last=fibo(i);
				break;
			}
			System.out.printf("%d + ",fibo(i));
		}
		System.out.printf("= %d",sum-fibo_last);
	}
	public static int fibo(int num) {
		if(num<=1) {
			return num;
		}else 
			return fibo(num-2) + fibo(num-1);
	}
}
