// Zian Chen, Period 3
// November 30, 2017
// Card - creates Cards with both values and suit and can compare two cards

public class Card {
	private String suit;
	private int value;

	// precondition: none.
	// postcondition: creates a Card
	public Card(int value, String suit) {
		this.suit = suit;
		this.value = value;
	}

	// precondition: none.
	// postcondition: returns the suit.
	public String getSuit() {
		return suit;
	}

	// precondition: none.
	// postcondition: returns the value.
	public int getValue() {
		return value;
	}

	// precondition: none.
	// postcondition: prints out card identity.
	public String toString() {
		String number = getName();
		return number + " of " + suit;
	}
	
	// precondition: none.
	// postcondition: converts the value to a String
	public String getName() {
		if (value == 2) {
			return "two";
		}
		else if (value == 3) {
			return "three";
		}
		else if (value == 4) {
			return "four";
		}
		else if (value == 5) {
			return "five";
		}
		else if (value == 6) {
			return "six";
		}
		else if (value == 7) {
			return "seven";
		}
		else if (value == 8) {
			return "eight";
		}
		else if (value == 9) {
			return "nine";
		}
		else if (value == 10) {
			return "ten";
		}
		else if (value == 11) {
			return "jack";
		}
		else if (value == 12) {
			return "queen";
		}
		else if (value == 13) {
			return "king";
		}
		else if (value == 14) {
			return "ace";
		}
		else {
			return "ok";
		}
	}

	// precondition: none.
	// postcondition: compares two cards to each other and returns different results depending on <, >, or =
	public int compareTo(Card other) {
		if (this.value > other.value) {
			return 1;
		}
		else if (this.value < other.value) {
			return -1;
		}
		else {
			return 0;
		}
	}

	// precondition: none.
	// postcondition: returns true if cards are the same, false otherwise
	public boolean equals(Card other) {
		if (this.suit == other.suit && this.value == other.value) {
			return true;
		}
		else {
			return false;
		}
	}
}

/*
nine of hearts
nine of hearts
king of spades

The comparison is: 0
The comparison is: -1

nine of hearts and nine of hearts are equal
nine of hearts and king of spades are not equal
*/