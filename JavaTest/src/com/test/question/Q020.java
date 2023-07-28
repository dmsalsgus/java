package com.test.question;
import java.util.*;

public class Q020 { //오늘 태어난 아이의 백일과 첫돌을 출력하시오.
	public static void main(String[] args) {
		Calendar now=Calendar.getInstance();  //현재 시각
		
		now.add(Calendar.DATE,100);
		System.out.printf("백일 : %tF\n",now);  //백일
		
		now=Calendar.getInstance();  //현재 시각 다시 불러오기
		now.add(Calendar.YEAR, 1);
		System.out.printf("첫돌 : %tF\n",now);  //첫돌
	}
}