import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WarmUpProject {
	public static void main(String[] args) throws FileNotFoundException {
		
		String first, last, id;
		int i = 0;
		String filename = "C:\\Users\\glaze\\OneDrive\\Documents\\Computer Science\\warmUpProject\\Roster.txt";
		Student [] studentList = new Student[10];
		Roster list = new Roster(studentList[i]);
		Scanner sc = new Scanner(System.in);
		Scanner IN = new Scanner (new File(filename));
		
		 
		while(IN.hasNext()) { // O(n)  goes n x however many lines there are until nothing left
			 first = IN.next();
			 last = IN.next();
	         id = IN.next();
	        studentList[i] = new Student(first, last, id);
	        list.addStudent(studentList[i++]);
		}
		IN.close();
		
		System.out.println("Select from the menu options:");
		System.out.println("-1 - Exit");
		System.out.println("0 - Load roster");
		System.out.println("1 - Add student");
		System.out.println("2 - Remove student");
		System.out.println("3 - Search student by ID");
		System.out.println("4 - Search student by name (last name , first name)");
		System.out.println("5 - Save and Close");
		System.out.println("6 - Load waitList");
		//System.out.println("6 - Save changes");
	
		String a = "0";
		list.loadWaitList();
		list.loadUpdatedRoster();
		
		while(!a.equals("5")) { //O(n) goes however many times the user keeps it running until a = -1 + whatever case is called. worst runtime is o(n^3) for saveClose 
			a = sc.next();
			switch(a) {
			case "-1": // constant time
				System.out.println("Program exited");
				break;
			case "0": // constant time + methods run time
				list.loadUpdatedRoster(); 
				System.out.println("Roster loaded");
				break;
			case "1": // constant time + methods run time
				System.out.println("Type the First,Last, and ID you want to add");
			 		first = sc.next();
			 		last = sc.next();
			 		id = sc.next();
			 	list.addStudent(new Student (first, last, id));
				break;
			case "2": // constant time + methods run time
				System.out.println("Type the ID of the Student you want removed");
					id = sc.next();
				list.removeStudent(id);
				System.out.println("Student removed");
				break;
			case "3":// constant time + methods run time
				System.out.println("Enter the ID you're searching for");
					id = sc.next();
					list.IDSearch(id);
				break;
			case "4": // constant time + methods run time
				System.out.println("Enter the last name you're searching for");
					last = sc.next();
				System.out.println("Enter the first name you're searching for");
					first = sc.next();
				list.nameSearch(last, first);
				break;
			case "5":// constant time + methods run time
				list.saveClose();
				System.out.println("Saved");
				break;
			case "6":
				list.printWaitingList();
				System.out.println("Waitlist Loaded");
				break;
//			case "6":// constant time + methods run time
//				try {
//					list.saveChanges();
//				} catch (FileNotFoundException e) {
//					System.out.println("File not found");
//					e.printStackTrace();
//				}	
//				System.out.println("Changes saved");
//				break;
			default:
			System.out.println("Invalid entry");
			
			sc.close();
			}// switch
		}//while
	}//main
}//warmUpProject