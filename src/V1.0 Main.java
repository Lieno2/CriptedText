import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("(1) Cripta (2) Decripta");
        final int intChoice = scanner.nextInt();
        scanner.nextLine();
        switch (intChoice) {
            case 1 -> {

                System.out.println("Inserisci il testo: ");
                final String testo = scanner.nextLine();

                System.out.println("Inserisci la chiave (numero intero): ");
                String inputChiave = scanner.nextLine();
                int chiave = 0;
                try {
                    chiave = Integer.parseInt(inputChiave);
                } catch (NumberFormatException e) {
                    System.out.println("Errore nell'input della chiave. Assicurati di inserire un numero intero.");
                    System.exit(1);
                }

                final StringBuilder newText = new StringBuilder();

                for (char c : testo.toCharArray()) {
                    if (Character.isLetter(c)) {
                        final int caso = Character.isUpperCase(c) ? 'A' : 'a';
                        c = (char) (((c - caso + chiave) % 26) + caso);
                    }
                    newText.append(c);
                }

                System.out.println("Il tuo testo criptato: " + newText);

                scanner.close();
            }
            case 2 -> {
                System.out.println("Inserisci il testo: ");
                final String testo = scanner.nextLine();

                System.out.println("Inserisci la chiave (numero intero): ");
                String inputChiave = scanner.nextLine();
                int chiave = 0;
                try {
                    chiave = Integer.parseInt(inputChiave);
                } catch (NumberFormatException e) {
                    System.out.println("Errore nell'input della chiave. Assicurati di inserire un numero intero.");
                    System.exit(1);
                }

                final StringBuilder newText = new StringBuilder();

                for (char c : testo.toCharArray()) {
                    if (Character.isLetter(c)) {
                        final int caso = Character.isUpperCase(c) ? 'A' : 'a';
                        c = (char) (((c - caso - chiave + 26) % 26) + caso);
                    }
                    newText.append(c);
                }

                System.out.println("Il tuo testo uncriptato: " + newText);

                scanner.close();
            }
        }

    }
}
