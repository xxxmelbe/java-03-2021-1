import java.util.Random;
import java.util.Scanner;

        class Lesson_4 {

        private static final Scanner scanner= new Scanner(System.in);
        private static final Random random = new Random();

        public static final int SIZE = 3;
        private static final int DOTS_TO_WIN = 3;
        private static final char DOT_EMPTY = '_';
        private static final char DOT_X = 'X';
        private static final char DOT_O = 'O';
        private static final char[] players = new char[]{DOT_X, DOT_O};

        private static int lastRow;
        private static int lastCol;

        private static char[][] map;
        private static int emptyFields;

        public static void main(String[] args) {
            initMap();
            game();
        }

        private static void game() {
            System.out.println("Вы в игре крестики-нолики. Вы ходите первым.");
            while (true) {
                for (char player : players) {
                    if (isFilled()) {
                        System.out.println("Ничья!");
                        return;
                    } else if (turn(player)) {
                        System.out.format("%s победил!%n", player);
                        return;
                    }
                }
            }
        }

        private static boolean turn(char value) {
            switch (value) {
                case DOT_X -> humanStep();
                case DOT_O -> aiStep();
                default -> System.out.println("Новый игрок");
            }
            printMap();
            --emptyFields;
            return hasWinner(value);
        }

        private static void printMap() {
            for (char[] row : map) {
                for (char item : row) {
                    System.out.print(" " + item);
                }
                System.out.println();
            }
        }

        private static void initMap() {
            map = new char[SIZE][SIZE];
            emptyFields = SIZE * SIZE;
            for (int row = 0; row < map.length; row++) {
                for (int column = 0; column < map.length; column++) {
                    map[row][column] = DOT_EMPTY;
                    System.out.print(" " + DOT_EMPTY);
                }
                System.out.println();
            }
        }

        private static boolean isFilled() {
            return emptyFields <= 0;
        }

        private static void aiStep() {
            int row;
            int column;
            if (onMap(lastRow, lastCol - 1) && map[lastRow][lastCol - 1] == DOT_X) {
                row = lastRow;
                column = lastCol + 1;
                if (validate(row, column)) {
                    doAiStep(row, column);
                    return;
                }
            }
            if (onMap(lastRow, lastCol + 1) && map[lastRow][lastCol + 1] == DOT_X) {
                row = lastRow;
                column = lastCol - 1;
                if (validate(row, column)) {
                    doAiStep(row, column);
                    return;
                }
            }
            if (onMap(lastRow - 1, lastCol) && map[lastRow - 1][lastCol] == DOT_X) {
                row = lastRow + 1;
                column = lastCol;
                if (validate(row, column)) {
                    doAiStep(row, column);
                    return;
                }
            }
            if (onMap(lastRow + 1, lastCol) && map[lastRow + 1][lastCol] == DOT_X) {
                row = lastRow - 1;
                column = lastCol;
                if (validate(row, column)) {
                    doAiStep(row, column);
                    return;
                }
            }
            if (onMap(lastRow - 1, lastCol - 1) && map[lastRow - 1][lastCol - 1] == DOT_X) {
                row = lastRow + 1;
                column = lastCol + 1;
                if (validate(row, column)) {
                    doAiStep(row, column);
                    return;
                }
            }
            if (onMap(lastRow + 1, lastCol + 1) && map[lastRow + 1][lastCol + 1] == DOT_X) {
                row = lastRow - 1;
                column = lastCol - 1;
                if (validate(row, column)) {
                    doAiStep(row, column);
                    return;
                }
            }

            row = column = SIZE / 2;
            if (!validate(row, column)) {
                do {
                    row = random.nextInt(SIZE);
                    column = random.nextInt(SIZE);
                } while (!validate(row, column));
            }
            doAiStep(row, column);
        }

        private static void doAiStep(int row, int column) {
            System.out.format("Компьютер совершил ход в ячейку %s %s %n", row + 1, column + 1);
            map[row][column] = DOT_O;
        }

        private static void humanStep() {
            int row;
            int column;
            do {
                System.out.println("Введите значение строки и столбца," +
                        " в которые вы хотите сходить");
                row = scanner.nextInt() - 1;
                column = scanner.nextInt() - 1;
            } while (!validate(row, column));
            lastRow = row;
            lastCol = column;
            map[row][column] = DOT_X;
        }

        private static boolean validate(int row, int column) {
            return onMap(row, column)
                    && map[row][column] == DOT_EMPTY;
        }

        private static boolean onMap(int row, int column) {
            return row >= 0 && row < SIZE
                    && column >= 0 && column < SIZE;
        }

        private static boolean hasWinner(char value) {
            boolean row;
            boolean column;
            boolean diagonalL1;
            boolean diagonalR2;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
                    row = true;
                    column = true;
                    diagonalL1 = true;
                    diagonalR2 = true;
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        row &= (map[i][j + k] == value);
                        column &= (map[j + k][i] == value);
                        if (i <= SIZE - DOTS_TO_WIN) {
                            diagonalL1 &= (map[i + k][j + k] == value);
                            diagonalR2 &= (map[i + k][SIZE - 1 - j - k] == value);
                        } else {
                            diagonalL1 = false;
                            diagonalR2 = false;
                        }
                    }
                    if (row || column || diagonalL1 || diagonalR2) return true;
                }
            }
            return false;
        }
    }

