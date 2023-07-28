package com.test.java;
import java.util.*;

public class Ex32_Array {
	public static void main(String[] args) {
		//배열(=Array) : 자료 구조 중 하나, 참조형에 포함된다.
		//배열은 여러개의 데이터를 저장할 수 있는 자료형의 집합 데이터
		//같은 자료형이나 같은 성격의 데이터 집합
		//

		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		//m10();
		//m11();
		//m12();
		//m13();
		
	}

	private static void m13() {
		int[] nums= {5,3,1,4,2}; 
		Arrays.sort(nums);  //퀵정렬
		System.out.println(Arrays.toString(nums));
	}
	private static void m12() {
		// 정렬 : 요소간의 크기를 비교해서 다시 재배치하는 방법
		//종류 : 오름차순 정렬(작은수->큰수), 내림차순 정렬(큰수->작은수)
		//문자열 정렬일 경우 : 오름차순일 때, 문자코드값 순으로 정렬.
		//날짜시간 정렬일 경우 : 오름차순일 때, 과거->미래 / 내림차순 : 미래->과거
		
		//정렬 구현 방법 : 개발자 구현 or jdk or Library
		
		//버블 정렬로 오름차순으로 출력하기.  //쉽지만 느리다.
		int[] nums= {5,3,1,4,2};
		System.out.println(Arrays.toString(nums));  //원본 출력
		
		for(int i=0; i<nums.length-1; i++) {  //0,1,2,3만 돌게끔해라.->cycle
			for(int j=0; j<nums.length-1-i; j++) {
				if(nums[j]>nums[j+1]) {  //오름차순   //부등호를 바꾸면 내림차순
					int temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
		
	}

	private static void m11() {
		// 배열 초기화 리스트
		int[] nums=new int[3];
		System.out.println(Arrays.toString(nums));  //0, 0, 0
		
		nums[0]=100;
		nums[1]=200;
		nums[2]=300;
		System.out.println(Arrays.toString(nums));
		
		//초기화 리스트
		int[] nums2=new int[] {100,200,300};  //초기화하는 방법1  //길이 적으면 에러남.
		System.out.println(Arrays.toString(nums2));  //배열 출력하는 클래스
		
		int[] nums3= {100, 200, 300};  //초기화하는 방법2
		System.out.println(Arrays.toString(nums3));
		
		
		String[] names1=new String[3];
		names1[0]="홍길동";
		names1[1]="아무개";
		names1[2]="하하하";
		
		String[] names2= {"홍길동", "아무개", "하하하"};
		
		System.out.println(Arrays.toString(names1));
		System.out.println(Arrays.toString(names2));
			
	}

	private static void m10() {
		int a;  //null
		//System.out.println(a);
		
		//배열 자동 초기화
		//배열(참조형)은 생성 직후에 자동으로 초기화 된다.
		//초기화 규칙.
		//1. 정수배열은 0으로 초기화
		//2. 실수배열은 0.0으로 초기화
		//3. 문자배열은 \0으로 초기화
		//4. 논리배열은 false으로 초기화
		//5. 참조형배열은 null으로 초기화
		int[] nums=new int[3];   ///int x 3
		System.out.println(nums[0]);  //0
		System.out.println(Arrays.toString(nums));
		
		double[] nums2=new double[3];
		System.out.println(Arrays.toString(nums2));
		
		char[] nums3=new char[3];
		System.out.println(Arrays.toString(nums3));
		
		boolean[] nums4=new boolean[3];
		System.out.println(Arrays.toString(nums4));
		
		String[] nums5=new String[3];
		System.out.println(Arrays.toString(nums5));
		
	}

	private static void m9() {
		// 유틸리티 클래스 : int -> Integer / double -> Double
		//arrays 클래스 : 배열 전용 유틸리티 클래스
		int[] nums=new int[3];
		nums[0]=111;
		nums[1]=222;
		nums[2]=333;
		
		printArray(nums);  //배열의 상태 출력.
		//dump(덤프) : 객체의 상태를 하나의 문자열로 풀어내는 행동.(=printArray와 같은 메소드를 의미)
		
		System.out.println(nums);  //[I@7d6f77cc 출력.-> @가 배열을 의미. @를 기준으로 I(Integer)와 메모리 주소로 구분됨.
		                                  //여기서 메모리 주소는 해시코드라고 부름.
		System.out.println(Arrays.toString(nums));  //[111, 222, 333]가 출력.
		
		//깊은 복사
		int[] copy;
		copy=Arrays.copyOfRange(nums,0,nums.length); //원본의 0~(길이-1) 만큼 복사
		nums[0]=1000;  //원본수정
		System.out.println(Arrays.toString(nums));  ///[1000, 222, 333]
		System.out.println(Arrays.toString(copy));  ///[111, 222, 333]
		
	}
	public static void printArray(int[] nums) {  //배열도 매개변수로 가능.
		for(int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}  //잘 저장되었는지 확인하는 출력문
	}

	private static void m8() {
		// 배열 복사
		//1. 얕은 복사(=Shallow Copy) : 주소값 복사로 side effect가 발생.
		//2. 깊은 복사(=Deep Copy) : 요소 복사로 side effect가 발생하지 않음.
		//깊은 복사
		int[] nums = new int[3]; 
		nums[0]=100;
		nums[1]=200;
		nums[2]=300;
		
		int[] copy=new int[3];  //변수만 만드는 것이 아니라 배열을 생성.
		
		for(int i=0; i<nums.length; i++) {
			copy[i]=nums[i];  //배열끼리의 복사(주소값 복사)가 아닌 int 값형끼리 복사.
		}
		System.out.printf("num[0] : %d\n",nums[0]);  //100
		System.out.printf("copy[0] : %d\n",copy[0]);  //100
		
		nums[0]=1000;
		System.out.printf("num[0] : %d\n",nums[0]);  //1000
		System.out.printf("copy[0] : %d",copy[0]);  //100
		///위의 방식처럼하면 copy의 값은 변하지 않음.
		
	}

	private static void m7() {  // 배열을 복사
		//얕은 복사
		int a=10;  //원본
		int b;
		b=a;
		//원본을 수정 -> 복사본에게 영향을 미치는지 확인하기.
		a=20;
		System.out.printf("a : %d\n",a);
		System.out.printf("b : %d\n",b);
		//값형끼리 복사는 side effect가 발생하지 않는다.
		
		//배열 복사
		int[] num= new int[3]; //원본
		num[0]=100;
		//stack에 저장되어있는 num에 찾아갔더니 주소를 받아서 heap에 접근하는 것
		num[1]=200;
		num[2]=300;
		
		int[] copy;
		copy=num;  
		//배열 변수끼리의 복사는 주소값 복사다.
		
		//원본 수정
		num[0]=1000;
		//**num과 copy는 같은 주소값을 가지고, 같은 배열을 가리킨다.
		//둘 중 하나를 조작하면 나머지 배열도 영향을 받아 side effect가 발생한다.
		
		System.out.printf("num[0] : %d\n",num[0]);  //1000
		System.out.printf("copy[0] : %d",copy[0]);    //1000
		//가리키는 주소 번지가 동일하기 때문에 복사 시 영향을 받는다.
		//**개발자가 만드는 모든 지역변수는 stack에 생성한다.
		//new와 함께 쓰이는 애들은 heap에 저장된다.

	}

	private static void m6() {
		//배열의 길이는 런타임때 정할 수도 있다.
		Scanner sc = new Scanner(System.in);
		System.out.print("학생수 : ");
		int student=sc.nextInt();
		int[] kors=new int[student];
		
		System.out.println(kors.length);
		
	}

	private static void m5() {
		// ***메모리의 공간은 한번 할당받으면, 절대로 공간을 더 늘리거나 줄일 수 없다.
		int[] num=new int[3];  //4byte x 3 = 12byte  //길이 3이 고정이므로 변경불가능
		//배열은 처음부터 사용하는 최대 길이를 미리 예측해야한다. 나중에 수정이 불가능하기때문.
		
	}

	private static void m4() {
		// 각 자료형으로 배열만들기
		
		//정수 배열(byte, short, int, long)
		long[] list1=new long[5];
		list1[0]=100;
		System.out.println(list1[0]);
		
		//실수 배열(float, double)
		double[] list2=new double[5];
		list2[0]=3.14;
		System.out.println(list2[0]);
		
		//문자 배열(char)
		char[] list3=new char[5];
		list3[0]='A';
		System.out.println(list3[0]);
		
		//논리 배열(boolean)
		boolean[] list4=new boolean[5];
		list4[0]=true;
		System.out.println(list4[0]);
		
		//참조형
		String[] list5=new String[5];
		list5[0]="홍길동";
		System.out.println(list5[0]);
		
		//Calendar c1;
		Calendar[] list6=new Calendar[5];  //null값으로 아무것도 없음.
		//캘린더를 5개 만든것이 아닌 캘린더를 저장할 수 있는 변수 5개를 만든 것.
		list6[0]=Calendar.getInstance();  //이렇게 값을 넣어줘야함.
		System.out.printf("%tF\n",list6[0]);

	}

	private static void m3() {
		int[] nums = new int[3];  //3칸짜리 int 자료형의 nums라는 이름의 배열
		//길이 = 3, 인덱스(방번호) = 0~2(=0~길이-1까지 방번호 존재)
		//방 1개(데이터) : 배열의 요소(Element)라고 부름.
		
		nums[0]=100;
		nums[1]=200;
		nums[2]=300;
		//nums[3]=300;  //실행하면 런타임에러가 난다.
		//java.lang.ArrayIndexOutOfBoundsException:  //배열의 길이를 벗어났다는 에러msg
		
		//배열의 방을 원하는 순서대로 접근하는 것이 '탐색'. -> 보통 for문을 주로 사용함.
		for(int i=0; i<nums.length; i++) {
			nums[i]=i;
			System.out.printf("nums[%d] = %d\n",i,nums[i]);
		}
	}

	private static void m2() {
		// 학생 3명의 국어 점수를 저장해서 총점이나 평균(실수) 구하기
		//추가사항 -> 학생 수가 300명으로 증가
		//1. 배열 선언 및 생성하기 : 자료형[] 배열이름 = new 자료형[정수];
		int[] kors=new int[300];  //4byte의 int공간이 연속적으로 3개 잡힌 것.
		
		//배열의 방 갯수==배열의 길이
		System.out.println(kors.length); //배열의 길이를 확인하는 방법.
		/*
		kors[0]=100;  //첫번째방
		kors[1]=90;
		kors[2]=80;
		
		int total =kors[0]+kors[1]+kors[2];  //총점
		*/
		int total=0;
		for(int i=0; i<kors.length; i++) {  //배열의 길이를 사용하는 방법
			//i<학생 수 만큼인데, kors.length를 쓰면 학생수 변동이 있을 때 유용함.
			total+=kors[i];
		}
		double avg= (double)total/kors.length;  //평균
		
		System.out.printf("총점 : %d점, 평균 : %.1f점",total, avg);	
		
	}

	private static void m1() {
		// 학생 3명의 국어 점수를 저장해서 총점이나 평균(실수) 구하기
		//추가사항 -> 학생 수가 300명으로 증가
		int kor1=100, kor2=90, kor3=80;
		int total=kor1+kor2+kor3;
		
		double avg=total/3.0;  //또는 (double)total/3;
		System.out.printf("총점 : %d점, 평균 : %.1f점",total, avg);	
	}
}