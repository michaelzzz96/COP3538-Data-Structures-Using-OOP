import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.*;

/**
 * COP 3538: Project 2 - Stacks and Priority Queues 
 * <p>
 * The Project2 class reads a CSV file that is used to create an array of state objects
 * from States2 csv. It asks the user to enter the file to display the result. This 
 * program uses these states objects by applying the stack and priority queue class.
 * The stack class  implement a stack of state objects using an array. 
 * The Priority class implements a priority queue of state objects using an array, 
 * dealing with population. The highest population is the highest priority.
 * Project2 class creates a stack of state objects from regions 
 * South, West, and Midwest. Then it will Print all three priority queues 
 * in the order from South, West, then Midwest. Finally, 
 * it removes items from all three queues and pushes
 * them on the stack and prints the content of that stack.
 * Reference: Data Structure & Algorithms in Java 2nd edition. Robert Lafore
 * <p>
 * 
 * @author Michael Zulfekar
 * @version 2-22-19
 *
 */
public class Project2 {
	
	 /**
     * Method to split the states
     * @param none
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
		System.out.println("COP3538 Project 2");
		System.out.println("Instructor: Xudong Liu");
		System.out.println("           ");
		System.out.println("Stacks and Priority Queues");
	}


	/**
     * The main method reads and parse the file using the splitStates method
     * to split it into an array of States objects.
     * 
     * @param args
     * @throws Exception
     */
	public static void main(String[] args) {
		
		// Create scanner object
		Scanner scan = new Scanner(System.in);
		String filename;
		
		// Call the message function
		Message();

		
		while (true) {

			// User input 
			System.out.print("Enter the file name: ");
			filename = scan.nextLine();

			// Call the stack object
			Stack stackArray = new Stack(33);
		

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
					
					// push the stack of array objects from the south, west, and midwest region. 
					if (s.getStateRegion().equalsIgnoreCase("South") || s.getStateRegion().equalsIgnoreCase("West")
							|| s.getStateRegion().equalsIgnoreCase("Midwest"))
						stackArray.push(s);

				}
				
				// Close file
				file.close();
				
				// Calls the priority queue objects
				Priority southPriorityQueue = new Priority(10);
				Priority westPriortiyQueue = new Priority(11);
				Priority midwestProrityQueue = new Priority(12);
				
				// Display output called from the stack object 
				System.out.println(" ");
				System.out.println("There were " + stackArray.size() + " state records put on the stack.");
				System.out.println(" ");
				System.out.println("Stack Contents:");
				stackArray.printStack();
				
				//Iterate until the stack is empty
				while (!stackArray.isEmpty()) {
					State s = stackArray.pop();
					if (s.getStateRegion().equalsIgnoreCase("South"))
						southPriorityQueue.insert(s);
					else if (s.getStateRegion().equalsIgnoreCase("West"))
						westPriortiyQueue.insert(s);
					else if (s.getStateRegion().equalsIgnoreCase("Midwest"))
						midwestProrityQueue.insert(s);
				}
				
				
				// Display output called from the priority queue objects
				System.out.println("\nSouth Priority Queue Contents: ");
				southPriorityQueue.printQueue();
				System.out.println("\nWest Priority Queue Contents: ");
				westPriortiyQueue.printQueue();
				System.out.println("\nMidwest Priority Queue Contents: ");
				midwestProrityQueue.printQueue();
				
				//Iterate until the queue containing states from the south region is empty
				while (!southPriorityQueue.isEmpty())
					stackArray.push(southPriorityQueue.remove());
				
				//Iterate until the queue containing states from the west region is empty
				while (!westPriortiyQueue.isEmpty())
					stackArray.push(westPriortiyQueue.remove());
				
				//Iterate until the queue containing states from the midwest region is empty
				while (!midwestProrityQueue.isEmpty())
					stackArray.push(midwestProrityQueue.remove());
				
				// Display output from the stack from the queue class 
				System.out.println(" ");
				System.out.println("Stack contents:");
				
				stackArray.printStack();

			} catch (FileNotFoundException error) {
				System.out.println("\nFile not found. Please try again.");
			}
		}
	}
}// End Project2 class
