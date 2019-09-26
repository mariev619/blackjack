import java.util.Scanner;

class Play {

    public static void main(String[] args) {
        System.out.println("BIENVENUE AU BLACKJACK DE MICHEL\n");
        menu();
    }

    public static void menu() {
        System.out.println("Voulez-vous jouer ou quitter ?");
        Scanner choice = new Scanner(System.in);
        String choicePlay = choice.next();
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
        //Partie joueur
        int card = takeCardPlayer(choice);
        int score = 0;
        score = score + card;
        System.out.println("Votre première carte est un " + card);
        int card2 = takeCardPlayer(choice);
        score = score + card2;
        System.out.println("Votre deuxième carte est un " + card2 + " et votre score est de " + score);
        //Partie dealer
        int scoreDealer = 0;
        int cardDealer = takeCard();
        scoreDealer = scoreDealer + cardDealer;
        System.out.println("La première carte de Michel est un " + cardDealer + " et son score est de " + scoreDealer + ". Sa deuxième carte est cachée.");
        //Boucle
        boolean continuer = true;
        while ((continuer) && (score < 21)) {
            System.out.println("Voulez-vous continuer ?");
            String choicePlayer = choice.next();
            if (choicePlayer.equals("oui")) {
                card = takeCardPlayer(choice);
                score = score + card;
                System.out.println("Votre nouvelle carte est " + card + " et votre score est de " + score);
            } else if (choicePlayer.equals("non")) {
                continuer = false;
                System.out.println("Au tour de Michel :");
            } else {
                System.out.println("Valeur incorrecte. Veuillez réessayer");
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
        System.out.println("La deuxième carte de Michel est révélée, sa carte est un " + card2Dealer + ". Son score est donc de " + scoreDealer);
        while (scoreDealer <= 16) {
            int newCardDealer = takeCard();
            scoreDealer = scoreDealer + newCardDealer;
            System.out.println("La nouvelle carte de Michel est un " + newCardDealer + " et son score est de " + scoreDealer);
            if (newCardDealer == 1) {
                if (((scoreDealer + 11) >= 17) && ((scoreDealer + 11) <= 21)) {
                    scoreDealer = scoreDealer + 11;
                    System.out.println("L'As de Michel vaut 11, son score est donc de " + scoreDealer);
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


    public static int takeCardPlayer(Scanner choice) {
        int min = 1;
        int max = 10;
        int card = (int) (Math.random() * ((max - min) + 1)) + min;
        if (card == 1) {
            card = choiceAce(choice);
        }
        return card;
    }

    public static int takeCard() {
        int min = 1;
        int max = 10;
        int card = (int) (Math.random() * ((max - min) + 1)) + min;
        return card;
    }

    public static int choiceAce(Scanner choice) {
        System.out.println("Une de vos cartes est un As, vaut-elle 1 ou 11 ?");
        int choiceAce = choice.nextInt();
        if (choiceAce == 1) {
            return 1;
        }
        if (choiceAce == 11) {
            return 11;
        }
        System.out.println("Valeur incorrecte. Veuillez réessayer");
        return choiceAce(choice);
    }
}