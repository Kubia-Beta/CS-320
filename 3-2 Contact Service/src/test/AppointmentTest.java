////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 30 June 2024        //
// TO: 03 August 2024 //
///////////////////////

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate; // Note: Date is deprecated
import main.Appointment;

class AppointmentTest extends Appointment {

	private String testID, testDescriptionUpper, testDescriptionLower,
	testDescriptionBelow, overloadString, nullString;
	private Appointment aAppointment;
	private LocalDate aPastDate, aPresentDate, aFutureDate;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("<Setup>");
		testID = "A New ID"; // 8/10 char limit
		aPresentDate = LocalDate.now();
		aPastDate = aPresentDate.minusDays(1); // Yesterday
		aFutureDate = aPresentDate.plusDays(1); // Tomorrow
		testDescriptionUpper = "This is what you should do with this given task."; // 49/50 char limit
		testDescriptionLower = "Go"; // 2 char minimum
		testDescriptionBelow = ""; // under 2 char
		nullString = null;
		overloadString = "Far too many characters to be tolerated"; // Used to make sure we run the char limit
		aAppointment = new Appointment();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("</Teardown>");
	}

	@Test
	void testTask() { // Verifies the default constructor behavior
		assertTrue(aAppointment.getID().equals(""));
		assertTrue(aAppointment.getDate().equals(aPresentDate));
		assertTrue(aAppointment.getDescription().equals(""));
	}

	@Test
	void testAppointmentStringDateString() { // Verifies the constructor behavior
		aAppointment = new Appointment(testID, aFutureDate, testDescriptionUpper); // Upper bound cases
		assertTrue(aAppointment.getID().equals(testID));
		assertTrue(aAppointment.getDate().equals(aFutureDate));
		assertTrue(aAppointment.getDescription().equals(testDescriptionUpper));
		aAppointment = new Appointment(testID, aFutureDate, testDescriptionLower); // Lower bound cases
		assertTrue(aAppointment.getDescription().equals(testDescriptionLower));
	}

	@Test
	void testIllegalID() { // Verifies bad Id behavior
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testID + overloadString, aFutureDate, testDescriptionUpper);
		}); // Above size case
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(nullString + overloadString, aFutureDate, testDescriptionUpper);
		});} // Null case

	@Test
	void testIllegalDate() { // Verifies bad Date behavior is handled
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testID, aPastDate, testDescriptionUpper);
		});} // Past case

	@Test
	void testIllegalDescription() { // Verifies bad Description behavior
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testID, aFutureDate, testDescriptionUpper + overloadString);
		}); // Above size case
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testID, aFutureDate, testDescriptionBelow);
		}); // Below size case
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testID, aFutureDate, nullString);
		});} // Null case
	
	
}