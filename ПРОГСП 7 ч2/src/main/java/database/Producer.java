package database;

import java.util.ArrayList;

public class Producer {
    private int idProducer;
    private String name;
    private String country;
    private ConnectionDB connectionDB;

    public Producer() {
        connectionDB = ConnectionDB.getInstance();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void insert() {
        String str = "INSERT INTO producer (name, country) VALUES('" +
                this.name + "', '" + this.country + "')";
        connectionDB.execute(str);
    }
    public String find(){
        String str = "SELECT * From producer Where name = '" + this.name + "'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        String status = "";
        for (String[] item: result)
            status = item[0];
        return status;
    }
    public String find(int id){
        String str = "SELECT * From producer Where idproducer = '" + id + "'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        String status = "";
        for (String[] item: result)
            status = item[1];
        return status;
    }
    public ArrayList<String> selectNames(){
        String str = "SELECT * From producer";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        ArrayList<String> listNames = new ArrayList<>();
        for (String[] items: result){
            listNames.add(items[1]);
        }
        return listNames;
    }
}
