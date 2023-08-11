package com.test.java.obj;

public class Ex49_static {
	public static void main(String[] args) {
		//Q. 펜을 생산하시오. -> 생산된 펜의 개수를 세시오.
		/*
		//1.첫번째 방법
		//Pen객체(클래스)와 cnt간의 관계가 약함. -> cnt가 꼭 펜의 개수 셀 때 사용하라는 법은 없기때문, 또한 누락하면 오차가 발생하게됨.
		int cnt=0;
		Pen p1=new Pen("MonAmi","black"); cnt++;
		Pen p2=new Pen("MonAmi","black"); cnt++;
		Pen p3=new Pen("MonAmi","black"); cnt++;
		System.out.println("펜 개수 : "+cnt);
		*/
		/*
		//2.두번째 방법 : pen과 cnt간의 결합을 강화시키기  //cnt변수를 pen 클래스 안에 만들기
		//객체 변수가 여러개 발생하고, 그 중 1개를 사용한다고 했을 때 왜 그 객체의 cnt를 사용해야하는지에 대한 당위성이 없음.
		Pen p1=new Pen("MonAmi","black"); p1.cnt++;
		Pen p2=new Pen("MonAmi","black"); p1.cnt++;
		Pen p3=new Pen("MonAmi","black"); p1.cnt++;
		System.out.println("펜 개수 : "+p1.cnt);  //cnt를 p1으로 해서 몰아주기 -> 근데 말이 안됨. 왜 p1이 전부 맡아야함?ㅡㅅㅡ
		*/
		/*
		//3. 세번째 방법 : pen과 cnt의 관계를 강하게 하면서, cnt변수를 딱 1개만 만들기 -> cnt 변수를 static으로 해주면 됨.
		Pen p1=new Pen("MonAmi","black"); Pen.cnt++;
		Pen p2=new Pen("MonAmi","black"); Pen.cnt++;
		Pen p3=new Pen("MonAmi","black"); Pen.cnt++;
		System.out.println("펜 개수 : "+Pen.cnt);  //공용으로 관리.
		*/
		//4.네번째 방법  => Pen.cnt++;을 생성자 초기화에 넣어주기 
		Pen p1=new Pen("MonAmi","black"); 
		Pen p2=new Pen("MonAmi","black"); 
		Pen p3=new Pen("MonAmi","black"); 
		System.out.println("펜 개수 : "+Pen.cnt);  
		
	}
}
class Pen{
	private String model;
	private String color;
	public static int cnt=0;   //편의상 public으로, private으로 하면 getter/setter를 만들어야함.
	//static은 모든 변수가 사용할 수 있어야 한다.
	
	public Pen(String model, String color) {  //생성자 초기화
		this.model=model;
		this.color=color;
		Pen.cnt++;
	}
	
	//  alt+shift+s => Generate toString()  //여러 출력 방식을 선택할 수 있다. (String.format, StringBuilder, 메소드 체인 방식 등등)
	@Override  
	public String toString() {
		return String.format("Pen [model=%s, color=%s]", model, color);
	} 
	
	
}



