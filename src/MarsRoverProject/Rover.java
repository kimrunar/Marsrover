package MarsRoverProject;
public class Rover{

	/*
	 * ****The Mars Rover****
	 * 
	 * */


//Positions
private int x;
private int y;
private int currentlyFacing;
	
//constructor with start values. Bottom left facing north
	public Rover(){
		this.x = 0;
		this.y = 0;
		this.currentlyFacing = 0;
	}
//constructor with userdefined startvalues	
	public Rover(int x, int y, int facing){
		this.x = x;
		this.y = y;
		this.currentlyFacing = facing;
	}
//Getters and setters	
	public void setX(int x){
		this.x = x;
	}
	
	public int getX(){
		return x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getY(){
		return y;
	}
	
	public void setFacing(int f){
		this.currentlyFacing = f;
	}
	
	public int getCurrentlyFacing(){
		return currentlyFacing;
	}
// Getters and setters end
	


	

}
