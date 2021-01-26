package lab3;

public class Schoolboy implements Object, Learner {
    private int clNum;
    private String clLetter;
    public Schoolboy(){
        clNum=0;
        clLetter = new String();
    }
    public Schoolboy(int clnum, String clletter)
    {
        clNum=clnum;
        clLetter = clletter;
    }

    public int getClNum() {
        return clNum;
    }

    public String getClLetter() {
        return clLetter;
    }

    public String EducInst() {
        return "школа";
    }

    @Override
    public void printInfo() {
        System.out.println(EducInst()+": Класс: "+ clNum+ clLetter);
    }
}
