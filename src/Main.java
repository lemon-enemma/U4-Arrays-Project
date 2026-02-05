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
        for (String deck: decks){
            String[] cards = deck.split(",");
            cards[4] = cards[4].substring(0, cards[4].lastIndexOf("|"));
            Deck d = new Deck(cards);
            d.findType();
            if (d.getType().equals("Five of a kind")){
                five++;
            }
            else if (d.getType().equals("Four of a kind")){
                four++;
            } else if (d.getType().equals("Full house")) {
                fullH++;
            } else if (d.getType().equals("Three of a kind")) {
                three++;
            } else if (d.getType().equals("Two pair")) {
                twoPair++;
            } else if (d.getType().equals("One pair")) {
                onePair++;
            } else {
                highCard++;
            }

        }
        System.out.println("Number of five of a kind hands: " + five + "\nNumber of full house hands: " + fullH + "\nNumber of four of a kind hands: " + four + "\nNumber of three of a kind hands: " + three + "\nNumber of two pair hands: " + twoPair + "\nNumber of one pair hands: " + onePair + "\nNumber of high card hands: " + highCard);
            }

        }