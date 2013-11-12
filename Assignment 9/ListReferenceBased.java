/*
Griffin Jones
CS 110 - Intermediate Programming with Java
Assignment 9: Reference-Based Linked List
*/

public class ListReferenceBased implements ListInterface
{
   private Node head;
   private Node curr;
   private Node prev;
   
   /** 
   Create an Empty List
   */
   public ListReferenceBased()
   {
      head = null;
   }
   
   /**
   return true if the value of the head is null.
   @return head == null
   */
   public boolean isEmpty()
   {
      if(head == null)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /** 
   return size of list (number of elements in the list)
   @return number of elements in list
   */ 
   public int size()
   {
      curr = head;
      int index = 0;
      while (curr != null)
      {
         curr = curr.getNext();
         index++;
      }
      return index;   
   }
   
  /** 
  add specified item at specified index, index is 1 based
  @param index, location to add item (1 based)
  @param item, data to be added to list 
  @throws ListIndexOutOfBoundsException if index <1 or list > size
  */
  public void add(int index, Object item) throws ListIndexOutOfBoundsException
  {
     if (index == 1)
     {
        Node newNode = new Node(item, null);
        newNode.setNext(head);
        head = newNode;
     }
     
     else
     {
        prev = head;
        int counter = 0;
        while(counter < index-2)
        {
           prev = prev.getNext();
           counter++;
        }
        Node newNode = new Node(item, null);
        newNode.setNext(prev.getNext());
        prev.setNext(newNode); 
     }
  }
  
  /**
  return item at specified index, index is 1 based
  @param index - location of requested item
  @return data of item at index specified
  @throws ListIndexOutOfBoundsException if index <1 or list > size
  */
  public Object get(int index) throws ListIndexOutOfBoundsException
  {
     prev = head;
     
     if (index == 1)
     {
        curr = prev.getNext();
        return curr.getItem();
     }
     else
     {
        int counter = 0;
        while(counter < index-2)
        {
           prev = prev.getNext();
           counter++;
        }
       
        return curr.getItem();
     }
  }
  
  /** 
  remove item at specified index, index is 1 based
  @param index - location of item to be removed
  @throws ListIndexOutOfBoundsException if index <1 or list > size
  */
  public void remove(int index) throws ListIndexOutOfBoundsException
  {
     
  }

  /** 
  remove all items from the list
  */ 
  public void removeAll()
  {
  
  }
}