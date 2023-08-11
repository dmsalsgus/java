package com.test.question;

public class Q055 {  //1부터 100사이의 완전수를 구하시오.
	//완전수: 자기 자신을 제외한 나머지 약수들의 합이 자신과 동일한 수
	//약수: 어떤 수나 식을 나누어 나머지가 없이 떨어지는 수
	//ex) 6 = [1, 2, 3,]  /  28 = [1, 2, 4, 7, 14,]
	public static void main(String[] args) {
		String result="";
		for(int i=1; i<=100; i++) {
			int sum=0;
			result="";  //**새로 출력할 것이므로 String도 초기화
			for(int j=1; j<i; j++) {
				if(i%j==0) {  //약수이면
					sum+=j;  //6일때, j=1,2,3.
					result+=j+",";
				}
			}
			if(i==sum) {
				System.out.print(i+" = "+ "["+result+"]\n");
			}
		}
	}
}