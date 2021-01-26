package lab1;

public class Main {
    public static void main(String[] args) {
        Patient P1 = new Patient("Иванов",15,"муж");
        Patient P2 = new Patient("Петрова",24,"жен");
        Patient P3 = new Patient("Сидоров",35,"муж");
        WriterInfo write = new WriterInfo();
        write.showPatient(P1);
        write.showPatient(P2);
        write.showPatient(P3);
    }
}

