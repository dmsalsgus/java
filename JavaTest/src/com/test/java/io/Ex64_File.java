package com.test.java.io;
import java.io.*;
import java.util.Calendar;

public class Ex64_File {
	private static int cnt=0;   //static 메소드에서는 static이 안 붙은 변수는 사용 불가
	//->그래서 cnt변수도 static붙여야함.   //파일 개수.
	private static int dcnt=0;  //폴더개수
	private static long length=0;  //폴더 크기
	public static void main(String[] args) {
		//1. 파일 / 디렉토리 조작 : 윈도우 탐색기로 하는 모든 행동을 자바로 구현.
		//                               : 파일 -> 정보 확인, 새로 만들기, 이름 바꾸기, 이동하기, 삭제하기 등등
		//                               : 폴더 -> 정보 확인, 새로 만들기, 이름 바꾸기, 이동하기, 삭제하기 등등 파일과 비슷.
		
		//2. 파일 입출력 : 파일을 읽거나 쓰기. / 메모장과 같은 기능. -> 자바로 구현하기.
		
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
		
		//m14();  //15을 위한 빌드업
		m15();  //************************************
	}

	private static void m15() {
		//특정 폴더 안에 있는 파일 개수 세기
		File dir =new File("C:\\class\\dev\\eclipse-jee-2021-03-R-win32-x86_64\\eclipse");
		
		if(dir.exists()) {
			countFile(dir);  //메소드로 빼기
			System.out.printf("총 파일 개수 : %d개\n",cnt);    //파일개수
			System.out.printf("총 폴더 개수 : %d개\n",dcnt);   //폴더개수
			System.out.printf("폴더 크기 : %dB\n",length);   //폴더 크기
		}
	}

	private static void countFile(File dir) {
		//메소드 만들기 -> 블럭 잡고 -> 오른쪽 마우스 -> Refactor -> Extract Method 선택하면 자동으로 만들어진다.
		
		//1. 목록 가져오기
		File[] list=dir.listFiles();
		
		//2. 파일 개수만 세기
		for(File subfile :list) {
			if(subfile.isFile()) {
				cnt++;
				length+=subfile.length();   //파일 크기를 누적 -> 폴더 크기가 된다.
			}
		}
		//3. 자식 폴더를 대상으로 1~2번을 반복.
		for(File subdir : list) {
			if(subdir.isDirectory()) {
				//1~2번 실행 -> 3번 -> 손자폴더
				dcnt++;
				countFile(subdir);   //자식 폴더를 반복.(재귀)
				
			}
		}
	}

	private static void m14() {
		// 특정 폴더 안에 있는 파일 개수 세기
		File dir =new File("C:\\class\\dev\\eclipse-jee-2021-03-R-win32-x86_64\\eclipse");
		
		int cnt=0;  //누적변수
		
		if(dir.exists()) {
			File[] list=dir.listFiles();
			
			for(File subfile : list) {
				if(subfile.isFile()) { 
					cnt++;
				}
			}
			for(File subdir:list) {
				if(subdir.isDirectory()) {  //자식폴더의 내용
					File[] sublist=subdir.listFiles();
					
					for(File subsubfile : sublist) {
						if(subsubfile.isFile()) {
							cnt++;
						}
					}
					for(File subsubfile : sublist) {
						if(subsubfile.isDirectory()) {
							//손자 폴더의 내용
							//File[] subsublist=subsubdir.listFiles();
							
						}
				}
			}
			//계속 반복해서 폴더 없을때까지 반복.
			System.out.printf("총 파일 개수 : %d개\n",cnt);
			
			}
		}
	}

