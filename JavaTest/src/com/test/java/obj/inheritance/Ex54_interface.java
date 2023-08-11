package com.test.java.obj.inheritance;

public class Ex54_interface {
	public static void main(String[] args) {
		//상속 : 자식입장에서 부모를 가리키는 입장
		//1. 단일 상속 : 부모가 1개일 때
		//2. 다중 상속 : 부모가 2개 이상일 때
		
		//*** 자바는 다중 상속을 허용하지 않는다.
		//***하지만 인터페이스에 한해서는 다중 상속을 허용한다. -> 왜? -> 인터페이스는 구현부가 없기 때문에.
		
		//회사의 직원으로서의 역할.
		Hong hong=new Hong();
		hong.출근하다();
		hong.일을한다();
		hong.퇴근하다();
		
		hong.애들하고놀기();  //아빠로서의 역할.
		hong.낮잠자기();
		
	}
}
interface 직원{  //직원이 갖춰야 할 행동을 미리 정의
	void 출근하다();
	void 퇴근하다();
	void 일을한다();
}
interface 아빠{  //아빠로서 할 행동을 미리 정의
	void 애들하고놀기();
	void 돈벌기();
	void 낮잠자기();
}
//다중상속
class Hong implements 직원, 아빠{  //어떤 때는 직원으로서, 어떤 때는 아빠로서.
	@Override
	public void 출근하다() {
		
	}
	@Override
	public void 퇴근하다() {
		
	}
	@Override
	public void 일을한다() {
		
	}
	@Override
	public void 애들하고놀기() {
	
	}
	@Override
	public void 돈벌기() {
		
	}
	@Override
	public void 낮잠자기() {
		
	}
	
}

class Lee implements 직원{
	@Override
	public void 출근하다() {
	
	}
	@Override
	public void 퇴근하다() {
		
	}
	@Override
	public void 일을한다() {
		
	}
	
}
class Park implements 아빠{
	@Override
	public void 애들하고놀기() {
		
	}
	@Override
	public void 돈벌기() {
		
	}
	@Override
	public void 낮잠자기() {
		
	}
	
}






