////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 30 June 2024        //
// TO: 01 August 2024 //
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
	
	// Get and set date
	/**
	 * @param N/A
	 * @return Calendar date
	 */
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate newDate) {
		LocalDate curDate = LocalDate.now();
		int comparisonResult = curDate.compareTo(newDate);
		int threshold = 0; // Negative if in the past; Zero if present, positive if future
		if(newDate == null || comparisonResult >= threshold) { // Not null and in the future
			throw new IllegalArgumentException("Invalid date; Exists in the past");
		}
		date = newDate;
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
