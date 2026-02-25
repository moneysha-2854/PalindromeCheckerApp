import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    // Method 1: Loop Method
    public static boolean loopMethod(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Method 2: Stack Method
    public static boolean stackMethod(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Performance Comparison of Palindrome Algorithms ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String processed = input.replaceAll("\\s+", "").toLowerCase();

        // Measure Loop Method
        long start1 = System.nanoTime();
        boolean result1 = loopMethod(processed);
        long end1 = System.nanoTime();

        // Measure Stack Method
        long start2 = System.nanoTime();
        boolean result2 = stackMethod(processed);
        long end2 = System.nanoTime();

        System.out.println("\nLoop Method Result: " + result1);
        System.out.println("Loop Method Time: " + (end1 - start1) + " ns");

        System.out.println("\nStack Method Result: " + result2);
        System.out.println("Stack Method Time: " + (end2 - start2) + " ns");

        sc.close();
    }
}