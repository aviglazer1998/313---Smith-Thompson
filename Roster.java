import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Roster {
	
	private int counter = 0;
	private Object [] array = new Student [counter];
	private LinkedList <Student> roster = new LinkedList<Student>();
	private Queue<Student> waitList = new LinkedList<Student>();
	
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
	
	public Object[] sort() { //O(n^2) nested for loop
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
	
	public void printWaitingList() { //O(1)
		System.out.println(waitList);
	}
	
	// how do i get the last name in my method to stop showing up twice.

	public void loadWaitList() throws FileNotFoundException { // O(n) while loop
		
	
		  File wait =   new File("C:\\Users\\glaze\\OneDrive\\Documents\\Computer Science\\warmUpProject\\waitList.txt"); 
			    Scanner sc = new Scanner(wait);
			    String first = "", last = "", id = "";
			   
			    while (sc.hasNext()) { // O(n) while loop 
			    	if(sc.hasNext())
			    		first = sc.next();
			    	if(sc.hasNext())
			    		last = sc.next();
			    	if(sc.hasNext())
			    		id = sc.next();
			    	if (!first.equals("") && !last.equals("") && !id.equals("") ) {
			    		Student a =  new Student (first,last,id);
			    		addStudent(a);
			    	}
			    }
		
		saveClose();
		sc.close();
	}
	
	public void loadRoster() throws FileNotFoundException { // O(n) executes the length of the array
		removeNull();
		//saveChanges();
		for(int i =0; i< array.length; i++)
			System.out.println(array[i]);
	}
	
	public void loadUpdatedRoster() throws FileNotFoundException { // O(n) while loop
		saveClose();
		Scanner IN = new Scanner (new File("Roster.txt"));
		 
		while(IN.hasNext()) // O(n) while loop
			System.out.println(IN.nextLine());
		IN.close();
	}
	
	public void addStudent(Student student) { // O(n) toArray()
		if(counter > 9) {
			System.out.println("Sorry the class is full, you'll be added to the waiting list");
			waitList.add(student);
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
		if(!waitList.isEmpty())
			roster.add(waitList.remove());
			array = roster.toArray();				
	}
	
	public void removeNull() { //O(n) for loop
		int k = 0;
		for(int i =0; i < counter; i++) {
			if (array[i] != null)
				array[k++] = (Student) array[i];
		}	
	}

	public Student IDSearch( String IDNumber) {  // O(n) runs the for loop
		for(int i = 0; i < array.length -1;i++)
			if(((Student) array[i]).getIDNumber().equalsIgnoreCase(IDNumber)) {
				System.out.print(array[i] + "\n" + "\n");
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
	
//	public void save() { // constant time
//		sort();
//	}

	public void saveClose() throws FileNotFoundException{ // O(n) for loop to print to the new file
		//save()
		sort();
		File file = new File ("Roster.txt");
		File wait = new File("waitList.txt");
		
		if (file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Error");
				e.printStackTrace();
			}
		if (wait.exists())
			try {
				wait.createNewFile();
			} catch (IOException e) {
				System.out.println("Error");
				e.printStackTrace();
			}
	
		PrintWriter ros = new PrintWriter(file);
		PrintWriter WL = new PrintWriter(wait);
		for(int i =0; i <array.length; i++)
			ros.println(array[i]);
		
		WL.println(waitList.toString());
		
		ros.close();
		WL.close();
	}
}