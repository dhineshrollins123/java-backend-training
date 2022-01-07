package Factory;

public class Atm {
    public CardProvider swipe(String Bank){
        CardProvider card=CardFactory.getCard(Bank);
        card.swipe(250);
        return card;
    }
    public CoinProvider pay(String bank){
        CoinProvider coin=CoinFactory.getCoin("abc");
        coin.currentPrice();
        return coin;
    }
    public void usingAppFactory(){
        AppFactory factory=new AppFactory();
        CardFactory cardFactory=(CardFactory) factory.getFactory("card");
        CoinFactory coinFactory=(CoinFactory) factory.getFactory("coin");
    }
}
