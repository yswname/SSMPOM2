package cn.com.demo.ssm.spring.po;

public class Person {
    private Card card = new Card();

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
