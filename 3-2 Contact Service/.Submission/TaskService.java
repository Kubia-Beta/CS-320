////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 26 June 2024        //
// TO: 28 June 2024   //
///////////////////////

package main;

import java.util.HashMap;
//import java.util.Scanner;

public class TaskService {
	private HashMap<String, Task> Tasks = new HashMap<String, Task>();
	// Stores tasks by ID as a key.
	
	
	//====================================
	// Public Methods
	//====================================

	/**
	 * Checks for a unique Task ID and reserves that ID if it is unused
	 * @param str ID, str Name, str Description
	 * @return N/A
	 */
	public void addTask(String newID, String newName, String newDescription) {
		// Call uniqueness check
		boolean isPresent = Tasks.containsKey(newID);
		if (isPresent == true) { // No duplicates allowed!
			throw new IllegalArgumentException("Invalid ID; This Task already exists.");
		}
		// Call constructor for task obj
		Task tempTask = new Task(newID, newName, newDescription);
		// Add new contact obj to Tasks
		Tasks.put(newID, tempTask);
		return;
	}
	
	/**
	 * Deletes a Task at specified address
	 * @param str ID
	 * @return N/A
	 */
	public void deleteTask(String ID) {
		// Make sure the ID exist, throw exception if it doesn't. Implicit else continues
		boolean	isPresent = Tasks.containsKey(ID);
			if (isPresent == false) {
				throw new IllegalArgumentException("Invalid ID; This ID does not exist.");
			}
		Tasks.remove(ID); // Remove the object by ID
		return;
	}
	
	/**
	 * Fetches a task by ID
	 * @param str ID
	 * @return Task object
	 */
	public Task lookupTask(String ID) {
		Task tempTask = new Task();
		tempTask = Tasks.get(ID);
		return tempTask;
	}
	
	/**
	 * Updates a task's name.
	 * @param str ID, str Name
	 * @return N/A
	 */
	public void updateTaskName(String ID, String updatedField) { // TODO: Split this into 4 functions based on type?
		Task tempTask = new Task(); // Holds the searched task's values
		tempTask = Tasks.get(ID); // Assign the data
		if (tempTask == null) { // If no data was assigned
			throw new IllegalArgumentException("Invalid ID; This ID does not exist.");
		}
		tempTask.setName(updatedField);
		Tasks.put(ID, tempTask);
		return;
	}
	
	
	/**
	 * Updates a task's description.
	 * @param str ID, str Description
	 * @return N/A
	 */
	public void updateTaskDescription(String ID, String updatedField) {
		Task tempTask = new Task(); // Holds the searched task's values
		tempTask = Tasks.get(ID); // Assign the data
		if (tempTask == null) { // If no data was assigned
			throw new IllegalArgumentException("Invalid ID; This ID does not exist.");
		}
		tempTask.setDescription(updatedField);
		Tasks.put(ID, tempTask);
		return;
	}
	
}
