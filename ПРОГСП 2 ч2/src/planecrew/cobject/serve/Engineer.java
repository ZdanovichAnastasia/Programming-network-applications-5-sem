package planecrew.cobject.serve;

public class Engineer extends serveperson{
    private String Specializ;
    private int eId;
    private static int eNum;
    public Engineer()
    {
        super();
        Specializ=new String();
        eNum=eNum+1;
        eId = eNum;
        generatePosition();
    }
    public void setSpecializ(String specializ){Specializ=specializ;}
    @Override
    protected void generatePosition()
    {
        position="Инженер";
    }
    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+"  Специализация: "+ Specializ;
        return str;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Engineer)
        {
            Engineer temp=(Engineer) obj;
            return this.FIO.equals(temp.FIO) &&
                    this.Specializ.equals(temp.Specializ) &&
                    this.ServObject.equals(temp.ServObject) &&
                    this.Old==(temp.Old) &&
                    this.position.equals(temp.position) &&
                    this.Salary==temp.Salary &&
                    this.eId==temp.eId;
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.Specializ != null ? this.Specializ.hashCode() : 0);
        hash = 79 * hash + this.eId;
        return hash;
    }
}

