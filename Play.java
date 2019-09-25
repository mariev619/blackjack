import java.util.Scanner;

class Play {

    public static void main(String[] args) {
        System.out.println("BIENVENUE AU BLACKJACK DE MICHEL\n");
        menu();
    }

    public static void menu() {
        System.out.println("Voulez-vous jouer ou quitter ?");
        Scanner choice = new Scanner(System.in);
        String choicePlay = choice.nextLine();
        if (choicePlay.equals("jouer")) {
            jouer(choice);
        }
        if (choicePlay.equals("quitter")) {
            System.exit(0);
        }
        System.out.println("Valeur incorrecte. Veuillez réessayer");
        menu();
    }

    public static void jouer(Scanner choice) {
        int card = takeCard();
        int score = 0;
        //Partie joueur
        score = score + card;
        System.out.println("Votre première carte est " + card + " et votre score est de " + score);
        int card2 = takeCard();
        score = score + card2;
        System.out.println("Votre deuxième carte est " + card2 + " et votre score est de " + score);
        if (card == 1) {
            int newValue = choiceAce(choice);
            score = (score + newValue) - 1;
            System.out.println("Votre nouveau score est de " + score);
        }
        if (card2 == 1) {
            int newValue = choiceAce(choice);
            score = (score + newValue) - 1;
            System.out.println("Votre nouveau score est de " + score);
        }
        //Partie dealer
        int scoreDealer = 0;
        int cardDealer = takeCard();
        scoreDealer = scoreDealer + cardDealer;
        System.out.println("La première carte de Michel est " + cardDealer + " et son score est de " + scoreDealer + ". Sa deuxième carte est cachée.");
        //Boucle
        boolean continuer = true;
        while ((continuer == true) && (score < 21)) {
            System.out.println("Voulez-vous continuer ?");
            String choicePlayer = choice.nextLine();
            if (choicePlayer.equals("oui")) {
                card2 = takeCard();
                score = score + card2;
                System.out.println("Votre nouvelle carte est " + card2 + " et votre score est de " + score);
            } else {
                continuer = false;
                System.out.println("Au tour de Michel :");
            }
        }
        if (score > 21) {
            System.out.println("Vous avez perdu !");
            menu();
        }
        if (score == 21) {
            System.out.println("Vous avez gagné !");
            menu();
        }

        int card2Dealer = takeCard();
        scoreDealer = scoreDealer + card2Dealer;
        System.out.println("La deuxième carte de Michel est révélée, sa carte est " + card2Dealer + ". Son score est donc de " + scoreDealer);
        while (scoreDealer <= 16) {
            int newCardDealer = takeCard();
            scoreDealer = scoreDealer + newCardDealer;
            System.out.println("La nouvelle carte de Michel est " + newCardDealer + " et son score est de " + scoreDealer);
            if (newCardDealer == 1) {
                if (((scoreDealer + 11) >= 17) && ((scoreDealer + 11) <= 21)) {
                    scoreDealer = scoreDealer + 11;
                } else {
                    scoreDealer = scoreDealer + 1;
                }
            }
        }

        if ((score > scoreDealer) && (scoreDealer < 21) && (score < 21)) {
            System.out.println("Vous avez gagné !");
            menu();
        } else if ((score < scoreDealer) && (scoreDealer < 21) && (score < 21)) {
            System.out.println("Vous avez perdu !");
            menu();
        }

        if (scoreDealer > 21) {
            System.out.println("Vous avez gagné !");
            menu();
        }
        if (scoreDealer == 21) {
            System.out.println("Vous avez perdu !");
            menu();
        }
        if (score == scoreDealer) {
            System.out.println("Ex-aequo !");
            menu();
        }
    }

    public static int takeCard() {
        int min = 1;
        int max = 10;
        int card = (int) (Math.random() * ((max - min) + 1)) + min;
        return card;
    }

    public static int choiceAce(Scanner choice) {
        System.out.println("Une de vos cartes est un As, voulez-vous qu'elle vale 1 ou 11 ?");
        int choiceAce = choice.nextInt();
        if (choiceAce == 1) {
            return 1;
        }
        if (choiceAce == 11) {
            return 11;
        }
        System.out.println("Valeur incorrecte. Veuillez réessayer");
        choiceAce(choice);
        return 0;
    }
}
