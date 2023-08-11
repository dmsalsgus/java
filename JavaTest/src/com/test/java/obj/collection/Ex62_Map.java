package com.test.java.obj.collection;
import java.util.*;

public class Ex62_Map {
	public static void main(String[] args) {
		//ArrayList : 요소를 접근할 때 첨자(index)를 사용.
		//             : 순서가 있는 데이터 집합(방번호==요소의 순서) ex) 강의실 6개 -> 1강의실, 2강의실, 3강의실...
		//             : ==스칼라 배열(Scalar Array)
		//       장점 : 요소에 일관 접근으로 for문 사용 가능.
		//       단점 : 요소끼리 구분이 힘들다. 방번호가 의미가 없다.
		//             : 첨자(index)는 유일하다. ex) 우리 1강의실인데 맞은편도 1강의실일 수 없음.
		//             : 값은 중복이 가능하다.(방번호가 유일해서) ex) 1강의실 홍길동, 2강의실 홍길동...
		
		//HashMap : 요소를 접근할 때 키(key)를 사용.
		//             : 순서가 없는 데이터 집합(방번호x) ex) 강의실 6개 -> 햇님반, 달님반, 별님반...
		//             : 키(key) -> 값(value)
		//             : 맵(Map), 딕셔너리(Dictionary) = 사전 구조
		//             : 연관 배열
		//      장점 : 요소끼리 구분이 용이하다. 식별자(key) -> 방의 의미가 가독성 좋음.
		//      단점 : 방번호가 아니므로 for문 사용 불가능
		//             : 키(key)는 유일해야 한다. ex) 햇님반 중복 불가능.
		//             : 값은 중복이 가능하다.(키가 유일해서)
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();   //타입변수가 2개짜리
		//String이 key의 자료형으로 방의 이름이고, Integer는 value의 자료형으로 데이터를 의미한다.
		
		//1. 요소 추가 : V put(K key, V value)
		map.put("국어",100);   //int 국어=100   -> 방이 변수명이라고 생각하기.
		map.put("영어",90);
		map.put("수학",80);
		
		//2. 요소 개수 : int size()
		System.out.println(map.size());   //3
		
		//3. 요소 읽기 : V get(K key)
		System.out.println(map.get("국어"));   //key들을 직접적으로 읽어온다.
		System.out.println(map.get("영어"));
		System.out.println(map.get("수학"));
		
		//4. 일괄 탐색은 불가능.(존재는 하지만...나중에 가서)
		
		//5. 요소 수정 : V put(K key, V value)
		map.put("국어",95);   //데이터 추가가 아니라 수정하는 것이다.
		//요소 추가랑 똑같은데 왜? -> 키는 유일해야하는데, 이미 국어라는 키를 가지고 있어서. -> 추가가 아닌 수정으로 들어감.
		//-> 동일한 키를 삽입하면 추가가 아닌 수정!
		
		System.out.println(map.get("국어"));
		
		//6. 요소 검색 : boolean containsKey(K key) / boolean containsValue(V value)
		// indexOf 는 존재 안함. 방번호가 없어서.
		System.out.println(map.containsKey("국어"));  // 국어점수가 있니? -> true
		System.out.println(map.containsKey("국사"));   //false
		
		System.out.println(map.get("국사"));  //없는 아이인데 에러가 아닌 null을 반환함.
		
		System.out.println(map.containsValue(90));  //너 시험본 것 중에 90점 맞은 거 있니? -> true
		System.out.println(map.containsValue(100));   //위에서 국어점수 고쳐서 95. -> false.
		
		
		//7. 요소 삭제 : V remove(K key)
		map.remove("국어");
		
		System.out.println(map.size());     //2
		System.out.println(map.get("국어"));    //null
		
		
		//8. 초기화 : clear()
		map.clear();
		System.out.println(map.size());
		
		////////////////////////////////////////
		
		map.put("국어",100);
		map.put("영어",90);
		map.put("수학",80);
		
		Set<String> set = map.keySet();   //키의 집합들만 모아온 것.
		
		System.out.println(set);   //[국어, 수학, 영어]
		for(String key : set) {   //향상된 for문으로 반복문 사용가능.
			System.out.println(key+" : "+map.get(key));  
		}
		
		////////////////
		//교실
		HashMap<String, String> list  = new HashMap<String, String>();
		list.put("반장", "홍길동");
		list.put("부반장", "아무개");
		list.put("미화부장", "하하하");
		
	}
}
