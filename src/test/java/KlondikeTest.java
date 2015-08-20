import org.junit.Test;

public class KlondikeTest {

    @Test
    public void testPlay() throws Exception {
        Klondike klondike = new Klondike();
        klondike.setUp(21);
        klondike.play();
        klondike.trace();
    }

    @Test
    public void TryToWin() throws Exception {
        Klondike klondike = new Klondike();
        int won = 0;
        for (int i = 0; i < 1000; i++) {
            klondike.setUp(i);
            klondike.play();
            if (klondike.won()) {
                won++;
                System.out.println(i);
            }
        }
        System.out.println("Total wins: " + won);
    }

}