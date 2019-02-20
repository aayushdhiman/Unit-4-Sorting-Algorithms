// Deck.java
// Mr. Poland
// 12.18.18

package Deck;

public class Card implements Comparable{
	public static final int CLUBS = 0, DIAMONDS = 1, HEARTS = 2, SPADES = 3;
	public static final int ACE = 1, JACK = 11, QUEEN = 12, KING = 13;


	private int faceValue;
	private int suit;

	/**
	 * Constructs a new card with a face and a suit
	 *
	 * @param face the face value of the card
	 * @param suit the suit value of the card
	 */
	public Card(int face, int suit) {
		this.faceValue = face;
		this.suit = suit;
	}

	/**
	 * Returns the face value of the suit as an integer
	 *
	 * @return card face value
	 */
	public int getFaceValue() {
		return faceValue;
	}

	/**
	 * Returns the suit of the card as an integer
	 *
	 * @return the card suit as an integer
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * Returns the suit of the card as an String
	 *
	 * @return the card suit as an String
	 */
	public String getSuitAsString() {
		if (suit == CLUBS) {
			return "Clubs";
		} else if (suit == DIAMONDS) {
			return "Diamonds";
		} else if (suit == HEARTS) {
			return "Hearts";
		} else {
			return "Spades";
		}
	}

	/**
	 * Prints the card as a String
	 *
	 * @return the card as a String
	 */
	public String toString() {
		String str = "";

		if (getFaceValue() == ACE) {
			str = "Ace";
		} else if (getFaceValue() == JACK) {
			str = "Jack";
		} else if (getFaceValue() == QUEEN) {
			str = "Queen";
		} else if (getFaceValue() == KING) {
			str = "King";
		} else {
			str += getFaceValue();
		}

		return str + " of " + getSuitAsString();
	}

	/**
	 * Determines if the <code>obj</code> is equal to a second <code>obj</code>
	 *
	 * @param obj the object to test for equality
	 * @return boolean true if equal, false if not equal
	 */
	public boolean equals(Object obj) {
		Card card = (Card) obj;

		return getSuitAsString().equals(card.getSuitAsString()) && faceValue == card.getFaceValue();
	}

	@Override
	public int compareTo(Object obj) {
		Card temp = (Card) obj;
		if (this.getFaceValue() < temp.getFaceValue()) {
			return -1;
		} else if (this.getFaceValue() > temp.getFaceValue()) {
			return 1;
		} else {
			return 0;
		}
	}
}