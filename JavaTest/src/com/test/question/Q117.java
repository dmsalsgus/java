package com.test.question;
import java.util.*;
import java.io.*;

public class Q117 {
	public static void main(String[] args) {
		File dir= new File("C:\\Users\\leeje\\OneDrive\\바탕 화면\\학원\\폴더 삭데");   //글씨 수정해야함.
		
		//탐색
		delete(dir);
		
		System.out.println("종료");
	}

	private static void delete(File dir) {
		File[] list=dir.listFiles();
		
		for(File f:list) {
			if(f.isFile()) {  //파일이니
				f.delete();  //그럼 지워
				//cnt++;  //지워지는 파일 개수 카운트하는 방법
			}
		}
		for(File d:list) {
			if(d.isDirectory()) {
				delete(d);
				//dnct++;   //지워지는 폴더 개수 카운트하는 방법
			}
		}
		//두개의 for문을 빠져나왔다는 것은 빈 폴더라는 뜻.
		dir.delete();   //자신이 비워졌다고 생각하는 순간 자기자신도 지우기.
		
	}
}
