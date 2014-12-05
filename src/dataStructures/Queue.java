package dataStructures;

/**
 * @author cwomble
 * A queue is a first in first out data structure
 * that is a list of data with pointers to the first and last
 * nodes. Data is always added to the end of the list
 * and removed from the front. It is very easy to implement
 * with a linked list.
 * Complexity:
 * Enqueue, dequeue, isEmpty are O(1)
 * Pros:
 * Fast and can grow/shrink dynamically.
 * Cons: 
 * Allocating or freeing memory can be costly.
 * Types:
 * Plain queue, priority queue, circular queue, double ended queue
 */
public class Queue 
{
	Node first = null, last = null;
	
	public void enqueue(int data)
	{
		Node added = new Node(data);
		if (first == null)
		{
			last = added;
			first = last;
		}
		else
		{
			last.next = added;
		}
	}
	
	public Node dequeue()
	{
		if (first != null)
		{
		Node oldNode = first;
		first = oldNode.next;
		return oldNode;
		}
		return null;
	}
	
	public Node peek()
	{
		return first;
	}
	
	public boolean isEmpty()
	{
		if (first != null)
			return false;
		return true;
	}
	
	public class Node
	{
		int intData;
		Node next = null;
		public Node(int data)
		{
			intData = data;
		}
	}
	
	
}
