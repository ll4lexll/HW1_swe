public class Player {
    private String name;
    private Deck draw_deck;
    private Deck win_deck;

    public Player(String name){
        this.draw_deck = new Deck(false);
        this.win_deck = new Deck(false);
    }
    public String toString() {
        return this.name;
    }
    public boolean outOfCards(){
        if(this.draw_deck)
    }
}
