package com.test.java.obj;

public class Box {    //Ex39_Access
	public String color;  
	//public은 해당 클래스 외부에 이 멤버를 공개하겠다.
	
	private int size;
	//private은 해당 클래스 외부에 이 멤버를 비공개하겠다.-> 내부 전용 변수
	//왜? -> 위험해서, 공개할 필요가 없어서
	
	public void aaa() {
		System.out.println("aaa");
		
		//같은 클래스 내부에서 같은 멤버끼리는 접근지정자가 동작하지 않는다. 
		color="노랑";
		size=200;
	}
	
	private void bbb() {
		System.out.println("bbb");
	}
}