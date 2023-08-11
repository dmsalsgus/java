package com.test.java.obj;

public class Book {  //Ex39_Access
	//접근 지정자의 가이드라인
	//1. 멤버 변수는 무조건 private을 사용한다.
	//2. Getter/Setter를 구현한다.  //유효성 검사
	
	/*
	public String title;
	public String author;
	public String publisher;
	public int price;
	public int page;
	*/
	
	private String title;
	private String author;
	private String publisher;
	private int price;
	private int page;
	
	public void aaa(String a) {  //포인트는 public
		title=a;  //title은 private으로 밖에서 안보이는데 public메소드를 통해 사용할 수 있다.
		//tihs.title=a; 이런식을 권장함.
	}
	public void bbb(int b) {
		if(b>=0 &&b<=100000) price=b;
		else System.out.println("올바른 책 가격이 아닙니다.");
		
	}
	public int ccc() {
		return price;   //'읽기'는 데이터의 손상 없다.
	}
	// Setter/Getter는 객체 내외부를 연결하는 통로, 인터페이스 역할을 하는 것이다.(프로퍼티, Property)
	
	//Setter : 이름이 보통 set멤버변수명 / 반환형이 void 
	public void setTitle(String title) {
		//멤버변수 = 매개변수
		//title=title;
		//title : 무조건 누구를 가리킨다.(이미 정해져있음.)
		//***영역이 큰 요소와 영역이 작은 요소가 충돌하면, 반드시 작은 영역의 요소를 우선한다. -> 대부분의 프로그래밍 환경에서 적용
		
		//멤버변수 : 클래스 전역 title 
		//지역 변수 : 메소드 전역 title
		
		this.title=title;   //this를 연산자(객체 접근 연산자)라고 부름, '나' 객체 자기 자신을 가리키는 표현(예약어)
		
	}
	//Getter
	//1. get멤버변수명
	//2. return 값
	   public String getTitle() {  //get은 this 생략 가능.
		   return this.title;  //==return title;
	   }
	   public String getAuthor() {
		   return author;
	   }
		   public void setAuthor(String author) {
		      this.author = author;
		   }
		   public String getPublisher() {
		      return publisher;
		   }
		   public void setPublisher(String publisher) {
		      this.publisher = publisher;
		   }
		   public int getPrice() {
		      return price;
		   }
		   public void setPrice(int price) {
		      this.price = price;
		   }
		   public int getPage() {
		      return page;
		   }
		   public void setPage(int page) {
		      this.page = page;
		   }

}