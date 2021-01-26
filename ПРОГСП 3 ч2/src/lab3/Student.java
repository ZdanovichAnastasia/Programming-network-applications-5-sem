package lab3;

public abstract class Student implements Object, Learner{
    private int grNum;
    private String Spec, Fac;
    public Student(){
        grNum=0;
        Spec = new String();
        Fac=new String();
    }
    public Student( int grnum, String spec, String fac)
    {
        grNum=grnum;
        Spec = spec;
        Fac=fac;
    }
    //public abstract String EducInst();
    public int getGrNum() {
        return grNum;
    }

    public String getSpec() {
        return Spec;
    }

    public String getFac() {
        return Fac;
    }
}
