package com.test.java.io;
import java.io.*;
import java.util.*;

public class Ex65_File {
	
	public static final String FILE="C:\\class\\code\\java\\file\\list.txt";
	
	public static void main(String[] args) {
		//파일 입출력 : 응용프로그램 <- (데이터) -> 저장장치(*.txt)
		
		//저장장치 : 데이터를 1과 0으로 저장
		//            : 데이터의 자료형은 존재하지 않는다.  -> 모두 다 문자
		
		//인코딩(Encoding) : 문자 코드(자바 데이터)를 부호화(1, 0)시키는 작업
		//                      : 자바 프로그램("홍길동")을 텍스트 파일(100100100110110)
		
		//디코딩(Decoding) : 부호화 데이터를 문자 코드로 변환하는 작업
		//                      : 텍스트 파일(100100100110110)을 자바 프로그램("홍길동")으로 변환.
		
		//인코딩과 디코딩 규칙
		//1. ISO-8859-1
		//2. EUC-KR
		//3. ANSI
		//4. MS949(CP949)
		//5. UTF-8
		//6. UTF-16
		//7.ASCII
		
		//ANSI(ISO-8859-1, EUC-KR, MS949)
		//1. 영어(숫자, 특수문자, 서유럽 문자 등) : 1byte
		//2. 한글(한자, 일본어 등) : 2byte
		
		//UTF-8 *** -> 국제 표준으로, 대부분 이것을 사용.
		//1. 영어 : 1byte
		//2. 한글 : 3byte
		
		//UTF-16
		//1. 영어 : 2byte
		//2. 한글 : 2byte
		
		//m1();
		//m2();
		
		//m3();
		//m4();
		
		//m5();
		//m6();
		
		//m7();   //메모장 만들기
		//m8();
		
	}

	private static void m8() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\code\\java\\JavaTest\\src\\com\\test\\java\\Ex32_Array.java"));
			
