package main.primitives;

public class D_IsPowerOfFour {
    public static void main(String[] args) {
        // find whether the given number is power of four or not
        // 4 - true, 64 - true, 32 - true etc.
        int num = 256;
        System.out.println(isPowerOfFour(num));
    }

    private static boolean isPowerOfFour(int number) {
        if (number < 0) {
            return false;
        }
        // let's check if is power of 2 or not
        if ((number & (number - 1)) != 0) {
            return false;
        }

        // validate the position of 1 - it should be in even position with odd index
        // perform the & operation with 01010101010101010101010101010101 - int value is 1431655765
        // once the value is obtained, verify the result and the initial value is same or not
        // the original value could be - 0010000
        // the value after & operation could be - 0000100
        // but these two are not same, hence comparison is needed
        return (number & 1431655765) == number;
    }
}
