package com.test.question;
import java.util.*;

public class Q086 {  //숫자를 입력받아 3자리마다 , 를 붙이시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		String num=sc.nextLine();  //숫자 입력받기
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0; i<num.length(); i++) {
			if((num.length()-i)%3==0&&i>0) sb.append(",");  //뒤에서부터 3자리마다 ,표시
			sb.append(num.charAt(i));  //그게 아니면 그냥 숫자 추가.
		}
		System.out.println(sb);
	}
}