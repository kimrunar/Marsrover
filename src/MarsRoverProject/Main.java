package MarsRoverProject;

public class Main {

	public static void main(String args[]) {
			// Starting controlcenter
			Control ctr = new Control();
	
			// Creating rovers
			Rover rover1 = new Rover(1, 2, 0);
			Rover rover2 = new Rover(3, 3, 1);
			
	
			// Start instructions and get feedback from mars rover
			ctr.instructions(rover1, "LMLMLMLMM");
			System.out.println(ctr.roversPosition(rover1));
	
			ctr.instructions(rover2, "MMRMMRMRRM");
			System.out.println(ctr.roversPosition(rover2));
			
			
	
			// Should give values [1 3 N ] and [ 5 1 E ]
			// It does!
	
		}

	

}
