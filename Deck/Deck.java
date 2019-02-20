//package Deck;

import java.util.*;

public class Deck {
    final int numOfCards = 52;
    private List<Card> deck = new ArrayList<Card>(52);

    /**
     * Creates a deck of standard playing cards.
     * There are 52 cards with 13 cards in 4 suits.
     */
    public Deck() {
        // fill deck with cards
        for(int i = 0; i < 52; i++){
            for(int j = 0; j < 13; j++){
                for(int k = 0; k < 4; k++){
                    deck.add(new Card(j, k));
//                    System.out.print(deck.get(i) + " ");
                }
            }
        }
    }

    /**
     * Deals one card from the deck.
     *
     * @return a <code>Card</code> from the deck, <code>null</code> if there are no cards in the deck.
     */
    public Card deal() {
        shuffle();
        if(deck.size() == 0){
            return null;
        }
        Card dealt = new Card(deck.get(0).getFaceValue(), deck.get(0).getSuit());
        deck.remove(0);
        return dealt;
    }


    /**
     * Shuffles the remaining cards in the deck by placing the cards in random order.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Returns true if the deck of cards has no cards remaining.
     *
     * @return true if the deck of cards has no cards remaining.
     */
    public boolean isEmpty() {
        if (deck.size() == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Returns the number of cards dealt from the deck.
     *
     * @return the number of cards dealt from the deck.
     */
    public int getNumCardsDealt() {
        return 52 - deck.size();
    }


    /**
     * Returns the number of cards remaining in the deck.
     *
     * @return the number of cards remaining in the deck.
     */
    public int getNumCardsRemaining() {
        return deck.size();
    }


    @Override
    /**
     * Prints the number of cards remaining in the deck and each card in the deck on the same line.
     */
    public String toString() {
        for(Card card : deck){
            System.out.print(card + " ");
        }
        return "";
    }


}
