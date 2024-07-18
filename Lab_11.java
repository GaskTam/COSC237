import java.util.Scanner;

public class Lab_11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            int number = getPositiveInteger(scanner, "Enter a positive integer: ");

            int base = getPositiveInteger(scanner, "Enter a positive integer for base: ");


            int sumIterative = sumOfDigitsIterative(number);
            int sumRecursive = sumOfDigitsRecursive(number);


            String binaryIterative = binaryRepresentationIterative(number);
            String binaryRecursive = binaryRepresentationRecursive(number);


            String baseIterative = baseRepresentationIterative(number, base);
            String baseRecursive = baseRepresentationRecursive(number, base);

    
            System.out.printf("Sum of digits for %d is %d (iterative solution)%n", number, sumIterative);
            System.out.printf("Sum of digits for %d is %d (recursive solution)%n", number, sumRecursive);

            System.out.printf("%d in binary code is %s (iterative solution)%n", number, binaryIterative);
            System.out.printf("%d in binary code is %s (recursive solution)%n", number, binaryRecursive);

            System.out.printf("%d in base %d is %s (iterative solution)%n", number, base, baseIterative);
            System.out.printf("%d in base %d is %s (recursive solution)%n", number, base, baseRecursive);

        
            System.out.print("Do you want to continue (y/Y): ");
            String continueInput = scanner.next().trim();
            if (!continueInput.equalsIgnoreCase("y")) {
                break;
            }
        }

        scanner.close();
    }


    private static int getPositiveInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next().trim();
            try {
                int number = Integer.parseInt(input);
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("INVALID! Should be positive! REENTER: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("WRONG TYPE! Not a positive integer! REENTER: ");
            }
        }
    }

    // Method to calculate sum of digits iteratively
    private static int sumOfDigitsIterative(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // Method to calculate sum of digits recursively
    private static int sumOfDigitsRecursive(int number) {
        if (number == 0) {
            return 0;
        }
        return number % 10 + sumOfDigitsRecursive(number / 10);
    }

 
    private static String binaryRepresentationIterative(int number) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.insert(0, number % 2);
            number /= 2;
        }
        return sb.toString();
    }


    private static String binaryRepresentationRecursive(int number) {
        if (number == 0) {
            return "";
        }
        return binaryRepresentationRecursive(number / 2) + number % 2;
    }


    private static String baseRepresentationIterative(int number, int base) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.insert(0, number % base);
            number /= base;
        }
        return sb.toString();
    }

    private static String baseRepresentationRecursive(int number, int base) {
        if (number == 0) {
            return "";
        }
        return baseRepresentationRecursive(number / base, base) + number % base;
    }
}
