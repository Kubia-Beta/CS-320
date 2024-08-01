////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 30 June 2024        //
// TO: 01 August 2024 //
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

	private String testID, testDescription, nullString, overloadString;
	private Appointment aAppointment;
	private LocalDate aPastDate, aPresentDate, aFutureDate;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("<Setup>");
		testID = "A New ID"; // 8/10 char limit
		aPastDate = LocalDate.parse("2008-11-23"); // November 23, 2008
		aPresentDate = LocalDate.now();
		aFutureDate = LocalDate.parse("2132-11-01"); // November 1, 2132
		testDescription = "This is what you should do in this given task"; // 46/50 char limit
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
		aAppointment = new Appointment(testID, aFutureDate, testDescription);
		assertTrue(aAppointment.getID().equals(testID));
		assertTrue(aAppointment.getDate().equals(aFutureDate));
		assertTrue(aAppointment.getDescription().equals(testDescription));
	}

	@Test
	void testIllegalID() { // Verifies ID behavior when it is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testID + overloadString, aFutureDate, testDescription);
		});}

	@Test
	void testIllegalDate() { // Verifies Name behavior when it is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testID, aPastDate, testDescription);
		});}

	@Test
	void testIllegalDescription() { // Verifies Description behavior when it is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testID, aFutureDate, testDescription + overloadString);
		});}
}