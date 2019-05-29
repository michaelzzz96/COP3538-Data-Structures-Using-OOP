
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.*;


/**
 * COP 3538: Project 3 - Linked List
 * <p>
 * The Project3 class reads a CSV file that is used to implement a Stack using a 
 * linked list and a Queue using a doubly linked list
 * from States2 csv. It asks the user to enter the file to display the result. This 
 * program uses these states objects by applying the custom Abstract 
 * data type stack and queue class using a linked list class.
 * The stack class  implement a stack of state objects using a linked list. 
 * The queue class implements a queue of state objects using a doubly linked list.
 * Project3 class creates a stack and queue of state objects from regions 
 * New England, Middle Atlantic, and South region. Then it will implement the push and pop
 * methods form stack and insert front and insert end from queue.
 * Reference: Data Structure & Algorithms in Java 2nd edition. Robert Lafore
 * <p>
 * 
 * @author Michael Zulfekar
 * @version 3-15-19
 *
 */
public class Project3 {

	
	 /**
     * Method to split the states
     * @param String line
     * @return states
     */
	private static State splitStates(String line) {
		// split file by comma
		String split[] = line.split(",");

		// call State object
		State states = new State();

		// split states into arrays
		states.setStateName(split[0]);
		states.setStateCapital(split[1]);
		states.setStateAbrv(split[2]);
		states.setStatePopulation(Integer.parseInt(split[3]));
		states.setStateRegion(split[4]);
		states.setStateSeats(Integer.parseInt(split[5]));
		return states;
	}

	 /**
     * Method to display message.
     * @param none
     * @return nothing
     */
	public static void Message() {
		System.out.println("COP3538 Project 3");
		System.out.println("Instructor: Xudong Liu");
		System.out.println("           ");
		System.out.println("Linked lists ");
		
	}

	 /**
     * Method to print the states data.
     * @param none
     * @return nothing
     */
	public static void PrintData() {
		System.out.print(String.format("%-20s", "State Name"));
		System.out.print(String.format("%-20s", "Capital City"));
		System.out.print(String.format("%-20s", "State Abbr"));
		System.out.print(String.format("%-20s", "State Population"));
		System.out.print(String.format("%-20s", "Region"));
		System.out.println(String.format("%-20s", "US House Seats"));
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
	}
	
	/**
     * The main method reads and parse the file using the splitStates method
     * to split it into States objects.
     * 
     * @param args
     * @throws Exception
     */
	public static void main(String[] args) {

		// Call the message function
		Message();

		// Create scanner object
		Scanner scan = new Scanner(System.in);
		String filename;

		
		while (true) {

			// User input 
			System.out.print("Enter the file name: ");
			filename = scan.nextLine();
			System.out.println("");


			// Call Stack and Queue objects
			Queue queueStates = new Queue();
			Stack stackStates = new Stack();

			// Counter
			int Stack_Queue_Counter = 0;
			int counter = 0;

			
			
			try {

				//Call Scanner Object
				Scanner file = new Scanner(new File(filename));
				file.nextLine();

				// reads file
				while (file.hasNextLine()) {

					String line = file.nextLine();
					if (line.isEmpty())
						continue;

					// call the splitStates function
					State s = splitStates(line);

					// push the stack of objects from the New England, Middle Atlantic, and South region. 
					if (s.getStateRegion().equalsIgnoreCase("New England")
							|| s.getStateRegion().equalsIgnoreCase("Middle Atlantic")
							|| s.getStateRegion().equalsIgnoreCase("South"))
						stackStates.push(s);
					    counter++;
					
						
				}
				
				// Close file
				file.close();

			
				
				//Prints Content of the Stack
				System.out.println("Stack Contents: \n");
				System.out.println();
				PrintData();
				stackStates.printStack();

				
				// Pop items from the stack if not empty
				//Set Counter to one
				counter = 0;
				while (!stackStates.isEmpty()) {
					// insert the first popped state in the front, the second popped state at the end
					if (counter % 2 == 0) {
						//Insert item to Queue to front popped from stack
						queueStates.insertFront(stackStates.pop());
						//Lower counter
						counter--;
					} else {
						//Insert item to Queue to end popped from stack
						queueStates.insertEnd(stackStates.pop());
						//Lower counter
						counter--;
					}
				}

				
				//Prints Content of the Queue
				System.out.println("Queue Contents: \n");
				PrintData();
				queueStates.printQueue();
				
				
				// Delete given states 
				queueStates.findDelete("Massachusetts");
				queueStates.findDelete("New Hampshire");
				queueStates.findDelete("Rhode Island");
				queueStates.findDelete("Maryland");
				queueStates.findDelete("New Jersey");
				queueStates.findDelete("Pennsylvania");
				queueStates.findDelete("Alabama");
				queueStates.findDelete("Kentucky");
				queueStates.findDelete("North Carolina");

				
				
				//Prints Content of the Queue with the given states deleted
				System.out.println("Queue Contents: \n");
				PrintData();
				queueStates.printQueue();

				
				// Pop items from the stack if not empty
				// Set Counter to one 
				Stack_Queue_Counter = 1;
				while (!queueStates.isEmpty()) {
					//Remove one state from the front, then one from the back, then the front, then the back
					if (Stack_Queue_Counter % 2 != 0) {
						//Push item to Stack and remove item from front of Queue
						stackStates.push(queueStates.removeFront().stateData);
						//Increase counter
						Stack_Queue_Counter++;
					} else {
						//Push item to Stack and remove item from front of Queue
						stackStates.push(queueStates.removeEnd().stateData);
						//Increase counter
						Stack_Queue_Counter++;
					}
				}

				
				
				//Prints Content of the Stack
				System.out.println("Stack Contents: \n");
				PrintData();
				stackStates.printStack();

			} catch (FileNotFoundException error) {
				System.out.println("\nFile not found. Please try again.");

			}
		}
	}
}
