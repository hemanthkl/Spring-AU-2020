package model;

public class point {

	private int x;
	private int y;
	public point() {
		
	}
	public point(int x,int y) {
	this.x=x;
	this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String print() {
		return "value of x : "+x+" and  value of y : "+y;
	}
	
}
