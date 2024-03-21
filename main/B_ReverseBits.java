package main;

public class B_ReverseBits {
    public static void main(String[] args) {
        // reverse the bits - assume these are unsigned
        // Ex: 1101 -> 1011
        int num = 13;
        System.out.println(reverseBitsOfNum(num));
    }

    private static int reverseBitsOfNum(int number) {
        int result = 0;
        // use while loop if we want to ignore leading zeros -> 00101 becomes 101, but not 10100
        // loop from 0 to 32 if we want the whole thing to be reversed
        while (number != 0) {
            result = result << 1;
            if ((number & 1) == 1) {
                result = result | 1;
            }
            number = number >> 1;
        }
        return result;
    }
}
