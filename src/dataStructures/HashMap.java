package dataStructures;

/**
 * @author Cwomble
 * The HashMap, or HashTable is a a data structure used to implement 
 * an associative array. It utilizes a function called a hash to modify
 * a hashkey to place the object in the array. The function will always place 
 * the same element in the same position of the array except in the case 
 * of a collision. It is often used to store passwords.
 * Complexity: Search, insert, delete are all O(1) in the best case (no collisions) 
 * and O(n) in the worst case
 * Pros:
 * generally very fast to insert, search, or delete.
 * Cons:
 * as amount of data input increases, chances of collision increase. You should
 * know about how much data the table needs to store before creating it, the data is not sorted.
 * Types: 
 * many different ways to perform hashing, 
 * chaining, coalesced, cuckoo, hopscotch, robin hood, choice
 *
 */
public class HashMap 
{
    private final static int TABLE_SIZE = 128;

    HashEntry[] table;

    HashMap() 
    {
          table = new HashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }

    public int get(int key) 
    {
          int hash = (key % TABLE_SIZE);
          while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % TABLE_SIZE;
          if (table[hash] == null)
                return -1;
          else
                return table[hash].getValue();
    }

    public void put(int key, int value) 
    {
          int hash = (key % TABLE_SIZE);
          while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % TABLE_SIZE;
          table[hash] = new HashEntry(key, value);
    }
    
    public class HashEntry 
    {
        private int key;
        private int value;
   
        HashEntry(int key, int value) 
        {
              this.key = key;
              this.value = value;
        }     
   
        public int getKey() 
        {
              return key;
        }
   
        public int getValue() 
        {
              return value;
        }
  }
}