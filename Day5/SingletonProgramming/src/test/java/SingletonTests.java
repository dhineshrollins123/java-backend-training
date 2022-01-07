import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class SingletonTests {
    @DisplayName("Check Car Instance")
    @Test
    void testCarSingleton(){
        var c1=Singleton.newInstance();
        var c2=Singleton.newInstance();
       Assertions.assertEquals(c1.hashCode(),c2.hashCode());

    }
}
