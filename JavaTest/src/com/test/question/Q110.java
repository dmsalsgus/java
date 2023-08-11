package com.test.question;
import java.util.*;
import java.io.*;

public class Q110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("파일 경로 : ");
		String path=sc.next();
		File file=new File(path);
		
		// 파일명
		System.out.println("파일명 : "+file.getName());  
		//종류
		int index=path.lastIndexOf(".");
		String extension= path.substring(index+1);
		System.out.println("종류 : "+extension+" 파일");
		//파일 크기
		if(file.length()<1024) System.out.println("파일 크기 : "+file.length()+"B");
		else if(file.length()<=1024*1024) System.out.printf("파일 크기 : %.2f KB\n",file.length()/1024.0);
		else if(file.length()<=1024*1024*1024) System.out.printf("파일 크기 : %.2f MB\n",file.length()/1024.0/1024.0);
		else if(file.length()<=1024*1024*1024*1024) System.out.printf("파일 크기 : %.2f GB\n",file.length()/1024.0/1024.0/1024.0);
		else System.out.printf("파일 크기 : %.2f TB\n",file.length()/1024.0/1024.0/1024.0/1024.0);
		
	}
}
