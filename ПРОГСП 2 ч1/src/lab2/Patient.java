package lab2;

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

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getage() {
        return age;
    }
    public void setage(int age) {
        this.age = age;
    }
    public String getgen() {
        return gen;
    }
    public void setgen(String gen) {
        this.gen = gen;
    }

    public void showPatient(){
        System.out.println("Фамилия: "+ surname
                + ". " + "Возраст: "+ age
                + ". " + "Пол: "+ gen);
    }
    public static int avgage(Patient []pt) {
        int sum = 0;
        for (int i = 0; i < pt.length; i++) {
            sum += pt[i].age;
        }
        return sum;
    }
    public static int countw(Patient []pt) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (pt[i].gen=="жен")
                count++;
        }
        return count;
    }
}
