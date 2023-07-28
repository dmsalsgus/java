package com.test.question;
import java.util.*;

public class Q079 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr=new int[3][3];
		Random rd=new Random();
		int num = rd.nextInt(9)+1;
		
    	int a = (int)(num /3);  //배열위치
    	int b = (int)(num % 3);   //배열위치
    	
	    for(int i =1; i<=9; i++) {
	    	if(arr[a][b]==0) {
	    		arr[a][b] = i;
	    	}
	    	else if (arr[a][b] != 0) { // 이동
	    		a= a -1;
		    	b = b+1;
		    	if (a<0) {
					a = 2;
				}
		    	if (b>2) {
					b=0;
				}
		    	if ((arr[a][b] < i )&& (arr[a][b] != 0)) {
		    		a = a+1;
		    		b = b+1;
		    		if(a>2) {
		    			a=0;
		    		}
		    		if(b>2) {
		    			b=0;
		    		}
		    		arr[a][b] =i;
		    	}
		    	else arr[a][b] =i;
			}
	    }
	    //출력
	    for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
	}
}
