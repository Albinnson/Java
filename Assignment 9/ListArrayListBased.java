import java.util.ArrayList;

// ****************************************************
// Array list-based implementation of ADT list.
// ****************************************************
public class ListArrayListBased implements ListInterface 
{

   private ArrayList<Object> list;

   /** Create empty list
   */
   
   public ListArrayListBased() 
   {
      list = new ArrayList<Object>();
   }   
   /** return true if the size of the list is 0
       @return size == 0
   */
   public boolean isEmpty() 
   {
      return list.size() == 0;
   }
   /** return size of list (number of elements in the list
       @return number of elements in list
   */ 
   public int size() 
   {
      return list.size();
   }
   /** return item at specified index, index is 1 based
      @param index - location of requested item
      @return data of item at index specified
      @throws ListIndexOutOfBoundsException if index <1 or list > size
   */

   public Object get(int index) 
                throws ListIndexOutOfBoundsException 
   {
      try 
      {
          Object dataItem = list.get(index-1);
          return dataItem;
      }
      catch (IndexOutOfBoundsException e)
      {
         throw new ListIndexOutOfBoundsException(
                "List index out of bounds on get");
      } 
   }
   
   /** add specified item at specified index, index is 1 based
      @param index, location to add item (1 based)
      @param item, data to be added to list 
      @throws ListIndexOutOfBoundsException if index <1 or list > size
   */
   public void add(int index, Object item)
                  throws ListIndexOutOfBoundsException {

      try
      {
         list.add(index-1,item);
      }
      catch(IndexOutOfBoundsException e)
      {   
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds on add");
      } 
   }  
  /** remove item at specified index, index is 1 based
      @param index - location of item to be removed
      @throws ListIndexOutOfBoundsException if index <1 or list > size
  */
   public void remove(int index) 
                     throws ListIndexOutOfBoundsException 
   {
       try
      {
         list.remove(index-1);
      }
      catch(IndexOutOfBoundsException e)
      {   
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds on remove");
      } 
   }
   /** remove all items from the list
   */
   public void removeAll() 
   {
      list = new ArrayList<Object>();
   } 

} 