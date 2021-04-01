public class lesson_2 {

    public static void main(String[] args) {

        CheckSum(20, 5);
        System.out.println(moreThanTwenty(15, 6));
        PrintPositiveDigit(7);
        System.out.println(PositiveOrNegative(-5));
        PrintStingNTimes("Have a nice day", 3);
    }


    //1 Вариант 1
    static void CheckSum (int a,int b) {
        int sum = a + b;
        if (sum >= 20) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    //1 Вариант 2
    static boolean moreThanTwenty(int a, int b) {
        return a + b > 10 && a + b < 20;
    }


    //2
    static void PrintPositiveDigit(int value) {
        if (value >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    //3
    static boolean PositiveOrNegative(int a){
        return (a < 0);
    }

    //4
    static void PrintStingNTimes(String text, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(text);
        }
    }
}
