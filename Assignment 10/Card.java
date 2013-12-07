// Griffin Jones
// CS 110
// Assignment 10
// Card Class

public class Card implements Comparable<Card>
{
   private int rank;
   private char suit;
   
   // Default Constructor
   public Card()
   {
      rank = 0;
      suit = '\u0000';
   }
   
   /**
   Constructor
   @param rnk the rank of the card.
   @param sut the suit of the card.
   */
   public Card(int rnk, char sut)
   {
      if(sut == 'c' || sut == 'd' || sut == 'h' || sut == 's')
      {
         rank = rnk;
         suit = sut;
      }
      else
      {
         System.out.println("Invalid Input for suit on" + rank);
      }
   }
   
   /**
   Set Rank:
   @param r the rank
   */
   public void setRank(int r)
   {
      rank = r;
   }
   /**
   Set Suit:
   @param s the suit
   */
   public void setSuit(char s)
   {
      suit = s;
   }
   
   /**
   Get Rank
   @return the rank of the card object.
   */
   public int getRank()
   {
      return(rank);
   }
   
   /**
   Get Suit
   @return the suit of the card object.
   */
   public char getSuit()
   {
      return(suit);
   }
   
   /**
   toString Method:
   @return a string containing the rank and suit of the card
   */
   public String toString()
   {
      return("" + rank + " " + suit);
   }
   /**
   Compare To Method
   @param otherCard the card that the first card is being compared to
   @return a positive integer if the first card's rank is greater than the other card's,
    a negative integer if the first card's rank is less than the other cards or
    a zero if their ranks are equal.*/
   public int compareTo(Card otherCard)
   {
      if(this.rank > otherCard.rank)
      {
         return(1);
      }
      else if(this.rank < otherCard.rank)
      {
         return(-1);
      }
      else
      {
         return(0);
      }
   }
   
}