package lab3;

public class FullTimeSt extends Student {
    FullTimeSt()
    {
        super();
    }
    public FullTimeSt( int grnum, String spec, String fac)
    {
        super(grnum, spec, fac);
    }

    @Override
    public String EducInst() {
        return "универ(очно)";
    }

    @Override
    public void printInfo() {
        System.out.println(EducInst()+": Факультет: "+getFac()+"; Специальность: "+getSpec()+ "; Группа: "+ getGrNum());
    }
}
