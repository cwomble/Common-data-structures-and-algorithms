package dataStructures;

/**
 * @author cwomble
 * A binary search tree is a tree that follows the rule that 
 * every node has smaller nodes as children on the left, and larger
 * nodes as children on the right. There should be no duplicate nodes.
 * There is a unique path from the root to every other node in the tree.
 * Not to be confused with a plain binary tree which has no rules about
 * size of nodes.
 * Complexity:
 * most operations are O(log (n)) search, insert, delete
 * Pros:
 * Fast insertion/deletion if balanced, efficient and easy to code
 * searching, insertion, deletion is efficient, dynamic.
 * Cons:
 * shape depends on order of insertions, in search every visited node must be 
 * compared to key node and can take a long time, after many insertions/deletions
 * height of tree grows larger towards the square root of the number of nodes(unless balanced).
 * Types: Plain BST, Balanced BST, Red-Black tree, AVL tree, splay tree, tango tree, treap
 *
 */
public class BinarySearchTree 
{

	private Node root;
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public void insert(int data)
	{
		insert(root, data);
	}
	
	public Node insert(Node n, int data)
	{
		if (root == null)
			root = new Node(data);
		else
		{
			if (data < n.getData())
				n.leftChild = insert(n.leftChild, data);
			else
				n.rightChild = insert(n.rightChild, data);
		}
		return n;
	}
	
	public void insert(Node in)
	{
		if (root != null)
		{
			if (in.intData > root.intData)
			{
				
			}
		}
	}
	
	public void delete(int data)
	{
		root = delete(root, data);
	}
	
	public Node delete(Node n, int data)
	{
		Node p1, p2, p3;
		if (root.getData() == data)
		{
			Node l, r;
			l = root.getLeft();
			r = root.getRight();
			if (l == null && r == null)
				return null;
			else if (l == null)
			{
				p1 = r;
				return p1;
			}
			else if (r == null)
			{
				p1 = l;
				return p1;
			}
			else 
			{
				p2 = r;
				p1 = r;
				while (p1.getLeft() != null)
					p1 = p1.getLeft();
				p1.setLeft(l);
				return p2;
			}
		}
		
		if (data < root.getData())
		{
			p3 = delete(root.getLeft(), data);
			root.setLeft(p3);
		}
		else 
		{
			p3 = delete(root.getRight(), data);
			root.setRight(p3);
		}
		
		return root;
		
	}
	
	public int countNodes()
	{
		return countNodes(root);
	}
	
	private int countNodes(Node n)
	{
		if (n == null)
			return 0;
		else
		{
			int l = 1;
			l += countNodes(n.getLeft());
			l += countNodes(n.getRight());
			return l;
		}
	}
	
	public boolean search(int data)
	{
		return search(root, data);
	}
	
	private boolean search(Node n, int data)
	{
		boolean found = false;
		while (n != null && found == false)
		{
			int rval = n.getData();
			if (data < rval)
				n = n.getLeft();
			else if (data > rval)
				n = n.getRight();
			else 
			{
				found = true;
				break;
			}
			found = search(n,data);
		}
		return found;
	}
	
	public void inOrder()
	{
		inOrder(root);
	}
	
	private void inOrder(Node n)
	{
		if (n != null)
		{
			inOrder(n.getLeft());
			//output
			inOrder(n.getRight());
		}
	}
	
	public void preOrder()
	{
		preOrder(root);
	}
	
	private void preOrder(Node n)
	{
		if (n != null)
		{
			//output
			preOrder(n.getLeft());
			preOrder(n.getRight());
		}
	}
	
	public void postOrder()
	{
		postOrder(root);
	}
	
	private void postOrder(Node n)
	{
		postOrder(n.getLeft());
		postOrder(n.getRight());
		//output
	}
	
	public class Node
	{
		int intData;
		Node leftChild;
		Node rightChild;
		
		public Node()
		{
			intData = 0;
			Node leftChild = null;
			Node rightChild = null;
		}
		
		public Node(int data)
		{
			intData = data;
			leftChild = null;
			rightChild = null;
		}
		
		public void setLeft(Node n)
		{
			leftChild = n;
		}
		
		public void setRight(Node n)
		{
			rightChild = n;
		}
		
		public Node getLeft()
		{
			return leftChild;
		}
		
		public Node getRight()
		{
			return rightChild;
		}
		
		public void setData(int data)
		{
			intData = data;
		}
		
		public int getData()
		{
			return intData;
		}
		
	}
}
