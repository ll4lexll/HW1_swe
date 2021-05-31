import java.util.ArrayList;

public class Card {
    private int value;
    private Shape s;

    public Card(int value, Shape s) {  //Card constructor
        this.setShape(s);
        this.setValue(value);
    }
    public int getValue(){
        return this.value;
    }
    public Void setValue(int value){
        this.value = value;
    }
    public Shape getShape() {
        return this.s;
    }
    public Void setShape(Shape s){
        this.s = s;
    }

    public int compare (Card other){ //Compares this Card to another
        if(this.getValue() < other.getValue()) return -1;
        if(this.getValue() == other.getValue()) return 0;
        if(this.getValue() > other.getValue()) return 1;
    }
    public String toString(){ //return the value and shape as a String
        String type = this.getShape().toString();
        switch (this.getValue()){
            case 1:  return ("Ace of " + type);
            case 11: return ("Jack of " + type);
            case 12: return ("Queen of " + type);
            case 13: return ("King of " + type);
        }
    return (this.getValue() + " of " + type);



    }


}
