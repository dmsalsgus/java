package com.test.question;
import java.util.*;

public class Q027 {  //문자 1개를 입력받아 아래와 같이 출력하시오.
	//조건 : f, F → Father / m, M → Mother / s, S → Sister / b, B → Brother
	//유효성 검사를 하시오.(위의 문자가 아닌 문자는 예외 처리)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자 : ");
		String alpha=sc.nextLine();
		
		if(alpha.equals("f")||alpha.equals("F")) {
			System.out.print("Father");
		}else if(alpha.equals("m")||alpha.equals("M")) {
			System.out.print("Mother");
		}else if(alpha.equals("s")||alpha.equals("S")) {
			System.out.print("Sister");
		}else if(alpha.equals("b")||alpha.equals("B")) {
			System.out.print("Brother");
		}else System.out.print("입력한 문자가 올바르지 않습니다.");
		
	}
}