package app.entities;

public class Producer {
    private String name;
    private String country;
    private static Producer instance;
    private DBConnection connection;


    public Producer(String name, String country){
        //connection = DBConnection.getInstance();
        connection = new DBConnection();
        this.name = name;
        this.country = country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public void insert() {
        //System.out.println(name+", "+ country);
        String str = "INSERT INTO producer (name, country) VALUES('" + this.name
                + "', '" + this.country + "')";
        connection.execute(str);
    }
}

