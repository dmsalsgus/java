package com.test.java.obj;
import java.util.*;

public class Ex39_Access {
	public static void main(String[] args) {
		//접근 지정자(제어자, Access Modifier) : 주로 클래스 멤버(클래스 멤버 변수, 클래스 멤버 메소드)에 붙여서 사용한다.
		//                                               : 클래스 자체에 붙여서 사용한다. 지역변수에는 사용이 불가능하다.
		//                                              : 클래스(객체)의 영역을 기준으로, 외부에 해당 멤버를 어떻게 노출할지 통제하는 역할-> 보안 수준 제어
		//                                               : 객체를 기준으로 public과 private이 나눠짐.
		//1. public
		//2. private
		//--------------
		//3. protected : 상속을 배워야 알 수 있음
		//4. default : 패키지를 배워야 알 수 있음
		
		Box box=new Box();  
		box.color="갈색";  //box.했을때 color는 나타남.   //public
		//box.size=100;                                         //private
		box.aaa();
		//box.bbb();
		
		//Book객체
		Book book=new Book();
		
		/*
		book.title="자바의 정석";
		book.author="홍길동";
		book.publisher="도우출판";
		book.price=30000;
		book.page=1000;
		
		
		int temp=30000;  //책 가격
		
		if(temp>=0 && temp<=100000) {  //유효성 검사
			book.price=temp;
		}
		System.out.println(book.price);
		*/
		/*
		book.aaa("자바의 정석");
		book.bbb(30000);    //쓰기 작업   //Setter
		System.out.println("책가격 : "+book.ccc());   //읽기 작업    //Getter
		*/
		
		book.setTitle("자바의 정석");
		System.out.println(book.getTitle());
		
		/////////위에까지는 book, 밑에서부터는 mouse.
		
		Mouse m1 = new Mouse();  //클래스 선언
	    m1.setModel("M910");
	    System.out.println(m1.getModel());
	    
	    //쓰기 전용
	    //m1.price = 50000;
	    m1.setPrice(50000);
	    //System.out.println(m1.getPrice);
	  
	    //읽기 전용
	    System.out.println(m1.getColor());
	   
	    //Getter/Setter 역할
	    //1.private 멤버 -> 인터페이스 역할
	    //2.읽기 전용 멤버, 쓰기 전용 멤버
	      
	    /*
	    Calendar date=Calendar.getInstance();
	    date.add(Calendar.YEAR,-3);
	    
		m1.setDate(date);
		
		System.out.printf("마우스 제조년월일 : %tF\n",m1.getDate());
		*/
	      
	    //m1.getState > private String state;
	      
	    //(객체) 사용자 편의성 향상
	    m1.setDate(2020,7,31);
	    System.out.println(m1.getDate());  
	    
	    System.out.println(m1.getState());   //구형인지 신형인지
	    System.out.println(m1.info());  //개발자가 객체의 상태를 확인하고 싶을 때 사용하는 메소드  >> dump.
		
	}
}