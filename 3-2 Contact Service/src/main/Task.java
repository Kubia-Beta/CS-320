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
	 * This function is not called outside of object creation.
	 * @param N/A
	 * @return string ID
	 */
	public String getID() {
		return ID;
	}

	/**
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
	 * @param N/A
	 * @return string Name
	 */
	public String getName() {
		return name;
	}

	public void setName(String newName) {
		int maxLength = 20; // Upper bound from design doc
		if(newName == null || newName.length() > maxLength) {
			throw new IllegalArgumentException("Invalid Name");
		}
		name = newName;
	}
	
	// Get and set description
	/**
	 * @param N/A
	 * @return string description
	 */
	public String getDescription() {
		return description;
	}

	/**
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