package Factory;

public class Atm {
    public CardProvider swipe(String Bank){
        CardProvider card=CardFactory.getCard(Bank);
        card.swipe(250);
        return card;
    }
}
