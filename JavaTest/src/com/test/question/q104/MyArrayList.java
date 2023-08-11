package com.test.question.q104;
import java.util.*;

public class MyArrayList { // 일단 제네릭말고 String 버전이라고 생각하고 만들기
	private String[] list;
	private int index; // **    //현재 요소를 대입할 방번호  //현재까지 대입된 요소의 개수

	public MyArrayList() { // 생성자
		this.index = 0;
		this.list = new String[4];
	}
	//개발할 때 유용하게 사용하는 것이 toString() !
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append(String.format("length : %d\n",this.list.length));
		sb.append(String.format("index : %d\n",this.index));
		sb.append(Arrays.toString(this.list)+"\n");
		
		return sb.toString();  //StringBuilder가 가지고 있는 문자열.
	}
	
	//public boolean add(String value)
	public void add(String value) { // 데이터 추가-append모드
		/*
		try { // 일단 에러를 미룸.
			if (this.index == 0) { // 처음 데이터 넣을때만 //배열 생성
				this.list = new String[4]; // 조건을 안 걸어주면 값을 넣을때마다 객체를 생성하기 때문에 값이 저장안됨.
			}
			// 배열의 방이 남았는지 확인 -> 없으면 공간 두배로 들리기.
			if (index == list.length) {
				String[] temp = new String[list.length * 2];
				for (int i = 0; i < list.length; i++) { // 늘린 공간에 이전 값들 복사해서 새 배열 만들어주기.
					temp[i] = list[i];
				}
				list=temp;
			}
			this.list[this.index] = value;
			this.index++; // 데이터의 개수
			
			return true;
		} catch (Exception e) {
			return false;
		}
		*/ //위의 방식도 가능
		if(checkLength()) {   //방 길이 체크해서
			doubleList();  //배열길이 늘리기
		}
		this.list[this.index]=value;
		this.index++;
		
	}
	private boolean checkLength() {
		if(this.list.length==this.index) {
			return true;  //방이 꽉 참
		}
		return false;  //방이 여유있다.
	}
	private void doubleList() {
		String[] temp=new String[this.list.length*2];
		//깊은 복사
		for(int i=0; i<this.list.length; i++) {   //루프는 짧은 배열의 길이만큼
			temp[i]=this.list[i];  //temp 배열에 기존 배열 옮기고
		}
		this.list=temp;  //배열 다시 교체.
	}

	public String get(int index) { // 읽기.
		if(index<0&&index>=this.index) {
			throw new IndexOutOfBoundsException();    // 예외발생시키기.
		}
		return this.list[index];
	}

	public int size() { // 요소의 개수를 반환.
		return this.index; // index를 읽은만큼 개수를++하니까 index를 반환해주면 됨.
	}

	public void set(int index, String value) { // 수정.
		if(index<0&&index>=this.index) {  
			throw new IndexOutOfBoundsException();    // 예외발생시키기.
		}
		list[index]=value;
	}

	public void remove(int index) { // 방 번호를 찾아서 삭제.
		for (int i = index; i < this.index - 1; i++) { // 삭제하면 앞쪽으로 시프트.
			this.list[i] = this.list[i + 1];
		}
		this.index--; //삭제하면서 방개수도 하나 줄이기.
	}

	//public boolean add(int index, String value)
	public void add(int index, String value) { // 데이터 추가-insert모드.
		if(checkLength()) {  //삽입할때 배열길이 모자르지 않은지 체크하기.
			doubleList();
		}
		if(index<0&&index>=this.index) {  //존재하지 않는 방번호이면
			throw new IndexOutOfBoundsException();    // 예외발생시키기.
		}
		//요소 삽입은 우측의 모든 요소들을 오른쪽으로 한 칸 shift. -> Right Shift. 
		for(int i=this.list.length-2; i>=index; i--) {
			this.list[i+1]=this.list[i];
		}
		this.list[index]=value;
		this.index++;  //방개수 늘리기.
		/*
		if (index == list.length) {
			String[] temp = new String[list.length * 2];
			for (int i = 0; i < list.length; i++) { // 늘린 공간에 이전 값들 복사해서 새 배열 만들어주기.
				temp[i] = list[i];
			}
			for(int i=list.length-1; i>index; i--) {
				temp[i]=temp[i-1];
			}
		}
		this.list[index] = value;  //값 넣어주고
		this.index++; // 데이터의 개수 1개 증가
		return true;
		*/ ///얘도 위와 동일.
	}

	public int indexOf(String value) { // 원하는 요소가 몇번째 위치에 있는지 위치값을 반환.
		for (int i = 0; i < this.index; i++) {
			if (list[i].equals(value))
				return i;
		}
		return -1;  //없다는 뜻.
	}
	//위랑 같은데 진행 순서 방향만 반대.
	public int lastIndexOf(String value) { // 원하는 요소가 몇번째 위치에 있는지 위치값을 반환.
		for (int i = this.index-1; i >= 0; i--) {
			if (list[i].equals(value))
				return i;
		}
		return -1;  //없다는 뜻.
	}
	//인덱스 오버로딩
	public int indexOf(String value, int beginIndex) { // 원하는 요소가 몇번째 위치에 있는지 위치값을 반환.
		for (int i = beginIndex; i < this.index; i++) {  //beginIndex는 내가 원하는 위치에서부터 찾기 시작하기.
			if (list[i].equals(value))
				return i;
		}
		return -1;  //없다는 뜻.
	}
	//라스트 인덱스 오버로딩
	public int lastIndexOf(String value, int beginIndex) { // 원하는 요소가 몇번째 위치에 있는지 위치값을 반환.
		for (int i = beginIndex; i >= 0; i--) {
			if (list[i].equals(value))
				return i;
		}
		return -1;  //없다는 뜻.
	}
	
	public boolean contains(String value) {
		for(int i=0; i<this.index; i++) {  //0부터 데이터 들어가있는 방까지 검사.
			if(this.list[i].equals(value)) return true;
		}
		return false;
	}
	
	public void clear() { // 배열의 모든 요소를 삭제.
		/*  //첫번째 방법
		for(int i=0; i<this.index; i++) {
			this.list[i]=null;
		}
		index = 0; // index를 0으로 초기화.
		*/
		/* //두번째 방법
		this.list=new String[4];  //그냥 새로운 배열로 교체.
		index=0;  //인덱스 초기화도 해줘야함.
		*/
		//세번째 방법
		index=0;   //데이터가 들어있어도 그냥 쓰레기 값으로 무시하면 된다.
	}
}