package planecrew.cobject.driver;

public class Captain extends driverperson{
    private String Function;
    private int Captainexp;
    private int cId;
    private static int cNum;
    public Captain()
    {
        super();
        Function=new String();
        Captainexp =0;
        cNum=cNum+1;
        cId = cNum;
        generatePosition();
    }
    public void setFunction(String function){Function=function;}
    public void setCaptainexp(int captainexp){Captainexp=captainexp;}
    @Override
    protected void generatePosition()
    {
        position="Капитан";
    }
    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+"  Функции: "+Function+"  Опыт капитана: "+Captainexp;
        return str;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Captain)
        {
            Captain temp=(Captain)obj;
            return this.FIO.equals(temp.FIO) &&
                    this.Function.equals(temp.Function) &&
                    this.Category.equals(temp.Category) &&
                    this.Old==(temp.Old) &&
                    this.position.equals(temp.position) &&
                    this.Salary==temp.Salary &&
                    this.Drivingexp==temp.Drivingexp&&
                    this.Captainexp==temp.Captainexp&&
                    this.cId==temp.cId;
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.Function != null ? this.Function.hashCode() : 0);
        hash = 79 * hash + this.Captainexp;
        hash = 79 * hash + this.cId;
        return hash;
    }

}
