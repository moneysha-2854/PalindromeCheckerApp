import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<Character> deque = new LinkedList<>();

        System.out.println("=== Deque-Based Optimized Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String processed = input.replaceAll("\\s+", "").toLowerCase();

        // Insert characters into deque
        for (int i = 0; i < processed.length(); i++) {
            deque.addLast(processed.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}