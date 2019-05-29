import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * COP 3538: Project 4 - Binary Search Trees.
 * <p>
 * The Project4 class reads a CSV file that is used to implement a Binary Search Tree using 
 * States4.csv file. 
 * Reference: Data Structure & Algorithms in Java 2nd edition. Robert Lafore
 * <p>
 * 
 * @author Michael Zulfekar
 * @version 4-5-19
 *
 */
public class Project4 {
	
	// Create Tree object
	 static BinarySearchTree bst = new BinarySearchTree();
	 
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
     * Method to display message.
     * @param none
     * @return nothing
     */
	public static void Message() {
		System.out.println("COP3538 Project 4 - Xudong Liu");
		System.out.println("           ");
		System.out.println("Binary Search Trees ");
		
	}// End Message()

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
	}// End PrintData()
	
	 /**
     * Format heading.
     * @param none
     * @return nothing
     */
	public static void Format() {
		System.out.print("State Name    ");
		System.out.println("               State Population");
		System.out.println(
				"---------------------------------------------");
	}
	
	 /**
     * Delete states before Preorder Traversal.
     * @param none
     * @return nothing
     */
	public static void DeleteIn() 
	{
		bst.delete("California");
		bst.delete("Florida");
		bst.delete("Kentucky");
	}
	
	 /**
     * Find states.
     * @param none
     * @return nothing
     */
	public static void Find() 
	{
		bst.find("Michigan");
		bst.find("Guam");
		bst.find("Florida");
	}
	
	 /**
     * Delete states before PostOrder Traversal
     * @param none
     * @return nothing
     */
	public static void DeletePre() 
	{
		bst.delete("Delaware");
		bst.delete("American Samoa");
		bst.delete("West Virginia");
		bst.delete("North Dakota");
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

		
		
		while (true) {
			
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

				//Call Scanner Object
				Scanner file = new Scanner(new File(filename));
				file.nextLine();

				// reads file
				while (file.hasNextLine()) 
				{

					String line = file.nextLine();
					if (line.isEmpty())
						continue;

					// call the splitStates function
					State s = splitStates(line);

					// insert name and population on the tree
					bst.insert(s.getStateName(), s.getStatePopulation());
					
					// increment states
					StatesCounter++;
					
				}// End while
				
				// Close file
				file.close();
			

				// Output number of states onto the tree
				System.out.println("There were " + StatesCounter + " state records put on the binary search tree.\n");
			
				
				// Output
				System.out.println("Inorder Traversal\n ");
				Format();
				
				// Output InOrder
				bst.printInorder(bst.root);
				
				System.out.println(" ");
				
				// Delete states
				DeleteIn();
				System.out.println(" ");

				
				System.out.println("Preorder Traversal\n ");
				Format();
				// Output PostOrder
				bst.printPreorder(bst.root); 
				
				System.out.println(" ");
				
				// Find given states
				Find();
			
				System.out.println("");

				// Delete states
				DeletePre();
				
				System.out.println("\n");
				
				// Output PostOrder
				System.out.println("Postorder Traversal\n ");
				Format();
				bst.printPostorder(bst.root);
				
				
				// Output Minimum
				System.out.println("\n");
				System.out.println("State with the minimum population ");
				System.out.println("");
				Format();
				bst.printMinimum();
				
				System.out.println(" ");
				System.out.println(" ");
				
				// Output Maximum
				System.out.println("State with the maximum population ");
				System.out.println(" ");
				Format();
				bst.printMaximum();
				
				System.out.println("\n");
				
		
			} catch (FileNotFoundException error) {
				System.out.println("\nFile not found. Please try again.");

			}// End Catch
		}// End while
	}// End main
}// End class
