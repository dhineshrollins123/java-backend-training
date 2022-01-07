package Factory;

public class PqrCard implements CardProvider{
    @Override
    public void swipe(float amt) {

    }

    @Override
    public String getBank() {
        return "pqr";
    }
}
