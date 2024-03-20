package main;

public class A_IsNumberPalindrome {
    public static void main(String[] args) {
        // Check if a given number is a Palindrome or not
        int num = 123321;
        System.out.println("Is Palindrome: "+isNumberPalindrome(num));
    }

    private static boolean isNumberPalindrome(int number) {
        if (number < 0) {
            return false;   // return false if the number is negative
        }

        // Considering the tree structure, total nodes = log(number of levels) + 1
        int totalDigits = (int) Math.floor(Math.log10(number) + 1);
        // Prepare a masked number like 100000
        int maskedNumber = (int) Math.pow(10, totalDigits - 1.0);

        // traverse until half of the length
        for (int i = 0; i < (totalDigits / 2); i++) {
            int msd = number / maskedNumber;
            int lsd = number % 10;

            // compare most significant digit with the least significant digit
            if (msd != lsd) {
                return false;
            }

            number = number % maskedNumber; // remove msd
            number = number / 10;   // remove lsd
            maskedNumber = maskedNumber / 100;  // remove two zeros from masked number
        }

        return true;
    }
}
