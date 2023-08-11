package com.test.java.obj.collection;
import java.util.*;

public class Ex60_List {
	public static void main(String[] args) {
		//컬렉션(Collection) : JCF(Java Collection Framework)
		//컬렉션은 향상된 배열 => 기존에 사용하던 순수한 배열을 사용법을 개량하거나, 용도에 따른 입출력 방식이나 효율성을 개량한 것.
		//                             : 클래스 형태이며, 내부 순수 배열을 가지고 있다.
		//                             : 길이가 가변적이다 -> 방의 개수를 마음대로 늘리고 줄이는 게 가능하다.
		//                             : 자료구조이며, 요즘은 전부 제네릭 버전을 권장
		
		//컬레션 종류 : 인터페이스 계열(사용법이 비슷함)
		//1. List 계열 : ArrayList********, LinkedList, Queue, Stack, Vector(legacy)
		//2. Set 계열 : HashSet*****, TreeSet
		//3. Map 계열 : HashMap*********, TreeMap, Properties(legacy), HashTable(legacy)
		
		//Collection이라는 인터페이스가 있고, 그 밑에 List 인터페이스와 Set 인터페이스가 존재.
		
		//ArrayList 클래스 : Collection 인터페이스 밑에, List 인터페이스 밑에, ArrayList 클래스가 존재
		//                      : 순수 배열과 구조가 가장 유사하며, 첨자(index)를 사용해서 요소(element)에 접근
		
		//m1();   //ArrayList vs 순수 배열
		//m2();  //ArrayList 용법
		//m3();   //차원
		//m4();   //성적표 출력하기
		//m5();   
		m6();
	}

	private static void m6() {
		ArrayList<Integer> list=new ArrayList<Integer>();  //여기까지는 아직 배열 생성 안됨.
		for(int i=0; i<10; i++) {
			list.add(i);   //add를 만나고 배열을 생성한다.
			//길이가 모자라면 기존의 크기보다 2배짜리 큰 배열을 생성 및 사용하고, 기존의 것은 버린다..
		}
		System.out.println(list);
		
		/////컬렉션의 초기 용량 -> 내부 배열의 초기 길이**
		ArrayList<Integer> list1=new ArrayList<Integer>(10);  //괄호안에 숫자를 넣어줘야 그만큼만 돌아감.
		for(int i=0; i<10; i++) {
			list1.add(i);
		}
		System.out.println(list);
		
		list.add(10);  //이거 추가하면 10칸 지정해도 *2로 20칸이 다시 새로 생성.
		//그럼 20칸 중 남은 9칸은...? -> 더 추가안한다는 확신이 있을 때. -> 없앨 수 있다.
		
		list.trimToSize();   //데이터가 들어있는 길이만큼의 길이로 재조정. -> 진짜진짜 추가할 계획이 없다고 확신할때만 사용. 굳이 사용안하는게 더 나음. 
		
	}

	private static void m5() {
		//ArrayList 컬렉션의 특징
		//1. 내부에 배열을 가지고 있다.
		//2. ArrayList 클래스의 대부분의 기능이 내부 배열을 조작하는 기능으로 구성
		//3. 길이가 가변이어서 데이터를 계속 넣으면, 계속 공간이 늘어난다.
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		for(int i=0; i<1000000; i++) {
			list.add(i);
		}
		System.out.println(list.size());  // 1000000
		
		//
		ArrayList<Integer> list1=new ArrayList<Integer>();
		list1.add(10);
		System.out.println(list1.size());  ///여태까지 집어넣은 데이터의 개수.  //1
		
		list1.add(20);
		list1.add(30);
		list1.add(40);
		System.out.println(list1.size());  //4
		
		list1.add(50);
		list1.add(60);
		list1.add(70);
		list1.add(80);
		list1.add(90);
		System.out.println(list1.size());   
		
	}

	private static void m4() {
		// 성적표 출력하기 -> 학생(이름, 국어, 영어, 수학, 총점, 평균)
		
		//배열은 고정이고, ArrayList는 가변. 길이로 둘 중 어떤 것을 사용할 지 정한다.
		
		//Student[] list;
		ArrayList<Student> list = new ArrayList<Student>();  ///Student 타입의 배열.
		
		for(int i=0; i<10; i++) {
			int kor=(int)(Math.random()*41)+60;  //60점~100점
			int eng=(int)(Math.random()*41)+60;
			int math=(int)(Math.random()*41)+60;
			
			Student s=new Student("학생"+i,kor,eng,math);
			list.add(s);  //배열에 학생 추가
			
		}
		//System.out.println(list);
		
		System.out.println("=============================================");
		System.out.println("                     성적표");
		System.out.println("=============================================");
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
		
		for(Student s : list) {
			int total=s.getKor()+s.getEng()+s.getMath();
			double avg=total/3.0;
			System.out.printf("%s\t%4d\t%4d\t%4d\t%4d\t%4.1f\n",s.getName(), s.getKor(), s.getEng(), s.getMath(), total, avg);
		}
		
	}

