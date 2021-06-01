public class Player {
    private String name;
    private Deck draw_deck;
    private Deck win_deck;

    public Player(String name) {
        this.draw_deck = new Deck(false);
        this.win_deck = new Deck(false);
    }

    public String setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public boolean outOfCards() { //check if the player has no cards
        if (this.draw_deck.isEmpty() && this.win_deck.isEmpty())
            return true;
    }

    public Card drawCard(){ //remove the top card from the draw deck and returns it
        this.draw_deck.removeTopCard();
    }

    public void addCard



}