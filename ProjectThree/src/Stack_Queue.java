/**
 * The Stack_Queue class is an empty to access the stack and queue classes
 * @author 
 */
public class Stack_Queue {

}//End Stack_Queue


/**
 * The Stack class contains a constructor, push, pop, isEmpty, isFull, size, and print method
 * to allow the Project2 class to access it's properties. All methods in stack class are
 * referenced from Data Structure & Algorithms in Java 2nd edition. 
 * Robert Lafore   
 * @author 
 */
	  class Stack {
		  
		    // Declare fields
			private LinkListStack List_States_Stack;
			
			
	
			/**
			 * Constructor for Stack.
			 * @param nothing
			 * @return nothing
			 */
			public Stack() // Constructor
			{ 
				List_States_Stack = new LinkListStack();
			}
			
		
			/**
			 * Method to push the state object.
			 * @param State states
			 * @return nothing
			 */
			public void push(State states){
				List_States_Stack.insertFront(states);
			}
			
			
			/**
			 * Method to pop the state object.
			 * @param nothing
			 * @return List_States_Stack.removeFront()
			 */
			public State pop(){
				return List_States_Stack.removeFront();
			}
			
			
			/**
		     * Method to print the contents of the stack
		     * @param nothing
		     * @return nothing
		     */
			public void printStack(){
				List_States_Stack.printStack();
			}
			
			
			/**
			 * Method when the stack is empty.
			 * @param nothing
			 * @return (List_States_Stack.isEmpty())
			 */
			public boolean isEmpty(){
				return (List_States_Stack.isEmpty());
			}
	
			
			/**
			 * Method when the stack is full.
			 * @param nothing
			 * @return false
			 */
			public boolean isFull(){
				return false;
			}
			
			
			/**
			 * Method to tell the size of the stack.
			 * @param nothing
			 * @return List_States_Stack.size()
			 */
			public int size() {
				return List_States_Stack.size();
			}
		
		}// End Stack
	 
	  
	  
	  /**
	   * The Queue class contains a constructor, insertEnd, insertFront, 
	   * removeEnd, removeFront, findDelete, isEmpty, isFull, and print method
	   * to allow the Project3 class to access it's properties. 
	   * All methods in queue class are referenced from 
	   * Data Structure & Algorithms in Java 2nd edition. 
	   * Robert Lafore   
	   * @author 
	   */
	  class Queue {
			
		    // Declare fields
			private DoublyLinkListQueue List_States_Queue;
			
		
			/**
			 * Constructor for Queue.
			 * @param nothing
			 * @return nothing
			 */
			public Queue()// Constructor
			{ 
				List_States_Queue = new DoublyLinkListQueue();
			}
			
		
			/**
			 * Method to insertEnd the state object.
			 * @param State states
			 * @return nothing
			 */
			public void insertEnd(State states){
				List_States_Queue.insertEnd(states);
			}
			
			
			/**
			 * Method to insertFront the state object.
			 * @param State states
			 * @return nothing
			 */
			public void insertFront(State states){
				List_States_Queue.insertFront(states);
			}

			
			/**
			 * Method to removeEnd the link object.
			 * @param none
			 * @return List_States_Queue.removeEnd
			 */
			public Link removeEnd(){
				return List_States_Queue.removeEnd();
			}
				
			
			/**
			 * Method to removeFront the link object.
			 * @param none
			 * @return List_States_Queue.removeFront
			 */
			public Link removeFront(){
				return List_States_Queue.removeFront();
			}
			
			
			/**
			 * Method to delete the given state.
			 * @param String states
			 * @return none
			 */
			public void findDelete(String states){
				List_States_Queue.findDelete(states);
			}
			
			
			/**
			 * Method to print the Queue.
			 * @param none
			 * @return none
			 */
			public void printQueue(){
				List_States_Queue.printList();
			}
			
		
			/**
			 * Method when Queue is empty.
			 * @param none
			 * @return List_States_Queue.isEmpty()
			 */
			public boolean isEmpty(){
				return List_States_Queue.isEmpty();
			}
			
			
			/**
			 * Method when Queue is full.
			 * @param none
			 * @return false
			 */
			public boolean isFull(){
				return false;
			}
			
		}// End Queue
	
	  
	  
	  
	  /**
	   * The Link class contains a next and previous field 
	   * to allow the stack and queue class to access it's properties. 
	   * All methods in the link class are referenced from 
	   * Data Structure & Algorithms in Java 2nd edition. 
	   * Robert Lafore   
	   * @author 
	   */
	  class Link{
		  
		  // Declare Fields
		  public State stateData;
		  public Link next;
		  public Link previous;
	
		  /**
			 * Constructor for Link.
			 * @param State states
			 * @return nothing
			 */
		  public Link(State states){ 
			  stateData = states;
	  }
	
		  /**
			 * Method to print the States attributes.
			 * @param none
			 * @return none
			 */
	public void displayState(){
		
			for (int index = 0; index >= 0; index--) {

				System.out.print(String.format("%-20s", stateData.getStateName()));
				System.out.print(String.format("%-20s", stateData.getStateCapital()));
				System.out.print(String.format("%-20s", stateData.getStateAbrv()));
				System.out.print(String.format("%-20s", stateData.getStatePopulation()));
				System.out.print(String.format("%-20s", stateData.getStateRegion()));
				System.out.println(String.format("%-20s", stateData.getStateSeats()));
			}// end for

		}// end displayState
	}// end Link class





	  /**
	   * The LinkListStack class is an Abstract Data 
	   * Type that will implement a linked list using a stack
	   * that contains a first and size field 
	   * to allow the stack to access the links properties. 
	   * All methods in the LinkListStack are referenced from 
	   * Data Structure & Algorithms in Java 2nd edition. 
	   * Robert Lafore   
	   * @author 
	   */	  
