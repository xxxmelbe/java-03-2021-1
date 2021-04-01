public class HomeWorkLesson1 {
 //1
    public static void main(String[] args) {
        PrintThreeWords();
        checkSumSign(8,-17);
        printColor(100);
        compareNumbers(16, 10);
    }

    //2
    static void PrintThreeWords() {
        System.out.println("_Orange");
        System.out.println("_Banana");
        System.out.println("_Apple");
    }
    //3
    static void checkSumSign(int a, int b) {
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }
    //4
    static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (value <= 100) {
            System.out.println("Жёлтый");
        }
        else {
            System.out.println("Зелёный");
        }
    }
    //5
    static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
    }


}

