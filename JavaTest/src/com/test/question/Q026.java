package com.test.question;
import java.util.*;

public class Q026 {  //학생의 국어 점수를 입력받아 성적을 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 : ");
		int kor=sc.nextInt();
		
		if(kor<0||kor>100) {
			System.out.printf("점수가 올바르지 않습니다. 0~100사이의 값을 입력하시오.");
		}else if(kor>=90&&kor<=100) {
			System.out.printf("입력한 %d점은 성적 A입니다.",kor);
		}else if(kor>=80) {
			System.out.printf("입력한 %d점은 성적 B입니다.",kor);
		}else if(kor>=70) {
			System.out.printf("입력한 %d점은 성적 C입니다.",kor);
		}else if(kor>=60){
			System.out.printf("입력한 %d점은 성적 D입니다.",kor);
		}else System.out.printf("입력한 %d점은 성적 F입니다.",kor);
		
	}
}