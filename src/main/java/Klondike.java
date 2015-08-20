/**
 * Created by rtiede on 20.08.2015.
 */
public class Klondike {
    public static final int TABLEAUS = 7;

    CardStack tableau[] = new CardStack[TABLEAUS];
    CardStack stack;
    CardStack discard;
    CardStack foundations[] = new CardStack[Color.values().length];

    void setUp(int rndVal) {
        Deck deck = new Deck(rndVal);
        for (int i = 0; i < TABLEAUS; i++) {
            tableau[i] = new CardStack();
            for (int j = 0; j <= i; j++) {
                tableau[i].add(deck.pop());
            }
            tableau[i].setCardsInVisible(i);
        }
        stack = new CardStack();
        discard = new CardStack();
        while (!deck.isEmpty()) {
            stack.add(deck.pop());
        }
        for (int i = 0; i < Color.values().length ; i++) {
            foundations[i] = new CardStack();
        }
    }

    public boolean won() {
        int count = 0;
        for (CardStack foundation : foundations) {
            count += foundation.size();
        }
        return count == 52;
    }

    public void trace() {
        for (CardStack cardStack : tableau) {
            cardStack.trace("tableau");
        }
        for (CardStack foundation : foundations) {
            foundation.trace("foundation");
        }
        stack.trace("stack");
        discard.trace("discard");
    }

    public void play() {
        // to be implemented :-)
    }

}
