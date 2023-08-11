package com.test.java.obj;

public class Ex42_Constructor {
	public static void main(String[] args) {
		//Constructor (생성자) : (특수한 목적을 가지는) 메소드, 멤버를 초기화 하는 역할
		
		//자료형 변수명= new 생성자();
		//Box box=new Box();
		
		//배열 포함 모든 참조형은 객체 생성 직후 자동으로 멤버가 초기화가 된다.
		//1. new : 객체 생성 연산자 : 객체를 생성한다.
		//2. Cup() : 생성자라는 메소드가 호출되면서 값이 초기화 된다.
		
		Cup c1= new Cup();
		
		//c1.setColor("yellow");
		//c1.setSize(300);
		System.out.println(c1.info());   // 색상 : null, 크기 : 0
		
		Cup c2=new Cup();
		c2.setColor("녹색");
		c2.setSize(500);
		System.out.println(c2.info());
		
		Cup c3=new Cup("pink");
		System.out.println(c3.info());
		
		Cup c4=new Cup(350);
		System.out.println(c4.info());
		
		Cup c5=new Cup("Orange",600);
		System.out.println(c5.info());
		
		//Cup();  //The method is undefined -> Cup()을 일반 메소드 취급한다.
		//생성자는 반드시 new와 함께 사용이 가능하다. -> 생성자는 평색 딱 한번만 호출 가능하다.
		
	}
}
