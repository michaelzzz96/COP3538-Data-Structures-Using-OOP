
/**
 * The BinarySearchTree class contains a constructor, insert, find, delete, isFull, getSuccessor, 
 * printInorder, printPreorder, printPostorder, printMinimum, printMinimum, and a node class
 * to allow the Project4 class to access it's properties. Methods in BinarySearchTree class
 * are referenced from Data Structure & Algorithms in Java 2nd edition. 
 * Robert Lafore   
 * @author 
 */
public class BinarySearchTree {

	
	Node root; // first node of tree
	


	/**
	 * Constructor for Stack.
	 * @param nothing
	 * @return nothing
	 */
	public BinarySearchTree() // constructor
	{
		root = null; // no nodes in tree yet
		
	}
	
	/**
	 * Method to insert states name and population onto the tree.
	 * @param String state, int population.
	 * @return 
	 */
	public void insert(String state, int population){
		 Node newNode = new Node(state, population);
			
		 newNode.stateName = state;
		 newNode.statePopulation = population;
		 
		 if(root==null)
				root = newNode;
			else{
				Node current = root;		
				Node parent;				
				
				while(true)
				{
					parent = current;
						if(state.compareTo(current.stateName) < 0 )
							{			 		
							current = current.leftChild;
							if(current==null)
								{									
								parent.leftChild = newNode;
								return;
								}
							}
						 else 
						 	{
							current = current.rightChild;
							if(current == null)
							  {
							  parent.rightChild = newNode;
							  return;
						}
					}
				}
			}
		}
			

	/**
	 * Method to search states name on the tree.
	 * @param String state.
	 * @return -1
	 */
	public int find (String state)	{
		
		// Count the nodes
		int NodeCounter = 1;
		
		Node current = root;
		
		while ((state.compareTo(current.stateName) != 0))
		{
			NodeCounter++;
			
			if((state.compareTo(current.stateName)) < 0) 
				current = current.leftChild;
			
			else
				current = current.rightChild;
				
			if(current == null){
				System.out.println(state + " is not found" + "\n" + NodeCounter  + " nodes visited" );
				return -1;
			}
			
			if(state.compareTo(current.stateName) == 0){
				System.out.println(state + " was found with a population of " + current.statePopulation+ "\n" + NodeCounter + " nodes visited\n ");
				return current.statePopulation;
			}
		}
	
		return -1;
		
	}
	
		
	/**
	 * Method to delete states name on the tree.
	 * @param String state.
	 * @return
	 */
		public void delete(String state){
			
			Node current = root;
			Node parent = root;
			boolean isLeftChild = true;

			while (current.stateName.compareToIgnoreCase(state) != 0)	 
				{
				parent = current;
				if (0 < current.stateName.compareToIgnoreCase(state))
					{
					isLeftChild = true;
					current = current.leftChild;
					}
				else	
					{
					isLeftChild = false;
					current = current.rightChild;
					}
				if (current == null){
					return;
				}
			}
			
			if (current.leftChild == null && current.rightChild == null)	{
				
				if (current==root)	
					root = null;
				
				else if (isLeftChild == true)	
					parent.leftChild = null;
				
				else	
					parent.rightChild = null;
			}
			
			else if (current.rightChild == null)	
				
				if (current==root)	
				root = current.leftChild;
				
				else if (isLeftChild)	
				parent.leftChild = current.leftChild;	
				
				else	
				parent.rightChild = current.leftChild;
			
			
			else if (current.leftChild == null)
				
				if (current == root)	
				root = current.rightChild;
				
				else if (isLeftChild)	
				parent.leftChild = current.rightChild;
				
				else	
				parent.rightChild = current.rightChild;
			
			else 
			{
				
				Node successor = getSuccessor(current);
				
				if (current == root)	
					root = successor;
				
				else if (isLeftChild)	
				parent.leftChild = successor;
				
				else			
				successor.leftChild = current.leftChild;
			}		
			
			System.out.println(state + " has been deleted from tree");		
		}
	
		
		/**
		 * Method to get states highest value or name on the tree.
		 * @param Node delNode.
		 * @return successor.
		 */
		private Node getSuccessor(Node delNode) 
			{
			Node successorParent = delNode;
			Node successor = delNode;
			Node current = delNode.rightChild;
			while(current != null)
				{
				successorParent=successor;
				successor=current;
				current=current.leftChild;
				}
			
			if(successor != delNode.rightChild)
				{
				successorParent.leftChild=successor.rightChild;
				successor.rightChild=delNode.rightChild;
				}
			return successor;
		}

	
		/**
		 * Method to traverse the tree inorder to print states name on the tree.
		 * @param Node localRoot.
		 * @return none
		 */
		public void printInorder(Node localRoot){
			if (localRoot != null)
			{
				printInorder(localRoot.leftChild);
				localRoot.printNode();
				printInorder(localRoot.rightChild);
			}
		}
		
	
		/**
		 * Method to traverse the tree preorder to print states name on the tree.
		 * @param Node localRoot.
		 * @return none
		 */
		public void printPreorder(Node localRoot){
			if (localRoot != null)
			{
				localRoot.printNode();
				printPreorder(localRoot.leftChild);
				printPreorder(localRoot.rightChild);
			}
		}
		
	
		/**
		 * Method to traverse the tree postorder to print states name on the tree.
		 * @param Node localRoot
		 * @return none
		 */
		public void printPostorder(Node localRoot){
			if (localRoot != null)
			{
				printPostorder(localRoot.leftChild);
				printPostorder(localRoot.rightChild);
				localRoot.printNode();
			}		
		}
		
		

