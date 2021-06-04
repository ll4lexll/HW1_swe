public class Player {
    private String name;
    private Deck draw_deck;
    private Deck win_deck;

    public Player(String name) {  //building a new player with empty decks
        this.draw_deck = new Deck(false);
        this.win_deck = new Deck(false);
    }

    public String get_name(){
        return this.name;
    }
//    public Deck getDraw_deck(){
//        return this.draw_deck;
//    }
//    public Deck getwin_deck(){
//        return this.win_deck;
//    }

    public void setName(String name) { //set player name
        this.name = name;
    } // Chenges were made here

    public String toString() {
        return this.name;
    } //returns the name of the player

    public boolean outOfCards() { //check if the player has no cards
        if (this.draw_deck.isEmpty() && this.win_deck.isEmpty())
            return true;
        return false; // Chenges were made here
    }

    public Card drawCard(){ //remove the top card from the draw deck and returns it
        if(this.draw_deck.isEmpty()){
            Deck winDeck = this.win_deck;
            winDeck.shuffle();
            while (!winDeck.isEmpty())
                this.toDraw(winDeck.removeTopCard());
        }
        return this.draw_deck.removeTopCard();// Chenges were made here
    }

    public void toDraw(Card card){ //adds a card to the draw deck
      draw_deck.addCard(card);
    }
    public void toWin(Card card){  // adds a card to the win deck
        win_deck.addCard(card);
    }



}