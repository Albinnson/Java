public class TEST
{
   public static void main(String [] args)
   {
      ListInterface list1 = new ListReferenceBased();
      list1.add(1, new Integer(1));
      list1.add(2, new Integer(2));
      list1.add(3, new Integer(3));
      System.out.println(list1.get(1));
   }
}
