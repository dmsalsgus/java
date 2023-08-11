package com.test.java.obj.collection;
import java.util.*;

public class Ex70_TreeSet {
	public static void main(String[] args) {
		//TreeSet = Tree구조(이진 탐색 트리 구조, Binary Search Tree) + Set 사용법
		//Set은 순서가 없고, 중복값을 가지지 않는 것.
		//Set은 순서가 없어서 정렬이 불가능한데, 정렬이 필요할 때 사용하는 TreeSet.(Tree 구조 이용하면 가능.)
		
		HashSet<Integer> set1 = new HashSet<Integer>();
		TreeSet<Integer> set2 = new TreeSet<Integer>();
		
		set1.add(10);
		set1.add(30);
		set1.add(40);
		set1.add(20);
		set1.add(50);
		
		set2.add(10);
		set2.add(30);
		set2.add(40);
		set2.add(20);
		set2.add(50);
		
		System.out.println(set1);
		System.out.println(set2);
		
		//탐색은 for->iterator
		for(int n: set2) {
			System.out.println(n);
		}
		
		Iterator<Integer> iter=set2.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		//TreeSet 고유 기능
		System.out.println(set2.first());
		System.out.println(set2.last());
		
		System.out.println(set2.headSet(30));   //exclusive
		System.out.println(set2.tailSet(30));    //inclusive
		System.out.println(set2.subSet(20, 40));   //[20, 30]
		
		//////////////////////////////////////////////////
		
		HashSet<Integer> set3= new HashSet<Integer>();
		
		set3.add(20);
		set3.add(50);
		set3.add(30);
		set3.add(10);
		set3.add(40);
		
		System.out.println(set3);  ///정렬x
		
		ArrayList<Integer> list = new ArrayList<Integer>(set3);
		Collections.sort(list);   //ArrayList에 넣어서 정렬.
		System.out.println(list);
		
	}
}
