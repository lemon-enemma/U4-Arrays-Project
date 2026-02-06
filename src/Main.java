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

        // hooray you now have an array (allHands) that has every Deck object in it

        System.out.println("Number of five of a kind hands: " + five + "\nNumber of full house hands: " + fullH + "\nNumber of four of a kind hands: " + four + "\nNumber of three of a kind hands: " + three + "\nNumber of two pair hands: " + twoPair + "\nNumber of one pair hands: " + onePair + "\nNumber of high card hands: " + highCard);
        System.out.println("Total Bid Value: " + totalVal);
    }

        }