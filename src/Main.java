import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String fileData = "";
        try {
            File f = new File("src/input");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData += line + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        String[] decks = fileData.split("\n");
        int five = 0;
        int four = 0;
        int fullH = 0;
        int three = 0;
        int twoPair = 0;
        int onePair = 0;
        int highCard = 0;
        int totalVal = 0;
        Deck[] allHands = new Deck[decks.length];
        int index = 0;
        for (String deck: decks){
            String[] cards = deck.split(",");
            String bidString = cards[4].substring(cards[4].length()-1);
            for (int i = cards[4].length()-2; !cards[4].substring(i, i+1).equals("|"); i--){
                bidString = cards[4].substring(i, i+1) + bidString;
            }
            int bidInt = Integer.parseInt(bidString);
            cards[4] = cards[4].substring(0, cards[4].lastIndexOf("|"));
            Deck d = new Deck(cards);
            d.setBidVal(bidInt);
            allHands[index] = d;
            d.findType();
            if (d.getType() == 6){
                five++;
            }
            else if (d.getType() == 5){
                four++;
            } else if (d.getType() == 4) {
                fullH++;
            } else if (d.getType() == 3) {
                three++;
            } else if (d.getType() == 2) {
                twoPair++;
            } else if (d.getType() == 1) {
                onePair++;
            } else {
                highCard++;
            }
            index++;
        }
        // pt. 2; rank deck
        for (int i = 0; i < allHands.length; i++){
            int rankInc = 1;
            for (int j = 0; j < allHands.length; j++){
                if (i != j && allHands[i].getType() > allHands[j].getType()){
                    rankInc++;
                } else if (i!=j && allHands[i].getType() == allHands[j].getType()) {
                    Boolean done = false;
                    String[] d = allHands[i].getCards();
                    String[] e = allHands[j].getCards();
                    for (int k = 0; !done && k<d.length; k++) {
                        if (!d[k].equals(e[k])) {
                            if (d[k].equals("Ace")) {
                                    rankInc++;
                                    done = true;
                            } else if (d[k].equals("King")) {
                                if (!e[k].equals("Ace")) {
                                    rankInc++;
                                    done = true;
                                }
                                else{
                                    done = true;
                                }
                            } else if (d[k].equals("Queen")) {
                                if (!e[k].equals("Ace") && !e[k].equals("King")){
                                    rankInc++;
                                    done = true;
                                }
                                else {
                                    done = true;
                                }
                            } else if (d[k].equals("Jack")) {
                                if (!e[k].equals("Ace") && !e[k].equals("King") && !e[k].equals("Queen")){
                                    rankInc++;
                                    done = true;
                                }
                                else {
                                    done = true;
                                }
                            }
                            else if (e[k].equals("Ace") || e[k].equals("King") || e[k].equals("Queen") || e[k].equals("Jack")){
                                done = true;
                            }
                            else if (!e[k].equals("Ace") && !e[k].equals("King") && !e[k].equals("Queen") && !e[k].equals("Jack")){
                                if (Integer.parseInt(d[k]) > Integer.parseInt(e[k])){
                                    rankInc++;
                                    done = true;
                                }
                                else if ((Integer.parseInt(d[k]) < Integer.parseInt(e[k]))){
                                    done = true;
                                }
                            }
                        }
                    }
                }
            }
            allHands[i].setRank(rankInc);
        }
        // pt 2; calc total bid
        for (Deck hand: allHands){
            totalVal += (hand.getBidVal() * hand.getRank());
        }

        System.out.println("Number of five of a kind hands: " + five + "\nNumber of full house hands: " + fullH + "\nNumber of four of a kind hands: " + four + "\nNumber of three of a kind hands: " + three + "\nNumber of two pair hands: " + twoPair + "\nNumber of one pair hands: " + onePair + "\nNumber of high card hands: " + highCard);
        System.out.println("Total Bid Value: " + totalVal);
    }

        }