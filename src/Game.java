import java.util.Scanner;

public class Game {
	// precondition: none.
	// postcondition: moves each player until either the stock pile is gone or one player has no more cards. */
	public void playGame(Deck deck, Player player1, Player computer) {
		boolean over = false;
		boolean yourTurn = true;
		Card cardPlayed = new Card(0, "");

		/* The first card displayed will be the top card dealt off the stock pile. */
		Card topCard = deck.deal();
		System.out.println("THE TOP CARD IS: " + topCard);

		/* Continue rotating players until the game is designated to be over. */
		while(!over) {
			if(yourTurn) {
				cardPlayed = makeMove(player1, deck, topCard);
				topCard = cardPlayed;
				yourTurn = false;
				System.out.println();
			}
			else {
				cardPlayed = computerChoose(computer, topCard);
				yourTurn = true;
				System.out.println();
			}
			System.out.println("THE TOP CARD IS: " + cardPlayed);
		}
	}

	// precondition: none.
	// postcondition: plays a valid card for the player.
	private Card makeMove(Player player1, Deck deck, Card topCard) {
		Scanner keys = new Scanner(System.in);
		boolean done = false;
		Card cardPlayed = new Card(0, "");
		while(!done) {
			/* Display the top card and ask for which card the player wants to put down. */
			System.out.println("YOUR HAND IS: " + '\n' + player1);
			System.out.println("WHICH CARD DO YOU WANT TO PLAY?" + '\n' + "ENTER 0 TO DRAW");
			int response = keys.nextInt();

			/* If they do not have any cards, draw cards from stock pile. */
			if(response == 0) {
				player1.add(deck.deal());
			}

			/* Otherwise, check the validity of the card chosen. */
			else {
				boolean canPlay = checkValidity(player1.getCard(response - 1), topCard);

				/* If the card is valid, then play that card by setting cardPlayed to valid card. */
				if(canPlay) {
					System.out.println("YOU PLAYED: " + player1.getCard(response - 1));
					done = true;
					cardPlayed = player1.getCard(response - 1);
					// REMOVE CARD FROM HAND ---------------------------------------------
				}

				/* Otherwise, return an error message. */
				else {
					System.out.println("YOU CANNOT PLAY THIS CARD. PICK NEW CARD. ");
				}
			}
		}
		return cardPlayed;
	}

	// precondition: none.
	// postcondition: return a true or false depending on whether or not the card matches suit or value.
	public static boolean checkValidity(Card card, Card topCard) {
		if(card.getValue() == topCard.getValue() || card.getSuit().equals(topCard.getSuit())) {
			return true;
		}
		else {
			return false;
		}
	}


	/* NOTE: STILL NEED TO LEAVE OUT AN EIGHT!!!!!!!!! ---------------------------------------- */

	// precondition: none.
	// postcondition: computer returns the "best" card move. 

	/* Note: this method will first determine which cards are playable in the 
	 * computer's hand. Playable cards can be played due to EITHER suit or number. 
	 * Among a selection of multiple suits or numbers, choosing a card with multiple
	 * suits is more advantageous than choosing a card with multiple numbers.
	 */
	public Card computerChoose(Player computer, Card topCard) {
		Card cardPlayed = new Card(0, "");
		Card[] hand = computer.getHand();

		/* New array that will hold the locations of playable cards in my hand,
		 * so that later, hand[player[i]] will be a playable card. Playable card
		 * locations will have 1 in the location of playableTracker.
		 */
		int[] playableTracker = new int[hand.length];

		/* Go through each card in the hand, only checking ones that have values. */
		for(int i = 0; i < hand.length; i++) {
			if(hand[i] != null) {

				/* If the numbers OR suit match, save the location in playableTracker
				 * by adding 1 to the spot in playableTracker. */
				if(hand[i].getValue() == topCard.getValue() || hand[i].getSuit() == topCard.getSuit()) {
					playableTracker[i]++;
				}
			}
		}

		/* We then need to confirm which suits are the most abundant in the hand.
		 * To do this, we use a new array which each spot corresponding to a suit.
		 * 0 - clubs
		 * 1 - spades
		 * 2 - hearts 
		 * 3 - diamonds
		 */
		int[] suitTracker = new int[4];
		for(int i = 0; i < hand.length; i++) {
			if(hand[i] != null) {
				if(hand[i].getSuit().equals("clubs")) {
					suitTracker[0]++;
				}
				else if(hand[i].getSuit().equals("spades")) {
					suitTracker[1]++;
				}
				else if(hand[i].getSuit().equals("hearts")) {
					suitTracker[2]++;
				}
				else if(hand[i].getSuit().equals("diamonds")) {
					suitTracker[3]++;
				}
			}
		}

		/* Save which suit appears the most. */
		String mostSuit = "";
		int greatest = 0;
		for(int i = 0; i < suitTracker.length; i++) {
			if(suitTracker[i] != 0 && suitTracker[i] > greatest) {
				mostSuit = hand[i].getSuit();
				greatest = suitTracker[i];
			}
		}

		/* Go through the playable cards and decide which one is best. */
		for(int i = 0; i < playableTracker.length; i++) {
			if(hand[i] != null) {
				if(playableTracker[i] == 1) {
					if(hand[i].getSuit().equals(mostSuit)) {
						cardPlayed = hand[i];
					}
				}
			}
		}
		System.out.println("COMPUTER PLAYED: " + cardPlayed);
		return cardPlayed;
	}
}
