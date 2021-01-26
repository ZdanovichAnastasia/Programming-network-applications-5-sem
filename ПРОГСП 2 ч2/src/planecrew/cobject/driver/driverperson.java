package planecrew.cobject.driver;
import planecrew.cobject.CObject;

public class driverperson extends CObject{
    protected String Category;
    protected int Drivingexp;
    public driverperson()
    {
        super();
        Category =new String();
        Drivingexp=0;
        generatePosition();
    }
    public void setCategory(String category){Category=category;}
    public void setDrivingexp(int drivingexp){ Drivingexp=drivingexp;}
    @Override
    protected void generatePosition() {
        position="Unknown_Driver_Position";
    }
    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+"  Категория: "+Category+"  Опыт пилотирования: "+Drivingexp;
        return str;
    }
}
