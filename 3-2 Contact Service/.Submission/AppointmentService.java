////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 30 June 2024        //
// TO: 24 August 2024 //
///////////////////////

package main;

import java.util.HashMap;
import java.time.LocalDate; // Date() is deprecated

public class AppointmentService {
	private HashMap<String, Appointment> Appointments = new HashMap<String, Appointment>();
	// Stores tasks by ID as a key.
	
	
	//====================================
	// Public Methods
	//====================================

	/**
	 * Checks for a unique Appointment ID and reserves that ID if it is unused
	 * Time: O(n), θ(1), Ω(1)
	 * Space: O(n)
	 * @param str ID, LocalDate Date, str Description
	 * @return N/A
	 */
	public void addAppointment(String newID, LocalDate newDate, String newDescription) {
		// Call uniqueness check
		boolean isPresent = Appointments.containsKey(newID);
		if (isPresent == true) { // No duplicates allowed!
			throw new IllegalArgumentException("Invalid ID; This Task already exists.");
		}
		// Call constructor for appointment obj
		Appointment tempAppointment = new Appointment(newID, newDate, newDescription);
		// Add new contact obj to Appointments
		Appointments.put(newID, tempAppointment);
		return;
	}
	
	/**
	 * Deletes a Task at specified address
	 * Time: O(n), θ(1), Ω(1)
	 * Space: O(n)
	 * @param str ID
	 * @return N/A
	 */
	public void deleteAppointment(String ID) {
		// Make sure the ID exist, throw exception if it doesn't. Implicit else continues
		boolean	isPresent = Appointments.containsKey(ID);
			if (isPresent == false) {
				throw new IllegalArgumentException("Invalid ID; This ID does not exist.");
			}
			Appointments.remove(ID); // Remove the object by ID
		return;
	}
	
	/**
	 * Fetches an Appointment by ID
	 * Time: O(n), θ(1), Ω(1)
	 * Space: O(n)
	 * @param str ID
	 * @return Task object, null if noexist
	 */
	public Appointment lookupAppointment(String ID) { // FIXME: String noexist not handled (tempAppointment = null)
		Appointment tempAppointment = new Appointment();
		tempAppointment = Appointments.get(ID);
		return tempAppointment;
	}
}
