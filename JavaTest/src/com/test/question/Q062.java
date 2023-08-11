package com.test.question;
import java.util.*;

public class Q062 {  //학생의 이름을 N개 입력받아 아래와 같이 출력하시오.
	//이름을 오름차순 정렬하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수 : ");
		int cnt=sc.nextInt();
		String[] student=new String[cnt];  //학생 수 크기만큼의 student 배열 생성.
		
		for(int i=0; i<cnt; i++) {
			System.out.print("학생명 : ");
			student[i]=sc.next();
		}
		Arrays.sort(student);
		System.out.printf("입력한 학생은 총 %d명입니다.\n",cnt);
		/*
		for(int i=0; i<cnt-1; i++) {
			for(int j=0; j<cnt-i-1; j++) {
				if(student[j].compareTo(student[j+i])>0) {  //student[j]가 [j+1]보다 큼
					String temp=student[j];
					student[j]=student[j+1];
					student[j+1]=temp;	
				}
			}
		}*/
		for(int i=0; i<cnt; i++) {
			System.out.printf("%d. %s\n",i+1,student[i]);
		}
	}
}