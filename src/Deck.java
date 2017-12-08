// Zian Chen, Period 3
// November 30, 2017
// Deck - class that holds an array of Card values and can shuffle, deal, and split the deck

public class Deck {
	private int top;
	private int size;
	private Card[] cards;

	// precondition: none.
	// postcondition: creates a deck with 52 cards
	public Deck(int size) {
		/* Set the deck size to 52 in this case. */
		size = 52;
		this.size = size;
		top = 0;
		cards = new Card[size];

		/* Add values to each card. */
		addValues();
	}

	// precondition: none.
	// postcondition: adds values to each card.
	public void addValues() {
		int quarter = size / 4;
		/* Stuff values into spades cards. */
		int counter = 2;
		for (int i = 0; i < quarter; i++) {
			cards[i] = new Card(counter, "spades");
			counter++;
		}
		/* Add values into the hearts cards. */
		counter = 2;
		for (int i = quarter; i < 2 * quarter; i++) {
			cards[i] = new Card(counter, "hearts");
			counter++;
		}
		/* Put values into the clubs cards. */
		counter = 2;
		for (int i = 2 * quarter; i < 3 * quarter; i++) {
			cards[i] = new Card(counter, "clubs");
			counter++;
		}
		/* Generate values for the spades cards. */
		counter = 2;
		for (int i = 3 * quarter; i < 4 * quarter; i++) {
			cards[i] = new Card(counter, "diamonds");
			counter++;
		}
	}

	// precondition: none.
	// postcondition: prints out the entire deck
	public void print() {
		for (int i = 0; i < cards.length; i++) {
			System.out.println(cards[i]);
		}
	}

	// precondition: none.
	// postcondition: deals a card out 
	public Card deal() {
		Card newCard = cards[top];
		top++;
		return newCard;
	}

	// precondition: none.
	// postcondition: shuffles cards
	public void shuffle() {
		top = 0;
		for (int i = 0; i < size; i++) {
			int swap = (int)(Math.random() * 52);
			Card oldCard = cards[i];
			cards[i] = cards[swap];
			cards[swap] = oldCard;
		}
	}
}