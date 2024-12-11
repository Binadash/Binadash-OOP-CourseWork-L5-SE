import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main{
    public  static void main (String[]args) {
        Scanner scanner = new Scanner (System.in);

        try {
            Logger.system("Welcome to the Ticketing System !");


        }
    }
    private static int getPositiveInt (Scanner scanner, String prompt, String label) {
        int value;
        while (true) {
            Logger.system(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                Logger.userInput(label + value);
                if (value > 0) {
                    break;
                } else {
                    Logger.system ("Please Enter a Positive Number : ");
                }
            } catch (NumberFormatException e) {
                Logger.system ("Invalid Integer. Please Enter A Positive Number : ")
            }
        }
    }
}