import java.util.ArrayList;

public class Card {
    private int value;
    private Shape s;


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

    public Card(int value, Shape s){
        this.setShape(s);
        this.setValue(value);
    }
    public int compare (Card other){
        if(this.getValue() < getValue(other)) return -1;
        if(this.getValue() == getValue(other)) return 0;
        if(this.getValue() > getValue(other)) return 1;
    }
    public String toString(){
        int value = this.getValue();
        

    }


}
