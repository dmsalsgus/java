package com.test.question.q104;

public class Main {
	public static void main(String[] args) {
		
		//배열 생성
		MyArrayList list = new MyArrayList();
		//System.out.println(list);
		
		//추가
		list.add("홍길동");
		list.add("아무개");
		list.add("하하하");
		list.add("호호호");
		list.add("후후후");
		System.out.println(list);

		//읽기
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		//System.out.println(list);

		//개수
		System.out.println(list.size());
		
		//탐색 + 읽기
		for (int i=0; i<list.size(); i++) {
		      System.out.println(list.get(i));
		}
		
		//수정
		list.set(0, "우하하");
		System.out.println(list.get(0));
		//System.out.println(list);
		
		//삭제
		list.remove(1);
		for (int i=0; i<list.size(); i++) {
		      System.out.println(list.get(i));
		}
		//System.out.println(list);

		//삽입
		list.add(1, "호호호");
		for (int i=0; i<list.size(); i++) {
		      System.out.println(list.get(i));
		}
		//System.out.println(list);

		//검색
		if (list.indexOf("홍길동") > -1) {
		      System.out.println("홍길동 있음");
		} else {
		      System.out.println("홍길동 없음");
		}
		
		//System.out.println(list.lastIndexOf("홍길동"));
		
		//System.out.println(list.indexOf("홍길동",3));  //인덱스 오버로딩

		//System.out.println(list.contains("홍길동"));
		
		//System.out.println(list);
		
		//초기화
		list.clear();
		System.out.println(list.size());
	}
}
