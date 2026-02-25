import java.util.Scanner;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String str);
}

// Simple Stack Strategy
class StackStrategy implements PalindromeStrategy {
    public boolean check(String str) {

        str = str.replaceAll("\\s+", "").toLowerCase();

        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

// Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String str) {
        return strategy.check(str);
    }
}

// Main Class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Simple Strategy Pattern Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Inject strategy
        PalindromeStrategy strategy = new StackStrategy();
        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.execute(input);

        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        sc.close();
    }
}