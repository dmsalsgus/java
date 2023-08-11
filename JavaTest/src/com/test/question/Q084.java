package com.test.question;

public class Q084 {  //특정 단어가 문장내에 몇회 있어있는지 수를 세시오.
	// 대상 문자열: String content = "안녕~ 길동아~ 잘가~ 길동아~";
	// 검색 문자열: String word = "길동";
	public static void main(String[] args) {
		String content="안녕~ 길동아~ 잘가~ 길동아~";  //대상 문자열
		String word="길동";   //검색 문자열
		int cnt=0, index=-1;
		for(int i=0; i<2; i++) {
			index=content.indexOf(word,index);
			index+=2;
			cnt++;
		}
		System.out.printf("'길동'을 총 %d회 발견했습니다.\n",cnt);
	}
}