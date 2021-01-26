package planecrew.cobject.driver;

public class Secondpilot extends driverperson{
    private String Status;
    private int sId;
    private static int sNum;
    public Secondpilot()
    {
        super();
        Status=new String();
        sNum=sNum+1;
        sId = sNum;
        generatePosition();
    }
    public void setStatus(String status){Status= status;}
    @Override
    protected void generatePosition()
    {
        position="Второй пилот";
    }
    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+"  Статус: "+Status;
        return str;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Secondpilot)
        {
            Secondpilot temp=(Secondpilot) obj;
            return this.FIO.equals(temp.FIO) &&
                    this.Status.equals(temp.Status) &&
                    this.Category.equals(temp.Category) &&
                    this.Old==(temp.Old) &&
                    this.position.equals(temp.position) &&
                    this.Salary==temp.Salary &&
                    this.Drivingexp==temp.Drivingexp&&
                    this.sId==temp.sId;
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.Status != null ? this.Status.hashCode() : 0);
        hash = 79 * hash + this.sId;
        return hash;
    }
}

