package lab1;
public class WriterInfo {
    public void showPatient(Patient pt){
        System.out.println("Фамилия: "+ pt.getSurname()
                + ". " + "Возраст: "+ pt.getage()
                + ". " + "Пол: "+ pt.getgen());
    }
}
