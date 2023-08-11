package com.test.java.obj.collection;
import java.util.*;

public class Ex67_sort {
	public static void main(String[] args) {
		//배열 또는 컬렉션에 정렬이 필요할 때가 있다.(오름차순 정렬, 내림차순 정렬)
		//직접 알고리즘 구현 vs jdk에서 제공하는 기능이 있다.
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
		
	}

	private static void m5() {
		// 컬렉션의 정렬
		//1. ArrayList : 순서가 있는 목록 -> 정렬 가능.
		//2. HashMap :  순서가 없는 데이터 목록 -> 정렬 불가능.
		//3. Queue : 순서가 있는 목록이지만 정렬 안함.
		//4. Stack : 순서가 있는 목록이지만 정렬 안함.
		//5. HashSet : 방번호가 없어서 정렬 불가능
		//==> 결국 ArrayList만 가능하다는 것.
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<10; i++) {
			list.add((int)(Math.random()*100));  //0 ~ 99
		}
		System.out.println(list);
		/*
		Collections.sort(list);    // == Arrays.sort(list);
		System.out.println(list);
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		} );
		System.out.println(list);
		*/
		
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		} );
		System.out.println(list);
		
	}

	private static void m4() {
		// 객체 정렬
		Score[] list=new Score[5];
		
		list[0]=new Score("홍길동", 100, 90, 80);
		list[1]=new Score("아무개", 98, 78, 88);
		list[2]=new Score("유재석", 78, 95, 79);
		list[3]=new Score("박명수", 56, 78, 76);
		list[4]=new Score("이순신", 99, 67, 79);
		
		System.out.println(Arrays.toString(list));
		
		//이름순으로 정렬
		//Arrays.sort(list);   //이렇게는 sort불가능->기준이 없기 때문에
		Arrays.sort(list, new Comparator<Score>() {
			@Override
			public int compare(Score o1, Score o2) {
				//return o1.getName().compareTo(o2.getName());  //이름순으로 정렬.
				//return o2.getKor()-o1.getKor();  //국어점수가 잘나온 애부터 정렬.
				return (o2.getKor()+o2.getEng()+o2.getMath())-(o1.getKor()+o1.getEng()+o1.getMath());  //총점이 높은 애부터 낮은 애까지 정렬.
			}
		} );
		System.out.println(Arrays.toString(list));
		
	}

	private static void m3() {
		Calendar[] dates = new Calendar[5];  //단순히 방만 만든거임.
		
		for(int i=0; i<dates.length; i++) {
			dates[i]=Calendar.getInstance();
		}
		dates[0].add(Calendar.DATE, 7);
		dates[1].add(Calendar.DATE, -2);
		dates[2].add(Calendar.DATE, 1);
		dates[3].add(Calendar.DATE, 0);
		dates[4].add(Calendar.DATE, 3);
		
		for(int i=0; i<dates.length; i++) {
			System.out.printf("%tF\n",dates[i]);
		}
		System.out.println();
		
		Arrays.sort(dates);  //오름차순 정렬
		
		for(int i=0; i<dates.length; i++) {
			System.out.printf("%tF\n",dates[i]);
		}
		System.out.println();
		
		//이번에는 내림차순
		Arrays.sort(dates, new Comparator<Calendar>() {
			@Override
			public int compare(Calendar o1, Calendar o2) {
				//return o2.compareTo(o1);    //날짜 비교는 반드시 compareTo 사용하기.
				//요일은 일요일이 1~토요일이 7
				return o1.get(Calendar.DAY_OF_WEEK)-o2.get(Calendar.DAY_OF_WEEK);  //요일 기준 정렬.
			}
		} );
		for(int i=0; i<dates.length; i++) {
			System.out.printf("%tF %tA\n",dates[i], dates[i]);
		}
		System.out.println();
		
	}

	private static void m2() {
		//자료형별 정렬
		//1. 숫자
		//2. 문자(열) -> 문자코드값을 정렬한다는 뜻 -> 결국은 숫자 정렬
		//3. 날짜시간 -> 숫자 정렬(과거가 작고, 미래가 크다고 생각)
		//4. 객체 정렬
		
		String txt1="홍길동";
		String txt2="아무개";
		//System.out.println(txt1>txt2);    //이렇게 쓰면 참조형이라서 에러.
		//위의 출력은 주소값 비교인데, 주소값은 연산자의 피연산자가 될 수 없다.
		//하지만 문자 vs 문자는 값이라서 비교가 가능하다.
		System.out.println('A'>'B');  //이건 char라 가능.   //false.
		
		int n=0;
		for(int i=0; i<3; i++) {
			char c1=txt1.charAt(i);
			char c2=txt2.charAt(i);
			if(c1>c2) { n=1; break; }
			else if(c1<c2) { n=-1; break; }
		}
		System.out.println(n);
		//근데 위처럼 구현할 필요 없음. 아래의 메소드가 있음.
		System.out.println(txt1.compareTo(txt2));  //나오는 숫자는 상관없이 양수냐 음수냐만 따짐.
		System.out.println(txt1.compareToIgnoreCase(txt2));  //대소문자 구분없이 비교 -> 영어만 가능.
		
		
		//문자열을 가나다순으로 정렬
		String names[]= {"홍길동", "아무개", "유재석", "박명수", "이순신", "김철", "훈"};
		System.out.println(Arrays.toString(names));
		//Arrays.sort(names);  //오름차순
		System.out.println(Arrays.toString(names));
		
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				//return o1.compareTo(o2);  //오름차순
				//return o2.compareTo(o1);  //내림차순
				//return o1.length()-o2.length();  //글자수 비교 -> 작은값부터 정렬.
				
				if(o1.length()==o2.length()) {
					return o1.compareTo(o2);
				}else return o1.length()-o2.length();
			}
		} );
		System.out.println(Arrays.toString(names));  
		
	}

	private static void m1() {
		//지금 하는것은 jdk에서 제공하는 것을 약간의 커스터마이징하는 느낌 -> 이때, 익명 클래스가 사용됨.
		//익명 클래스 사용은 선택이지만, 안쓰면 코드 지저분해짐.
		
		Integer[] nums= {1,5,2,4,3};   //int(value 타입)이 아닌 Integer(class 타입)으로 해야 익명 클래스 사용 가능. 
		
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums);  //오름차순 정렬  //Quick sort
		System.out.println(Arrays.toString(nums));
		
		//내림차순 정렬을 하고 싶은데....없당
		//내림차순은 지원을 안하니까 직접 구현해야 한다.
		//Arrays.sort(배열(T[] a), comparator);  //배열의 T[] 때문에 int를 Integer로 바꾼거임.
		
		Arrays.sort(nums, new MyComparator());
		System.out.println(nums);
		
		/*  //쓸모없는 코드
		MyComparator mc1 = new MyComparator();
		System.out.println(mc1.compare(10,20));
		*/
		
		Double[] nums2= {2.5, 7.1, 3.8, 9.2, 8.9};
		//MyComparator는 Integer형이라 실수비교는 에러.
		Arrays.sort(nums2,new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				if(o1>o2) {   //내림차순일 경우
					return -1;
				}else if(o1<o2) {
					return 1;
				}else return 0;
			}
		} ); 
		System.out.println(nums2);
	}
}
class MyComparator implements Comparator<Integer>{   //제네릭은 배열의 요소와 맞춰야 한다.
	@Override
	public int compare(Integer o1, Integer o2) {
		//숫자 2개를 어떻게 비교할래? 
		//오름차순 비교
		//a. o1이 더 크면 양수반환 - 보통 1
		//b. o2가 더 크면 음수반환 - 보통 -1
		//c. 같으면 0을 반환
		
		//내림차순 비교
		//a. o1이 더 크면 음수반환 - 보통 -1
		//b. o2가 더 크면 양수반환 - 보통 1
		//c. 같으면 0을 반환
		
		if(o1>o2) {    //오름차순일 경우
			return 1;
		}else if(o1<o2) {
			return -1;
		}else return 0;
		//내림차순일 때는 return값만 바꿔주면된당.
	} 
	
}
class Score{
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
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
		return String.format("Score [name=%s, kor=%s, eng=%s, math=%s]\n", name, kor, eng, math);
	}
	
}