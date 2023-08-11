package com.test.java.obj;

public class Cup {
	private int size;
	private String color;
	
	/* 
	 	컴파일러가 자동으로 생성하는 코드  => 기본 생성자
	 	개발자가 직접 생성자를 구현하면, 컴파일러는 생성자를 안만들어준다.
	 	
	   	1. 메소드명이 클래스명과 동일하다.(반드시 일치)
	   	2. 반환형이 생략되어 있다. : 반환값을 가질 수 없다.-> 무조건 void라서 생략된거임.
	   	3. 구현부(안쪽)는 일반 메소드이다. 
	   	
	   	생성자의 역할 : 멤버를 초기화하는 전용 메소드, 방금 new가 만든 갓 태어난 객체를 초기화하는 역할
	   // this.color="yellow" / this.size=300;
	   	*/
	
	public Cup() {
		//this.color="yellow";
		//this.size=300;
		this("yellow",300);
	}
	
	public Cup(String color) {   //메소드 오버로딩
		//this.color=color;
		//this.size=300;
		this(color,300);
	}
	
	public Cup(int size) {   //메소드 오버로딩
	//	this.color="yellow";
		/*
		if(size>0 &&size<3000) {
			this.size=size;
		}
		*/
		this("yellow",300);  //생성자 위임.
	}
	
	public Cup(String clor,int size) {
		this.color=color;
		if(size>0 &&size<3000) {
			this.size=size;
		}
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String info() {
		
		return "색상 : "+this.color+", 크기 : "+this.size;
	}
	
}
