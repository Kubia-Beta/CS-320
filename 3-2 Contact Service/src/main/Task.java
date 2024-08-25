////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 22 June 2024        //
// TO: 25 Aug 2024    //
///////////////////////

package main;

public class Task {
	
	private String ID;
	private String name;
	private String description;
	
	//====================================
	// Public Methods
	//====================================
	
	/**
	 * Default Constructor
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(1)
	 * @param N/A
	 * @return N/A
	 */
	public Task() {
		ID = "";
		name = "";
		description = "";
	}
	
	/**
	 * Constructor
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param string ID, string Name, string Description
	 * @return N/A
	 */
	public Task(String newID, String newName, String newDescription){ // Called constructor
		setID(newID);
		setName(newName);
		setDescription(newDescription);
	}
	
	// Get and set ID
	/**
	 * Unused, but can be used to verify a task ID.
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(1)
	 * @param N/A
	 * @return string ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Called only in the default constructor to set the ID of our object.
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param string New ID
	 * @return N/A
	 */
	public void setID(String NewID) {
		int maxLength = 10; // Upper bound from design doc
		if (NewID == null || NewID.length() > maxLength) { // Validate ID exists and length is <=10
			throw new IllegalArgumentException("Invalid ID");
		}
		
		ID = NewID; // Must be valid to reach
	}
	
	// Get and set name
	/**
	 * Gets the name associated with an object
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(1)
	 * @param N/A
	 * @return string Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name associated with an object to String given its length < 20
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param N/A
	 * @return string Name
	 */
	public void setName(String newName) {
		int maxLength = 20; // Upper bound from design doc
		if(newName == null || newName.length() > maxLength) {
			throw new IllegalArgumentException("Invalid Name");
		}
		name = newName;
	}
	
	// Get and set description
	/**
	 * Gets the description associated with an object
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(1)
	 * @param N/A
	 * @return string description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description associated with an object to String given its length < 50
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param string New description
	 * @return N/A
	 */
	public void setDescription(String newDescription) {
		int maxLength = 50; // Upper bound from design doc
		if(newDescription == null || newDescription.length() > maxLength) {
			throw new IllegalArgumentException("Invalid Description");
		}
		description = newDescription;
	}
}