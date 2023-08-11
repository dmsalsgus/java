package com.test.question;

public class Q100 {
	public static void main(String[] args) {
		//포장하는 직원
		Packer packer = new Packer();

		//연필
		Pencil p1 = new Pencil();
		p1.setHardness("HB");
		packer.packing(p1);

		Pencil p2 = new Pencil();
		p2.setHardness("4B");
		packer.packing(p2);

		//지우개
		Eraser e1 = new Eraser();
		e1.setSize("Large");
		packer.packing(e1);

		//볼펜
		BallPointPen b1 = new BallPointPen();
		b1.setThickness(0.3);
		b1.setColor("black");
		packer.packing(b1);

		BallPointPen b2 = new BallPointPen();
		b2.setThickness(1.5);
		b2.setColor("red");
		packer.packing(b2);

		//자
		Ruler r1 = new Ruler();
		r1.setLength(30);
		r1.setShape("줄자");
		packer.packing(r1);

		//결과 확인
		packer.countPacking(0);
		packer.countPacking(1);
		packer.countPacking(2);
		packer.countPacking(3);
		packer.countPacking(4);
	}
}
class Packer{  //사무용품을 포장하는 직원
	private static int pencilCount;
	private static int eraserCount;
	private static int ballPoinPenCount;
	private static int rulerCount;
	
	public void packing(Pencil pencil) {
		
	}
	public void packing(Eraser eraser) {
		
	}
	public void packing(BallPointPen ballPointPen) {
		
	}
	public void packing(Ruler ruler) {
		
	}
	public void countPacking(int type) {
		
	}
}
class Pencil{
	private String hardness;

	public String getHardness() {
		return hardness;
	}
	public void setHardness(String hardness) {
		this.hardness = hardness;
	}
	
	
	
}
class Eraser{
	private String size;

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
}
class BallPointPen{
	private double Thickness;
	private String color;
	
	public double getThickness() {
		return Thickness;
	}
	public void setThickness(double thickness) {
		this.Thickness = thickness;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
class Ruler{
	private int length;
	private String shape;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String type) {
		this.shape = type;
	}
	
	
	
}



















