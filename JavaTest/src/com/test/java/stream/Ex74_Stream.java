package com.test.java.stream;
//import java.nio.*;   //java.io의 버전업
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import com.test.data.*;
import com.test.java.obj.collection.Student;

public class Ex74_Stream {
	public static void main(String[] args) {
		// 자바 스트림
		//1. 입출력 스트림 : 파일 입출력, 콘솔 입출력, 네트워크 입출력...
		//2. 스트림 : Java 8(JDK 1.8), 람다식 + 함수형 인터페이스, 배열(컬렉션)의 탐색(조작) 지원, 파일 입출력 지원, 디렉토리 탐색 지원
		
		//배열, 컬렉션 탐색
		//1. for문(루프변수)
		//2. 향상된 for문
		//3. Iterator
		//4. 스트림
		
		//함수형 인터페이스
		//1. Consumer : (매개변수) -> {구현부}
		//2. Supplier : () -> (return 값)
		//3. Function : (매개변수) -> {return 값}
		//4. Operator : (매개변수) -> {return 값}
		//                : 매개변수와 반환값의 자료형이 동일
		//5. Predicate : (매개변수) -> {return 값}
		//                : 반환값이 boolean
		
		//stream() 종류
		//- .filter(Predicate)
		//- .map(Function)
		//- .sorted(Comparator)
		//- .distinct()
		
		//- .count() / .max() / .min() / .sum() / .average()
		//- .allMatch() / .anyMatch() / .noneMatch()
		//- .forEach()
		/////////////////////////////////////////////////////////
		
		String path="test.java";
		
		//MyFile mf=new MyFile();   //import는 같은 프로젝트내에서만 가능.
		
		//개발자 자바 소스를 다른 개발자에게 전달하는 방법(배포)
		//1. 소스 자체를 전달하기 -> MyFile.java
		//2. 컴파일한 실행 파일을 전달 -> MyFile.class -> 1개 파일로 압축하는데 .zip이 아닌 .jar이다.
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		m10();
		
	}
	
	private static void m10() {
		// 집계, 통계 : count(), max(), min(), sum(), average() : 최종 파이프로서, 요소들을 가공해서 통계값.
		
		System.out.println(Data.getIntList().stream().count());  //100
		
		//Optional<Integer>
		System.out.println(Data.getIntList().stream().max((a, b)-> a-b).get());
		System.out.println(Data.getIntList().stream().min((a, b)-> a-b).get());
		
		//map : Stream<Integer>가 아닌 IntStream이다.
		int sum = Data.getIntList().stream().mapToInt(n-> n).sum();
		System.out.println(sum);
		
		double avg = Data.getIntList().stream().mapToInt(n->n).average().getAsDouble();
		System.out.println(avg);
		
	}

	private static void m9() {
		// 매칭 : allMatch(), anyMatch(), noneMatch() : 최종 파이프로서, 스트림 요소들이 제시한 조건을 만족하는지 유무를 판단한다.
		//        : 스트림이 아닌 boolean을 반환.
		//(조건이라고 하면 Predicate라고 생각해라.)
		
		// a. boolean allMatch(Predicate) : 모든 요소가 조건을 100% 만족
		// b. boolean anyMatch(Predicate) : 일부 요소가 조건을 만족
		// c. boolean noneMatch(Predicate) : 모든 요소가 조건을 만족하지 않을 때
		
		//Q. 배열을 만들어서 짝수만 있는지?
		int[] nums= {1, 2, 4, 4, 6};
		boolean result=false;
		
		for(int n : nums) {
			if(n%2==1) {
				result=true;
				break;
			}
		}
		if(result) System.out.println("홀수 발견!");
		else System.out.println("짝수 배열~");
		
		if(Arrays.stream(nums).allMatch(n->n%2==0)) System.out.println("짝수 배열~");
		else System.out.println("홀수 발견!");
		
		System.out.println(Arrays.stream(nums).allMatch(n->n%2==0));  //false
		System.out.println(Arrays.stream(nums).anyMatch(n->n%2==0));  //true
		System.out.println(Arrays.stream(nums).noneMatch(n->n%2==0));  //false
		
	}

	private static void m8() {
		// 정렬 : sorted() : 중간 파이프로서, 배열/컬렉션의 sort()와 사용법이 동일하다 -> Comparator 구현.
		
		Data.getIntList(10).stream().sorted().forEach(n-> System.out.println(n));  //오름차순
		Data.getIntList(10).stream().sorted((a, b)-> b-a).forEach(n-> System.out.println(n));  //내림차순
		//데이터 10개를 Stream을 뽑아서 오름 또는 내림으로 정렬한다.
		
	}

