package org.example;

public class App {

    public static void main(String[] args) {

        int[][] matrix =    {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};

        printMatrix(matrix);

    }


    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length - 1; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print(matrix[i][matrix[i].length - 1]);
            System.out.println();
        }
    }

}
