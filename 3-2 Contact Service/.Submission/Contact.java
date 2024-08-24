////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 21 June 2024        //
////////////////////////

package main;

/**
 * @author connorscultho_snhu
 *
 */

public class Contact {
	
	private String ID;
	private String firstName;
	private String lastName;
	private String phoneNumber; // String for now, this may change to int later? Check wk.6
	private String address; // This should be verified to exist in the customer country if possible (USPS format?)
	
	//====================================
	// Public Methods
	//====================================
	
	/**
	 * Default Constructor
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param N/A
	 * @return N/A
	 */
	public Contact() {
		ID = "";
		firstName = "";
		lastName = "";
		phoneNumber = "";
		address = "";
	}
	
	/**
	 * Constructor
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param string ID, string First, string Last, string Phone, string Address
	 * @return N/A
	 */
	public Contact(String newID, String newFirstName, String newLastName,
			String newPhoneNumber, String newAddress){ // Called constructor
		setID(newID);
		setFirstName(newFirstName);
		setLastName(newLastName);
		setPhoneNumber(newPhoneNumber);
		setAddress(newAddress);
	}
	
	// Get and set ID
	/**
	 * Returns the ID of an object
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param N/A
	 * @return string ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Sets the ID of an object at object creation from a string.
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param string New ID
	 * @return N/A
	 */
	public void setID(String NewID) {
		if (NewID == null || NewID.length() > 10) { // Validate ID exists and length is <=10
			throw new IllegalArgumentException("Invalid ID");
		}
		
		ID = NewID; // Must be valid to reach
	}
	
	// Get and set firstName
	/**
	 * Gets the first name associated with the object as string.
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param N/A
	 * @return string First Name
	 */
	public String getfirstName() {
		return firstName;
	}

	public void setFirstName(String newFirstName) {
		if(newFirstName == null || newFirstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		firstName = newFirstName;
	}
	
	// Get and set lastName
	/**
	 * Gets the last name associated with the object as string.
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param N/A
	 * @return string Last Name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets a last name to be equal to the input string for an object.
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param string New Last Name
	 * @return N/A
	 */
	public void setLastName(String newLastName) {
		if(newLastName == null || newLastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		lastName = newLastName;
	}
	
	// Get and set phone
	/**
	 * Gets the phone number associated with an object as a string.
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param N/A
	 * @return string phone
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets an objects phone number to the string input given it is equal to 10 in length
	 * @param string New Phone
	 * @return N/A
	 */
	public void setPhoneNumber(String newPhone) {
		int requiredLength = 10;
		if(newPhone == null || newPhone.length() != requiredLength) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		phoneNumber = newPhone;
	}
	
	// Get and set address
	/**
	 * @param N/A
	 * @return string address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param string New Address
	 * @return N/A
	 */
	public void setAddress(String newAddress) {
		int maxLength = 30;
		if(newAddress == null || newAddress.length() > maxLength) { // Strangely does NOT have a min length in requirements
			throw new IllegalArgumentException("Invalid Address");
		}
		address = newAddress;
	}
}