	private static void m3() {
		//차원
		int[] ns1=new int[3];  //얘네는 순수배열
		int[][] ns2=new int[3][3];
		int[][][] ns3=new int[3][3][3];
		
		
		ArrayList<Integer> ms1= new ArrayList<Integer>();  //1차원
		ArrayList<ArrayList<Integer>> ms2= new ArrayList<ArrayList<Integer>>();  //2차원
		ArrayList<ArrayList<ArrayList<Integer>>> ms3 = new ArrayList<ArrayList<ArrayList<Integer>>>();  //3차원
		
	}

	private static void m2() {
		//ArrayList 용법
		ArrayList<String> list = new ArrayList<String>();
		
		//CRUD
		//- Create
		//- Read
		//- Update
		//- Delete
		
		//1. 요소 추가하기 : boolean add(T value) / 배열의 맨 마지막에 추가하기(Append)
		list.add("바나나");
		list.add("딸기");
		list.add("사과");
		list.add("귤");
		list.add("파인애플");
		
		//2. 요소의 개수 : int size()
		System.out.println(list.size());  //5
		System.out.println();
		
		//3. 요소 접근(읽기) : T get(int index)
		System.out.println(list.get(0));
		System.out.println(list.get(4));    //파인애플
		System.out.println(list.get(list.size()-1));   //파인애플
		//System.out.println(list.get(5));  //없는 방번호  //에러남.
		System.out.println();
		
		//4. 요소 수정 : String set(int index, T newValue) -> 수정되기 직전의 값을 return해줌.
		String temp=list.set(2, "포도");
		System.out.println(list.get(2));  //사과->포도
		System.out.println(temp);  //얘는 수정 직전값 반환이라 사과
		System.out.println();
		
		//5. 요소 삭제 : 순수배열의 방삭제는 불가능, 컬렉션은 가능.
		//                 : T remove(int index) -> 방번호를 찾아서 삭제
		//                 : boolean remove(T value) -> 값을 찾아서 삭제
		//                 : 삭제하면 시프트가 발생한다.!! -> 삭제된 방 이후의 모든 요소는 모두 방번호 -1 감소.
		
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println();
		
		//list.remove(2);
		list.remove("포도");   //만약 포도가 2개 이상이면?? -> 무조건 첫번째 만나는 포도를 지운다. 두번째 포도는 못지운다.
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		//6. 탐색 : 루프돌리기
		for(int i=0; i<list.size(); i++) {
			System.out.printf("list.get(%d) = %s\n",i,list.get(i));
		}
		System.out.println();
		
		///////////
		//향상된 for문(foreach문) : 단순하지만 고정된 형태로 사용.
		//for(변수 : 배열/컬렉션) -> 이렇게 사용.
		
		for(String item : list) {
			System.out.println(item);
		}
		System.out.println();
		
		
		//7. 덤프 -> Arrays.toString
		System.out.println(list.toString());   // [바나나, 딸기, 귤, 파인애플]
		System.out.println(list);                // [바나나, 딸기, 귤, 파인애플]
		
		
		//8. 요소의 추가 : 배열의 원하는 위치에 추가하는 것 -> Insert.
		//Append는 줄서기. Insert는 새치기.
		//형식 : void add(index index(삽입될 위치), T value(삽입될 값)) -> 시프트 발생함. -> 삽입된 방 이후에 모든 요소의 방번호 +1.
		
		list.add(2,"망고");
		System.out.println(list);
		System.out.println();
		
		
		//9. 기타 등등
		System.out.println(list.indexOf("사과"));  //없으면 -1을 반환.
		System.out.println(list.indexOf("귤"));
		System.out.println(list.lastIndexOf("파인애플"));
		System.out.println(list.contains("망고"));  //true
		
		//10.
		System.out.println(list.isEmpty());  //false
		
		list.clear();  //모든 요소 삭제 -> 초기화 -> 배열 전체 삭제.
		
		System.out.println(list.isEmpty());  //true
		System.out.println(list.size());  //0
		System.out.println(list);  //[]
		
		
	}

	private static void  m1() {
		// 순수 배열
		int[] num1=new int[3];
		
		//요소 접근이 첨자(index)를 사용해서 접근함.
		num1[0]=10;
		num1[1]=20;
		num1[2]=30;
		
		System.out.println(num1[0]);
		System.out.println(num1[1]);
		System.out.println(num1[2]);
		
		System.out.println(num1.length);
		
		
		//컬렉션 : ArrayList
		//타입이 Integer라고 제네릭으로 명시되어있음. / 길이는 가변이라서 명시되어 있지 않음.
		ArrayList<Integer> num2=new ArrayList<Integer>();    //int는 사용 불가, 클래스 타입으로만 정의 가능.
		
		//요소추가 -> 첨자가 없는데 몇번째 방에..? -> add()  == append  -> 차례대로 마지막 방(0번째부터)에 넣어라 
		num2.add(10);  //0번째 방
		num2.add(20);  //1번째 방
		num2.add(30);  //2번째 방
		
		System.out.println(num2.get(0));    //num2[0]를 의미.
		System.out.println(num2.get(1));    //num2[1]를 의미.
		System.out.println(num2.get(2));    //num2[2]를 의미.
		
		//add가 요소추가, get이 요소읽기.
		
		//길이를 알고싶으면 length 대신 size.
		System.out.println(num2.size());    //길이 3.
		
		//값 추가도 가능.
		num2.add(40);  //3번째 방
		num2.add(50);  //4번째 방
		
		System.out.println(num2.size());    //길이 5.
		
	}
}
