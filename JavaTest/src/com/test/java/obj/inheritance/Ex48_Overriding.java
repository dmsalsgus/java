package com.test.java.obj.inheritance;
import java.util.*;

public class Ex48_Overriding {
	public static void main(String[] args) {
		//대중적인 오버라이딩
		
		Time t1=new Time(2,30);
		
		System.out.println(t1);  //주소 알려주는 것
		System.out.println(t1.toString());  //주소 알려주는 것, 위와 동일.  //String java.lang.Object.toString()
		// 전세계 개발자가 다 아는 이름  //2:30
		
		System.out.println(t1.info());  //=> 내가 만든 거니까 나밖에 모름.  //2:30
		
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.toString());  
		
	}
}
class Time{
	private int hour;
	private int min;
	
	public Time(int hour, int min) {
		this.hour=hour;
		this.min=min;
	}
	
	public String info() {  //덤프  //toString 대신으로 info 썼던 것. -> 이제는 toString을 오버라이딩해서 사용할 것.
		return this.hour+":"+this.min;
	}
	@Override  //'어노테이션(Annotation)'이라고 불림.  //ctrl+space
	public String toString() {  //Object 클래스에서 물려받은 toString을 다시 재정의=메소드 오버라이딩
		return this.hour+":"+this.min;
	}
	
}

