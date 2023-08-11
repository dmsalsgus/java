package com.test.java.lambda;
import java.util.*;
import java.util.function.*;

public class Ex73_Lambda {
	public static void main(String[] args) {
		//람다식 : 익명 객체의(구현된) 추상 메소드이며, 인터페이스 변수에 저장된다.
		//         : 람다식은 반드시 인터페이스가 필요하다!!
		
		//함수형 인터페이스(Functional Interface) : 람다식을 사용하기 위한 자격(다른 용도로는 사용안함)
		// 표준 API 함수형 인터페이스(jdk에서 미리 만들어진)와 사용자 정의 함수형 인터페이스(개발자가 만든)가 있다.
		
		//표준 API 함수형 인터페이스 : 추상메소드 딱 1개를 가진다는 공통점이 있다.
		//1. Consumer : Consumer<T>, BiConsumer<T>, IntConsumer 등등
		//                 : 매개변수가 있고, 반환값이 없는 형식(데이터 받아서 소비만 하고 반환은 없는.)
		//2. Supplier : Supplier<T> 등등
		//               : 매개변수는 없고, 반환값은 있는 형식
		//3. Function : Function<T, R>,BiFunction<T, U, R> 등등 
		//               : 매개변수도 있고, 반환값도 있는 형식
		//4. Operator : BinaryOperator<T>
		//                : 매개변수도 있고, 반환값도 있는 형식 -> Operator는 Function의 하위셋이므로 겹치는게 맞음.
		//5. Predicate : Predicate<T>
		//                : 매개변수도 있고, 반환값도 있는 형식 -> Predicate도 Function의 하위셋.
		
		/*
		Test t1=()->System.out.println("aaa");  //람다식 표현
		t1.aaa();
		*/
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		m6();
	}

	private static void m6() {
		//표준 API 함수형 인터페이스의 정적/디폴트 메소드
		// 람다 객체들의 연산자 역할
		
		//업무 1. 
		Student s1 = new Student("홍길동", 100, 90, 80);
		Consumer<Student> c1= s -> System.out.println("총점 : "+s.getTotal());
		c1.accept(s1);
		
		//업무 2.
		Consumer<Student> c2= s -> System.out.println("총점 : "+s.getTotal());
		c1.accept(s1);
		
		//업무 1과 업무 2를 동시에 실행하기
		test(s1, c1, c2);
		
		Consumer<Student> c4= s -> System.out.println("평균 : "+s.getTotal()/3.0);
		
		//
		Consumer<Student> c3=c1.andThen(c2).andThen(c4);
		c3.accept(s1);
		System.out.println();
		
		//
		Function<Integer, Boolean> f1=num -> num>0;
		System.out.println(f1.apply(10));
		
		Function<Boolean, String> f2=flag-> flag ? "성공" : "실패";
		System.out.println(f2.apply(true));
		
		Function<Integer, String> f3= f1.andThen(f2);   //f1의 매개변수, f2의 반환값
		System.out.println(f3.apply(-10));  //실패
		
		//
		Function<Integer, String> f4 = num -> num>0 ? "참" : "거짓";
		Function<String, Integer> f5 = str -> str.length();
		
		Function<Integer, Integer> f6 = f4.andThen(f5);   //f4 + f5
		System.out.println(f6.apply(-10));
		
		Function<Integer, Integer> f7 = f5.compose(f4);  //f5 + f4
		System.out.println(f7.apply(-10));
		//위의 애들은 순서가 중요.
		
		
		///////////////////////
		//Predicate
		//2의 배수
		Predicate<Integer> p1 = num -> num%2==0;
		//3의 배수
		Predicate<Integer> p2 = num -> num%3==0;
		
		int a=10;
		System.out.println(p1.test(a));   //true
		System.out.println(p2.test(a));   //false
		
		//a가 2와 3의 공배수?
		System.out.println(p1.test(a) && p2.test(a));
		
		//p1 + p2 == p1 and p2  == p1 && p2
		Predicate<Integer> p3=p1.and(p2);
		System.out.println(p3.test(a));
		
		//
		System.out.println(p1.test(a) || p2.test(a));
		Predicate<Integer> p4=p1.or(p2);
		System.out.println(p4.test(a));
		
		//
		System.out.println(!p1.test(a));
		Predicate<Integer> p5=p1.negate();
		System.out.println(p5.test(a));
		
	}

	private static void test(Student s1, Consumer<Student> c1, Consumer<Student> c2) {
		c1.accept(s1);
		c2.accept(s1);
	}

	private static void m5() {
		// Operator : 매개변수를 전달하면 처리 후, 반환값을 돌려주는 업무를 구현.
		//             : 매개변수O, 반환값O
		//             : testXXX() 추상 메소드를 제공
		//             : Function의 하위셋.
		//             : 매개변수를 전달받아 Boolean형을 반환한다.
		
		Function<Integer, Boolean> f1= num -> num>0;
		Predicate<Integer>           p1= num -> num>0;
		
		System.out.println(f1.apply(10));
		System.out.println(f1.apply(-10));
		
		System.out.println(p1.test(10));
		System.out.println(p1.test(-10));
		
		BiPredicate<Integer, Integer> bp2 = (a, b) -> a>b;
		System.out.println(bp2.test(10, 20));
		System.out.println(bp2.test(20, 10));
		
	}

