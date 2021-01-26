package MainPackage;
import lab2.Patient;

public class Main {
    public static void main(String[] args) {
        Patient []pt = new Patient[4];
        pt[0] = new Patient("Иванов", 15);
        pt[1] = new Patient("Петрова", 24, "жен");
        pt[2] = new Patient("Сидоров", 15, "муж");
        pt[3] = new Patient();
        for(int i=0;i<4;i++){
            pt[i].showPatient(); }
        System.out.println("Средний возрвст "+Patient.avgage(pt));
        System.out.println("Количество женщин "+Patient.countw(pt));
    }

}
