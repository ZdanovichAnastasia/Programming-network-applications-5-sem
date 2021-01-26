package planecrew;
import planecrew.cobject.driver.Captain;
import planecrew.cobject.driver.Secondpilot;
import planecrew.cobject.serve.Engineer;
import planecrew.cobject.serve.Stewardess;
import planecrew.crew.Crew;

public class Main {

    public static void main(String[] args) {
        Crew crew=new Crew();
        Captain captain=new Captain();
        Secondpilot secondpilot=new Secondpilot();
        Engineer engineer=new Engineer();
        Stewardess stewardess1=new Stewardess();
        Stewardess stewardess2=new Stewardess();

        captain.setFIO("Петров Игорь Сергеевич");
        captain.setOld(38);
        captain.setSalary(12980);
        captain.setCategory("ATPL");
        captain.setDrivingexp(14);
        captain.setCaptainexp(6);
        captain.setFunction("полный набор");

        secondpilot.setFIO("Иванов Филипп Игоревич");
        secondpilot.setOld(25);
        secondpilot.setSalary(8530);
        secondpilot.setCategory("CPL");
        secondpilot.setDrivingexp(3);
        secondpilot.setStatus("стажер");

        engineer.setFIO("Дудко Олег Викторович");
        engineer.setOld(43);
        engineer.setSalary(5890);
        engineer.setServObject("механическая часть самолета");
        engineer.setSpecializ("авиамеханик");

        stewardess1.setFIO("Федорова Дарья Сергеевна");
        stewardess1.setOld(27);
        stewardess1.setSalary(3049);
        stewardess1.setServObject("пассажиры");
        stewardess1.setLanguage("англ., исп.");

        stewardess2.setFIO("Павлова Нина Олеговна");
        stewardess2.setOld(23);
        stewardess2.setSalary(3049);
        stewardess2.setServObject("пассажиры");
        stewardess2.setLanguage("англ., япн., ктй.");

        crew.addPerson(captain);
        crew.addPerson(secondpilot);
        crew.addPerson(engineer);
        crew.addPerson(stewardess1);
        crew.addPerson(stewardess2);

        crew.SummSalary();
        crew.printCrew();
        System.out.println(crew.toString());

    }
}
