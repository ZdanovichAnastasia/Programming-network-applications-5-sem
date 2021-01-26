package planecrew.cobject.serve;

public class Stewardess extends serveperson{
    private String Language;
    private int stId;
    private static int stNum;
    public Stewardess()
    {
        super();
        Language=new String();
        stNum=stNum+1;
        stId = stNum;
        generatePosition();
    }
    public void setLanguage(String language){Language=language;}
    @Override
    protected void generatePosition()
    {
        position="Бортпроводник";
    }
    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+"  Языки: "+Language;
        return str;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Stewardess)
        {
            Stewardess temp=(Stewardess)obj;
            return this.FIO.equals(temp.FIO) &&
                    this.Language.equals(temp.Language) &&
                    this.ServObject.equals(temp.ServObject) &&
                    this.Old==(temp.Old) &&
                    this.position.equals(temp.position) &&
                    this.Salary==temp.Salary &&
                    this.stId==temp.stId;
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.Language != null ? this.Language.hashCode() : 0);
        hash = 79 * hash + this.stId;
        return hash;
    }
}

