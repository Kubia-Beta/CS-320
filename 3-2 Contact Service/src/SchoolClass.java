/**
 * 
 */

/**
 * @author connorscultho_snhu
 *
 */
public class SchoolClass {
	private String ID;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String address;

	// Get and set ID
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		if(iD == null || iD.length()>10) { // Validate name length
			throw new IllegalArgumentException("Invalid ID");
		}
		ID = iD; // Must be valid to reach
	}
	
	// Get and set lastName
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		if(name == null || name.length()>=10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		lastName = name;
	}
	
	// Get and set firstName
	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String name) {
		if(name == null || name.length()>=10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		firstName = name;
	}
	
	// Get and set phone
	public String getPhone() {
		return phoneNumber;
	}

	public void setPhone(String phone) {
		if(phone == null || phone.length()>=10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		phoneNumber = phone;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}



}
