package datastructures;
import java.util.*;

/** Class: TreeCell - A data structure that represents a node or cell of
 * a tree with at most two children.
 * 
 * @author Charles
 * @param <T>
 */
public class TreeCell<T> {
	//Fields
	private T datum;
	private TreeCell<T> left;
	private TreeCell<T> right;
	private ArrayList<TreeCell<T>> adjacent = new ArrayList<TreeCell<T>>();
	
	//Main Method
	public static void main(String[] args) {
		TreeCell<Integer> binarySearchTree;
		binarySearchTree = new TreeCell<Integer>(8, (new TreeCell<Integer>(5, new TreeCell<Integer>(2), new TreeCell<Integer>(6))), new TreeCell<Integer>(10));
		//Testing the binary search tree algorithm
		System.out.print(TreeCell.binaryTreeSearch(6, binarySearchTree));
		//Testing the general binary tree searching algorithm
		System.out.print(TreeCell.DFSearch(binarySearchTree, 2));
		//Testing the binary search tree insertion algorithm
		TreeCell.bstInsert(5, binarySearchTree);
		TreeCell.bstInsert(8, binarySearchTree);
		System.out.print(TreeCell.binaryTreeSearch(5, binarySearchTree));
		System.out.print(TreeCell.inorder(binarySearchTree));
	}
	
	//Constructors
	public TreeCell(T x) {
		setDatum(x);
	}
	public TreeCell(T x, TreeCell<T> left, TreeCell<T> right) {
		setDatum(x);
		setLeft(left);
		setRight(right);
		adjacent.add(left);
		adjacent.add(right);
	}
	
	//Class Methods
	public T getDatum() {return datum;} //Gets the TreeCell's data
	
	public void setDatum(T datum) {this.datum = datum;} //Sets the TreeCell's Data
	
	public TreeCell<T> getLeft() {return left;} //Gets the left 
	
	public void setLeft(TreeCell<T> left) {this.left = left;}
	
	public TreeCell<T> getRight() {return right;}
	
	public void setRight(TreeCell<T> right) {this.right = right;}
	
	//== ALGORITHMS ======================================================
	/** Algorithm for searching through a tree. Precondition: Must be 
	 * binary but doesn't have to be a binary search tree. Runs in O(n) 
	 * time.
	 * @param x - Object that we are searching for
	 * @param node - Tree/Node we are searching through
	 * @return - A boolean true or false if Object x is found or not
	 */
	public static boolean treeSearch(Object x, TreeCell<?> node) {
		if (node.datum == null) return false; //If the datum is null, the tree is empty and return false.
		if (node.datum.equals(x)) return true; //If the datum is x, then it's in the tree and return true.
		//If there are two children on the node, call the search on both sides of the tree with a logical or
		if (node.left != null && node.right != null) {
			return treeSearch(x, node.left) || treeSearch(x, node.right);
			}
		//If there is only a left child, call the search on the left side of the tree
		if (node.left != null && node.right == null) {
			return treeSearch(x, node.left);
		}
		//If there is only a right child, call the search on the right side of the tree.
		if (node.left == null && node.right != null) {
			return treeSearch(x, node.right);
		}
		else return false;
	}
	/** Algorithm for searching through a tree. Precondition: Must be a 
	 * binary search tree and x must have the same type as the datum in 
	 * the tree. In this case, this static method is a binary search
	 * algorithm for integer binary search trees. O(logn) time.
	 * @param x - Integer that we are searching for
	 * @param node - Tree/Node we are searching through
	 * @return - A boolean true or false if Object x is found or not
	 */
	public static boolean binaryTreeSearch(Integer x, TreeCell<Integer> node) {
		if (node.datum == null) return false; //If there is no value in the datum of the null, return false
		if (node.datum.equals(x)) return true; //If the datum is equal to x return true
		//If x is smaller than the datum and there exist a left child, then recursively call the search on left side of the tree.
		if (node.left != null && node.datum.compareTo(x) >= 0) {
				return binaryTreeSearch(x, node.getLeft());
			}
		//If x is larger than the datum and there exists a right child, then recursively call the search on the right side of the tree.
		if (node.right != null && node.datum.compareTo(x) < 0) {
			return binaryTreeSearch(x, node.getRight());
		}
		//Else x isn't in the tree and return false
		else return false;
	}
	
