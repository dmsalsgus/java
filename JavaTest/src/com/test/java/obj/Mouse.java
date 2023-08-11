package com.test.java.obj;
import java.util.*;

public class Mouse {  //Ex39_Access
	private String model="M301";
	private int price=30000;
	private String color="white";
	private Calendar date;  //마우스 제조날짜
	
	public String getModel() {   //get은 this 생략가능.
		return model;
	}
	public void setModel(String model) {   //set은 this 생략불가능!
		this.model=model;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public String getColor() {
		return color;
	}
	/*
	public void getDate(Calendar date) {
		return date;
	}
	public void setDate(Calendar date) {
		this.date=date;
	}
	*/
	
	//계산된 프로퍼티 : getter와 setter는 기본적으로 private멤버 변수를 조작하지만, 그게 필수가 아니다.
	//멤버 변수와 무관한 getter와 setter를 만들기도 한다.
	public String getState() {
		if(this.date.get(Calendar.YEAR)<=2021) {
			return "구형";
		}else return "신형";
	}
	public void setDate(int year, int month, int date) {
		Calendar c= Calendar.getInstance();
		c.set(year, month-1, date);
		this.date=c;
	}
	public String getDate() {
		//System.out.printf("%tF",this.date);     //그냥 출력만 -> 자바 콘솔 수업에서만 사용 가능
		return String.format("%tF",this.date);   //반환 -> 모든 분야에서 사용 가능
	}
	//m1의 현재 모든 상태를 확인하고 싶으면?
	public String info() {   //문자열 덤프 메소드 만들기.
		String temp="[";
		temp+=this.model+",";
		temp+=this.price+",";
		temp+=this.color+",";
		temp+=String.format("%tF",this.date);
		
		temp+="]";
		return temp;
	}
	
}