class LinkListStack {
	private Link first;
	private int size;
	
	
	/**
	 * Constructor for LinkListStack
	 * @param none
	 * @return none
	 */
	public LinkListStack(){
		first = null;
		size = 0;
	}
	
	/**
	 * Method when LinkListStack is empty.
	 * @param none
	 * @return first == null
	 */
	public boolean isEmpty(){
		return first == null;
	}
	
	/**
	 * Method to insert link states to the front
	 * @param State states
	 * @return none
	 */
	public void insertFront(State states){
		Link newLink= new Link(states);
		newLink.next = first;
		first = newLink;
	}
	
	/**
	 * Method to remove link states from the front
	 * @param none
	 * @return temp.stateData
	 */
	public State removeFront(){
		Link temp = first;
		first = first.next;
		return temp.stateData;
	}
	
	
	/**
	 * Method to return the size  of LinkListStack
	 * @param none
	 * @return size
	 */
	public int size() {
		return size;
	}

	
	/**
	 * Method to print the LinkListStack
	 * @param none
	 * @return none
	 */
	public void printStack(){
		Link displaying =first;
		while(displaying != null){
			displaying.displayState();
			displaying=displaying.next;
		}
	System.out.println("");
	}
	

}// LinkListStack



/**
 * The DoublyLinkListQueue class is an Abstract Data 
 * Type that will implement a linked list using a double linked list
 * that contains a first and last field 
 * to allow the queue to access the links properties. 
 * All methods in the DoublyLinkListQueue are referenced from 
 * Data Structure & Algorithms in Java 2nd edition. 
 * Robert Lafore   
 * @author 
 */	
class DoublyLinkListQueue{
	private Link first;
	private Link last;
	
	
	/**
	 * Constructor for DoublyLinkListQueue
	 * @param none
	 * @return none
	 */
	public DoublyLinkListQueue(){ 
		first = null;
		last = null;
	}
	
	/**
	 * Method when DoublyLinkListQueue is empty.
	 * @param none
	 * @return first == null
	 */
	public boolean isEmpty(){
		return first==null;
	}
	
	/**
	 * Method to insert link states to the end
	 * @param State states
	 * @return none
	 */
	public void insertEnd(State states){
		
		Link newLink = new Link(states);
		if (isEmpty())
			first = newLink;
		else {
			last.next = newLink;
			newLink.previous = last;    
           }
           
		last = newLink;                
      }
	

	/**
	 * Method to insert link states to the front
	 * @param State states
	 * @return none
	 */
	public void insertFront(State states) {
		Link newLink = new Link(states);
		
		if (isEmpty())
			last = newLink;
		else 
			first.previous = newLink;  
			newLink.next = first;          
		    first = newLink;  
		}
	

	/**
	 * Method to removeFront
	 * @param none
	 * @return none
	 */
	public Link removeFront(){
		Link temp = first;
		if(first.next==null)
			last = null;
		else first.next.previous=null;
		first = first.next;
		return temp;
	}
	
	
	/**
	 * Method to removeEnd
	 * @param none
	 * @return temp
	 */
	public Link removeEnd() {
		Link temp = last;
		if(first.next==null)
			first = null;
		else 
			last.previous.next=null;
		last = last.previous;
		return temp;
	}


	/**
	 * Method to delete the given states
	 * @param String key
	 * @return current
	 */
	public Link findDelete(String key){
		Link current = first;
		
		while(current.stateData.compareTo(key) != 0)
		{
			current = current.next;
			if(current == null)
				return null;
		}
		if(current == first)
			first = current.next;
		else
			current.previous.next  = current.next;
		if(current==last)
			last = current.previous;
		else
			current.next.previous = current.previous;
	      return current; 
		 
	 }
	
	
	/**
	 * Method to print the DoublyLinkListQueue
	 * @param none
	 * @return none
	 */
	public void printList(){
		Link displaying = first;
		while (displaying != null){
			displaying.displayState();
			displaying=displaying.next;
		}	
		System.out.println("");
	}
		
}// DoublyLinkListQueue

