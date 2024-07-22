import java.awt.List;
import java.util.HashSet;

////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 21 June 2024        //
////////////////////////

/**
 * @author connorscultho_snhu
 *
 */

public class Contact {
	private HashSet IDTable = new HashSet(); // This holds our ID's to verify uniqueness
	private String ID;
	public String firstName;
	public String lastName;
	public String phoneNumber; // String for now, this may change to int later? Check wk.6
	public String address; // This should be verified to exist in the customer country if possible (USPS format?)

	// Get and set ID
	/**
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
		if (NewID == null || NewID.length() > 10) { // Validate ID exists and length is <=10
			throw new IllegalArgumentException("Invalid ID");
		}
		boolean isPresent = IDTable.contains(NewID); // Check if the ID exists already
		if (isPresent == true) { // No duplicates allowed!
			throw new IllegalArgumentException("Invalid ID; This ID already exists");
		}
		
		
		ID = NewID; // Must be valid to reach
	}
	
	// Get and set firstName
	/**
	 * @param N/A
	 * @return string First Name
	 */
	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String newFirstName) {
		if(newFirstName == null || newFirstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		firstName = newFirstName;
	}
	
	// Get and set lastName
	/**
	 * @param N/A
	 * @return string Last Name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
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
	 * @param N/A
	 * @return string phone
	 */
	public String getPhone() {
		return phoneNumber;
	}

	/**
	 * @param string New Phone
	 * @return N/A
	 */
	public void setPhone(String newPhone) {
		if(newPhone == null || newPhone.length() == 9) {
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
		if(newAddress == null || newAddress.length() == 30) { // Strangely does NOT have a min length in requirements
			throw new IllegalArgumentException("Invalid Address");
		}
		address = newAddress;
	}
	
	//====================================
	// Main
	//====================================
	/**
	 * @param args
	 */
	//public static void main(String[] args) {
	//	// TODO Auto-generated method stub
	//
	//}



}