	/**Algorithm for inserting a new object into a tree by finding the appropriate 
	 * location in the tree and inserting the value in the empty space. Precondition: Tree must be 
	 * a binary search tree and x must have the same type as the datum in the tree. 
	 * @param x - Value to be inserted into the tree
	 * @param node - Tree/Node that we are inserting into.
	 */
	public static void bstInsert(Integer x, TreeCell<Integer> node) {
		if (node.datum == null) node.setDatum(x); //If the datum of the node is null, set x equal to the datum of the node
		//If the node doesn't have a left branch and x is smaller than the datum, set a new left child equal to x
		if (node.left == null && node.datum.compareTo(x) >= 0) {
			node.setLeft(new TreeCell<Integer>(x));
			return;
		}
		//If the node doesn't have a right branch and x is larger than the datum, set a new right child equal to x
		if (node.right == null && node.datum.compareTo(x) < 0) {
			node.setRight(new TreeCell<Integer>(x));
			return;
		}
		//If the node has a left node already and x is smaller than the datum, the recursively call the insert method on the left side of the tree.
		if (node.left != null && node.datum.compareTo(x) >= 0) {
			bstInsert(x, node.getLeft());
		}
		//If the node has a right node already and x is larger than the datum, then recursively call the insert method on the right side of the tree.
		if (node.right != null && node.datum.compareTo(x) < 0) {
			bstInsert(x, node.getRight());
		}
		//Else do nothing.
		else return;
	}
	/** This method represents a breadth first search for searching a binary search tree
	*/
	public static boolean BFSearch(TreeCell<Integer> node, Integer goal) {
		if (node.datum == null) return false;
		if (node.datum.equals(goal)) return true;
		ArrayList<TreeCell<Integer>> visited = new ArrayList<TreeCell<Integer>>();
		LinkedList<TreeCell<Integer>> queue = new LinkedList<TreeCell<Integer>>();
		queue.push(node);
		while (!queue.isEmpty()) {
			TreeCell<Integer> nextNode = queue.pollLast();
			visited.add(nextNode);
			for (TreeCell e:nextNode.adjacent) {
				if (!visited.contains(e) && e != null) {
					visited.add(e);
					queue.push(e);
				}
			}
			if (nextNode.datum == goal) return true;
		}
		return false;
	}
	
	/** This method represents a depth first search for searching a binary search tree
	*/
	public static boolean DFSearch(TreeCell<Integer> node, Integer goal) {
		if (node.datum == null) return false;
		if (node.datum.equals(goal)) return true;
		ArrayList<TreeCell<Integer>> visited = new ArrayList<TreeCell<Integer>>();
		LinkedList<TreeCell<Integer>> stack = new LinkedList<TreeCell<Integer>>();
		stack.push(node);
		while (!stack.isEmpty()) {
			TreeCell<Integer> nextNode = stack.pollFirst();
			visited.add(nextNode);
			for (TreeCell e:nextNode.adjacent) {
				if (!visited.contains(e) && e != null) {
					visited.add(e);
					stack.push(e);
				}
			}
			if (nextNode.datum == goal) return true;
		}
		return false;
	}

	//===============================================TRAVERSALS=======================================================//
	
	/** Implementation of a preorder traversal of a tree*/
	public static ArrayList<Integer> preorder(TreeCell<Integer> node) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (node.datum == null) return list;
		list.add((Integer) node.datum);
		if (node.left !=null) list.addAll(preorder(node.left));
		if (node.right != null) list.addAll(preorder(node.right));
		return list;
	}
	
	/**Implementation of a postorder traversal of a tree*/
	public static ArrayList<Integer> postorder(TreeCell<Integer> node) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (node.left != null) list.addAll(postorder(node.left));
		if (node.right != null) list.addAll(postorder(node.right));
		list.add((Integer) node.datum);
		return list;
	}
	
	/**Implementation of a inorder traversal of a a tree*/
	public static ArrayList<Integer> inorder(TreeCell<Integer> node) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (node.left != null) list.addAll(inorder(node.left));
		list.add((Integer) node.datum);
		if (node.right != null) list.addAll(inorder(node.right));
		return list;
	}
}


