package Test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import MarsRoverProject.Control;
import MarsRoverProject.Rover;

public class MainTest {
	Control testControl = new Control();
	Rover testRover = new Rover(0, 0, 0);

	@Test
	public void testCompass() {

		/*
		 * Testing compass North = 0 East = 1 South = 2 West = 3 Checking that
		 * the crux of the compass is working properly. from west to north and
		 * north to west.
		 */
		testControl.instructions(testRover, "R");
		assertEquals("Facing East (1)", 1, testRover.getCurrentlyFacing());

		testControl.instructions(testRover, "LL");
		assertEquals("Facing West (3)", 3, testRover.getCurrentlyFacing());

		testControl.instructions(testRover, "RRR");
		assertEquals("Facing South (2)", 2, testRover.getCurrentlyFacing());

	}

	@Test
	public void testPlatformLimits() {
		// Test if Rover stays on platform
		// Startvalues is (0,0,0) = bottom left facing north.
		// NB: The rover will still change facing directions and will move until
		// getting to the edge of platform,
		Control testControl = new Control();
		Rover testRover2 = new Rover(0, 0, 0);

		// Testing x direction lower limit
		testControl.instructions(testRover2, "LM");
		assertEquals("Should stop before the edge", 0, testRover2.getX());

		// Testing y direction upper limit upper limits
		testControl.instructions(testRover2, "RMMMMMM");
		assertEquals("Should stop before the edge", 5, testRover2.getY());

		// Testing x-direction upper limits
		testControl.instructions(testRover2, "RMMMMMM");
		assertEquals("Should stop before the edge", 5, testRover2.getX());

	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testInstructionSet() {

		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Unrecognized command");

		// Test if the exception is thrown when illegal instructions are given
		Control testControl = new Control();
		Rover testRover = new Rover(0, 0, 0);

		testControl.instructions(testRover, "ASDASDSAD");
		testControl.instructions(testRover, "");

	}

}
