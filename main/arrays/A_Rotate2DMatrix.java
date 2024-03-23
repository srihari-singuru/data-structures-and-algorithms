package main.arrays;

import java.util.Arrays;

public class A_Rotate2DMatrix {
    public static void main(String[] args) {
        // rotate 2D matrix clockwise
        // [1, 2, 3]
        // [4, 5, 6]
        // [7, 8, 9]
        // this becomes
        // [7, 4, 1]
        // [8, 5, 2]
        // [9, 6, 3]

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // the below way is to create a new result matrix, but what if we are supposed to use same matrix inline ?
        int[][] result = rotateMatrix(matrix);
        Arrays.stream(result)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println("=========");

        // the below uses an inline way of rotation
        int[][] newResult = rotateMatrixInline(matrix);
        Arrays.stream(newResult)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }

    private static int[][] rotateMatrix(int[][] matrix) {
        int[][] resultMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                resultMatrix[j][matrix[i].length - 1 - i] = matrix[i][j];
            }
        }
        return resultMatrix;
    }

    private static int[][] rotateMatrixInline(int[][] matrix) {
        int lastIndex = matrix.length - 1;
        for (int layer = 0; layer < (matrix.length / 2); layer++) {
            for (int j = layer; j < lastIndex - layer; j++) {
                int topLeft = matrix[layer][j];
                int bottomLeft = matrix[lastIndex - j][layer];
                int topRight = matrix[j][lastIndex - layer];
                int bottomRight = matrix[lastIndex - layer][lastIndex - j];

                // after finding the four corners, move them
                matrix[layer][j] = bottomLeft;
                matrix[lastIndex - j][layer] = bottomRight;
                matrix[j][lastIndex - layer] = topLeft;
                matrix[lastIndex - layer][lastIndex - j] = topRight;
            }
        }
        return matrix;
    }
}
