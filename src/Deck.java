import java.util.Arrays;

public class Deck {
    private String[] cards;
    private int type;
    private int[] numRepeats;
    private int rank;
    private int bidVal;

    public Deck(String[] c) {
        cards = c;
        numRepeats = new int[5];
        rank = 1;
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
        if (fiveOfKind()) {
            type = 6;
        } else if (fourofKind()) {
            type = 5;
        } else if (fullHouse()) {
            type = 4;
        } else if (threeofKind()) {
            type = 3;
        } else if (twoPair()) {
            type = 2;
        } else if (onePair()) {
            type = 1;
        } else {
            type = 0;
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
        if (inc == 4) {
            return true;
        } else {
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
        if (inc == 2) {
            return true;
        } else {
            return false;
        }
    }

    public int getType() {
        return type;
    }

    public void setRank(int r){
        rank = r;
    }
    public int getRank(){
        return rank;
    }
    public String[] getCards(){
        return cards;
    }

    public void setBidVal(int b){
        bidVal = b;
    }

    public int getBidVal(){
        return bidVal;
    }
    public String toString(){
        return Arrays.toString(cards);
    }
}