	private static void m7() {
		//매핑 : map(), mapXXX(), 중간 파이프로, 변환작업을 한다.
		
		List<String> list = Data.getStringList(10);
		System.out.println(list);
		System.out.println();
		
		list.stream().filter(word->word.length()<=3).forEach(word->System.out.println(word));  //3글자 이하만 출력.
		//Stream<String> -> Stream<String> : 변환 없음.
		System.out.println();
		
		list.stream().map(word-> word.length()).forEach(num->System.out.println(num));
		//map = word를 주면 word.length를 돌려준다.  -> 데이터의 성질을 문자열에서 숫자형으로 변환함.
		//forEach는 숫자형으로 받게 된다.
		//Stream<String> -> Stream<Integer>
		System.out.println();
		
		//이름 추출
		String[] names = {"홍길동", "아무개", "이순신", "권율", "강감찬", "연개소문", "홍길동", "이순신", "남궁장군", "연개소문"};
		Arrays.stream(names).map(name-> name.substring(1)).forEach(name->System.out.println(name));
		
		//
		List<Student> slist=new ArrayList<Student>();
		
		slist.add(new Student("가가가", 100, 90, 80));
		slist.add(new Student("나나나", 77, 88, 99));
		slist.add(new Student("다다다", 60, 50, 40));
		slist.add(new Student("라라라", 82, 67, 91));
		slist.add(new Student("마마마", 67, 88, 68));
		
		slist.stream().map(s->{
			if((s.getKor() + s.getEng() + s.getMath()) >=180) {
				return s.getName() + " : 합격";
			}else return s.getName() + " : 불합격";   //근데 이렇게 쓰면 추후에 관리가 힘듬.
		}).forEach(result-> System.out.println(result));   //Stream<Student> -> Stream<String>
		System.out.println();
		
		//밑에처럼 class 만들고 객체를 생성하는 방식으로 하는게 낫다.
		slist.stream().map(s->{
			if((s.getKor() + s.getEng() + s.getMath()) >=180) {
				Result r= new Result();  //Result 객체를 생성.
				r.setName(s.getName());
				r.setResult("합격");
				return r;
			}else {
				Result r= new Result();  //Result 객체를 생성.
				r.setName(s.getName());
				r.setResult("불합격");
				return r;
			}
		}).forEach(r-> {
			System.out.println("이름 : "+r.getName());
			System.out.println("결과 : "+r.getResult());
			System.out.println();
		} );
		
	}

	private static void m6() {
		//중복 제거(distinct()) : 중간 파이프이며, 앞의 스트림에서 중복 요소를 제거하고, 유일한 요소만 남은 새로운 스트림을 반환한다.
		
		List<Integer> list =Data.getIntList();   //난수라 중복값이 존재.
		System.out.println(list.size());  //100개의 난수값.
		
		//Q. 위의 배열에서 중복값 제거.
		//Case 1.
		Set<Integer> set1= new HashSet<Integer>();
		for(int n : list) {
			set1.add(n);
		}
		System.out.println(set1.size());  //61개
	
		//Case 2.
		Set<Integer> set2= new HashSet<Integer>(list);   // 이거와 비슷한 내용은 아마 컬렉션 마지막 쯤에..?   //중복값 제거.
		System.out.println(set2.size());   //61개
		
		//Case 3.
		list.stream().distinct().forEach(n-> System.out.println(n));
		System.out.println(list.stream().count());  //list의 개수를 세주는 count().   //100개
		System.out.println(list.stream().distinct().count());  //원본을 가져와서. 중복을 제거하고. 개수를 출력.   //61개
		
		String[] names = {"홍길동", "아무개", "이순신", "권율", "강감찬", "연개소문", "홍길동", "이순신", "남궁장군", "연개소문"};
		Arrays.stream(names).distinct().forEach(name-> System.out.println(name));  //중복제거.
		Arrays.stream(names).distinct().filter(name-> name.length()==3).forEach(name-> System.out.println(name));
		//순서상 중복값을 먼저 없애고 넘기겠다-> 그다음 filter
		//distinct와 filter의 순서에 따라 결과가 달라질 수 있다.**
		
		List<Cup> clist=new ArrayList<Cup>();
		//컵 10개 생성
		clist.add(new Cup(Cup.BLACK, 200));
		clist.add(new Cup(Cup.BLUE, 300));
		clist.add(new Cup(Cup.RED, 400));
		clist.add(new Cup(Cup.WHITE, 500));     // 동일한 상태
		clist.add(new Cup(Cup.YELLOW, 600));   //
		clist.add(new Cup(Cup.BLACK, 700));
		clist.add(new Cup(Cup.BLUE, 800));
		clist.add(new Cup(Cup.RED, 900));
		clist.add(new Cup(Cup.WHITE, 500));     //
		clist.add(new Cup(Cup.YELLOW, 600));    //
		
		clist.stream().forEach(cup->System.out.println(cup));
		System.out.println();
		
		//Set, distinct() 로 중복 객체를 제거하려면?
		//1. hashCode() 재정의
		//2. equals() 재정의
		//위의 2개를 재정의해주면(Cup class밑에 Override로 존재.)-> 밑에 문장을 출력하면 8개로 나옴. -> 안하면 10개.
		clist.stream().distinct().forEach(cup->System.out.println(cup));   //똑같이 10개 -> 왜? -> 주소값 비교라서 다른 컵이라고 인식하기 때문에.
		
	}

