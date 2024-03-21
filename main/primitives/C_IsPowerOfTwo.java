package main.primitives;

public class C_IsPowerOfTwo {
    public static void main(String[] args) {
        // find whether the given number is power of two or not
        // 4 - true, 65 - false, 128 - true etc.
        int num = 512;
        System.out.println(isPowerOfTwo(num));
    }

    private static boolean isPowerOfTwo(int number) {
        if (number < 0) {
            return false;
        }
        // for all squares of two the binary only contains one 1
        // 000001
        // 000010
        // 000100
        // 001000
        // 010000 etc.
        // the simpler way is to do & operation with its negation
        // 010000   - Original value = 16
        // 001111   - One less than original value = 15
        // ------- & operation
        // 000000
        // if we have any value other than 0, then it is not a power of two
        return (number & (number - 1)) == 0;
    }
}
