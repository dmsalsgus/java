package com.test.java.obj.inheritance;
import java.util.*;
import java.io.*;


public class Ex59_Exception {
	public static void main(String[] args) {
		// Exception(예외) : 런타임 오류를 말하는 것이다.(컴파일 때는 발견 x, but 실행 중에 발견된 것.)
		// : 개발자가 미리 예측가능한 것도 있고, 예측 못할 수도 있다.

		// 예외 처리(Exception Handling)
		// 1. 전통적인 방식 : 제어문(조건문) 사용

		// 2. 전용 방식 : try catch finally문을 사용

		// m1();
		// m2();
		// m3();
		//m4();
		try {
			//m5();
		}catch (Exception e) {
			e.printStackTrace();
		}
		m6();
		
	}

	private static void m6() {
		//예외 던지기
		//Q. 숫자를 입력하면 조건을 보고 처리한다.-> 조건 : 짝수만 입력, 홀수는 에러 처리.
		
		int num=5;
		
		if(num%2==0) System.out.println("업무를 진행합니다.");
		else System.out.println("예외 처리");
		
		///▼ try-catch로 구현.
		
		try {  //홀수일 때, 강제로 에러 발생시키기.
			if(num%2==1) throw new Exception("홀수입력");  //Exception 객체를 냅다 만들고 던져버리기 -> 강제로 에러 발생시키기.
			System.out.println("업무를 진행합니다.");
		}catch (Exception e) {
			System.out.println("예외 처리");
			System.out.println(e.getMessage());   //Exception 괄호 안에 메세지 입력하면 옆의 방식으로 메세지를 꺼낼 수 있다.
		}
			
	}

	private static void m5() throws Exception{
		//throws Exception -> 예외 미루기
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  //import java.io.*; 사용해야함.
		/*
		try {
			String input=reader.readLine();
		}catch (Exception e) {
			
		}
		*/
		String input=reader.readLine();   //->main에서 에러남.
		
	}

	private static void m4() {
		try {  //m3와 비교해서 예외처리는 편해졌지만 catch절이 섬세하지 못함. -> 그래서 catch절을 여러개 만들어서 예외를 나눠줘야함.
			int num = 10;  // 0으로 나누기 -> ArithmeticException 에러
			System.out.println(100 / num);   // new ArithmeticException()을 생성하고 이걸 냅다 catch로 던진다.

			// 배열 첨자 오류 -> ArrayIndexOutOfBoundsException 에러
			int[] nums = new int[3];
			nums[0] = 10;

			// null 참조 -> NullPointerException 에러
			Scanner sc = null;
			sc.nextLine();
		} catch(ArithmeticException e){
			System.out.println("0으로 나누기");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("배열 첨자");
		}catch(NullPointerException e){
			System.out.println("널 참조");
		}catch (Exception e) {     //나머지 예외처리 애들의 부모클래스라서 이 세상의 모든 예외처리를 다 받을 수 있음.
			///얘는 항상 마지막에 써야함.
			System.out.println("예외처리");
		}

	}

	private static void m3() {
		// 0으로 나누기 -> ArithmeticException 에러
		try {
			int num = 10;
			System.out.println(100 / num);
		} catch (Exception e) {
			System.out.println("0으로 나누기");
		}

		// 배열 첨자 오류 -> ArrayIndexOutOfBoundsException 에러
		try {
			int[] nums = new int[3];
			nums[0] = 10;
		} catch (Exception e) {
			System.out.println("배열 첨자");
		}

		// null 참조 -> NullPointerException 에러
		try {
			Scanner sc = null;
			sc.nextLine();
		} catch (Exception e) {
			System.out.println("널 참조");
		}

	}

	private static void m2() {
		int num = 10;

		try { // 비즈니스 코드 작성 영역
			System.out.println(100 / num);
		} catch (Exception e) { // 예외처리 코드 작성 영역
			System.out.println("예외 처리");
		} finally { // 마무리 영역 -> 무조건 실행되는 블럭 -> 뒷수습하라고.
			// 예외와 상관없이 항상 실행해야 하는 코드 블럭
			System.out.println("마지막");
		}

	}

	private static void m1() {
		// Q. 숫자를 입력받아 연산을 하시오.
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int num = sc.nextInt();

		// 전통적인 예외처리 방식
		if (num != 0)
			System.out.printf("100 / %d = %d\n", num, 100 / num); // 이 작업을
		else
			System.out.println("0을 입력하면 안됩니다."); // 예외처리코드 //예외처리라고 합니당

		// System.out.printf("100 / %d = %d\n",num,100/num); -> 원래 목적인 코드를 비즈니스 코드(업무
		// 코드)라고 부름.

		// 가독성 때문에 비권장함. 위에 예외처리 방식을 더 권장함.(결과는 같음)
		if (num == 0)
			System.out.println("0을 입력하면 안됩니다.");
		else
			System.out.printf("100 / %d = %d\n", num, 100 / num);

		////////////////////////////////////////////////
		// try 영역 : 예외가 발생하는지 감시역할을 한다.
		// 조건이 없기때문에 일단 try로 들어와서 실행한다.
		try {
			System.out.println(1);
			System.out.printf("100 / %d = %d\n", num, 100 / num);
			System.out.println(2);
		} catch (Exception e) {
			System.out.println("0을 입력하면 안됩니다.");

			// Exception e(예외 객체) : 예외의 상황을 전달
			System.out.println(e.getMessage());
			e.printStackTrace(); // 얘도 예외메세지 전달.

		}
		System.out.println("종료");

		// if문 : 사전에 미리 검사를 해서 사고가 안나게 처리
		// try문 : 일단 실행을 하고, 감시하다가 사고가 터지면 그때 가서 뒷처리하기.

	}
}
