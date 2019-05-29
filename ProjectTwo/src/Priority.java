/**
 * The Priority class contains a insert, remove, isEmpty, isFull, size, and print 
 * method to allow the Project2 class to access it's properties. All methods in the
 * Priority class are referenced from  Data Structure & Algorithms in Java 2nd edition. 
 * Robert Lafore pages 147-148. Except the Remove method. It is referenced from 
 * page 138. 
 * @author 
 */
public class Priority{

	// Declare fields
	private int maxSize; 
	public State[] queArray; 
	private int front; 
	private int nItems; 
	

	/**
	 * Constructor for Priority.
	 * @param s : integer
	 * @return nothing
	 */
	public Priority(int s) // constructor
		{         
		maxSize= s;
		queArray = new State[maxSize];
		} 


	/**
	 * Method to insert the state object.
	 * @param State item
	 * @return nothing
	 */
	public void insert(State item) // insert item
		{
		int j;
		if(nItems==0) // if no items,
			queArray[nItems++] = item; // insert at 0
		else {						   // if items 
			for(j=nItems-1; j>=0; j--) 
				{ 					   // start at end, 
				if(item.getStatePopulation() > queArray[j].getStatePopulation()) // if new item larger,
					queArray[j+1] = queArray[j];  // shift upward
				else 							  // if smaller,
					break; 						  // done shifting 
				} 
			queArray[j+1] = item; 				  // insert it
		nItems++;
		 }
		} 

	
	/**
	 * Method to remove the state object.
	 * @param nothing
	 * @return temp
	 */
	public State remove() // take item from front of queue
		{             
		State temp = queArray[front++];  // get value and increase front 
		if (front == maxSize)            // deal with wraparound
			front = 0;      
		nItems--;                      	 // one less item
		return temp; 
		} 
	
	
	/**
     * Method to print the contents of the queue
     * @param nothing
     * @return nothing
     */
	public void printQueue() {

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

		for (int index = 0; index < queArray.length; index++) {
			System.out.print(String.format("%-20s", queArray[index].getStateName()));
			System.out.print(String.format("%-20s", queArray[index].getStateCapital()));
			System.out.print(String.format("%-20s", queArray[index].getStateAbrv()));
			System.out.print(String.format("%-20s", queArray[index].getStatePopulation()));
			System.out.print(String.format("%-20s", queArray[index].getStateRegion()));
			System.out.print(String.format("%-20s", queArray[index].getStateSeats()) + "\n");
		}// end for

	}// end printQueue
	
	
	/**
	 * Method when the queue is empty.
	 * @param nothing
	 * @return (nItems==0)
	 */
	public boolean isEmpty() 
		{    
		return (nItems==0); // true if queue is empty 
		} 

	/**
	 * Method when the queue is full.
	 * @param nothing
	 * @return nItems==maxSize
	 */
	public boolean isFull() 
		{     
		return (nItems==maxSize); // true if queue is full
		} 

	/**
	 * Method to tell the size of the queue.
	 * @param nothing
	 * @return nItems
	 */
	public int size() {          
		return nItems; 
	} 


}// End Priority class.