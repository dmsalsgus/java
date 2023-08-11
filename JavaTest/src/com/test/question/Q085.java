package com.test.question;
import java.util.*;

public class Q085 {  //하이픈 유무와 상관없이 출력
	//올바른 주민등록번호의 기준  //951220-1021547 -> 올바른 주민등록번호입니다.
	//맨 앞 2자리를 00~99 : 따로 유효성 검사 필요없음
	//그 다음 2자리는 월로, 1~12
	//다음 2자리는 일로, 1~31로
	//하이픈 다음 1자리는 성별  1900년대생 : 1은남자, 2는여자 / 2000년대생 : 3은 남자, 4는 여자
	//1800년대생 : 9는 남자, 0은 여자 / 5,6은 외국인(귀화) / 1~0까지 전부 쓰임
	//그다음 4자리는 출생신고한 지역의 번호, 지역번호
	//그 다음 1자리는 출생신고 순서
	//마지막 번호는 공식에 따라 마지막번호와 일치하는지 확인
	//공식 : 주민번호 각 자릿수마다 * 2 3 4 5 6 7 8 9  2 3 4 5 = 나온 수를 전부 더하고, 11로 나눈 나머지를, 11에서 다시뺀다.
	//나머지가 0일 경우 11인데, 1로 취급한다. 나머지가 1일 경우에는 11-1=10인데 0으로 취급한다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호 : ");
		String jumin=sc.nextLine();
		jumin=jumin.replace("-","");  //하이픈이 있다면 없애고 계산하기.
		int sum=0, result=0;
		
		if(Integer.parseInt(jumin.substring(2, 4))>0 && Integer.parseInt(jumin.substring(2, 4))<13) {  //생일 월 검사
			if(Integer.parseInt(jumin.substring(4, 6))>0 && Integer.parseInt(jumin.substring(4,6))<32) {  //생일 일 검사
				for(int i=0; i<12; i++) {
					sum=0;
					result+=(sum+=(i<=7) ? (jumin.charAt(i)-'0') *(i+2) : (jumin.charAt(i)-'0') *(i-6));
				}
				result=(11-(result%11))%10;  
				if(result==(jumin.charAt(12)-'0')) {
					System.out.println("올바른 주민등록번호입니다.");
				}else System.out.println("올바르지 않은 주민등록번호입니다.");
			}else System.out.println("올바르지 않은 주민등록번호입니다.");
		}else System.out.println("올바르지 않은 주민등록번호입니다.");
		/*  for문을 풀어서 쓴 것.
		for(int i=0; i<=7; i++) {
			sum=0;
			result+=(sum+=Integer.valueOf(jumin.charAt(i)-'0') *(i+2));
		}
		for(int j=8; j<=11; j++) {
			sum=0;
			result+=(sum+=(jumin.charAt(j)-'0') *(j-7));
		}
		*/
	}
}
