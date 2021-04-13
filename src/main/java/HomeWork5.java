public class HomeWork5 {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Edward Teach", "Engineer", "Teach@mailmy.com", "89112345566",50000,35);
        persArray[1] = new Person("Henry Morgan", "Finance Manager", "Morgan@mailmy.com", "89112346677",70000,53);
        persArray[2] = new Person("Jack Rackham", "Designer", "Rackham@mailmy.com", "89112347788",45000,43);
        persArray[3] = new Person("Charles Vane", "lawyer", "Vane@mailmy.com", "89112348899",67000,41);
        persArray[4] = new Person("Anne Bonny", "Accountant", "Bonny@mailmy.com", "89112349900",35000,27);
        for (Person person : persArray)
            if (person.getAge()>40)
                System.out.println(person);

    }
}
class Person {
    private final String name;
    private final String position;
    private final String email;
    private final String phone;
    private final int salary;
    private final int age;

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public String toString(){
        return(name+ "\n-"
                +position+ "\n-"
                +email+ "\n-"
                +phone+ "\n-"
                +salary+ "\n-"
                +age);
    }
}


