import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * COP 3538: Project 5 - Hash Tables.
 * <p>
 * The Project5 class reads a CSV file that is used to implement a Hash Table using 
 * States5.csv file. 
 * Reference: Data Structure & Algorithms in Java 2nd edition. Robert Lafore
 * <p>
 * 
 * @author Michael Zulfekar
 * @version 4-19-19
 *
 */

public class Project5 {

	private static HashTable StateHashTable = new HashTable();

	/**
     * Method to split the states
     * @param String line
     * @return states
     */
	public static State splitStates(String line) {
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
	}// End splitStates(String line)
	
	
	 /**
     * Method to delete States.
     * @param none
     * @return nothing
     */
	public static void deleteFirstStates() {
		StateHashTable.delete("Vermont");
		System.out.println("Vermont is deleted from the hash table");
		StateHashTable.delete("Kansas");
		System.out.println("Kansas is deleted from the hash table");
		StateHashTable.delete("South Carolina");
		System.out.println("South Carolina is deleted from the hash table");
	}
	
	 /**
     * Method to find states.
     * @param none
     * @return nothing
     */
	public static void findStates() {
		StateHashTable.find("Florida");
		StateHashTable.find("Rhode Island");
		StateHashTable.find("Kansas");
	}
	
	 /**
     * Method to delete second states.
     * @param none
     * @return nothing
     */
	public static void deleteSecondStates() {
		StateHashTable.delete("Kentucky");
		System.out.println("Kentucky is deleted from the hash table");
		StateHashTable.delete("Minnesota");
		System.out.println("Minnesota is deleted from the hash table");
		StateHashTable.delete("Puerto Rico");
		System.out.println("Puerto Rico is deleted from the hash table");
		StateHashTable.delete("Ohio");
		System.out.println("Ohio is deleted from the hash table");

	}
	
	/**
     * The main method reads and parse the file using the splitStates method
     * to split it into States objects.
     * 
     * @param args
     * @throws Exception
     */
	public static void main(String[] args) {
		
		while (true)
		{

			// Create scanner object
			Scanner scan = new Scanner(System.in);
			String filename;

			// User input
			System.out.print("Enter the file name: ");
			filename = scan.nextLine();
			System.out.println("");

			// Counter
			int StatesCounter = 0;

			try {

				// Call Scanner Object
				Scanner file = new Scanner(new File(filename));
				file.nextLine();

				// reads file
				while (file.hasNextLine()) {

					String line = file.nextLine();
					if (line.isEmpty())
						continue;

					// call the splitStates function
					State s = splitStates(line);

					// insert name and population on the tree
					StateHashTable.insert(s.getStateName(), s.getStatePopulation());
					// increment states
					StatesCounter++;

				} // End while

				// Close file
				file.close();

				// Output number of states onto the tree
				System.out.println("There were " + StatesCounter + " state records put on the hash table.\n");

				// Hash Table Header 
				System.out.println("Hash table content: \n ");

				// Display Table
				StateHashTable.display();

				System.out.println();

				// Delete 1st states
				deleteFirstStates();

				System.out.println();

				// Find states
				findStates();

				System.out.println();

				// Delete 2nd states
				deleteSecondStates();
			

				System.out.println();

				// Display States
				StateHashTable.display();

				System.out.println();

				//Display Available Spaces and Collisions 
				StateHashTable.printFreeAndCollisions();
				System.out.println();
				
			} catch (FileNotFoundException error) {
				System.out.println("\nFile not found. Please try again.");

			} // End Catch
		}
	}
}