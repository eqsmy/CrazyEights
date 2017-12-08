public class Player {
	private Card[] hand;
	private int numCards;
	private int handSize;
	private int highNum;

	// precondition: none.
	// postcondition: constructs a Player with a hand of cards
	public Player(int handSize) {
		highNum = 0;
		this.handSize = handSize;
		numCards = 0;
		/* Initialize your hand to null first. */
		hand = new Card[handSize];
		for(int i = 0; i < handSize; i++) {
			hand[i] = null;
		}
	}
	
	// precondition: none.
	// postcondition: returns the player's hand.
	public Card[] getHand() {
		return hand;
	}
	
	// precondition: none.
	// postcondition: returns the card at a specific location in hand.
	public Card getCard(int cardNumber) {
		return hand[cardNumber];
	}

	// precondition: none.
	// postcondition: prints out the hand of the player.
	public String toString() {
		String message = "";
		for(int i = 0; i < handSize; i++) {
			/* Only print out if the location has something in it. */
			if(hand[i] != null)
				message += "[" + (i + 1) + "] " + hand[i] + '\n';
		}
		return message;
	}

	// precondition: none.
	// postcondition: adds a card to the hand.
	public void add(Card newCard) {
		hand[numCards] = newCard;
		numCards++;
		highNum++;
	}
	
	public void subtract(int played) {
		hand[played] = hand[highNum - 1];
		hand[highNum - 1] = null;
		highNum--;
	}
}
