package com.test.java.lambda;
import java.io.*;
import java.util.*;

public class Ex72_Lambda {
	public static void main(String[] args) {
		//람다식(Lambda Expression) : 함수형 프로그래밍을 지원한다.
		//자바에서 람다식을 지원하는 이유 : 컬렉션 조작(=스트림)을 위해.
		//람다식을 사용하면 코드가 간결해진다.
		//람다식은 자바의 메소드의 다른 간결한 표현이다.
		//람다식은 매개변수를 가지는 코드블럭이다.(=메소드)
		//단점 : 자바의 람다식은 인터페이스를 사용해서 만든다.(자바만의 특징)
		
		//람다식 형식==> 인터페이스 변수=람다식;   ex) MyInterface m1=() -> {};    //화살표는 실제 문법식에 있는 표현
		//(매개변수) -> {실행코드};
		//a. (매개변수) : 메소드의 매개변수 리스트와 동일
		//b. -> : 화살표(Arrow), 코드블럭 호출역할
		//c. {실행코드} : 메소드의 구현부와 동일
		
		//m1();
		//m2();
		m3();
		
	}

	private static void m3() {
		// 1. 파일 읽기
		try {
			BufferedReader reader= new BufferedReader(new FileReader("C:\\Users\\leeje\\OneDrive\\바탕 화면\\학원\\과제 문제\\파일_입출력_문제\\성적.dat"));
			
			ArrayList<Student> list = new ArrayList<Student>();
			
			String line=null;
			while((line=reader.readLine())!=null) {
				//System.out.println();
				//텍스트 한줄을 Student 객체 1개로 생성
				
				String[] temp=line.split(",");
				Student s=new Student (temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
				
				list.add(s);
			}
			//System.out.println(list);
			
			//성적순으로 정렬하기
			/*
			list.sort(new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o2.getTotal()-o1.getTotal();
				}
			} );
			*/
			//위의 주석을 람다식으로 간단하게 표현한 것이 아래 식.
			list.sort((o1,o2) -> o2.getTotal()-o1.getTotal());
			
			for(Student s: list) {
				System.out.println(s.getName()+" : "+s.getTotal());
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at Ex72_Lambda.java");
			e.printStackTrace();
		}
		
	}

	private static void m2() {
		//람다식 활용 == 익명 클래스(객체) 활용
		
		Random rnd=new Random();
		System.out.println(rnd.nextInt(10));  //0부터 9까지의 난수를 출력.
		
		ArrayList<Integer> nums= new ArrayList<Integer>();
		
		for(int i=0; i<10; i++) {
			nums.add(rnd.nextInt(10)+1);  //1~9까지
		}
		System.out.println(nums);
		nums.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		} );
		System.out.println(nums);
		nums.sort((Integer o1, Integer o2)->{ return o1-o2; } );
		
		////람다식으로 간결하게 표현.
		nums.sort((o1,o2)->o1-o2);   //오름차순
		System.out.println(nums);
		
		nums.sort((o1,o2)->o1-o2);  //내림차순
		System.out.println(nums);
		
	}

	private static void m1() {
		//Q. MyInterface를 구현한 객체를 1개 만드시오.
		MyInterface m1=new MyClass();
		m1.test();
		////////////////////////////////////////////////////////////////////
		MyInterface m2=new MyInterface() {
			@Override
			public void test() {
				System.out.println("익명 클래스에서 구현한 메소드");
			}
		};
		m2.test();
		/////////////////////////////////////////////////////////////////////
		MyInterface m3= () -> {
			System.out.println("람다식에서 구현한 메소드");
		};
		m3.test();
		
		/////////////////////////////////////////////////////////////////
		//
		NoParameterNoReturn pr1= new NoParameterNoReturn() {
			@Override
			public void call() {
				System.out.println("pr1");
			}
		};
		
		NoParameterNoReturn pr2=() -> { System.out.println("pr2"); };
		pr2.call();
		
		NoParameterNoReturn pr3=() -> System.out.println("pr3");   //대괄호도 생략 가능.(실행블럭의 문장이 하나이면.)
		pr2.call();
		
		////////////////////////////////////////////////////////////////// ///////pr1==pr2==pr3
		
		ParameterNoReturn pr4= (int num) -> System.out.println(num);
		pr4.call(100);
		pr4.call(200);
		
		////////////////////////////////////
		//매개변수의 자료형을 생략할 수 있다.
		ParameterNoReturn pr5= (num) -> System.out.println(num);
		pr5.call(400);
		pr5.call(500);
		
		///////////////////////////////////
		//매개변수의 ()을 생략할 수 있다.
		ParameterNoReturn pr6= num -> System.out.println(num);
		pr6.call(600);
		pr6.call(700);

		//////////////////////////////////////////////////////////////////////////pr4==pr5==pr6

		MultiParameterNoReturn pr7=(String name, int age) -> System.out.println(name+","+age);
		pr7.call("홍길동",20);
		
		/////////////////
		//매개변수가 2개 이상이면 소괄호 생략 불가능.
		MultiParameterNoReturn pr8 = (name, age) -> System.out.println(name+","+age);
		pr8.call("아무개", 25);
		
		////////////////////////////////////////////////////////////////////////////pr7==pr8
		
		NoParameterReturn pr9 = () -> { return 100; };
		System.out.println(pr9.call());
		
		///////////return문 하나만 존재하면 return도 생략이 가능하다.
		
		NoParameterReturn pr10 = () -> 100;
		System.out.println(pr10.call()); 
		
		//////////////////////////////////////////////////////////////////////////pr9==pr10
		
		ParameterReturn pr11 = name -> name.length();
		System.out.println(pr11.call("홍길동"));   //3
		System.out.println(pr11.call("남궁길동"));   //4
	}
}
interface MyInterface{
	void test();
}
class MyClass implements MyInterface{
	@Override
	public void test() {
		System.out.println("실명 클래스에서 구현한 메소드");
	}
}
interface NoParameterNoReturn{
	void call();
}
interface ParameterNoReturn{
	void call(int num);
}
interface MultiParameterNoReturn{
	void call(String name, int age);
}
interface NoParameterReturn{
	int call();
}
interface ParameterReturn{
	int call(String name);
}

class Student{
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public int getTotal() {
		return this.kor+this.eng+this.math;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	
	@Override
	public String toString() {
		return String.format("Student [name=%s, kor=%s, eng=%s, math=%s]", name, kor, eng, math);
	}
	
}


