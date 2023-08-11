package com.test.question.q94;
import java.util.*;

class Bugles {
	   private int price;  //가격
	   private int weight;   //용량
	   private Calendar creationTime;  //생산일자
	   private int expiration;  //유통기한

	   //getter, setter 구현
	   
	   //용량
	   public void setSize(int weight) {  //쓰기
		   weight=(weight>=850)?850:((weight>=500)?500:300);
		   this.weight=weight;
	   }
	 //가격 && 남은 유통기한 설정하기
	   public String getPrice() {   //읽기
		   if(weight==300) { price=850; expiration=7; }
		   else if(weight==500) { price=1200; expiration=10; }
		   else { price=1850; expiration=15; }
		   return String.format("%,d",price);
	   }
	   //생산일자
	   public void setCreationTime(String day) {  //쓰기
		   Calendar c=Calendar.getInstance();
		   String[] temp=day.split("-");
		   int year=Integer.parseInt(temp[0]);
		   int month=Integer.parseInt(temp[1]);
		   int date=Integer.parseInt(temp[2]);
		   c.set(year,month-1,date);  //month-1 까먹지 말기
		   this.creationTime=c;
	   }
	   //유통기한 계산
	   public int getExpiration() {
		   Calendar now=Calendar.getInstance();  //현재
		   return this.expiration-(int) ((now.getTimeInMillis()-this.creationTime.getTimeInMillis())/1000/60/60/24);
	   }
	   
	   public void eat() {
		   if(getExpiration()>=0) {
			   System.out.printf("과자를 맛있게 먹습니다.\n");
		   }else System.out.printf("유통기한이 지나 먹을 수 없습니다.\n");
		   
	   }
	}