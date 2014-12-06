package dataStructures;

/**
 * @author cwomble
 * The stack is a last in first out data structure.
 * It is a list of objects with a pointer only to the top.
 * like a queue it is very easy to implement with a linked list.
 * Can be used for things like recursion, backtracking, and memory management.
 * Complexity: O(1) for push pop isEmpty
 * Pros:
 * fast and easy to implement made with array
 * fast and grow shrink dynamically made with linked list
 * Cons:
 * resizing the stack is O(n) made with array
 * allocating/freeing memory can be costly made with linked list
 * Types:
 * Plain stack, array or linked list implementation.
 *
 */
public class Stack 
{
	Node top = null;
	
	public Node pop()
	{
		if (top != null)
		{
			Node oldTop = top;
			top = top.previous;
			return oldTop;
		}
		return null;
	}
	
	public void push(Node newNode)
	{
		if (top != null)
		{
			newNode.previous = top;
			top = newNode;
		}
		else top = newNode;
	}
	
	public Node peek()
	{
		return top;
	}
	
	public boolean isEmpty()
	{
		if (top == null)
			return true;
		return false;
	}
	
	public class Node
	{
		int intData;
		Node previous = null;
	}
}
