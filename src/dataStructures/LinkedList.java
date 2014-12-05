package dataStructures;

/**
 * @author cwomble
 * A linked List is a data structure made from a list of nodes that 
 * each point to other nodes in the list.
 * Complexity: 
 * insert/delete/merge are O(1)
 * Pros:
 * Easy to implement insertion/deletion.
 * Dynamic, allocating memory in real time.
 * Easy to implement linear data structures like stacks/queues.
 * They may reduce access time, and can expand with very little overhead.
 * Cons:
 * They are sequential access, and must be read in order from the beginning.
 * Accessing individual elements may not be efficient.
 * Requires extra space to store the pointer.
 * Singly linked lists are hard to traverse backwards, 
 * doubly linked use extra space for the extra pointer.
 * Types:
 * Singly linked, each node only points to the next one
 * Doubly linked, each node points to the one in front of and behind itself
 * Circular Linked, each node points to the next but the last points to the first
 */
public class LinkedList 
{

	Node head;
	int listCount;
	
	LinkedList()
	{
		head = null;
		listCount = 0;
	}
	
	void insertAtEnd(int data)
	{
		Node end = new Node(data);
		Node n = head;
		while (n.next != null)
		{
			n = n.next;
		}
		n.next = end;
		listCount++;
	}
	
	void insertAt(int index,int data)
	{
		Node newNode = new Node(data);
		Node n = head;
		for (int i = 0; i < index && n != null; i++)
		{
			n = n.next;
		}
		newNode.next = n.next;
		n.next = newNode;
		listCount++;
	}
	
	public int getData(int index)
	{
		if (index <= 0)
			return 0;
		Node n = head.next;
		for (int i =0; i < index; i++)
		{
			if (n.next == null)
				return 0;
			n = n.next;
		}
		return n.intData;
	}
	
	boolean deleteNode(int index)
	{
		if (index < 1||index > listCount)
			return false;
		Node n = head;
		for (int i = 0; i < index; i++)
		{
			if (n.next == null)
				return false;
			n = n.next;
		}
		n.next = n.next.next;
		listCount--;
		return true;
	}
	
	
	public class Node
	{
		//this can be any type of data
		int intData;
		Node next = null;
		
		public Node(int data)
		{
			intData = data;
		}
		
	}
	
}
