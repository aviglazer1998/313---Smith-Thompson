Write a program that can maintain a Roster of Students, using a linked structure to enter students originally, and then storing the students into a sorted array. with a maximum of 10 students in the roster. The program should be able to search for a given student, add a student, and drop a student. The roster should be saved as a text file.

You may use the Java Linked List, or you may write your own.  The list should not be sorted, because I want you to create the sorted array for the roster from an un-sorted list.
Your array should have a max size of 10 for this part of the project, but should be partially filled to begin.  After the students have been stored in the sorted array, you should allow the user to add students (maintaining sorted order, but not allowing more than 10 students), drop students (with no “null” array entries) and search for students by ID and by name.  Your search should return the Student, not a Boolean.

You should include a menu for the user, including:
Load roster from a file 
Add student
Remove student
Search student by ID
Search student by name
“Save” change (this method will copy the list to a sorted array)
“Save changes” (this method will save a sorted text file in a different file, so I can see the final roster)\

You should be able to add/remove students using both the linked structure and the array. 
