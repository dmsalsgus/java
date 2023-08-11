package com.test.question;
import java.util.*;

public class Q076 {  //성적을 입력받아 아래와 같이 출력하시오.
	public static void main(String[] args) {
		String[][] score =new String[10][3];  //배열 선언.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 : ");
		int kor=sc.nextInt();
		System.out.print("영어 점수 : ");
		int eng=sc.nextInt();
		System.out.print("수학 점수 : ");
		int math=sc.nextInt();
		
		input(score,kor,0);
		input(score,eng,1);
		input(score,math,2);
		
		//출력
		for(int i=0; i<10; i++) {
			for(int j=0; j<3; j++) {
				System.out.printf("%5s",score[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------");
		System.out.print("   국어  영어  수학");
	}
	private static void input(String score[][], int num, int j) {
		int a=num/10;
		for(int i=9; i>=10-a; i--) {
			score[i][j]="■";        //+=는 안됨. 초기화가 null값으로 되어있는 배열에 추가하겠다는 의미라서 안됨.
		}
		for(int i=0; i<10-a; i++) {
			score[i][j]=" ";
		}
	}
}