import java.util.ArrayList;
import java.util.List;

/**
 * Created by rtiede on 20.08.2015.
 */
public class CardStack {
    private List<Card> cards = new ArrayList<Card>();
    int nCardsInVisible = 0;

    public int getCardsInVisible() {
        return nCardsInVisible;
    }

    public void setCardsInVisible(int nCardsInVisible) {
        this.nCardsInVisible = nCardsInVisible;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public Card getLast() {
        return cards.size() > 0 ? cards.get(cards.size()-1) : null;
    }

    public Card removeLast() {
        if (nCardsInVisible > 0 && cards.size() == nCardsInVisible+1)
            nCardsInVisible--;
        return cards.isEmpty() ? null : cards.remove(cards.size() - 1);
    }

    // zero-based index from top of stack
    public Card cardFromStack(int n) {
        int index = cards.size()-1-n;
        if (index >= nCardsInVisible && index < cards.size())
            return cards.get(index);
        else
            return null;
    }

    public void trace(String name) {
        System.out.println(name + ": " + cards);
    }

    public void moveFrom(CardStack takeFrom, int n) {
        int index = takeFrom.cards.size()-n;
        for (int i = 0; i < n; i++) {
            cards.add(takeFrom.cards.remove(index));
        }
        takeFrom.ensureOneCardVisible();
    }

    private void ensureOneCardVisible() {
        if (nCardsInVisible >= cards.size())
            nCardsInVisible = cards.size() > 0 ? cards.size()-1 : 0;
    }
}
