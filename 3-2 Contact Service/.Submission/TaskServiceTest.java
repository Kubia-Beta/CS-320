////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 26 June 2024        //
// TO: 28 June 2024   //
///////////////////////

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Task;
import main.TaskService;

class TaskServiceTest {
	
	private String testID, testName, testDescription, nullString, overloadString;
	private Task aTask;
	private TaskService aTaskService = new TaskService();
	
	@BeforeEach
	void setUp() throws Exception { // Initialize our variables
		System.out.println("<Setup>");
		testID = "A New ID"; // 8/10 char limit
		testName = "Go get groceries"; // 17/20 char limit
		testDescription = "This is what you should do in this given task"; // 46/50 char limit
		nullString = null;
		overloadString = "Far too many characters to be tolerated"; // Used to make sure we run the char limit
		aTaskService.addTask(testID, testName, testDescription);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("</Teardown>");
	}
	

	@Test
	void testAddTask() { // Verifies that duplicate Task objects cannot be added
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		aTaskService.addTask(testID, testName, testDescription);
		});}

	@Test
	void testDeleteTask() { // Verifies that the delete function works as intended
		assertNotNull(aTaskService.lookupTask(testID));
		aTaskService.deleteTask(testID);
		assertNull(aTaskService.lookupTask(testID));
	}
	
	@Test
	void testDeleteTaskNoExist() { // Verifies that delete handles invalid ID's
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aTaskService.deleteTask("noExist");
		});}

	@Test
	void testUpdateTaskName() { // Verifies task names are updated correctly
		Task aTask = new Task();
		aTask = aTaskService.lookupTask(testID);
		String beforeString = aTask.getName();
		aTaskService.updateTaskName(testID, "a new name");
		String afterString = aTask.getName();
		assertNotEquals(beforeString, afterString);
	}
	
	@Test
	void testUpdateTaskNameNoExist() { // Verifies that updateName handles invalid ID's
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aTaskService.updateTaskName("noExist", testDescription);
		});}

	@Test
	void testUpdateTaskDescription() { // Verifies that descriptions are updated correctly
		Task aTask = new Task();
		aTask = aTaskService.lookupTask(testID);
		String beforeString = aTask.getDescription();
		aTaskService.updateTaskDescription(testID, "a new description");
		String afterString = aTask.getDescription();
		assertNotEquals(beforeString, afterString);
	}

	@Test
	void testUpdateTaskDescriptionNoExist() { // Verifies that updateDescription handles invalid ID's
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aTaskService.updateTaskDescription("noExist", testDescription);
		});}
}
