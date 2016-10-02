package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import MarsRoverProject.Rover;


public class Rovertest {

@Test
public void turnLeft(){
	
	Rover roverTest = new Rover();
	
	assertEquals("Turn left when facing North the rover should face west",3,roverTest.turnLeft());
}

}
