package com.test.java.obj;

public class Ex40_Class {  //Person
	public static void main(String[] args) {
		Person hong = new Person();
		hong.setName("홍길동");
		hong.setAge(20);
		hong.setGender("남자");
		
		Person father=new Person();
		father.setName("홍아빠");
		father.setAge(50);
		father.setGender("남자");
		
		Person mother=new Person();
		mother.setName("최엄마");
		mother.setAge(48);
		mother.setGender("여자");
		
		hong.setFather(father);  //아빠라고 관계형성
		hong.setMother(mother);
		
		System.out.println(hong.info());
		
		//java.lang.NullPointerException 에러 -> 변수안에 아무것도 안들어간 것
		//System.out.println(father.info());
		
	}
}
