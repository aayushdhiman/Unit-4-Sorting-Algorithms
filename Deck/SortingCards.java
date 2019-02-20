//package Deck;

import java.util.*;

public class SortingCards {
    /**
     * Creates a hand of <code>numCards</code> cards
     * @param deck the deck to create the hand from
     * @param numCards the number of cards to create in each hand
     * @return the hand of cards
     */
    public ArrayList<Card> createHand(Deck deck, int numCards) {
        ArrayList<Card> deckList = new ArrayList<Card>();
        for (int i = 0; i < numCards; i++) {
            deckList.add(deck.deal());
        }

        return deckList;
    }
    
    /**
     * Sorts the cards in the given <code>hand</code>
     * @param hand the hand of <code>Card</code>s to sort
     * @return the sorted hand
     */
    public ArrayList<Card> sortCards(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size() - 1; i++) {
            int minCard = i;
            for (int j = i + 1; j < hand.size(); j++)
                if (hand.get(j).getFaceValue() < hand.get(minCard).getFaceValue()) {
                    minCard = j;
                }
        
            Card temp = hand.get(minCard);
            hand.set(minCard, hand.get(i));
            hand.set(i, temp);
        }
        return hand;
    }
    
    /**
     * Prints out the hand
     *
     * @param hand the hand of cards to print
     */
    public void printHand(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size(); i++) {
            System.out.print(hand.get(i) + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many cards do you want to deal?: ");
        int numOfCards = sc.nextInt();

        SortingCards sortingCard = new SortingCards();

        Deck deck = new Deck();
        ArrayList<Card> hand = sortingCard.createHand(deck, numOfCards);

        System.out.println("Not Sorted Hand: ");
        sortingCard.printHand(hand);

        ArrayList<Card> sorted = sortingCard.sortCards(hand);

        System.out.println("\nSorted Hand: ");
        sortingCard.printHand(hand);

    }
}
