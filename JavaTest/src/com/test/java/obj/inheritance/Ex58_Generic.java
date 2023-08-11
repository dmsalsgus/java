package com.test.java.obj.inheritance;

public class Ex58_Generic {
	public static void main(String[] args) {
		
		Item<String> item=new Item<String>();  // T 부분에 우리가 사용하는 자료형 중에 하나 넣기.
		item.c="문자열";
		Item<Integer> item2=new Item<Integer>();   //int는 안됨.
		item2.c=10;
		
		Pen<Boolean> p1= new Pen<Boolean>();
		p1.a=true;
		p1.b=false;
		p1.c=true;
		
		Note<String, Integer> note=new Note<String, Integer>("홍길동",20);
		System.out.println(note.getA());  //String
		System.out.println(note.getB());  //Integer
		
		
		
		
	}
}
//제네릭 클래스
// T : 타입변수(메소드의 매개변수 역할) -> 자료형을 전달하는 변수 -> 반드시 참조형만 가능.(int x, Integer o)
// <> : 인자 리스트(메소드의 ()역할)
class Item<T>{ 
	public int a;
	public int b;
	public T c;    //클래스 선언까지는 결정이 안되고, 객체를 생성할 때 결정된다.
	//다 넣을 수 있는 것이 마치 Object와 비슷하다.
	
}
class Pen<T>{
	public T a;
	public T b;
	public T c;
}
class Desk<T>{
	public T a; //멤버 변수의 자료형
	public void set(T a) {  //넘어오는 변수의 타입을 예측못하니 이렇게도 사용가능.
		//메소드 매개변수의 자료형
		this.a=a;
		
		T b;  //-> 가능하지만 권장x.
	}
	public T get() {  //메소드 반환타입
		return this.a;
	}
	
}
class Note<T, U>{   //대소문자 안가리지만 보통 한글자 대문자로 받고, 개수 지정도 가능. 
	public T a;
	public U b;
	
	public Note(T a, U b) {
		this.a=a;
		this.b=b;
	}
	public T getA() {
		return this.a;
	}
	public U getB() {
		return this.b;
	}
	
}




