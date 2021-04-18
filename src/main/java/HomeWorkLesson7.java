public class HomeWorkLesson7 {
    private static int TIME = 0;

    public static void main(String[] args) {

        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Тень", 150, 3);
        cat[1] = new Cat("Пятнышко", 100, 4);
        cat[2] = new Cat("Горошек", 30, 1);
        Plate plate = new Plate(700);
        System.out.println("Привет! У Вас есть три кота: " + cat[0].getName() + ", " + cat[1].getName() + " и " + cat[2].getName() + ", \nкоторые едят каждые " + cat[0].getSatietyTime() + ", " + cat[1].getSatietyTime() + " и " + cat[2].getSatietyTime() + " час соответственно.");
        System.out.println("Коты едят в разное время и сёедают разное количество еды. \nСейчас в миске " + plate.getFood() + " грамм корма. Коты очень голодны и идут есть.\n");

        do {
            for (Cat i : cat) {

                //кот голоден
                if (i.getSatiety() == 0) {

                    //если в миске не хватает еды она будет добавлена
                    if (!plate.checkFood(i.getAppetite())) {
                        plate.increaseFood();
                    }

                    //кот ест
                    i.eat(plate);
                    System.out.println("Кот " + i.getName() + " съел " + i.getAppetite() + " граммов корма и проголодается через " + (i.getSatiety()) + " часа(ов)");
                }

                //декрементация показателя сытости
                i.setSatiety(i.getSatiety() - 1);
            }
            System.out.println("\nС тех пор, как коты поели прошел(ло) " + TIME + " час(а). В миске осталось " + plate.getFood() + " граммов корма.\n");
            TIME++;

        } while (TIME <= 12);
    }
}

class Plate {

    private int food;

    int getFood() {
        return food;
    }

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int n) {
        food -= n;
    }

    void increaseFood() {
        this.food += 400;
        System.out.println("В миску добавили 400 грамм корма");
    }

    boolean checkFood(int n) {
        return (food - n) >= 0;
    }

}

class Cat {

    private final String name;
    private final int appetite;
    private final int satietyTime;
    private int satiety;

    String getName() {
        return name;
    }

    int getAppetite() {
        return appetite;
    }

    int getSatietyTime() {
        return satietyTime;
    }

    int getSatiety() {
        return satiety;
    }

    void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    Cat(String name, int appetite, int satietyTime) {

        this.name = name;
        this.appetite = appetite;
        this.satietyTime = satietyTime;
        this.satiety = 0;
    }

    void eat(Plate p) {
        p.decreaseFood(appetite);
        satiety += satietyTime;
    }
}

