////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 22 June 2024        //
// TO: 28 June 2024   //
///////////////////////

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Task;

class TaskTest {

	private String testID, testName, testDescription, nullString, overloadString;
	private Task aTask;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("<Setup>");
		testID = "A New ID"; // 8/10 char limit
		testName = "Go get groceries"; // 17/20 char limit
		testDescription = "This is what you should do in this given task"; // 46/50 char limit
		nullString = null;
		overloadString = "Far too many characters to be tolerated"; // Used to make sure we run the char limit
		aTask = new Task();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("</Teardown>");
	}

	@Test
	void testTask() { // Verifies the default constructor behavior
		assertTrue(aTask.getID().equals(""));
		assertTrue(aTask.getName().equals(""));
		assertTrue(aTask.getDescription().equals(""));
	}

	@Test
	void testTaskStringStringString() { // Verifies the constructor behavior
		aTask = new Task(testID, testName, testDescription);
		assertTrue(aTask.getID().equals(testID));
		assertTrue(aTask.getName().equals(testName));
		assertTrue(aTask.getDescription().equals(testDescription));
	}

	@Test
	void testIllegalID() { // Verifies ID behavior when it is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(testID + overloadString, testName, testDescription);
		});}

	@Test
	void testIllegalName() { // Verifies Name behavior when it is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(testID, testName + overloadString, testDescription);
		});}

	@Test
	void testIllegalDescription() { // Verifies Description behavior when it is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(testID, testName, testDescription + overloadString);
		});}
}