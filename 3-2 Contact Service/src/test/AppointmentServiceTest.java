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

import main.AppointmentService;
import java.time.LocalDate; // Date() is deprecated
import main.AppointmentService;

class AppointmentServiceTest extends AppointmentService {
	
	private String testID, testDescription, nullString, overloadString;
	private LocalDate aPastDate, aPresentDate, aFutureDate;
	private AppointmentService aAppointmentService = new AppointmentService();
	
	@BeforeEach
	void setUp() throws Exception { // Initialize our variables
		System.out.println("<Setup>");
		testID = "A New ID"; // 8/10 char limit
		aPastDate = LocalDate.parse("2008-11-23"); // November 23, 2008
		aPresentDate = LocalDate.now();
		aFutureDate = LocalDate.parse("2132-11-01"); // November 1, 2132
		testDescription = "This is what you should do in this given task"; // 46/50 char limit
		nullString = null;
		overloadString = "Far too many characters to be tolerated"; // Used to make sure we run the char limit
		aAppointmentService.addAppointment(testID, aFutureDate, testDescription);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("</Teardown>");
	}
	

	@Test
	void testAddTask() { // Verifies that duplicate Task objects cannot be added
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aAppointmentService.addAppointment(testID, aFutureDate, testDescription);
		});}

	@Test
	void testDeleteTask() { // Verifies that the delete function works as intended
		assertNotNull(aAppointmentService.lookupAppointment(testID));
		aAppointmentService.deleteAppointment(testID);
		assertNull(aAppointmentService.lookupAppointment(testID));
	}
	
	@Test
	void testDeleteTaskNoExist() { // Verifies that delete handles invalid ID's
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aAppointmentService.deleteAppointment("noExist");
		});}
}