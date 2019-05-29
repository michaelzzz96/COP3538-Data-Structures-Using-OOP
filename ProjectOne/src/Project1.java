import java.io.*;
import java.util.*;

/**
 * COP 3538: Project 1 - Array Searches and Sorts
 * <p>
 * The Project1 class reads a CSV file that is used to create an array of state objects from
 * States.csv. It asks the user to choose 6 options to enter to display the states,
 * sorts state by name using bubble sort if user chooses option 2, sorts state by population using 
 * selection sort if user chooses option 3, sorts state by population by region using insertion sort
 * if user chooses option 4, and printing a given state using binary and sequential search 
 * if user chooses option 5.
 * Reference: Data Structure & Algorithms in Java 2nd edition. Robert Lafore
 * <p>
 * 
 * @author Michael Zulfekar
 * @version 1-31-19
 *
 */
public class Project1 {


	
	/**
     * The main method reads and parse the file using a delimiter to split it
     * into an array of States objects.
     * 
     * @param args
     * @throws Exception
     */
	public static void main(String[] args) throws Exception {

		// Method
		Message();

		Scanner scanner = new Scanner(System.in);

		while (true) {

			// Input file name
			System.out.print("Please enter a file name: ");
			String file = scanner.next();

			try {
				File file_read = new File(file);

				Scanner scan = new Scanner(file_read);
				System.out.println("56 states found");

				//Array of state objects
				State[] s = new State[56];
				int index = 0;
				scan.nextLine();

				// reads file
				while (scan.hasNextLine()) {

					//parse the file
					String see = scan.nextLine();// gets a whole line
					String[] split = see.split(","); //split file by comma. 
					s[index] = new State(split[0], split[1], split[2], Integer.parseInt(split[3]), split[4],
							Integer.parseInt(split[5]));

					index++;// increase states object
				}
				scan.close();// close file

				// flag variable for binary search
				boolean binary = false;
				
				//scanner object
				Scanner select = new Scanner(System.in);

				try {

					while (true) {

						// Method for user menu choice
						Menu();

						int option = select.nextInt();
						switch(option) {
						
						case 1:  
							Display(s);
							break;
						case 2:
							BubbleSortOnStateName(s);
							//Display(s);
							break;
						case 3:
							SelectionSortOnStatePopulation(s);
							//Display(s);	
							break;
						case 4:
							InsertionSortOnStateRegion(s);
							//Display(s);
							break;
						case 5:
							System.out.println("Enter a state name");
							// Second scanner object
							Scanner option2 = new Scanner(System.in);
							String stateName = option2.next();
							stateName = stateName + option2.nextLine();
							boolean Located = true;

							if (binary) {
								System.out.println(" ");
								System.out.println("Binary Search");
								Located = BinarySearchPrintState(s, stateName);
								
							} else {
								System.out.println(" ");
								System.out.println("Sequential Search");
								Located = SequentialSearchPrintState(s, stateName);
								
							}

							if (Located) {
								System.out.print(stateName);
							} 
							else
							{
								System.out.println("Error: State " + stateName + " not found");
							}
							break;
							
						case 6:
							select.close();
							System.out.println("Have a good day!");
							System.exit(0);
							break;
						
						default:
							while (option < 1 || option > 6) {
								System.out.println("Invalid choice enter 1-6:");
								System.out.println();
								break;
							} // end while
						 
					}// end switch
					}// end while
				} catch (Exception error) {
					System.out.println();
					System.out.println("Invalid. Re-enter File name");
				}
				

			} catch (FileNotFoundException error) {
				System.out.println("\nFile not found. Please try again");
			}

		}

	}// end main method
	

	  /**
      * Method to display message.
      * @param none
      * @return nothing
      */
	public static void Message() {
		System.out.println("COP3538 Project 1");
		System.out.println("Instructor: Xudong Liu");
		System.out.println("           ");
		System.out.println("Array Searches & Sorts");
	}
	  /**
      * Method to display the option user has to enter.
      * @param none
      * @return nothing
      */
	public static void Menu() {
		System.out.println("  ");
		System.out.println("1. Print A State Report");
		System.out.println("2. Sort By State Name");
		System.out.println("3. Sort By Population");
		System.out.println("4. Sort By Region");
		System.out.println("5. Find And Print A Given State");
		System.out.println("6. Quit");
	}
	
	
	/**
     * Method to display the contents of the State array object
     * by its state, capital, abbr, population, region and seats.
     * @param State[] State_array
     * @return nothing
     */
	public static void Display(State[] State_array) {
		
		//Print the format of the states headings
		System.out.print(String.format("%-25s", "State"));
		System.out.print(String.format("%-25s", "Capital"));
		System.out.print(String.format("%-25s", "Abbr"));
		System.out.print(String.format("%-25s", "Population"));
		System.out.print(String.format("%-25s", "Region"));
		System.out.print(String.format("%-25s", "US House Seats" + "\n"));
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

		//Print contents of the state's attributes
		for (int index = 0; index < State_array.length; index++) {
			System.out.print(String.format("%-25s", State_array[index].getStateName()));
			System.out.print(String.format("%-25s", State_array[index].getStateCapital()));
			System.out.print(String.format("%-25s", State_array[index].getStateAbrv()));
			System.out.print(String.format("%-25s", State_array[index].getStatePopulation()));
			System.out.print(String.format("%-25s", State_array[index].getStateRegion()));
			System.out.print(String.format("%-25s", State_array[index].getStateSeats()) + "\n");
		} // end for

	}// end DisplayStateData
	
	
	 /**
     * Method to sort the contents of the State array object by region using 
     * insertion sort.
     * @param State[] State_array
     * @return nothing
     */
	public static void InsertionSortOnStateRegion(State[] State_array) {
		
		int in, out;
		for (out = 1; out < State_array.length; out++) // out is the dividing line
		{
			State temp = State_array[out]; //removed marked item
			in = out; // start shifts at out
			while (in > 0 && State_array[in - 1].getStateRegion().compareTo(temp.getStateRegion()) > 0) //until one is smaller
			{
				State_array[in] = State_array[in - 1]; // shift items right
				in--; //go left one position
			} // end while
			State_array[in] = temp; // insert marked item
		} 
		System.out.println();
		System.out.println("States sorted by Region.");
	}// end InsertionSortOnStateRegion(State[] State_array)

	

