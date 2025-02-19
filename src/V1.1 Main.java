import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] key = new char[10];


        System.out.println();

        System.out.print("Would you like to encrypt or decrypt? (e/d): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        switch (choice) {
            case "e": 
                System.out.print("Enter text to encrypt: ");
                String textToEncrypt = scanner.nextLine();


                Random rand = new Random();
                for (int i = 0; i < 10; i++) {
                    int randChoice = rand.nextInt(3);
                    if (randChoice == 0)
                        key[i] = (char) (rand.nextInt(26) + 65);
                    else if (randChoice == 1)
                        key[i] = (char) (rand.nextInt(26) + 97);
                    else
                        key[i] = (char) (rand.nextInt(10) + 48);
                }

                System.out.println("Key: ");

                for (char k : key) {
                    System.out.print(k);
                }

                String encryptedText = processText(textToEncrypt, key, true);
                System.out.println("Encrypted text: " + encryptedText);
                break;

            case "d":
                System.out.print("Enter text to decrypt: ");
                String textToDecrypt = scanner.nextLine();
                System.out.print("Enter the key: ");
                String keyInput = scanner.nextLine();


                if (keyInput.length() != 10) {
                    System.out.println("Invalid key. The key must be exactly 10 characters.");
                } else {
                    char[] userKey = keyInput.toCharArray();
                    String decryptedText = processText(textToDecrypt, userKey, false);
                    System.out.println("Decrypted text: " + decryptedText);
                }
                break;

            default:
                System.out.println("Invalid choice. Please select 'e' for encrypt or 'd' for decrypt.");
        }

        scanner.close();
    }


    public static String processText(String text, char[] key, boolean isEncrypt) {
        StringBuilder result = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (isEncrypt) {
                result.append((char) (c + key[counter % 10]));
            } else {
                result.append((char) (c - key[counter % 10]));
            }
            counter++;
        }

        return result.toString();
    }
}
