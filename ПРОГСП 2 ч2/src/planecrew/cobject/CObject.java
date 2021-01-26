package planecrew.cobject;
import planecrew.Interface;

abstract public class CObject{
   protected String FIO;
   protected int Old;
   protected double Salary;
   protected String position;
   public CObject(){
       position =new String();
       FIO=new String();
       Old=0;
       Salary=0.0;
   }
    abstract protected void generatePosition();
    public void setFIO(String fio){ FIO=fio; }
    public void setOld(int old){ Old=old;}
    public void setSalary(double salary){ Salary=salary;}
    public double getSalary(){return Salary;}
    @Override
    public String toString() {
        String str = new String();
        str = FIO + "  Возраст: " + Old + "  Должность: " + position + "  Зарплата " + Salary + "BYN";
        return str;
    }
}
