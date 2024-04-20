package org.example;

import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int MAX_SIZE = 20;
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ширину матриці:");
        int width = scanner.nextInt();
        System.out.println("Введіть висоту матриці:");
        int height = scanner.nextInt();

        if (width > MAX_SIZE || height > MAX_SIZE) {
            System.out.println("Розмір матриці не може бути більше " + MAX_SIZE);
            return;
        }

        System.out.println("Виберіть тип створення матриці (1 - ручне введення, 2 - рандомне заповнення):");
        int choice = scanner.nextInt();

        int[][] matrix = new int[height][width];
        if (choice == 1) {
            fillMatrixManually(matrix, scanner);
        } else {
            fillMatrixRandomly(matrix);
        }

        printMatrix(matrix);
        System.out.println("Мінімальний елемент: " + findMin(matrix));
        System.out.println("Максимальний елемент: " + findMax(matrix));
        System.out.println("Середнє арифметичне: " + calculateAverage(matrix));
    }

    private static void fillMatrixManually(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Введіть елемент [" + i + "][" + j + "]:");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void fillMatrixRandomly(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }
        return (double) sum / count;
    }
}