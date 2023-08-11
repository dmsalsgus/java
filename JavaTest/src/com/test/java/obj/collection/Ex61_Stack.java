package com.test.java.obj.collection;
import java.util.*;

public class Ex61_Stack {
	public static void main(String[] args) {
		//List 종류 : ArrayList, Queue, Stack
		
		//자료구조 컬렉션 : 물리적인 특징(내부 구조)과 추상적인 특징(사용법)이 있다.
		//ADT(Abstract Data Type) : Stack, Queue 
		
		//Stack : 후입선출(LIFO, Last Input First Out) -> 저장소에 나중에 들어간 요소가 가장 먼저 나온다.
		//        : ex) 메모리 구조(Stack), 되돌리기(ctrl+z), 다시하기(ctrl+y)
		
		//Queue : 선입선출(FIFO, First In First Out) -> 저장소에 먼저 들어간 요소가 가장 먼저 나온다.
		//         : ex) 줄서기
		
		
		//m1();
		//m2();
		m3();
		
	}

	private static void m3() {
		// //Queue : 선입선출
		Queue<String> queue= new LinkedList<String>();
		
		//1. 요소 추가하기 : boolean add<T>(T. value)
		queue.add("짜장면");
		queue.add("짬뽕");
		queue.add("탕수육");
		
		 // 2.요소 개수 : int size();
        System.out.println(queue.size());
        
        // 3. 요소 읽기(읽고 버리기 )
        System.out.println(queue.poll()); // poll도 읽고 삭제해서
        System.out.println(queue.size()); // 사이즈가 줄어든다

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.size());   // 애는 스택과다르게 읽어올게없어도 오류가 안나고 null이뜸

        //4. queue가 비었는지?
        if (!queue.isEmpty()) {  //읽어올 요소가 있을때만 꺼내오기
            System.out.println(queue.poll());
        }

		//5. 요소 확인
		System.out.println(queue.peek());
		
	}

	private static void m2() {
		Stack<String> stack=new Stack<String>();
		
		stack.push("짜장면");
		stack.push("짬뽕");
		stack.push("볶음밥");
		
		//5. 요소확인  //peek -> 읽기는 하지만 삭제는 안됨.
		System.out.println(stack.peek());
		
	}

	private static void m1() {
		Stack<String> stack=new Stack<String>();
		
		//후입선출
		
		//1. 요소 추가하기 : T push(T value)
		stack.push("짜장면");
		stack.push("짬뽕");
		stack.push("볶음밥");
		
		//2. 요소 개수 : int size()
		System.out.println(stack.size());   //3
		
		//3.요소 읽기 : T pop()
		System.out.println(stack.pop());   //볶음밤
		System.out.println(stack.size());   //2
		//pop()은 읽는 행동 + 제거하는 행동.
		
		System.out.println(stack.pop());   //짬뽕
		System.out.println(stack.size());   //1
		
		System.out.println(stack.pop());   //짜장면
		System.out.println(stack.size());   //0
		
		//System.out.println(stack.pop());   // 데이터가 더이상 없으니 에러.
		//System.out.println(stack.size());   
		
		//4. 스택이 비었는지?
		if(stack.size()!=0) {
			System.out.println(stack.pop());
		}
		if(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}
}
