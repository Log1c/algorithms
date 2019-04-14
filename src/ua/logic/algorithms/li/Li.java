package ua.logic.algorithms.li;

import java.util.ArrayList;
import java.util.Arrays;

/**
 Algorithms Li(A*) without direction finish point
 */
public class Li {
    final static int SIZE = 10;
    final static int WALL = -1;
    final static ArrayList<Cell> open = new ArrayList<>();
    final static ArrayList<Cell> close = new ArrayList<>();

    public static void main(String[] args) {
        int square[][] = new int[SIZE][SIZE];
        fillSquare(square);
        printArray(square);
        System.out.println();
        li(square, 0, 0);
        printArray(square);
    }

    private static int[][] li(int[][] square, int i, int j) {
        open.add(new Cell(i , j));
        while (!open.isEmpty()) {
            Cell currentCell = open.get(0);
            open.remove(currentCell);
            close.add(currentCell);
            fillCell(square, currentCell);
        }

        return square;
    }

    private static void fillCell(int [][] square, Cell currentCell) {
        int i = currentCell.getX();
        int j = currentCell.getY();
        Cell testCell;

        testCell = new Cell(i+1, j);
        if (i+1 < square.length) {
            if (close.indexOf(testCell) == -1) {
                square[i+1][j] = square[i][j] + 1;
                if (open.indexOf(testCell) == -1) {
                    open.add(testCell);
                }
            }
        }

        testCell = new Cell(i-1, j);
        if (i-1 >= 0) {
            if (close.indexOf(testCell) == -1) {
                square[i-1][j] = square[i][j] + 1;
                if (open.indexOf(testCell) == -1) {
                    open.add(testCell);
                }
            }
        }

        testCell = new Cell(i, j+1);
        if (j+1 < square.length) {
            if (close.indexOf(testCell) == -1) {
                square[i][j+1] = square[i][j] + 1;
                if (open.indexOf(testCell) == -1) {
                    open.add(testCell);
                }
            }
        }

        testCell = new Cell(i, j-1);
        if (j-1 >= 0) {
            if (close.indexOf(testCell) == -1) {
                square[i][j-1] = square[i][j] + 1;
                if (open.indexOf(testCell) == -1) {
                    open.add(testCell);
                }
            }
        }

    }


    private static void fillSquare(int[][] square) {

        //Wall
        square[1][1] = WALL;
        square[0][1] = WALL;
        //square[0][1] = WALL;

        close.add(new Cell(1, 1));
        close.add(new Cell(0, 1));
        //close.add(new Cell(1, 0));
    }

    private static void printArray(int[][] square) {
        for (int i = 0; i < square.length; i++) {
            System.out.println(Arrays.toString(square[i]));
        }
    }
}
