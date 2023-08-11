package com.test.question;
import java.io.*;

public class Q119 {
	public static void main(String[] args) {
		File dir=new File("C:\\Users\\leeje\\OneDrive\\바탕 화면\\학원\\직원");
		File[] list=dir.listFiles();
		
		for(File f : list) {
			String[] temp=f.getName().split("_");
			
			String name=temp[0];
			String year=temp[1];
			
			//직원이름으로 폴더 생성
			File nameDir=new File(dir.getAbsolutePath()+"\\"+name);
			nameDir.mkdir();
			
			//직원이름 폴더 밑에 년도별로 폴더를 생성하기
			File yearDir=new File(dir.getAbsolutePath()+"\\"+name+"\\"+year);
			yearDir.mkdir();
			
			//각 파일을 직원폴더 -> 년도 폴더에 이동시키기
			File dest=new File(dir.getAbsolutePath()+"\\"+name+"\\"+year+"\\"+f.getName());   //f.getName이 파일명.
			f.renameTo(dest);
			
		}
		
	}
}
