package atm;
import java.util.Random;
import java.util.Scanner;

public class ATMMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Typing Speed Test!");
        System.out.println("Type the following text:");

        String targetText = generateRandomText();
        System.out.println(targetText);

        System.out.print("Start typing (press Enter when finished): ");
        scanner.nextLine(); // Wait for user to start

        long startTime = System.currentTimeMillis();

        String typedText = scanner.nextLine();
        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
        int correctCharacters = countCorrectCharacters(targetText, typedText);
        int totalCharacters = targetText.length();
        int typingSpeed = calculateTypingSpeed(totalCharacters, elapsedTime);
        double accuracy = calculateAccuracy(correctCharacters, totalCharacters);

        System.out.println("Typing Speed: " + typingSpeed + " characters per minute");
        System.out.println("Accuracy: " + accuracy + "%");

        scanner.close();
    }

    private static String generateRandomText() {
        String[] words = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon"};
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            int randomIndex = (int) (Math.random() * words.length);
            builder.append(words[randomIndex]).append(" ");
        }

        return builder.toString();
    }

    private static int countCorrectCharacters(String target, String typed) {
        int correct = 0;
        int minLength = Math.min(target.length(), typed.length());

        for (int i = 0; i < minLength; i++) {
            if (target.charAt(i) == typed.charAt(i)) {
                correct++;
            }
        }

        return correct;
    }

    private static int calculateTypingSpeed(int totalCharacters, long elapsedTime) {
        double minutes = elapsedTime / 60000.0; // Convert milliseconds to minutes
        return (int) (totalCharacters / minutes);
    }

    private static double calculateAccuracy(int correctCharacters, int totalCharacters) {
        return ((double) correctCharacters / totalCharacters) * 100.0;
    }
}