	private static void m5() {
		// 스트림 : 데이터 소스로부터 탐색/조작 가능한 도구
		//          : list.stream().forEach()
		//          : 파이프(pipe) : 스트림 객체 메소드 ex) .forEach와 같은 애들
		
		//파이프의 종류
		//1. 중간 파이프 : 반환값이 존재하며, 스트림으로 돌려준다.
		
		//2. 최종 파이프 : 반환값이 없으면 void
		//                   : 반환값이 있을때는 다른 자료형을 반환한다.
		
		//요소처리 : forEach()(최종 파이프), 함수형 인터페이스 중에 적당한 것은 Consumer
		//필터링 : filter()(중간 파이프), 함수형 인터페이스 중에 적당한 것은 Predicate
		
		List<Integer> list = Data.getIntList(20);
		System.out.println(list);
		
		//Q. 짝수만 출력해라.
		for(int n : list) {
			if(n%2==0) {
				System.out.printf("%-4d",n);
			}
		}
		System.out.println();
		
		//위의 문제를 스트림으로 풀면
		list.stream().forEach(num -> {
			if(num%2==0) System.out.printf("%-4d",num);
		} );
		System.out.println();
		
		//위의 문제를 좀 더 스트림같이
		list.stream().filter(num -> num%2==0).forEach(num -> {  //넘어온 숫자가 짝수면 true.
			System.out.printf("%-4d",num);
		} );
		System.out.println();
		System.out.println("=========================");
		
		////
		Data.getStringList().stream().filter(word->word.length()>=5).forEach(word-> System.out.println(word));
		//filter는 조건식을 쓰고, forEach는 하고 싶은것을 쓰는 느낌.
		System.out.println();
		
		Data.getUserList().stream().filter(user-> user.getWeight()>=70 && user.getGender()==1).forEach(user-> System.out.println(user));
		System.out.println();
		
		Data.getUserList().stream().filter(user-> user.getWeight()>=70).filter(user-> user.getGender()==1).forEach(user-> System.out.println(user));
		//||는 안되고, &&조건일때만 가능. 위처럼 filter을 나누는 것이 가능 / forEach는 여러개 또는 중간에 쓰는 것이 불가능.
		
	}

	private static void m4() {
		//스트림을 얻어오는 방법
		//1. 배열로부터 ***
		//2. 컬렉션으로부터 ***
		
		//3. 숫자범위로부터
		//4. 파일로부터
		//5. 디렉토리로부터
		
		//1.배열로부터
		int[] nums1= {10, 20, 30};
		Arrays.stream(nums1).forEach(num->System.out.println(num));
		System.out.println();
		
		//2. 컬렉션으로부터
		ArrayList<Integer> nums2=new ArrayList<Integer>();
		nums2.add(100);
		nums2.add(200);
		nums2.add(300);
		
		nums2.stream().forEach(num->System.out.println(num));
		System.out.println();
		
		//3. 숫자범위로부터
		//Stream<Integer> : 범용 스트림 > forEach > Consumer<Integer>
		//InStream : 전용 스트림 > forEach > IntConsumer
		
		IntStream.range(1, 10).forEach(num -> System.out.println(num));
		System.out.println();
		
		//
		try {
			//4. 파일로부터 : 스트림에서 파일 읽기
			
			//Paths.get("C:\\class\\code\\java\\JavaTest\\data\\number.txt");
			//. : 현재 실행파일이 있는 폴더, 자바 콘솔 프로젝트에서는 프로젝트 루트 폴더를 표현.
			//.\\ : 생략 가능 -> data\\number.txt
			Path path = Paths.get(".\\data\\number.txt");
			
			Files.lines(path).forEach(line -> System.out.println(line));
			System.out.println();
			
			//5. 디렉토리로부터 : 목록보기 -> dir.listFiles()
			Path dir=Paths.get("C:\\class\\dev\\eclipse-jee-2021-03-R-win32-x86_64\\eclipse");
			
			Files.list(dir).forEach(p -> {
				System.out.println(p.getFileName());
				System.out.println(p.toFile().isFile());   //true는 파일, false는 폴더.
				System.out.println();
			} );
			
		}catch(Exception e) {
			System.out.println("at Ex74_Stream.m4");
			e.printStackTrace();
		}
		
	}