		/**
		 * Method to print states with the most minimum population on the tree.
		 * @param none
		 * @return none
		 */
		public void printMinimum()		
		{
			printMinimum(root).printNode();
		}
		
		
		/**
		 * Method to print states name on the tree.
		 * @param String state.
		 * @return none
		 */
		public void printMaximum()		
		{
			printMaximum(root).printNode();
		}
		
		

		/**
		 * Method to find states with minimum population on the tree.
		 * @param Node node.
		 * @return current.
		 */
		public Node printMinimum(Node node)	{
			
			if (node == null)	
			{
				return new Node(" " , Integer.MAX_VALUE);
			}
			
			Node current = node;
		
			
			if (printMinimum(node.leftChild).statePopulation < current.statePopulation)	
				current = printMinimum(node.leftChild);
			
			if (printMinimum(node.rightChild).statePopulation < current.statePopulation)	
				current = printMinimum(node.rightChild);
			
			return current;
		}
	

		/**
		 * Method to find states with maximum population on the tree.
		 * @param Node node.
		 * @return current.
		 */
		public Node printMaximum(Node node)	{
			
	       if (node == null) 
	       {
	            return new Node("", Integer.MIN_VALUE); 
	       }
	       
	        Node current = node;
	  
	        if (printMaximum(node.leftChild).statePopulation > current.statePopulation) 
	        	current = printMaximum(node.leftChild); 
	        if (printMaximum(node.rightChild).statePopulation > current.statePopulation) 
	        	current = printMaximum(node.rightChild);; 
	        
	        return current; 
	    } 
		
		

	  /**
	   * The Node class contains a constructor,  and print method
	   * to allow the Project4 class to access it's properties. 
	   * All methods in Node class are referenced from 
	   * Data Structure & Algorithms in Java 2nd edition. 
	   * Robert Lafore   
	   * @author 
	   */
	private class Node {
		String stateName;
		int statePopulation;
		Node leftChild;
		Node rightChild;

		public Node(String state, int population) {
			stateName = state;
			statePopulation = population;
		}

		public void printNode() {
			System.out.printf("%-25s%,10d\n", stateName, statePopulation);
		}
	}

}