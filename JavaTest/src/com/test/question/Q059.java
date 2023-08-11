package com.test.question;

public class Q059 {  //마지막 숫자가 100이 넘기 전까지 출력하시오.
	//ex) 1 + 2 + 4 + 7 + 11 + 16 + 22 + 29 + 37 + 46 + 56 + 67 + 79 + 92 +  = 469
	//증감치가 1, 2, 3..++
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