			String line=null;
			int n=1;  //줄번호를 위한 변수
			while((line=reader.readLine()) != null) {
				System.out.printf("%3d : %s\n", n, line);
				n++;
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at Ex65_file.java");
			e.printStackTrace();
		}
		
	}

	private static void m7() {
		// 메모장 쓰기
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("저장할 파일명 : ");
			String filename=sc.nextLine();
			
			BufferedWriter writer =new BufferedWriter(new FileWriter("C:\\class\\code\\java\\file"+filename+".txt"));
			
			while(true) {
				System.out.print("입력 : ");
				String line=sc.nextLine();
				
				if(line.equals("exit")) {
					break;
				}
				
				writer.write(line);   //sc로 한줄 입력, writer로 한줄 쓰기
				writer.write("\r\n");
			}
			writer.close();
		}catch(Exception e){
			System.out.println("at Ex65_file.java");
			e.printStackTrace();
		}
		
	}

	private static void m6() {
		// 읽기 : FileInputStream -> FileReader -> BufferedReader
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  //키보드 입력을 받는 파일
			
			BufferedReader reader2 = new BufferedReader(new FileReader("C:\\class\\code\\java\\file\\memo.txt"));  // 텍스트 파일을 읽는 파일
			
			//reader2.read();
			//reader2.readLine();
		
			//String line=reader2.readLine();
			//System.out.println(line);
			
			String line=null;
			while((line=reader2.readLine()) != null){   //null이 아니면 반복문으로 -> 읽다가 더 읽을게 없으면 null을 반환.
				System.out.println(line);
			}
			
			reader2.close();
		}catch(Exception e) {
			System.out.println("at Ex65_file.java");
			e.printStackTrace();
		}
		
	}

	private static void m5() {
		// 쓰기 : FileOutputStream -> FileWriter -> BufferedWriter
		//FileWriter와 BufferedWriter의 기능은 비슷하지만, 짝을 맞추기 위해서 BufferedReader를 쓸 때는 BufferedWriter를 써준다.
		
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\class\\code\\java\\file\\memo.txt"));
			
			writer.write("하나");
			writer.write('A');
			writer.write("\r\n");   //enter
			writer.write("둘");
			writer.newLine();
			writer.write("셋");
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Ex65_file.java");
			e.printStackTrace();
		}
		
	}

	private static void m4() {
		//파일 읽기 : FileInputStream -> FileReader
		
		try {
			FileReader reader=new FileReader("C:\\class\\code\\java\\file\\member.txt");
			
//			int code=reader.read();  //한글자씩만 읽어준다.
//			System.out.println(code);   //한글깨짐
			
			int code=-1;
			while((code=reader.read()) != -1) {     //이게 아쉬운점
				System.out.println((char)code);
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at Ex65_file.java");
			e.printStackTrace();
		}
		
	}

	private static void m3() {
		// 파일 쓰기 : FileOutputStream -> FileWriter
		
		try {
			FileWriter writer = new FileWriter("C:\\class\\code\\java\\file\\member.txt");
			writer.write(65);
			writer.write("ABC");
			writer.write("홍길동");  //이게 좋은점
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Ex65_file.java");
			e.printStackTrace();
		}
		
	}

	private static void m2() {
		// 파일 읽기
		//- FileOutputStream
		//- FileInputStream
		
		try {
			//읽기 스트림을 생성
			FileInputStream stream=new FileInputStream(Ex65_File.FILE);   //정적변수니까 앞에 클래스 이름 붙이기.
			
			int code=-1;
			
			while((code=stream.read()) != -1) {   //글자가 있을때까지 루프 돌기 -> 틀 아예 외워버리기.
				System.out.print((char)code);   //코드값을 char로 바꾸기.
			}
			System.out.println();
			
			stream.close();
			
		}catch(Exception e){
			System.out.println("at Ex65_file.java");
			e.printStackTrace();
		}
		
	}

	private static void m1() {
		//파일 쓰기 : 스트림 객체가 필요하다.
		//쓰기 스트림 객체를 만들기
		
		//스트림 객체
		//1. 생성 모드(Create Mode) : 덮어쓰기, 기존에 있던 파일을 없애고 다시쓴다.
		//                                  : 파일이 존재하지 않으면 자동으로 생성한다.
		//                                  : 파일이 존재하면 항상 덮어쓰기를 한다.------------> 더 자주 사용함.
		
		//2 추가 모드(Append Mode) : 기존 내용에서 이어쓰기.
		//                                   : 파일이 존재하지 않으면 자동으로 생성한다.
		//                                   : 파일이 존재하면 항상 이어쓰기를 한다.
		
		try {
			File file=new File("C:\\class\\code\\java\\file\\list.txt");   //list.txt는 존재안함.
			//스트림 객체 생성은 "스트림을 열었습니다."라는 뜻  -> 스트림 열기
			//스트림 객체 생성은 바이트 단위의 쓰기를 한다.(1 byte) -> 한글은 2 byte라서 읽고쓰기 불가능.
			
			//FileOutputStream stream=new FileOutputStream(file);   //덮어쓰기
			//FileOutputStream stream=new FileOutputStream(file, false);   //덮어쓰기
			FileOutputStream stream=new FileOutputStream(file,true);   //이어쓰기
			
			stream.write(65);  //A
			stream.write('B');
			stream.write(67);
			
			//stream.write('홍');    //한글 깨진거임.
			//stream.write('길');    //한글 깨진거임.
			//stream.write('동');    //한글 깨진거임.
			
			String txt="Hello~ Hong!";
			
			for(int i=0; i<txt.length(); i++) {
				stream.write(txt.charAt(i));
			}
			
			//스트림은 무조건 닫아야 한다.
			//안닫으면 저장이 안되고, 잠긴 파일이 된다.
			stream.close();
			System.out.println("종료");
			
		} catch (Exception e) {
			System.out.println("at Ex65_file.java");
			e.printStackTrace();
		}
		
	}
}