	private static void m13() {
		// 특정 폴더의 내용 보기
		String path=String.format("C:\\class\\dev\\eclipse-jee-2021-03-R-win32-x86_64\\eclipse");
		
		File dir=new File(path);
		
		if (dir.exists()) {
			//1. dir.list();
			//2. dir.listFiles();
			
			/* 1.
			String[] list=dir.list();
			for(String f:list) {
				//System.out.println(f);   //가지고 있는 자원들을 문자열로 돌려주기.
				File file=new File(path+"\\"+f);
				System.out.println(f+">"+(file.isFile() ? "파일" : "폴더"));
			}
			*/
			/* 2.
			File[] list=dir.listFiles();
			for(File f:list) {
				System.out.printf("%s - %s\n",f.getName(),f.isDirectory() ? "파일" : "폴더");
			}
			*/
			
			//탐색기 느낌으로 정리정돈해서 예쁘게 출력.
			File[] list=dir.listFiles();
			for(File d : list) {
				if(d.isDirectory()) {
					System.out.printf("[%s]\n",d.getName());
				}
			}
			for(File f : list) {
				if(f.isFile()) {
					System.out.println(f.getName());
				}
			}
			
		}
		
	}

	private static void m12() {
		//폴더 삭제하기 -> 빈 폴더일때만 가능하다. 내용물(자식, 자식폴더)이 있으면 삭제 불가능.
		File dir= new File("C:\\class\\code\\java\\aaa");
		
		if(dir.exists()) {
			System.out.println(dir.delete());
		} 
	}

	private static void m11() {
		//폴더 다른곳으로 이동하기
				
		File dir=new File("C:\\class\\code\\java\\file\\할일");     //수정 전 모습의 파일
		File dir2=new File("C:\\class\\code\\java\\move\\할일");
				
				if(dir.exists()) {
					System.out.println(dir.renameTo(dir2));
				} 
		
	}

	private static void m10() {
		//Q. 폴더 이름 바꾸기
		File dir= new File("C:\\class\\code\\java\\file\\날짜");
		File dir2= new File("C:\\class\\code\\java\\file\\할일");
		
		if(dir.exists()) {
			dir.renameTo(dir2);   //이름바꾸기
		}
		
	}

	private static void m9() {
		// Q. 날짜별 폴더만들기 -> 2023-01-01 ~ 2023-12-31까지
		
		Calendar c=Calendar.getInstance();
		c.set(2023,0,1);   //2023-01-01  //month는 -1.
		
		System.out.println(c.getActualMaximum(Calendar.DAY_OF_YEAR));  //2023년에서 특정단위의 최댓값을 뽑아내는 것.
		//2023년이 총 몇일인지.
		
		int max=c.getActualMaximum(Calendar.DAY_OF_YEAR);
		for(int i=0; i<max; i++) {
			//"2023-01-01"
			String name=String.format("%tF",c);
			System.out.println(name);
			
			File dir=new File("C:\\class\\code\\java\\file\\날짜\\"+name);
			dir.mkdirs();
			
			c.add(Calendar.DATE,1);
			
		}
			
	}

	private static void m8() {
		//Q. 회원들의 회원명으로 개인 폴더 생성하기.
		
		String[] member= {"홍길동","아무개","이순신","권율","유관순"};
		
		for(int i=0; i<member.length; i++) {
			String path=String.format("C:\\class\\code\\java\\file\\회원\\[개인폴더]%s님",member[i]);
			File dir=new File(path);
			System.out.println(dir.mkdirs());	
		}
		
	}

	private static void m7() {
		//폴더 만들기
		//File dir=new File("C:\\class\\code\\java\\aaa");
		File dir=new File("C:\\class\\code\\java\\bbb\\ccc");
		
		if(!dir.exists()) {
			//System.out.println(dir.mkdir());  //폴더 1개 만들기
			System.out.println(dir.mkdirs());   //연관된 폴더 전부 만들기
		}
		
	}

	private static void m6() {
		// 파일 삭제하기
		File file=new File("C:\\class\\code\\java\\move\\데이터.txt");
		
		if(file.exists()) {
			//휴지통은 파일 삭제가 아니라 파일 이동이다.
			System.out.println(file.delete());;
		}
		
	}

