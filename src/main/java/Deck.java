import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by rtiede on 20.08.2015.
 */
public class Deck {
    private List<Card> cards;

    public Deck(int rndVal) {
        cards = new ArrayList<Card>();
        for (Value value : Value.values()) {
            for (Color color : Color.values()) {
                cards.add(new Card(value,color));
            }

        }
        Random rnd = new Random(rndVal);
        Collections.shuffle(cards, rnd);
    }

    public Card pop() {
        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
