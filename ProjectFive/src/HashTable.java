
/**
 * The HashTable class contains a constructor, insert, find, delete, display, hash function
 * and print number of collisions and available spaces. All methods in HashTable class uses the
 * Linked list and node class methods except hash function and printFreeAndCollisions
 * are referenced from Data Structure & Algorithms in Java 2nd edition. Pages 555 - 557.
 * Robert Lafore   
 * @author 
 */
public class HashTable {

	
	private FirstLastList[] hashArray; // array of lists
	private int arraySize; 
	private int avaliableSpace = 113;
	
	/**
	 * Constructor for HashTable.
	 * @param nothing
	 * @return nothing
	 */
	public HashTable() {

		hashArray = new FirstLastList[arraySize = 113];
		for(int i = 0; i < arraySize; i++)
			hashArray[i] = new FirstLastList();
	}

	/**
	 * Method to insert states name and population onto the hash table.
	 * @param String state, int population.
	 * @return 
	 */
	public void insert(String state, int population) {

		int hashVal = HashFunc(state);
		hashArray[hashVal].insertLast(state, population);
		avaliableSpace--;
		
	}

	/**
	 * Method to find states name on the hashTable.
	 * @param String state.
	 * @return -1
	 */
	public int find(String state) {
		int hashVal = HashFunc(state);
		hashArray[hashVal].find(state);
		return -1;

	}

	/**
	 * Method to delete states name on the hash table.
	 * @param String state.
	 * @return
	 */
	public void delete(String state) {

		int hashVal = HashFunc(state);
		hashArray[hashVal].remove(state);
		avaliableSpace++;

	}

	/**
	 * Method to display states name and population on the hash table.
	 * @param none.
	 * @return
	 */
    public void display() {
        for (int i = 0; i < arraySize; i++) {
            try {
        	
            	if (hashArray[i].First == null) {
                System.out.println((i ) + ". Empty");
                continue;
            }
           
            System.out.print((i) + ". ");
            hashArray[i].displayList();
          
           
        }catch(NullPointerException c){
        }
        }
    }

    /**
	 * Method to print available spaces and collisions on the hash table.
	 * @param none.
	 * @return
	 */
	public void printFreeAndCollisions() {
		int StateCollisions = 0;
		int i = 0;
		
		while (i < arraySize) {
		
			
			if ( hashArray[i] == null) 
				StateCollisions = StateCollisions + 1;
			
			
			if (hashArray[i].First != hashArray[i].Last) 
				StateCollisions = StateCollisions + 1;
				
			
			i++;
		}

		System.out.println(
				"Hash Table has " +  avaliableSpace   + " empty spaces and " + StateCollisions + " collisions.");
	}

	/**
	 * Hash function.
	 * @param String state.
	 * @return
	 */
	private int HashFunc(String state) {
		int Statehash = 0;

		for (int i = 0; i < state.length(); i++)
		 {
			Statehash = Statehash + state.charAt(i);
		 }
		 return Statehash % arraySize;
	}

	 /**
	   * The Node class contains a constructor,  and print method
	   * to allow the Project5 class to access it's properties. 
	   * All methods in Node class are referenced from 
	   * Data Structure & Algorithms in Java 2nd edition. 
	   * Robert Lafore   
	   * @author 
	   */
	private class Node {

		String stateName;
		int statePopulation;
		Node nextNode;

		
		public Node(String state, int population)
		{
			stateName = state;
			statePopulation = population;
		}

		public void printNode() {
			System.out.printf("%-25s%,10d\n", stateName,
					statePopulation);
		}
	}

	
	 /**
	   * The FirstLastList class is the linked list that contains a constructor, 
	   * isEmpty, insertlast, remove, find, and displayList method
	   * to allow the Project5 class to access it's properties. 
	   * All methods in FirstLastList class are referenced from 
	   * Data Structure & Algorithms in Java 2nd edition page 198-200 and pages 555 - 558. 
	   * Robert Lafore   
	   * @author 
	   */
	private class FirstLastList {

		Node First;
		Node Last;

		public FirstLastList() {
			First = null;
			Last = null;
		}
		
		/**
		 * Method to set First to null.
		 * @param none.
		 * @return First==null.
		 */
		public boolean isEmpty() // true if no links
		{ return First==null; }
		

		/**
		 * Method to insert states with state name and population on the hash table.
		 * @param String state, int population.
		 * @return none.
		 */
		public void insertLast(String state, int population) {

			Node newNode = new Node(state, population);
			Node previous = null;
			Node current = First;

			if( isEmpty() ) // if empty list,
				Last = newNode; // newLink <-- last
			    newNode.nextNode = First; // newLink --> old first
				First = newNode; 
		}

		/**
		 * Method to remove states name  on the hash table.
		 * @param String state.
		 * @return none.
		 */
		public void remove(String state) {

				
				Node previous = null;
				Node current = First;

				while (current != null && state.compareTo(current.stateName) != 0) {
					previous = current;
					current = current.nextNode;
		
				}

				if (previous == null) {
					First = First.nextNode;
				}
				else 
					previous.nextNode = current.nextNode;
				
				return;
		}
		
		
		/**
		 * Method to find states on the hash table.
		 * @param String state.
		 * @return -1.
		 */
		public int find(String state) {

			Node current = First;

			while (current != null && state.compareTo(current.stateName) <= 0) {

				if (state.compareTo(current.stateName) == 0) {
					System.out.println(state + " is found with a population of " + current.statePopulation);
					return current.statePopulation;
				}
				current = current.nextNode;
			}

			System.out.println(state + " is not found");

			return -1;
		}
		
		/**
		 * Method to display states on the hash table.
		 * @param String state.
		 * @return -1.
		 */
		public void displayList() {
			
			
			for(Node current = Last;current != null; current = current.nextNode)
			{
				current.printNode();
				
			}
			System.out.print("");
		}
		
		
	}
	
	
}