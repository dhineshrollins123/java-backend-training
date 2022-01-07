import Factory.Atm;
import Factory.CardProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AtmTests {
    @DisplayName("Testing For ATM")
    @Test
    void testAtmSwipe() {
        Atm atm = new Atm();
        CardProvider provider=atm.swipe("pqr");
        Assertions.assertEquals("pqr",provider.getBank());
    }
}
