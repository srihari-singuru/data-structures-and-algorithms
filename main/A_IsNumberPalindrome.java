package main;

public class A_IsNumberPalindrome {
    public static void main(String[] args) {
        // Check if a given number is a Palindrome or not
        int num = 123321;
        System.out.println("Is Palindrome: "+isNumberPalindrome1(num)+" : Approach #1");
        System.out.println("Is Palindrome: "+isNumberPalindrome2(num)+" : Approach #2");
    }

    private static boolean isNumberPalindrome1(int number) {
        if (number < 0) {
            return false;   // return false if the number is negative
        }

        // Considering the tree structure, total nodes = log(number of levels) + 1
        int totalDigits = (int) Math.floor(Math.log10(number)) + 1;
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

    private static boolean isNumberPalindrome2(int number) {
        if (number < 0) {
            return false;   // return false if the number is negative
        }

        int result = 0;
        int initial = number;
        while (initial != 0) {
            result = result * 10;   // if it is 2, then make it 20 to add lsd
            int lsd = initial % 10;
            result = result + lsd;  // add lsd. 20 +  x
            initial = initial / 10; // remove the lsd for the initial
        }

        return result == number;
    }
}
