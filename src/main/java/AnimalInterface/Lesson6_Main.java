package AnimalInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws InputMismatchException {

        Scanner scanner = new Scanner(System.in);

        double distanceRun = 200;
        double distanceSwim = 0;
        Cat cat = new Cat(distanceRun, distanceSwim);

        distanceRun = 500;
        distanceSwim = 10;
        Animal dog = new Dog(distanceRun, distanceSwim);


        System.out.println("Кот может пробежать: " + cat.getAnimalDistanceRun() +
                " м. \nСобака может пробежать: " + dog.getAnimalDistanceRun() + " м.");

        System.out.println("Введите дистанцию для бега:");
        double distance = scanner.nextDouble();

        System.out.println("Кот пытается выполнить run(" + distance + "). Результат: " + cat.run(distance));
        System.out.println("Собака пытается выполнить run(" + distance + "). Результат: " + dog.run(distance));
        System.out.println("\n****************\n");


        System.out.println("Кот может проплыть: " + cat.getAnimalDistanceSwim() +
                " м. \nСобака может проплыть: " + dog.getAnimalDistanceSwim() + " м.");

        System.out.println("Введите дистанцию для плавания:");
        distance = scanner.nextDouble();

        System.out.println("Кот пытается выполнить swim(" + distance + "). Результат: " + cat.swim(distance));
        System.out.println("Собака пытается выполнить swim(" + distance + "). Результат: " + dog.swim(distance));

    }


}