	private static void m4() {
		// Operator : 매개변수를 전달하면 처리 후, 반환값을 돌려주는 업무를 구현.
		//             : 매개변수O, 반환값O
		//             : applyXXX() 추상 메소드를 제공
		//             : Function의 하위셋.
		//             : 매개변수와 반환값이 타입이 같다.
		
		BinaryOperator<Integer> bo1=(a, b) -> a+b;
		System.out.println(bo1.apply(10, 20));
		//아래랑 같은 
		BiFunction<Integer, Integer, Integer> bf1 = (a, b) -> a+b;   //앞에 Integer 2개가 매개변수고, 마지막 Integer는 반환값이다.
		System.out.println(bf1.apply(10, 20));
		
		//
		UnaryOperator<Integer> uo1=num -> num*num;
		System.out.println(uo1.apply(10));
		
	}

	private static void m3() {
		// Function : 매개변수를 전달하면 처리 후, 반환값을 돌려주는 업무를 구현.
		//             : 매개변수O, 반환값O
		//             : applyXXX() 추상 메소드를 제공
		
		Function<Integer, Boolean> f1 = num -> num>0;
		System.out.println(f1.apply(10));
		System.out.println(f1.apply(-10));
		
		Function<String, Integer> f2= str -> str.length();
		System.out.println(f2.apply("홍길동"));
		System.out.println(f2.apply("안녕하세요"));
		
		Function<Student, Boolean> f3= s -> {
			return s.getTotal()>=180 ? true : false;
		};
		if(f3.apply(new Student("홍길동", 100, 90, 80))) {
			System.out.println("합격");
		}else System.out.println("불합격");
		
		//
		BiFunction<Integer, Integer, Integer> bf1 = (a,b) -> a+b;   //앞에 Integer 2개가 매개변수고, 마지막 Integer는 반환값이다.
		System.out.println(bf1.apply(10, 20));
		
		//
		DoubleToIntFunction dtf=num-> (int)num;  //캐스팅
		System.out.println(dtf.applyAsInt(3.14));
		
	}

	private static void m2() {
		// Supplier : 매개변수 없이 반환값을 돌려주는 업무를 구현
		//            : 매개변수X, 반환값O
		//            : getXXX() 추상 메소드 제공
		
		Supplier<Integer> s1=()->100;
		System.out.println(s1.get());
		
		Supplier<Double> s2=()->Math.random();
		System.out.println(s2.get());
		
		Supplier<String> s3=()->"홍길동";
		System.out.println(s3.get());
		
		Supplier<Student> s4=()->new Student("홍길동", 100, 90, 80);
		System.out.println(s4.get());
		
		//
		IntSupplier s5=()->200;     //int
		System.out.println(s5.getAsInt());   //get()대신 getAsInt()
		
	}

	private static void m1() {
		// Consumer : 매개변수를 받아서 소비하는 업무를 구현. 
		//              : 매개변수 O, 반환값 X을 가지는 추상메소드
		//              : acceptXXX() 추상 메소드 제공
		
		MyConsumer m1= num->System.out.println(num*num);
		m1.test(10);
		
		Consumer<Integer> c1= num -> System.out.println(num*num);
		c1.accept(5);
		//
		Consumer<String> c2=str->System.out.println(str.length());
		c2.accept("홍길동");
		//
		Consumer<Integer> c3=cnt->{
			for(int i=0; i<cnt; i++) {
				System.out.println(i);
			}
			System.out.println();
		};
		c3.accept(5);
		//
		Consumer<Student> c4= s->{
			System.out.println("이름 : "+s.getName());
			System.out.println("국어 : "+s.getKor());
			System.out.println("영어 : "+s.getEng());
			System.out.println("수학 : "+s.getMath());
			System.out.println("총점 : "+s.getTotal());
		};
		c4.accept(new Student("홍길동", 100, 90, 80));
		System.out.println();
		
		//
		BiConsumer<String, Integer> bc1=(name, age)->{
			System.out.printf("이름 : %s, 나이 : %d\n", name, age);
		};
		bc1.accept("홍길동", 20);
		System.out.println();
		
		//
		IntConsumer ic1=num->System.out.println(num*num);  //Int라고 붙어있으니 굳이 제네릭 안씀.
		ic1.accept(10);
		
	}
}
@FunctionalInterface  //람다식으로 구현할 것이다.
interface MyConsumer{
	void test(int num);
}
//람다식을 저장하는 목적의 인터페이스 vs 일반적인 인터페이스 : 차이가 하나 있다.

@FunctionalInterface
interface Test{  
	void aaa();
	//void bbb();  //The target type of this expression must be a functional interface
	//위에서 오류남. -> 람다식은 메소드를 하나만 정의할 수 있다.
	//함수형 인터페이스는 추상 메소드를 딱 1개만 가질 수 있다. -> 그 1개의 추상 메소드가 곧 람다식이 되기 때문에
}
interface Test2{
	//일반적인 인터페이스 멤버는 추상멤버이다.
	void aaa();
	//자바의 인터페이스 멤버는 추상멤버와 구현멤버***를 가질 수 있다.
	final public int b=20;
	final static public int c=30;
	
	public static void ccc() {
		
	}
	default void ddd() {
		
	}
	///final, static, default 중에 하나라도 붙은 애들은 구현멤버를 가질 수 있다! -> 자바에서만 지원됨.
	
}