	private static void m5() {
		//파일을 다른곳으로 이동하기
		//C:\\class\\code\\java\\file\\data.txt -> C:\\class\\code\\java\\move 밑으로 옮기세요.
		
		File file=new File("C:\\class\\code\\java\\file\\data.txt");     //수정 전 모습의 파일
		File file2=new File("C:\\class\\code\\java\\move\\data.txt");
		
		if(file.exists()) {
			System.out.println(file.renameTo(file2));
		}
		
	}

	private static void m4() {
		// 파일명 변경하기
		File file=new File("C:\\class\\code\\java\\file\\data.txt");     //수정 전 모습의 파일
		File file2=new File("C:\\class\\code\\java\\file\\데이터.txt");    //수정 후 모습의 파일

		if(file.exists()) {
			System.out.println(file.renameTo(file2));
		}
		
	}

	private static void m3() {
		//파일 생성하기
		//1. 참조 객체 만들기
		File file=new File("C:\\class\\code\\java\\file\\hello.txt");
		
		if(!file.exists()) {
			try {
				System.out.println(file.createNewFile());   //새 파일이자 아무것도 없는 빈 파일
				//file.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else System.out.println("이미 동일한 파일 있음.");
		
	}

	private static void m2() {
		//폴더(Folder)==디렉토리(Directory)
		// 폴더의 정보를 확인하기
		
		//폴더 참조 객체를 생성해야한다. 폴더는 공간의 개념보다 참조의 개념.
		
		File dir=new File("C:\\class\\code\\java\\file");   //파일과 똑같음. -> 왜 같은거 써? -> 폴더도 파일이라서
		
		if(dir.exists()) {
			System.out.println("파일 있음");
			//업무
			System.out.println(dir.getName());  //file
			System.out.println(dir.isFile());   //false -> 파일은 아니니까
			System.out.println(dir.isDirectory());    //true
			System.out.println(dir.length());   //0
			System.out.println(dir.getAbsolutePath());  // C:\class\code\java\file (전체경로)
			System.out.println(dir.lastModified());  // 마지막으로 수정한 날짜  //1691379504117
			System.out.println(dir.isHidden());    //false  숨김파일이냐 아니냐
			System.out.println(dir.getParent());  //C:\class\code\java -> 부모가 누구냐
			
		}else System.out.println("파일 없음");
		
	}

	private static void m1() {
		//특정 파일의 정보를 확인하기.
		//C:\class\java\file 폴더 생성 후 data.txt 파일 생성하기
		
		//자바 프로그램에서 외부의 파일을 접근.
		//1. 외부 파일을 참조하는 참조 객체를 생성해야한다. -> 일종의 대리인, 위임자같은 느낌.
		//2. 참조 객체를 조작한다.(1번을 조작)-> 객체를 조작했지만 결과는 외부 파일에 알아서 적용된다.
		
		//파일 참조 객체 클래스가 존재한다.(import java.io.*;)
		File file=new File("C:\\class\\code\\java\\file\\data.txt");  //파일 참조 객체
		
		System.out.println(file.exists());  //true
		
		if(file.exists()) {
			System.out.println("파일 있음");
			//업무
			System.out.println(file.getName());  //data.txt
			System.out.println(file.isFile());   //true
			System.out.println(file.isDirectory());    //false
			System.out.println(file.length());   //36  (파일크기(바이트))
			System.out.println(file.getAbsolutePath());  // C:\class\code\java\file\data.txt (전체경로)
			System.out.println(file.lastModified());  // 마지막으로 수정한 날짜  //1691379560139
			System.out.println(file.isHidden());    //false  숨김파일이냐 아니냐
			
			//Tick -> 년월일시분초
			Calendar c1= Calendar.getInstance();
			System.out.println(c1.getTimeInMillis());
			c1.setTimeInMillis(file.lastModified());
			
			System.out.printf("%tF %tT\n",c1,c1);
			
		}else System.out.println("파일 없음");
		
	}
}
