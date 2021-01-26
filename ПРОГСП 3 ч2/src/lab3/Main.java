package lab3;

public class Main {
    public static void main(String[] args) {
	Schoolboy sc=new Schoolboy(11, "А");
	sc.printInfo();
	Gradstudent gr=new Gradstudent("Социальные сети как фактор успеха популизма","Павлова Нина Олеговна");
	gr.printInfo();
	FullTimeSt ft =new FullTimeSt(872302, "Исит(эк)", "ИЭФ");
	PartTimeSt pt =new PartTimeSt(673603, "Исит(л)", "ИЭФ");
	ft.printInfo();
	pt.printInfo();
    }
}
