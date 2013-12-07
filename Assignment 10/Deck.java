/*
Griffin Jones
CS 110
Assignment 10
Deck Class
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Deck
{  
   private ArrayList<Card> deck;
   
   /**
   This constructor creates an arrayList of a specified size.
   I've used it to create an empty deck object.
   @param size the size of the arraylist. */
   public Deck(int size)
   {
      deck = new ArrayList<Card>(size);
   }
   
   /**
   This Constructor creates a standard 52 Card deck */
   public Deck()
   { 
      deck = new ArrayList<Card>();
      // Fill the deck using nested for loops.
      int i; // indexing for suits
      int j; // indexing for ranks
      char[] st; //declares an array for the Suits
      st = new char[4]; //allocates space for four characters      
      st[0] = 'c';
      st[1] = 'd';
      st[2] = 'h';
      st[3] = 's';
      
      for(i=0; i<4; i++)
      {
         for(j=2; j<15; j++)
         {
            deck.add(new Card(j,st[i]));
         }
      } 
   }
   /**
   This constructor creates a new deck containing the elements of List of cards
   @param origDeck a list of cards to be copied*/
   public Deck(List<Card> origDeck)
   {
      deck = new ArrayList<Card>(origDeck);   
   }
   
   /**
   Shuffle Method:
   This method will shuffle a deck of 52 cards using the Fisher-Yates shuffling algorithm.
   */
   public void shuffle()
   {
      Random rand = new Random();
      int j;
      Card initialCard;
      Card randomCard;
      for(int i = 51; i > 0; i--)
      {
         j = rand.nextInt(i);
         initialCard = (Card) deck.get(i);
         randomCard = (Card) deck.get(j);
         
         deck.set(i, randomCard);
         deck.set(j, initialCard);
      }
   }
   
   /**
   Draw Method:
   This method uses the ArrayList methods size() and get() to retrieve the top card of a deck.
   It also uses remove() to take the card off of the player deck.
   @return the top card of the deck. */
   public Card draw()
   {
      System.out.println(deck.get(deck.size()-1));
      return(deck.remove(deck.size()-1));
   }   
   
   /**
   Get Cards Method:
   @return an ArrayList stored in a deck object */
   public ArrayList<Card> getCards()
   {
      return(deck);
   }
   
   /**
   Is Empty Method:
   @return true if the deck is empty, otherwise false.
   */
   public boolean isEmpty()
   {
      return(deck.isEmpty());
   }
   
   /**
   Add Method:
   @param index the position where to add the card.
   @param card the card to be added/
   */
   public void add(int index, Card card)
   {
      deck.add(index, card);
   }
   
   /**
   Clear Method:
   This method clears a deck of cards
   */
   public void clear()
   {
      deck.clear();
   }
   
   /**
   subList Method:
   @param fromIndex the starting point to copy from (inclusive)
   @param toIndex the ending point to copy to (exclusive)
   @return a deck containing the copied cards
   */
   public Deck subList(int fromIndex, int toIndex)
   {
      Deck temp = new Deck(deck.subList(fromIndex, toIndex));
      return(temp);
   }
} 