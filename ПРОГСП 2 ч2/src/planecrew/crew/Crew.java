package planecrew.crew;
import planecrew.Interface;
import planecrew.cobject.CObject;
import java.util.*;

public class Crew implements Interface{
    private List<CObject> crew;
    private double summSalary;
    private static int crewNum=0;

    public Crew()
    {
        crew = new ArrayList<CObject>();
        crewNum=crewNum+1;
    }

    public void addPerson(CObject obj)
    {
       crew.add(obj);
    }

    @Override
    protected void finalize()
    {
        try {
            super.finalize();
        } catch (Throwable ex) {
            System.err.println("Ошибка при удалении объекта");
        }
        crewNum=crewNum-1;
    }

    @Override
    public void SummSalary() {
        double summ = 0;
        Iterator it=crew.iterator();
        CObject obj;
        while(it.hasNext())
        {
            obj=(CObject)it.next();
            summ=summ+obj.getSalary();
        }
        summSalary = summ;
    }
    public void printCrew()
    {
        int i=1;
        Iterator it=crew.iterator();
        System.out.println("=================================================");
        while(it.hasNext())
        {
            System.out.println(i+")"+(it.next()).toString());
            i=i+1;
        }
        System.out.println();
        System.out.println("Сумма выплаты зарплат всего экипажа: "+summSalary);
        System.out.println("=================================================");
    }

}
