package lab3;

public class PartTimeSt extends Student{
    PartTimeSt()
    {
        super();
    }
    public PartTimeSt( int grnum, String spec, String fac)
    {
        super(grnum, spec, fac);
    }

    @Override
    public String EducInst() {
        return "универ(заочно)";
    }

    @Override
    public void printInfo() {
        System.out.println(EducInst()+": Факультет: "+getFac()+"; Специальность: "+getSpec()+ "; Группа: "+ getGrNum());
    }
}
