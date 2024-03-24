package main.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B_ThreeSum {
    public static void main(String[] args) {
        // the problem statement is to find the list of triplets that sums up to zero from an array
        // for array [-1,0,1,2,-1,-4], the output should be [[-1,-1,2],[-1,0,1]]
        // also it should not contain duplicate triplets
        int[] array = {-1,0,1,2,-1,-4};
        System.out.println(findTriplets(array));
    }

    private static List<List<Integer>> findTriplets(int[] array) {
        Set<List<Integer>> result = new HashSet<>();
        // let's sort the array first, so that we can use two pointer approach instead of caching approach
        // hashmap based caching approach introduces O(n) extra space, and two pointer eliminates it.
        Arrays.sort(array);
        // consider i traverse from first element to last but second element - because it is 3 numbers sum
        for (int i = 0; i < array.length - 2; i ++) {
            findTwoSum(i, array, result);
        }
        return new ArrayList<>(result);
    }

    private static void findTwoSum(int i, int[] array, Set<List<Integer>> result) {
        int left = i + 1;
        int right = array.length - 1;

        while (left < right) {
            int sum = array[i] + array[left] + array[right];
            if (sum == 0) {
                // adding into set to avoid duplicates
                result.add(List.of(array[i], array[left], array[right]));
                left ++;
                right --;
            }
            else if (sum < 0) {
                left ++;
            }
            else {
                right --;
            }
        }
    }
}