	private static void m3() {
		Data.getIntList().stream().forEach(num -> System.out.printf("%4d",num));
		//배열을 가져와서 스트림을 만들고 하나씩 가져와 그것을 화면에 출력합니다.
		//의식의 흐름대로 적는 느낌, 가독성이 떨어짐.
		System.out.println();
		
		Data
			.getIntList()
			.stream()
			.forEach(num -> System.out.printf("%4d",num));   //이렇게 메소드별로 나누는게 보기 좋음.
		System.out.println();
		
		Data.getUserList().stream().forEach(user->{
			System.out.println("[회원정보]");
			System.out.println("이름 : "+user.getName());
			System.out.println("나이 : "+user.getAge());
			System.out.println("성별 : "+user.getGender());
			System.out.println();
		});
		
		Data.getItemList().stream().forEach(item->{
			System.out.println(item.getName());
			System.out.println(item.getColor());
			System.out.println();
		} );
		
	}

	private static void m2() {
		// 배열(컬렉션) 탐색
		List<String> list = Data.getStringList(10);
		
		//1. for
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		System.out.println();
		
		//2. 향상된 for문
		for(String word : list) {
			System.out.print(word+" ");
		}
		System.out.println();
		System.out.println();
		
		//3. Iterator
		Iterator<String> iter = list.iterator();
		
		while(iter.hasNext()){
			System.out.print(iter.next()+" ");
		}
		System.out.println();
		System.out.println();
		
		//4. Stream
		Stream<String> stream = list.stream();
		
		Consumer<String> c1= str -> System.out.println(str+" ");  //Consumer를 구현한 오브젝트
		stream.forEach(c1);  //배열에서 가져온 데이터를 str로 넘어가서 println됨.
		//Consumer의 accept가 10번 호출된거임.
		
		//forEach 메소드 1. stream으로부터 얻어낸 데이터를 1개씩 가져온다.(향상된 for문처럼)
		//                    2. 가져온 데이터를 Consumer.accept() 메소드의 인자 전달하고 메소드를 호출한다.
		//                    3. 요소만큼 반복한다.
		
		//stream.forEach(c1); 이미 요소를 전부 소진해서 동일한 스트림을 한번 더 사용할 수 없다.
		//한번 더 사용하고 싶다면 밑에처럼 stream을 한번 더 만들어야 한다.
		stream=list.stream();
		stream.forEach(c1);
		
		list.stream().forEach(str -> System.out.println(str+" "));   // 메소드 체이닝 -> 함수형 프로그래밍 방식
		
	}

	private static void m1() {
		int[] nums1=Data.getIntArray();
		System.out.println(Arrays.toString(nums1));
		System.out.println(nums1.length);
		
		int[] nums2=Data.getIntArray(5);
		System.out.println(Arrays.toString(nums2));
		
		//List<Integer>
		List<Integer> nums3= Data.getIntList();
		System.out.println(nums3.size());
		
		List<Integer> nums4=Data.getIntList(5);
		System.out.println(nums4);
		
		//
		String[] txt=Data.getStringArray();
		System.out.println(Arrays.toString(txt));
		
		Item[] items = Data.getItemArray();
		System.out.println(Arrays.toString(items));
		
		User[] list=Data.getUserArray();
		System.out.println(Arrays.toString(list));
		
	}
}
class Cup{  //이전에 Set 수업 내용 때 했음.
	public final static int BLACK=1;
	public final static int WHITE=2;
	public final static int RED=3;
	public final static int YELLOW=4;
	public final static int BLUE=5;
	
	private int color;     //나열하고 그 중에서 선택하는 것을 열거값이라고 한다.
	//색을 String으로 받는 방법도 있지만, 오타가 날 수도 있어 불편하다. -> 개발자 손을 많이 타고, 사용자가 실수할 경우가 많다.
	private int size;
	
	public Cup(int color, int size) {
		this.color = color;
		this.size = size;
	}

	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return String.format("Cup [color=%s, size=%s]", color, size);
	}
	//개발자의 의도대로 객체를 비교하려면,,,
	@Override
	public int hashCode() {
		return (""+this.color+this.size).hashCode();
		//숫자는 값형이라 주소값x, 문자형으로 만들어야 한다.
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.hashCode()==obj.hashCode();
	}
	
}
class Result{   //Stream<String>을 받아서 map을 거치면 Stream<Result>를 줄거다.
	private String name;
	private String result;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}




