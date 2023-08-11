package com.test.java.dummy;
import java.io.*;
import java.util.*;

public class Ex75 {
	public static void main(String[] args) throws Exception {
		// 프로그램 제작에 필요한 데이터
		// 1. 테스트용 데이터 : 진짜 데이터 -> 10% -> 직접 작성
		// 2. 더미 데이터 : 양만 채우는 용도 -> 90% -> 프로그램으로 작성

		// ex) 게시판 만들기
		// 단순하게 "게시판입니다"를 200개 만들기

		// 회원가입하고 명단을 출력하는 기능 만들기
		// JavaTest-> data -> member.txt만들기
		// 규칙은 1,홍길동,20,010-1234-4567,서울시 강남구 역삼동 -> 과 같이 작성하기
		// 그다음이 데이터 생성

		Random rd = new Random(); // 숫자 난수
		String[] name1 = { "김", "이", "박", "최", "정", "현", "길", "조", "신", "허" }; // 성
		String[] name2 = { "진", "민", "인", "지", "명", "정", "재", "석", "길", "동", "현", "훈", "원", "혜" }; // 이름
		String[] address1 = { "서울시", "부산시", "대전시", "광주시", "제주시" }; // 시
		String[] address2 = { "강동구", "강남구", "강서구", "강북구", "중구" }; // 구
		String[] address3 = { "역삼동", "대치동", "압구정동", "천호동", "방배동" }; // 동

		// 파일쓰기
		BufferedWriter writer = new BufferedWriter(new FileWriter("data\\member.txt")); // 예외처리 해줘야함 try-catch

		try {

			for (int i = 0; i < 100; i++) {
				int no = i + 1; // 회원번호
				String name = name1[rd.nextInt(name1.length)] + name2[rd.nextInt(name2.length)] + name2[rd.nextInt(name2.length)]; // 이름 조합
				int age = rd.nextInt(41) + 20; // 나이
				String tel = "010-" + (rd.nextInt(9000) + 1000) + "-" + (rd.nextInt(9000) + 1000); // 연락처
				String address = address1[rd.nextInt(address1.length)] + " " + address2[rd.nextInt(address2.length)] + " " + address3[rd.nextInt(address3.length)];
				// 번지까지 출력하고 싶으면 주소 끝에 붙여주기 -> +(rd.nextInt(100))+20 + "번지";

				writer.write(String.format("%d,%s,%d,%s,%s\r\n", no, name, age, tel, address));
			}

			writer.close();
		} catch (Exception e) {
			System.out.println("at Ex75.java");
			e.printStackTrace();
		}

	}
}
