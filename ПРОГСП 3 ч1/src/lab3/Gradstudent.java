package lab3;

public class Gradstudent extends Learner{
    private String Scdirector, Namescwork;
    public Gradstudent(){
        super();
        Scdirector = new String();
        Namescwork=new String();
    }
    public Gradstudent(String fio, String gen, int age)
    {
        super(fio, gen, age);
        Scdirector = new String();
        Namescwork=new String();
    }
    public Gradstudent(String fio, String gen, int age, String scdirector, String namescwork)
    {
        super(fio, gen, age);
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
        Educinst="универ";
        return Educinst;
    }
}
