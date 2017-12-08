/*
 * Still to do: 
 * 	- Max cards possible
 * 	- MULTIPLAYER :(((
 */
import java.util.*;

public class EightsDriver {
	public static void main(String args[]) {
		int startCards = 52;

		/* Each player receive 52 slots on their hand. */
		Player player1 = new Player(startCards);
		Player computer = new Player(startCards);

		/* Give first seven cards off the deck to player1. */
		Deck deck = new Deck(52);
		deck.shuffle();
		for (int i = 1; i <= 7; i++)
			player1.add(deck.deal());
		
		/* Give next seven cards to computer. */
		for (int i = 1; i <= 7; i++)
			computer.add(deck.deal());

		/* Play the game. */
		EightsGame game = new EightsGame();
		game.playGame(deck, player1, computer);  
	}
}


