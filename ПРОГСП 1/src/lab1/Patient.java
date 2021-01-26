package lab1;

public class Patient {

    private String surname;
    private int age;
    private String gen;

    public Patient(String surname, int age, String gen) {
        this.surname = surname;
        this.age = age;
        this.gen = gen;
    }
    public Patient(String surname, int age) {
        this.surname = surname;
        this.age = age;
        this.gen ="---";
    }
    public Patient() {
        this.surname = "---";
        this.age = 0;
        this.gen = "---";
    }

    public String getSurname(){ return surname; }
    public int getage() {
        return age;
    }
    public String getgen() {
        return gen;
    }
    public void Print() {
        System.out.println("Фамилия: "+ surname
            + ". " + "Возраст: "+ age
            + ". " + "Пол: "+ gen);
    }
}