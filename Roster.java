import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Roster {
	
	private int counter = 0;
	private Object [] array = new Student [counter];
	private LinkedList <Student> roster = new LinkedList<Student>();
	
	public Roster (Student student) {// O(1) this runs in constant time
		addStudent(student);
	}

	public Student[] getArray() {// O(1) this runs in constant time
		return (Student[]) array;
	}

	public void setArray(Student[] array) {// O(1) this runs in constant time
		this.array = array;
	}

	public LinkedList<Student> getRoster() { // O(1) this runs in constant time
		return roster;
	}

	public void setRoster(LinkedList<Student> roster) {// O(1) this runs in constant time
		this.roster = roster;
	}
	
	public Object[] sort() { //O(n^2) runs n^2 times for the nested for loop
		array = roster.toArray();
		removeNull();
			for(int i =0; i < counter; i++) { // O(n)
				for(int j =1; j < counter - i; j++) // O(n)
				if((((Student) array[j - 1]).compareTo((Student) array[j])) >= 1) {
					Student temp = (Student) array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
			}
		}
		return array;
	} 

	public void loadRoster() { // O(n) executes the length of the array
		removeNull();
		for(int i =0; i< array.length; i++)
			System.out.println(array[i]);
	}
	
	public void addStudent(Student student) { // O(n) toArray()
		if(counter > 10) {
			System.out.println("Sorry the class is full");
		}
		else {
			roster.add(student);
			array = roster.toArray();
			counter++;
			System.out.println("Student added");
		}
	}
	
	public void removeStudent(String ID) { // O(n) toArray()
		if(counter <= 0)
			System.out.println("The class is empty");
		else {
			roster.remove(IDSearch(ID));			
			array = roster.toArray();
			counter--;
		}
	}
	public void removeNull() {
		int k = 0;
		for(int i =0; i < counter; i++) {
			if (array[i] != null)
				array[k++] = (Student) array[i];
		}	
	}

	public Student IDSearch( String IDNumber) {  // O(n) runs the for loop
		for(int i = 0; i < array.length;i++)
			if(((Student) array[i]).getIDNumber().equalsIgnoreCase(IDNumber)) {
				System.out.print(array[i]);
				System.out.println();
				System.out.println();
				return (Student) array[i];
			}
		
		System.out.println("Student not found");
		return null;
	}
	
	public Student nameSearch(String lastName , String firstName) { // O(n) for loop for array length
		for(int i = 0; i < array.length;i++)
			if((((Student) array[i]).getLastName().equalsIgnoreCase(lastName)) && (((Student) array[i]).getFirstName().equalsIgnoreCase(firstName))) {
				System.out.println(array[i]);
				return (Student) array[i];
			}
		
		System.out.print("Student not found");
		return null;	
	}
	
	public void save() { // constant time
		sort();
	}

	public void saveChanges() throws FileNotFoundException{ // O(n) for loop to print to the new file
		save();
		File file = new File ("Roster.txt");
		
		if (file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Error");
				e.printStackTrace();
			}
	
		PrintWriter out = new PrintWriter(file);
		for(int i =0; i <array.length; i++)
			out.println(array[i]);
		
		out.close();
	}
}