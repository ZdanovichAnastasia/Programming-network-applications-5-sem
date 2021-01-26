package planecrew.cobject.serve;
import planecrew.cobject.CObject;

public class serveperson extends CObject{
    protected String ServObject;
    public serveperson()
    {
        super();
        ServObject =new String();
        generatePosition();
    }
    public void setServObject(String servObject){ServObject=servObject;}
    @Override
    protected void generatePosition() {
        position="Unknown_Serv_Position";
    }
    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+"  Объект обслужиания: "+ServObject;
        return str;
    }
}
