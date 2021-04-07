import java.util.Arrays;
import java.util.stream.IntStream;

public class HomeWorkLesson3 {



    public static void main(String[] args) {

        //1
        int[] array01 = {1, 1, 1, 0, 0, 0, 1, 0, 1, 0};
        System.out.println(Arrays.toString(Change01(array01)));

        //2
        System.out.println(Arrays.toString(createArrayOfIntegers(100)));

        //3
        int[] arrayNumbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        modifierForArrays(arrayNumbers);
        System.out.println(Arrays.toString(arrayNumbers));

        //4
        createSquareArray(5);

        //5

            int ar[] = {2, 2, 1, 8, 3, 2, 2, 4, 2};
            Arrays.fill(ar, 10);
            System.out.println(Arrays.toString(ar));

        //6*
        int[] minMaxArray = {9, 7, 10, 12, 3, 15, 22, 6, 8, 31, 17};
        System.out.println(minInArray(minMaxArray));
        System.out.println(maxInArray(minMaxArray));


    }


    //1
    public static int[] Change01(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = (array[i] == 0)? 1 : 0;
        }
        return array;
    }

    //2
    public static int[] createArrayOfIntegers(int n) {
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i-1] = i;
        }

        return array;
    }

    //3
    public static void modifierForArrays(int[] array){
        for(int i = 0; i < array.length; i++) if (array[i] < 6) array[i] *= 2;
    }

    //4
    public static void createSquareArray(int size){
        int[][] sqrArray = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                sqrArray[i][j] = (i == j || j == (size - i - 1))? 1 : (int)(Math.random()*2);
                System.out.printf("%4d", sqrArray[i][j]);
            }
            System.out.println();
        }
    }

    //5
    //Задание выполнено выше. Не совсем поняла, как с помощью len и IntValue инициализировать массив.
    //Из прочитанных доп статей выделила Arrays.fill и заполнила им все значения массива int (это как бы Initial Value).
    //Но, массив задала сама. Тут запуталась немного (может нужно было задать пустой массив?).
    //Поясните, пожалуйста, верное решение.


    //6*
    public static int minInArray(int[] array){
        int min = array[0];
        for (int j : array) {
            if (min > j)
                min = j;
        }
        return min;
    }
    public static int maxInArray(int[] array){
        int max = array[0];
        for (int j : array) {
            if (max < j)
                max = j;
        }
        return max;
    }

}


