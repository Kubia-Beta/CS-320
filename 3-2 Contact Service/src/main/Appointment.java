////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 30 June 2024        //
// TO: 24 August 2024 //
///////////////////////

package main;
import java.time.LocalDate; // Date() is deprecated

public class Appointment {
	
	private String ID;
	private LocalDate date;
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
	public Appointment() {
		ID = "";
		date = LocalDate.now();
		description = "";
	}
	
	/**
	 * Constructor
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param string ID, string date, string Description
	 * @return N/A
	 */
	public Appointment(String newID, LocalDate newDate, String newDescription){ // Called constructor
		setID(newID);
		setDate(newDate);
		setDescription(newDescription);
	}
	
	// Get and set ID
	/**
	 * This function is not called outside of object creation.
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(1)
	 * @param N/A
	 * @return string ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Sets an ID to a value at object creation.
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
	
	// Get and set date
	/**
	 * Gets the LocalDate date of the object.
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(1)
	 * @param N/A
	 * @return LocalDate date
	 */
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * Sets the LocalDate date of the object given it is not null and not in the future.
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param LocalDate date
	 * @return LocalDate date
	 */
	public void setDate(LocalDate newDate) {
		LocalDate curDate = LocalDate.now();
		boolean comparisonResult = curDate.isBefore(newDate);
		if(newDate == null || comparisonResult == false) { // Not null and in the future
			throw new IllegalArgumentException("Invalid date; Exists in the past");
		}
		date = newDate;
	}
	
	// Get and set description
	/**
	 * Returns the description of an object.
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(1)
	 * @param N/A
	 * @return string description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of an object given its size is less than 50 and greater than 2.
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param string New description
	 * @return N/A
	 */
	public void setDescription(String newDescription) {
		int maxLength = 50; // Upper bound from design doc
		int minLength = 2; // "Go" is the shortest sentence
		if(newDescription == null || newDescription.length() > maxLength ||
				 newDescription.length() < minLength) {
			
			throw new IllegalArgumentException("Invalid Description");
		}
		description = newDescription;
	}
}
