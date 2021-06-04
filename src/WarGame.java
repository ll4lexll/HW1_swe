public class WarGame {
    private Player player1;
    private Player player2;

    public WarGame(String name1, String name2){
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);
    }
    public Player get_player1(){
        return this.player1;
    }
    public Player get_player2(){
        return this.player2;
    }

    public void initializeGame(){
        Deck init_deck = new Deck(true);
        init_deck.shuffle();
        int order = this.player1.get_name().compareTo(
                this.player2.get_name()
        );
        switch (order){ // even number of cards at the beginning
            case 1:{ // player 2 is first
                while (!init_deck.isEmpty()){
                    this.player2.toDraw(init_deck.removeTopCard());
                    this.player1.toDraw(init_deck.removeTopCard());
                }
            }
            break;
            default:{
                while (!init_deck.isEmpty()){
                    this.player1.toDraw(init_deck.removeTopCard());
                    this.player2.toDraw(init_deck.removeTopCard());
                }
            }
            break;
        }

    }
    public String start(){
        Deck temp_deck = new Deck(false);
        int war_counter = 0;
        while (!this.player1.outOfCards() && !this.player2.outOfCards()){
            Card p1_card = this.player1.drawCard();
            Card p2_card = this.player2.drawCard();
            if(war_counter > 0){
                temp_deck.addCard(p1_card);
                temp_deck.addCard(p2_card);
                war_counter+=1;
                continue;
            }
            if(war_counter == 3) {
                switch (p1_card.compare(p2_card)){
                    case 1:{
                        while (!temp_deck.isEmpty())
                            this.player1.toWin(temp_deck.removeTopCard());
                        this.player1.toWin(p1_card);
                        this.player1.toWin(p2_card);
                        war_counter = 0;
                        continue;
                    }
                    case -1:{
                        while (!temp_deck.isEmpty())
                            this.player2.toWin(temp_deck.removeTopCard());
                        this.player2.toWin(p1_card);
                        this.player2.toWin(p2_card);
                        war_counter = 0;
                        continue;
                    }
                    case 0:{
                        temp_deck.addCard(p1_card);
                        temp_deck.addCard(p2_card);
                        war_counter = 1;
                        continue;
                    }
                }
            }

            switch (p1_card.compare(p2_card)){
                case 1:{
                    this.player1.toWin(p1_card);
                    this.player1.toWin(p2_card);
                }
                break;
                case -1:{
                    this.player2.toWin(p1_card);
                    this.player2.toWin(p2_card);
                }
                break;
                case 0:{
                    temp_deck.addCard(p1_card);
                    temp_deck.addCard(p2_card);
                    war_counter = 1;
                }
            }

            if (p1_card.compare(p2_card) == 1) {
                this.player1.toWin(p1_card);
                this.player1.toWin(p2_card);
            }

        }
        if(this.player1.outOfCards()){
            return this.player1.get_name();
        }
        else {
            return this.player2.get_name();
        }
    }
}
