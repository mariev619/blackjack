import java.util.Scanner;
import java.util.Random;

class Play {
    
    public static int takeCard() {
        int min = 1;
        int max = 10;
        int card = (int) (Math.random() * ((max - min) + 1)) + min;
        return card;
    }
    
    public static void main (String[] args) {
        int card = takeCard();
        int score = 0;
        Scanner choice = new Scanner(System.in);
        Scanner as = new Scanner(System.in);

        //Partie joueur

        String messageScore =  "Votre score est: ";
        score = score + card;
        String messageCarte = "Votre carte est: ";
        String message = messageCarte + card + ", " + messageScore + score;
        System.out.println(message);
        int card2 = takeCard();
        score = score + card2;
        String message2 = messageCarte + card2 + ", " + messageScore + score;
        System.out.println(message2);

        //Partie dealer 

        int scoreDealer = 0;
        int cardDealer = takeCard();
        int card2Dealer = takeCard();
        scoreDealer = scoreDealer + cardDealer;
        String messageScoreDealer =  "Le score de Michel est: ";
        String messageCardDealer = "La carte de Michel est: ";
        String messageDealer = messageCardDealer + cardDealer + ", " + messageScoreDealer + scoreDealer;
        System.out.println(messageDealer);

        //Boucle
        boolean continuer = true;
        while ((continuer == true) && (score < 21)) {
            System.out.println("Voulez-vous continuer ?");
            String choicePlayer = choice.nextLine();
                if (choicePlayer.equals("oui")) {
                    card2 = takeCard();
                    score = score + card2;
                    message2 = messageCarte + card2 + ", " + messageScore + score;
                    System.out.println(message2);
                } else {
                    continuer = false;
                    System.out.println("Au tour de Michel");
                    }

            
                     
        }
        //Condition As
            if (card == 1) {
                System.out.println("Voulez-vous que votre As vale 1 ou 11?");
                String choiceAs = as.nextLine();
                if (choiceAs == "1") {
                    score = (score + 1) - 1;
                    message2 = messageCarte + card2 + ", " + messageScore + score;
                    System.out.println(message2);
                }
                if (choiceAs == "11") {
                    score = (score + 11) - 1;
                    message2 = messageCarte + card2 + ", " + messageScore + score;
                    System.out.println(message2);
                } 
            }
            if (card2 == 1) {
                System.out.println("Voulez-vous que votre As vale 1 ou 11?");
                String choiceAs = as.nextLine();
                if (choiceAs == "1") {
                    score = (score + 1) - 1;
                    message2 = messageCarte + card2 + ", " + messageScore + score;
                    System.out.println(message2);
                }
                if (choiceAs == "11") {
                    score = (score + 11) - 1;
                    message2 = messageCarte + card2 + ", " + messageScore + score;
                    System.out.println(message2);
                } 

            }
        if (score > 21) {
            System.out.println("Vous avez perdu !");
            System.exit(0);
        }
        if (score == 21) {
            continuer = false;
            System.out.println("Vous avez gagné !");
            System.exit(0);
        }
                    
        while (scoreDealer <= 16) {
            card2Dealer = takeCard();
            scoreDealer = scoreDealer + card2Dealer;
            String message2Dealer = messageCardDealer + card2Dealer + ", " + messageScoreDealer + scoreDealer;
            System.out.println(message2Dealer);
            
        }

        if ((score > scoreDealer) && (scoreDealer < 21) && (score < 21)) {
            System.out.println("Vous avez gagné !");
            System.exit(0);
        } else if ((score < scoreDealer) && (scoreDealer < 21) && (score < 21)) {
            System.out.println("Vous avez perdu !");
            System.exit(0);
            }
        
        if (scoreDealer > 21) {
            System.out.println("Vous avez gagné !");
            System.exit(0);
        }
        if (score == scoreDealer) {
            System.out.println("Ex-aequo !");
            System.exit(0);
        }
    }
}