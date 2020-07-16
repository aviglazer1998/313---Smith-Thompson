public class Student{

	private String firstName;
	private String lastName;
	private String IDNumber;
	
	public Student(String first, String last, String ID) {
		firstName = first;
		lastName = last;
		IDNumber = ID;	
	}
	
	public String getFirstName() {// O(1) this runs in constant time
		return firstName;
	}

	private void setFirstName(String firstName) {// O(1) this runs in constant time
		this.firstName = firstName;
	}

	public String getLastName() {// O(1) this runs in constant time
		return lastName;
	}

	private void setLastName(String lastName) {// O(1) this runs in constant time
		this.lastName = lastName;
	}

	public String getIDNumber() {// O(1) this runs in constant time
		return IDNumber;
	}

	private void setIDNumber(String iDNumber) {// O(1) this runs in constant time
		IDNumber = iDNumber;
	}

	public boolean equals(Student student) {// O(1) this runs in constant time
		return IDNumber.equals(student.getIDNumber());
	}
	
	public int compareTo(Student name1) { // if = 0 then same names, if >= 1 first name is later , if <= -1 second name is later 
	
		int comp = lastName.compareToIgnoreCase(name1.lastName);
		
		if(comp == 0)
			comp = firstName.compareToIgnoreCase(name1.firstName);
		if(comp == 0)
			comp = IDNumber.compareToIgnoreCase(name1.IDNumber);
		return comp;	
	}
		
	public String toString() { // O(1) this runs in constant time
		return firstName + ", " + lastName + ", " + IDNumber + ":";
	}
}