package MarsRoverProject;

public class Control {
	
	/*
	 * ******Houston control center*****
	 * 
	 * Here is the methods to control the rover and 
	 * the methods to communicate with it.
	 * 
	 * */
	
	//Set compass values
		private final int NORTH = 0;
		private final int EAST = 1;
		private final int SOUTH = 2;
		private final int WEST = 3;	
		
	//Platform-limits (0,0) -> (5,5), where 6 and -1 is outside of platform. 
		private final int ULIMIT = 6;
		private final int LLIMIT = -1;
	
	//function that takes in the instruction-set from the user, and pass one char at a time to priv method process().
	public void instructions(Rover r, String commands){
		for(int i = 0; i < commands.length(); i++){
			process(r, commands.charAt(i));
		}
	}
//method to execute the individual commands extracted from the string.	
	private void process(Rover r, Character command) {
		if (command.equals('L')) {
			turnLeft(r);
		} else if (command.equals('R')) {
			turnRight(r);
		} else if (command.equals('M')) {
			moveRover(r);
		} else {
			throw new IllegalArgumentException(
					"Unrecognized command");
		}
	}
	
	
	//prints the rovers current position. Message from mars
	public void roversPosition(Rover r){
		char direction = 'l';
		
		if(r.getCurrentlyFacing() == NORTH){
			direction = 'N';
			printPos(r.getX(),r.getY(),direction);
		}else if(r.getCurrentlyFacing() == WEST){
			direction = 'W';
			printPos(r.getX(),r.getY(),direction);
		}else if(r.getCurrentlyFacing() == SOUTH){
			direction = 'S';
			printPos(r.getX(),r.getY(),direction);
		}else if(r.getCurrentlyFacing() == EAST){
			direction = 'E';
			printPos(r.getX(),r.getY(),direction);
		}
		
		
		
	}
	
	public void printPos(int x,int y, char d){
		System.out.println(x + " " + y + " " + d);	
	}
	
	
	
	
	
// The rover turn left	
	public void turnLeft(Rover r){
		if (r.getCurrentlyFacing() - 1 < NORTH){
			r.setFacing(WEST);
		}else{
			r.setFacing(r.getCurrentlyFacing() -1);
		}
		
		
	}
	
//the rover turn right	
	public void turnRight(Rover r){
		if(r.getCurrentlyFacing() +1 > WEST){
			r.setFacing(NORTH);
			
		}else{
			r.setFacing(r.getCurrentlyFacing() + 1);
		}
		
	
		
	}
//the rover move according to what direction he's facing	
	public void moveRover(Rover r){
		if(r.getCurrentlyFacing() == NORTH && onPlatform(r.getY() + 1)){
			r.setY(r.getY() +1);
		}else if(r.getCurrentlyFacing() == WEST && onPlatform(r.getX() - 1)){
			r.setX(r.getX() -1);
		}else if(r.getCurrentlyFacing() == SOUTH && onPlatform(r.getY() - 1)){
			r.setY(r.getY() -1);
		}else if(r.getCurrentlyFacing() == EAST && onPlatform(r.getX() + 1)){
			r.setX(r.getX() +1);
		}
		
	}
	
	//Check if the rover will stay on platform if the command is executed
	private boolean onPlatform(int p){
		if(p < ULIMIT && p > LLIMIT){
			return true;
		}
		return false;
	}

}
