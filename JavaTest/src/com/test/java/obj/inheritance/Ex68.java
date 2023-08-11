package com.test.java.obj.inheritance;

public class Ex68 {
	public static void main(String[] args) {
		//this vs super;
		//둘 다 객체 지정 연산자
		//this : 자기 자신
		//super : 부모
		
		CupParent p1=new CupParent();
		p1.check();
		
		CupChild c1= new CupChild();
		c1.check();
		
	}
}
class CupParent{
	private int a=10;
	public int b=20;
	
	public void check() {
		System.out.println(this.a);
		System.out.println(this.b);
	}
}
class CupChild extends CupParent{
	private int c=30;
	public int d=40;
	
	public void check() {
		System.out.println(this.c);
		System.out.println(this.d);
		
		//System.out.println(this.a);  //private에는 부모 자식도 없다.
		//System.out.println(this.b);
		//this.check();  //이거는 자기자신의check를 호출하는 것이라 무한루프로 돌아감.
		super.check();  //이게 부모의 check()를 호출하는 것. -> 그러면 private int a도 접근가능.
	}
	public CupChild(int c, int d) {
		//super(); 
		this.c = c;
		this.d = d;
	}
	public CupChild() {
		// TODO Auto-generated constructor stub
	}
	
}