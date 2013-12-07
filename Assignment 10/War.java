/*
Griffin Jones
CS 110
Assignment 10
War Backend
*/
import java.util.ArrayList;

public class War
{
// Fields
   private Deck fullDeck; // The Deck of 52
   private Deck p1Deck; // Player 1's deck. Initially with 26 cards
   private Deck p2Deck; 
   private Deck temp = new Deck(0); // The pile of cards during a war
   private Card p1Card; // the currently drawn card for player 1
   private Card p2Card;
   private boolean winner; // true if there is a winner. Actually used to create a loop that exits upon an outofbounds error.
   private boolean war; // true if war is in progress
   
// Methods 
   /**
   War
   This initiates a game of war. */
   public void playWar()
   {
      try // Run the game until an out of bounds error occurs. In which case there is either a winner or a tie.
      { 
		   fullDeck	= new	Deck(); 
		   fullDeck.shuffle();
		   p1Deck =	fullDeck.subList(0,26);
		   p2Deck =	fullDeck.subList(26,52); // Create a deck of 52, Shuffle it and split it in half

         while(winner == false) // There are no winners in war.
		   {
			   System.out.print("player 1 draws ");
			   p1Card =	p1Deck.draw();
			   System.out.print("player 2 draws ");
			   p2Card =	p2Deck.draw();
			   
			   if(p1Card.compareTo(p2Card) >	0)
			   {
			   	winner(p1Deck,	p1Card, p2Card);
			   	System.out.println("player 1 wins");
			   }
			   
			   else if(p1Card.compareTo(p2Card)	< 0)
			   {
			   	winner(p2Deck,	p2Card, p1Card);
			   	System.out.println("player 2 wins");
			   }
			   
			   else
			   {
			   	henryRollins(); // This initiates the war process when the players draw the same cards.
			   }
		   }    
      }   
	   catch(ArrayIndexOutOfBoundsException e)
      {
         if(p1Deck.isEmpty() && p2Deck.isEmpty())
         {
            System.out.println("You're both losers.");
         }
         if( p1Deck.isEmpty())
         {
            System.out.println("Player Two Wins!");
         }
         else if(p2Deck.isEmpty())
         {
            System.out.println("Player One Wins!");
         }	  
      }
   }    
   /**
   winner method:
   This method executes when a card comparison results in a winner.
   It adds the drawn cards to the bottom of the winner's pile.
   @param winnerDeck the winner's deck
   @param winnerCard the winning card
   @param loserCard the losing card
   */   
   public void	winner(Deck winnerDeck,	Card winnerCard, Card loserCard)
	{
	   winnerDeck.add(0,winnerCard);	
      winnerDeck.add(0,loserCard); 
	}
         
   /**
   henryRollins method:
   As in the song "Let's Have a War" by Henry Rollins of FEAR
   This method initiates whenever there is a war.
   */
   public void	henryRollins()
	{				 
	   war =	true;
	   while(war == true)
		{
	     	temp.add(0,p1Card); 
		   temp.add(0,p2Card);
   	   p1Card =	p1Deck.draw();
   	   p2Card =	p2Deck.draw();
   	   temp.add(0,p1Card);
   	   temp.add(0,p2Card); // Place the two drawn cards into a new pile. Then place one more from each deck in the new pile.
	   	   
   	   System.out.print("\tplayer 1 draws ");
   	   p1Card =	p1Deck.draw();
   	   System.out.print("\tplayer 2 draws ");
   	   p2Card =	p2Deck.draw();			  
		   	   
   	   if(p1Card.compareTo(p2Card) >	0) // The war exits, player one wins
		   {
   	   	winner(p1Deck,	p1Card, p2Card); // Add the deciding cards to the winner's deck.
            while(!temp.isEmpty())
            {
               p1Deck.add(0, temp.draw()); // Add the cards in the pile to the winner's deck.
            }
		   	war =	false; // Exit the war loop
		     	temp.clear(); // clear the pile of war cards
	 	   	System.out.println("\tplayer 1 wins the war");
    	   }
		   	   
   	   else if(p1Card.compareTo(p2Card)	< 0) // The logic here is the same as above
   	   {
   	   	winner(p2Deck,	p2Card, p1Card);
            while(!temp.isEmpty())
            {
               p2Deck.add(0, temp.draw());
            }            
   	   	war =	false;
   	   	temp.clear();
   	   	System.out.println("\tplayer 2 wins the war");
   	   }
         else
         {
            henryRollins(); // This occurs during a multi-level war like double war. Note that the temp pile is not cleared.
         }
      }
   } 
}    