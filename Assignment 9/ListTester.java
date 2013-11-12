import java.util.Random;
public class ListTester
{

	public static void main(String [] args)
	{
	   long time1,time2;
      ListInterface list1 = new ListArrayListBased();
      list1.add(1, new Integer(5));
      list1.add(1, new Integer(7));
      list1.add(3, new Integer(2));
      list1.add(2, new Integer(9));
      displayList(list1);
      


	}
   // Traverse list displaying data in teach item
	public static void displayList(ListInterface list)
	{
		for (int i = 1; i<=list.size();i++)
			System.out.println(list.get(i));

	
	
	}
}