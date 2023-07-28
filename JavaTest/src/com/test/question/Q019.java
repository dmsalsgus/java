package com.test.question;
import java.util.*;

public class Q019 {//현재 시간을 출력하는 메소드 선언하시오.
	public static void main(String[] args) {
		nowTime();	
		
	}
	public static void nowTime() {
		Calendar now=Calendar.getInstance();  //현재시각
		
		System.out.printf("현재 시간 : %d시 %02d분 %02d초\n",now.get(Calendar.HOUR_OF_DAY),now.get(Calendar.MINUTE),now.get(Calendar.SECOND));
		System.out.printf("현재 시간 : %s %d시 %02d분 %02d초\n",now.get(Calendar.AM_PM)==0?"오전":"오후",now.get(Calendar.HOUR),now.get(Calendar.MINUTE),now.get(Calendar.SECOND));
		
	}
}