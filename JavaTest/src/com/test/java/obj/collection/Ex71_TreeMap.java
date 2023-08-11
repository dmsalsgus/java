package com.test.java.obj.collection;
import java.util.*;

import java.util.TreeMap;

public class Ex71_TreeMap {
	public static void main(String[] args) {
		//TreeMap
		//Tree = 이진 탐색 트리로 자동으로 정렬된다.
		//Map = 키+값 -> 연관배열
		
		TreeMap<String, String> map = new TreeMap<String, String>();
		
		map.put("white","흰색");
		map.put("black","검정");
		map.put("red","빨강");
		map.put("yellow","노랑");
		map.put("blue","파랑");
		map.put("orange","주황");
		map.put("green","초록");
		
		System.out.println(map.size());   //7
		System.out.println(map);   //키 정렬
		
		System.out.println(map.get("green"));
		map.put("green","녹색");
		System.out.println(map.get("green"));
		
		System.out.println(map.firstKey());  //black
		System.err.println(map.lastKey());   //yellow
		
		System.out.println(map.headMap("m"));
		System.out.println(map.tailMap("m"));
		System.out.println(map.subMap("r", "y"));
		
		//////////////////////////////////////////
		//List
		//- ArrayList : 배열이 필요할 때, 삽입x, 삭제x **************** 중요!
		//- LinkedList : ArrayList 대체제, 삽입o, 삭제o
		//- Stack : 스택 구조 필요
		//- Queue : 큐 구조 필요
		//- Vector...안할거지만 맛보기
		
		//Vector
		Vector<Integer> list=new Vector<Integer>();
		list.add(10);
		System.out.println(list.get(0));
		
		//////////////////////////////////////////
		//Set
		//- HashSet : 중복값 배제, 유일한 집합 ********************** 중요!
		//- TreeSet : HashSet + 정렬
		
		///////////////////////////////////////////
		//Map
		//- HashMap : 키/값 연관 배열이 필요할 때 ********************** 중요!
		//- TreeMap : HashMap + 정렬
		//- HashTable
		
		////////////////////////////////////////////
		//Properties -> JSON, XML로 많이 대체.
		
	}
}
