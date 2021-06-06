public class WarGame {
    private Player player1;
    private Player player2;

    public WarGame(String name1, String name2){
        int order = name1.compareTo(name2);
        switch (order){
            case 1:{
                this.player1 = new Player(name2);
                this.player2 = new Player(name1);
                return;
            }
            default:{
                this.player1 = new Player(name1);
                this.player2 = new Player(name2);
                break;
            }
        }
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);
    }

    public void initializeGame(){
        System.out.println("Initializing the game...");
        Deck init_deck = new Deck(true);
        init_deck.shuffle();

        while (!init_deck.isEmpty()){
            this.player1.toDraw(init_deck.removeTopCard());
            this.player2.toDraw(init_deck.removeTopCard());
        }

    }
    public String start(){
        this.initializeGame();
        Deck temp_deck = new Deck(false);
        int war_counter = 0;
        int round_counter = 0;
        while (!this.player1.outOfCards() && !this.player2.outOfCards()){
            round_counter += 1;
            if (war_counter > 0){
                if( war_counter < 3) {
                    Card p1_card = this.player1.drawCard();
                    System.out.println(player1.toString() + " drew a war card");
                    temp_deck.addCard(p1_card);
                    Card p2_card = this.player2.drawCard();
                    System.out.println(player2.toString() + " drew a war card");
                    temp_deck.addCard(p2_card);
                }

                if(war_counter == 3) {
                    Card p1_card = this.player1.drawCard();
                    System.out.println(player1.toString() + " drew " + p1_card.toString());
                    Card p2_card = this.player2.drawCard();
                    System.out.println(player2.toString() + " drew " + p2_card.toString());
                    switch (p1_card.compare(p2_card)){
                        case 1:{
                            while (!temp_deck.isEmpty())
                                this.player1.toWin(temp_deck.removeTopCard());
                            System.out.println(this.player1.toString()+" won the war");
                            war_counter = 0;
                            continue;
                        }
                        case -1:{
                            while (!temp_deck.isEmpty())
                                this.player2.toWin(temp_deck.removeTopCard());
                            System.out.println(this.player2.toString()+" won the war");
                            war_counter = 0;
                            continue;
                        }
                        case 0:{
                            System.out.println("Starting a war...");
                            temp_deck.addCard(p1_card);
                            temp_deck.addCard(p2_card);
                            war_counter = 1;
                            continue;
                        }
                    }
                }

                war_counter+=1;
                continue;
            }
            System.out.println("------------------------- Round number " + round_counter + " -------------------------");
            Card p1_card = this.player1.drawCard();
            System.out.println(player1.toString() + " drew " + p1_card.toString());
            Card p2_card = this.player2.drawCard();
            System.out.println(player2.toString() + " drew " + p2_card.toString());


            switch (p1_card.compare(p2_card)){
                case 1:{
                    System.out.println(this.player1.toString()+" won");
                    this.player1.toWin(p2_card);
                    this.player1.toWin(p1_card);
                }
                break;
                case -1:{
                    System.out.println(this.player2.toString()+" won");
                    this.player2.toWin(p1_card);
                    this.player2.toWin(p2_card);
                }
                break;
                case 0:{
                    System.out.println("Starting a war...");
                    temp_deck.addCard(p1_card);
                    temp_deck.addCard(p2_card);
                    war_counter = 1;
                }
            }

//            if (p1_card.compare(p2_card) == 1) {
//                this.player1.toWin(p1_card);
//                this.player1.toWin(p2_card);
//            }

        }
        if(this.player1.outOfCards()){
            return this.player1.toString();
        }
        else {
            return this.player2.toString();
        }
    }
}
