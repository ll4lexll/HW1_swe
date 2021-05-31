import java.util.*;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(boolean init){
        this.cards = new ArrayList<>();
        if (!init){
            return;
        }
        for (int i = 0; i<4; i++){
            for (int j = 1; j<=13; j++){
                switch(i) {
                    case 0:
                        this.cards.add(new Card(j, Shape.Spades));
                        break;
                    case 1:
                        this.cards.add(new Card(j, Shape.Diamonds));
                        break;
                    case 2:
                        this.cards.add(new Card(j, Shape.Clubs));
                        break;
                    case 3:
                        this.cards.add(new Card(j, Shape.Hearts));
                        break;
                }
            }
        }
    }

    public void addCard(Card card){
        this.cards.add(card);
    }
    public Card removeTopCard(){
        return this.cards.remove(this.cards.size() - 1);
    }
    public boolean isEmpty(){
            return this.cards.isEmpty();
    }
    public void shuffle(){
        Random rnd = Main.rnd;
        rnd = new Random();
        for (int i=0; i<50; i++){
            int index1 = 0;
            int index2 = 0;
            // we want index1 to be the first to pop from the deck
            while (index1 == index2){
                index1 = rnd.nextInt(this.cards.size());
                index2 = rnd.nextInt(this.cards.size());
            }
            Card temp1 = this.cards.get(index1);
            Card temp2 = this.cards.get(index2);
            this.cards.set(index2, temp1);
            this.cards.set(index1, temp2);
        }
    }


}
