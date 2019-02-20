package Deck;

public class DeckTester {

    private static final int NUM_HANDS = 7;

    public static void main(String[] args) {

        Deck deck = new Deck();
        System.out.println(deck);

        System.out.println(deck.deal());
        System.out.println(deck.deal());
        System.out.println(deck.deal());

        System.out.println("Cards Dealt: " + deck.getNumCardsDealt());
        System.out.println("Cards Remaining: " + deck.getNumCardsRemaining());
        System.out.println("Deck is empty: " + deck.isEmpty());

        deck.shuffle();
        System.out.println(deck);

        System.out.println();
        System.out.println("Dealing the remaining cards...");

        while (!deck.isEmpty()) {
            System.out.println(deck.deal());
        }

        System.out.println("Cards Dealt: " + deck.getNumCardsDealt());
        System.out.println("Cards Remaining: " + deck.getNumCardsRemaining());
        System.out.println("Deck is empty: " + deck.isEmpty());

        System.out.println(deck.deal());
        System.out.println(deck.deal());

        deck = new Deck();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);

        System.out.println();
        System.out.println("Create Hand and Finding Pairs");

        for (int i = 0; i < NUM_HANDS; i++) {
            // Create a hand, print the hand, check for a pair
            Card[] hand = createHand(deck);
            printHand(hand);
            if (hasPair(hand)) {
                System.out.println("There is at least one pair.");
            } else {
                System.out.println("No pair.");
            }
        }


    }


    private static Card[] createHand(Deck deck) {
        Card[] newDeck = {deck.deal(), deck.deal(), deck.deal(), deck.deal(), deck.deal()};
        return newDeck;
    }

    private static boolean hasPair(Card[] hand) {
        for (int i = 0; i < hand.length; i++) {
            for (int j = 1; j < hand.length; j++) {
                if (hand[i].getFaceValue() == hand[j].getFaceValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printHand(Card[] hand) {
        for (int i = 0; i < hand.length; i++) {
            System.out.print(hand[i] + " ");
        }
        System.out.println();
    }

}