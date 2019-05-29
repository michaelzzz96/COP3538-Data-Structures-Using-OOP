/**
 * The Stack class contains a push, pop, isEmpty, isFull, size, and print method
 * to allow the Project2 class to access it's properties. All methods in stack class are
 * referenced from Data Structure & Algorithms in Java 2nd edition. 
 * Robert Lafore pages 128 and 129. 
 * @author 
 */
public class Stack {

	// Declare fields
	private int maxSize;
	private State[] stackArray;
	private int top;
	private int number;

	/**
	 * Constructor for Stack.
	 * @param s : integer
	 * @return nothing
	 */
	public Stack(int s) // constructor
		{
		maxSize = s;
		stackArray = new State[maxSize];
		top = -1;
		}

	/**
	 * Method to push the state object.
	 * @param State j
	 * @return nothing
	 */
	public void push(State j) //put item on top of stack
		{
		stackArray[++top] = j; // increment top, insert item
		}

	/**
	 * Method to pop the state object.
	 * @param nothing
	 * @return stackArray[top--]
	 */
	public State pop()  // take item from top of stack
		{
		return stackArray[top--]; // access item, decrement top
		}
	
	
	
	/**
     * Method to print the contents of the stack
     * @param nothing
     * @return nothing
     */
	public void printStack() {
		System.out.println("\n");
		System.out.print(String.format("%-20s", "State Name"));
		System.out.print(String.format("%-20s", "Capital City"));
		System.out.print(String.format("%-20s", "State Abbr"));
		System.out.print(String.format("%-20s", "State Population"));
		System.out.print(String.format("%-20s", "Region"));
		System.out.println(String.format("%-20s", "US House Seats"));
		System.out.println(
				"--------------------------------------------------------------------------------------------------"
						+ "------------------------");

		for (int index = top; index >= 0; index--) {

			System.out.print(String.format("%-20s", stackArray[index].getStateName()));
			System.out.print(String.format("%-20s", stackArray[index].getStateCapital()));
			System.out.print(String.format("%-20s", stackArray[index].getStateAbrv()));
			System.out.print(String.format("%-20s", stackArray[index].getStatePopulation()));
			System.out.print(String.format("%-20s", stackArray[index].getStateRegion()));
			System.out.println(String.format("%-20s", stackArray[index].getStateSeats()));
		}// end for

		System.out.println("\n");
	}// end printStack
	

	
	/**
	 * Method when the stack is empty.
	 * @param nothing
	 * @return (top == -1)
	 */
	public boolean isEmpty() // true if stack is empty
		{
		return (top == -1);
		}

	
	/**
	 * Method when the stack is full.
	 * @param nothing
	 * @return (top == maxSize - 1)
	 */
	public boolean isFull() // true if stack is full 
		{
		return (top == maxSize - 1);
		}
	

	/**
	 * Method to tell the size of the stack.
	 * @param nothing
	 * @return maxSize
	 */
	public int size() 
		{
		return maxSize;
		}
	
}// End Stack Class
