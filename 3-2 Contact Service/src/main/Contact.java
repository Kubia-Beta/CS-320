////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 24 June 2024        //
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
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(1)
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
	 * Gets the ID associated with an object
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param N/A
	 * @return string ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Sets an ID in object creation given its size is < 10.
	 * Time: O(), θ(), Ω()
	 * Space: O()
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
	
	// Get and set firstName
	/**
	 * Gets the first name associated with an object as string.
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param N/A
	 * @return string First Name
	 */
	public String getfirstName() {
		return firstName;
	}
	
	/**
	 * Sets an objects associated first name as string if size < 10.
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param N/A
	 * @return string Last Name
	 */
	public void setFirstName(String newFirstName) {
		int maxLength = 10; // Upper bound from design doc, names can be longer than this
		if(newFirstName == null || newFirstName.length() > maxLength) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		firstName = newFirstName;
	}
	
	// Get and set lastName
	/**
	 * Gets an objects associated last name as string.
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param N/A
	 * @return string Last Name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets an objects last name from string given size < 10.
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param string New Last Name
	 * @return N/A
	 */
	public void setLastName(String newLastName) {
		int maxLength = 10; // Upper bound from design doc, yes names can be significantly longer than this.
		if(newLastName == null || newLastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		lastName = newLastName;
	}
	
	// Get and set phone
	/**
	 * Gets an objects associated phone number as string.
	 * @param N/A
	 * @return string phone
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets an objects phone number from string given its length is 10.
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param string New Phone
	 * @return N/A
	 */
	public void setPhoneNumber(String newPhone) {
		int requiredLength = 10; // Exact value from design doc
		if(newPhone == null || newPhone.length() != requiredLength) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		phoneNumber = newPhone;
	}
	
	// Get and set address
	/**
	 * Gets an objects associated address as string.
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param N/A
	 * @return string address
	 */
	public String getAddress() {
		return address; 
	}

	/**
	 * Sets an address to string input given 6 < size < 30.
	 * Time: O(), θ(), Ω()
	 * Space: O()
	 * @param string New Address
	 * @return N/A
	 */
	public void setAddress(String newAddress) {
		int maxLength = 30; // Upper bound from design doc
		int minLength = 6; // "1 8 Av" is a real address
		if(newAddress == null || newAddress.length() > maxLength
				|| newAddress.length() < minLength) { // null OR too long OR too short
		// Test this and change to add minLength || newAddress.length() < minLength
			throw new IllegalArgumentException("Invalid Address");
		}
		address = newAddress;
	}
}
