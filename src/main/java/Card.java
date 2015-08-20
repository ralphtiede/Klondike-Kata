/**
 * Created by rtiede on 20.08.2015.
 */
public class Card {
    private final Value value;
    private final Color color;

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", color=" + color +
                '}';
    }

    public Card(Value value, Color color) {
        this.value = value;
        this.color = color;
    }

    public Value getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public boolean isBlack() {
        return this.color == Color.CLUBS || this.color == Color.SPADES;
    }

}
