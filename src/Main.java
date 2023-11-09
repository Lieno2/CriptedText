import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        char[] text1 = new char[]{'d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c'};
        System.out.print("1. Cripta un messaggio. \n2. Risolvi un messaggio.\n");
        int scelta = scanner.nextInt();
        if (scelta == 1) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.print("Inserisci un testo da criptare. \n");
            char[] text = scanner1.nextLine().toLowerCase().toCharArray();
            int i = 0;
            for (char c : text) {
                if (c == 32) {
                    text[i++] = c;
                    continue;
                }
                text[i++] = text1[c - 97];
            }
            System.out.print("Testo Chiaro: \ta\tb\tc\td\te\tf\tg\th\ti\tj\tk\tl\tm\tn\to\tp\tq\tr\ts\tt\tu\tv\tw\tx\ty\tz \n");
            System.out.print("Testo Cifrato: \tD\tE\tF\tG\tH\tI\tJ\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ\tA\tB\tC \n");
            System.out.print("il tuo messaggio:\t" + String.valueOf(text));
            System.exit(0);
        }
        if (scelta == 2) {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Inserisci un testo da risolvere.");
            char[] text = scanner2.nextLine().toCharArray();
            int i = 0;
            for (char c : text) {
                if (c == 32) {
                    text[i++] = c;
                    continue;
                }
                text[i++] = (char) (c<100?(c+23): (c-3));
            }
            System.out.print("il tuo messaggio:\t"+String.valueOf(text));
            System.exit(0);
        }
        System.out.print("inserire un numero tra 1 e 2!");
        Thread.sleep(2000);
        System.exit(0);
    }
}
