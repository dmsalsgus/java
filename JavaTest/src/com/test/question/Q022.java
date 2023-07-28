package com.test.question;
import java.util.*;

public class Q022 {//남녀 커플의 이름과 만난날을 입력받아 기념일을 출력하시오.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("남자 이름 : ");
		String man_name=sc.nextLine();
		System.out.print("여자 이름 : ");
		String woman_name=sc.nextLine();
		System.out.print("만난날(년) : ");
		int year=sc.nextInt();
		System.out.print("만난날(월) : ");
		int month=sc.nextInt();
		System.out.print("만난날(일) : ");
		int date=sc.nextInt();
		
		Calendar now=Calendar.getInstance(); //현재 시각 생성.
		now.set(year,month-1,date);  //입력받은 만난날로 now다시 설정하기.
		//month는 0부터 시작하기 때문에 -1.
		System.out.printf("\'%s\'과(와) \'%s\'의 기념일\n",man_name,woman_name);
		now.add(Calendar.DATE,100);  
		System.out.printf("100일 : %tF\n",now);
		now.add(Calendar.DATE,100);
		System.out.printf("200일 : %tF\n",now);
		now.add(Calendar.DATE,100);
		System.out.printf("300일 : %tF\n",now);
		now.add(Calendar.DATE,200);
		System.out.printf("500일 : %tF\n",now);
		now.add(Calendar.DATE,500);
		System.out.printf("1000일 : %tF\n",now);
		
	}
}