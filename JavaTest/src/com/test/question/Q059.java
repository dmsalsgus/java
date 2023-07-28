package com.test.question;

public class Q059 {
	public static void main(String[] args) {
		int sum = 0;
		int cnt = 1;  //증감치
		int num = 1;  //첫번째 수
		while (true) {
			if (num >= 1 && num < 100) {
				sum += num;
				System.out.print(num+" + ");
				num += cnt;
				cnt++;
			}else break;
		}System.out.print("= "+sum);
	}
}
