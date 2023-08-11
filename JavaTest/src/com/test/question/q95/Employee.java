package com.test.question.q95;

class Employee {
	   private String name; //이름
	   private String department;  //부서
	   private String position;  //직책
	   private String tel;  //연락처
	   
	   private Employee boss;  //직속상사
	   
	   //getter, setter 구현

	   //이름
	   public String getName() {
		   return name;
	   }
	   public void setName(String name) {  //유효성 검사, 한글 2~5자이내
		   if(name.length()<2&&name.length()>5) return;
		   for(int i=0; i<name.length(); i++) {
			   char c=name.charAt(i);
			   if(c<'가'&&c>'힣') return;
		   }
		   this.name = name;
	   }
	   //부서
	   public String getDepartment() {
		   return department;
	   }
	   public void setDepartment(String department) {
		   if(department.equals("영업부")||department.equals("홍보부")||department.equals("기획부")||department.equals("총무부")||department.equals("개발부"))
		   this.department = department;
	   }
	   //직책
	   public String getPosition() {
		   return position;
	   }
	   public void setPosition(String position) {
		   if(position.equals("부장")||position.equals("사장")||position.equals("대리")||position.equals("사원"))
		   this.position = position;
	   }
	   //연락처
	   public String getTel() {
		   return tel;
	   }
	   public void setTel(String tel) {  //010-xxxx-xxxx 형식 유지
		   if(tel.substring(0,3).equals("010")||tel.substring(3,4).equals("-")||tel.substring(8,9).equals("-"))
		   this.tel = tel;
	   }
	   //직속	상사
	   public Employee getBoss() {
		   return boss;
	   }
	   public void setBoss(Employee boss) {
		   if(boss==null) return;
		   if(this.getName().equals(boss.getName())) return;  //동일인물이면 return.
		   else if(!this.getDepartment().equals(boss.getDepartment())) return;  //부서가 같지 않으면 return.
		   else this.boss=boss;
		   
	   }
	   //직원 정보 확인
	   public void info() {
		   String result="";
		   
		   result+="["+this.getName()+"]\n";
		   result+="- 부서 : "+this.getDepartment()+"\n";
		   result+="- 직위 : "+this.getPosition()+"\n";
		   result+="- 연락처 : "+this.getTel()+"\n";
		   if(boss==null) {
			   result+="- 직속 상사 : 없음";
		   }else result+="- 직속 상사 : "+this.boss.getName()+"("+this.boss.department+" "+this.boss.position+")";
		
		   System.out.println(result);
	   }
	   
	}