	/**
     * Method to sort the contents of the State array object by State name using 
     * bubble sort.
     * @param State[] State_array
     * @return nothing
     */
	public static void BubbleSortOnStateName(State[] State_array) {
		

		for (int i = 1; i < State_array.length; i++) // outer loop(backwards)
		{
			for (int j = 0; j < State_array.length - i; j++)//inner loop (forwards)
			{
				if (((State_array[j].getStateName()).compareTo((State_array[j + 1].getStateName()))) > 0) // out of order?
				{
					// Swap
					State temp = State_array[j];
					State_array[j] = State_array[j + 1];
					State_array[j + 1] = temp;
				} 
			} 
		} 
		System.out.println();
		System.out.println("States sorted by State name.");
	}// end BubbleSortOnStateName(State[] State_array)
	
	/**
     * Method to sort the print the contents of a given State array object
     * by region using binary search. Returns true if found
     * @param State[] State_array,  String stateName
     * @return true
     */
	public static boolean BinarySearchPrintState(State[] State_array, String stateName) {
		boolean found = true;

		int lowerBound = 0;
		int upperBound = State_array.length - 1;

		while (lowerBound <= upperBound) {
			int curIn = (lowerBound + upperBound) / 2;

			if (stateName.equals(State_array[curIn])) {
				System.out.print(String.format("%-20s", "State Name: " + State_array[curIn].getStateName()));
				System.out.print(String.format("%-20s", "Capital City: " + State_array[curIn].getStateCapital()));
				System.out.print(String.format("%-20s", "State Abbreviation: " + State_array[curIn].getStateAbrv()));
				System.out.print(String.format("%-20s", "State Population: " + State_array[curIn].getStatePopulation()));
				System.out.print(String.format("%-20s", "Region: " + State_array[curIn].getStateRegion()));
				System.out.print(String.format("%-20s", "U.S. House Seats: " + State_array[curIn].getStateSeats() + "\n"));

			} else if (stateName.compareTo(State_array[curIn].getStateName()) > 0) {
				upperBound = curIn - 1;

			} else {
				lowerBound = curIn + 1;

			}

		} 
		return found;
	}// end BinarySearchPrintState(State[] State_array, String stateName)

	/**
     * Method to sort the contents of a given State array object
     * by population using selection sort
     * @param State[] State_array
     * @return nothing
     */
	public static void SelectionSortOnStatePopulation(State[] State_array) {
		

		State temp;

		for (int outer = 0; outer < State_array.length - 1; outer++) // outer loop
		{

			int min = outer; // minimum
			for (int inner = outer + 1; inner < State_array.length; inner++)//inner loop
			{
				if (State_array[inner].getStatePopulation() < State_array[min].getStatePopulation()) //if min greater,
				{
					min = inner;// we have a new min
				}
			}
			// Swap
			temp = State_array[min];
			State_array[min] = State_array[outer];
			State_array[outer] = temp;
		}// end for(out)

		System.out.println();
		System.out.println("States sorted by Population.");
	}// end SelectionSortOnStatePopulation(State[] State_array)


	/**
     * Method to sort the print the contents of a given State array object
     * by region using sequential search. Returns false if not found.
     * @param State[] State_array,  String stateName
     * @return false
     */
	public static boolean SequentialSearchPrintState(State[] State_array, String NameofState) {
	
		// set flag variable to false
		boolean found = false;
		for (int index = 0; index < State_array.length - 1; index++) {
			String stateComparison = State_array[index].getStateName().toLowerCase();
			if (stateComparison.equalsIgnoreCase(NameofState)) {
				found = true;
				System.out.println(String.format("%-20s", "State Name: " + State_array[index].getStateName()));
				System.out.println(String.format("%-20s", "Capital City: " + State_array[index].getStateCapital()));
				System.out.println(String.format("%-20s", "State Abbreviation: " + State_array[index].getStateAbrv()));
				System.out.println(String.format("%-20s", "State Population: " + State_array[index].getStatePopulation()));
				System.out.println(String.format("%-20s", "Region: " + State_array[index].getStateRegion()));
				System.out.println(String.format("%-20s", "U.S. House Seats: " + State_array[index].getStateSeats() + "\n"));
			}
		} 
		return false;
	}// end SequentialSearchPrintState(State[] State_array, String NameofState)
	
}// end class