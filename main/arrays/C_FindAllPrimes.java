package main.arrays;

import java.util.ArrayList;
import java.util.List;

public class C_FindAllPrimes {
    public static void main(String[] args) {
        // the problem statement is to find all the prime numbers until N
        int number = 64;
        System.out.println(enumerateAllPrimes(number));

        // optimized approach using O(n) space and O(n*log(log(n))) time complexity
        System.out.println(enumerateAllPrimesOptimized(number));
    }

    private static List<Integer> enumerateAllPrimes(int number) {
        List<Integer> result = new ArrayList<>();
        if (number == 2) {
            return List.of(number);
        }
        for (int i = 2; i <= number; i ++) {    // 0 and 1 are not prime
            // boolean isPrime = isPrimeNumberBruteForce(i);
            boolean isPrime = isPrimeNumberBetter(i);
            if (isPrime) {
                result.add(i);
            }
        }
        return result;
    }

    // this is a brute force approach which takes O(n^2) time complexity
    private static boolean isPrimeNumberBruteForce(int i) {
        for (int j = 2; j <= i; j ++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    // this is a better approach which takes O(Math.sqrt(n)) time complexity
    private static boolean isPrimeNumberBetter(int i) {
        for (int j = 2; j * j <= i; j ++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    // let's store all the numbers upto N and by default mark them prime, and unmark then iteratively
    private static List<Integer> enumerateAllPrimesOptimized(int number) {
        // define an array of length N and mark everything as true (everything prime)
        boolean[] primeArray = new boolean[number];
        for (int i = 0; i < primeArray.length; i++) {
            primeArray[i] = true;
        }
        primeArray[0] = false;  // 0 is not prime
        primeArray[1] = false;  // 1 is not prime

        for (int i = 2; i < number; i++) {
            if (primeArray[i]) {    // of array contains true (by default we set it to true)
                // if the i is 2, then setting 4, 6, 8, 10 ... to false (they are not Prime)
                for (int j = i + i; j < number; j = j + i) {    // n/2 + n/3 + n/4 + n/5 ... -> log(log(n))
                    primeArray[j] = false;
                }
            }
        }

        // eventually iterate over array which has true only for prime numbers to prepare return type
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < primeArray.length; i++) {
            if (primeArray[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
