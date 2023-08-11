package com.test.java.obj;

public class Pencil {   //Ex41_Class
	
	private String hardness;  //HB, H, B, H2, B2...
	private String color;

	public String getHardness() {
		return hardness;
	}
	public void setHardness(String hardness) {
		this.hardness = hardness;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String info() {
		return String.format("Pencil[%s][%s]", this.hardness, this.color);
	}
	
}