import java.util.Arrays;

public class Deck {
    private String[] cards;
    private String type;
    private int[] numRepeats;

    public Deck(String[] c) {
        cards = c;
        numRepeats = new int[5];
    }

    public void findType() {
        for (int i = 0; i < cards.length; i++) {
            int numMatches = 1;
            for (int j = 0; j < cards.length; j++) {
                if (cards[i].equals(cards[j]) && i != j) {
                    numMatches++;
                }
                numRepeats[i] = numMatches;
            }
        }
        if (fiveOfKind()){
            type = "Five of a kind";
        } else if (fourofKind()) {
            type = "Four of a kind";
        } else if (fullHouse()) {
            type = "Full house";
        } else if (threeofKind()) {
            type = "Three of a kind";
        } else if (twoPair()) {
            type = "Two pair";
        } else if (onePair()) {
            type = "One pair";
        }
        else {
            type = "High card";
        }
    }

    public Boolean fiveOfKind() {
        Boolean b = false;
        for (int repeat : numRepeats) {
            if (repeat == 5) {
                b = true;
            }
        }
        return b;
    }

    public Boolean fourofKind() {
        Boolean b = false;
        for (int repeat : numRepeats) {
            if (repeat == 4) {
                b = true;
            }
        }
        return b;
    }

    public Boolean fullHouse() {
        Boolean b = false;
        Boolean c = false;
        for (int i = 0; i < numRepeats.length; i++) {
            if (numRepeats[i] == 3) {
                b = true;
                for (int j = 0; j < numRepeats.length; j++) {
                    if (numRepeats[j] == 2 && i != j) {
                        c = true;
                    }
                }
            }
        }
        return b && c;
    }

    public Boolean threeofKind() {
        Boolean b = false;
        Boolean c = false;
        for (int i = 0; i < numRepeats.length; i++) {
            if (numRepeats[i] == 3) {
                b = true;
                for (int j = 0; j < numRepeats.length; j++) {
                    if (numRepeats[j] == 2 && i != j) {
                        c = true;
                    }
                }
            }
        }
        if (b && !c) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean twoPair() {
        int inc = 0;
        for (int i = 0; i < numRepeats.length; i++) {
            if (numRepeats[i] == 2) {
                inc++;
            }
        }
            if (inc == 4){
                return true;
            }
            else {
                return false;
            }
    }

    public Boolean onePair() {
        int inc = 0;
        for (int i = 0; i < numRepeats.length; i++) {
            if (numRepeats[i] == 2) {
                inc++;
            }
        }
        if (inc == 2){
            return true;
        }
        else {
            return false;
        }
    }

    public String getType(){
        return type;
    }

}


