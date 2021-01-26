package lab3;
import lab3.Learner;
import lab3.Object;

public class Gradstudent implements Object, Learner {
    private String Scdirector, Namescwork;
    public Gradstudent(){
        Scdirector = new String();
        Namescwork=new String();
    }
    public Gradstudent(String scdirector, String namescwork)
    {
        Scdirector = scdirector;
        Namescwork=namescwork;
    }

    public String getScdirector() {
        return Scdirector;
    }

    public String getNamescwork() {
        return Namescwork;
    }

    public String EducInst() {
        return "универ";
    }

    @Override
    public void printInfo() {
        System.out.println(EducInst()+": Название научной работы: "+Namescwork+"; Научный руководитель: "+ Scdirector);
    }
}
