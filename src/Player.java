public class Player {
    private String name;
    private Deck draw_deck;
    private Deck win_deck;

    public Player(String name){
    Deck draw_deck = new Deck();
    Deck win_deck = new Deck();
    this.draw_deck = draw_deck;
    this.win_deck = win_deck;
    }
    public String toString() {
        return this.name;
    }
    public boolean outOfCards(){
        if(this.draw_deck)
    }
}
