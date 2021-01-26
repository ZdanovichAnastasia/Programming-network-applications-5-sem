package database;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;

public class Watch {
    private int idWatch;
    private String brand;
    private String type;
    private double price;
    private int amount;
    private int idProducer;
    private ConnectionDB connectionDB;

    public Watch() {
        connectionDB = ConnectionDB.getInstance();
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(String price) {
        this.price = Double.parseDouble(price);
    }

    public void setAmount(String amount) {
        this.amount = Integer.parseInt(amount);
    }

    public void setIdProducer(String idProducer) {
        this.idProducer = Integer.parseInt(idProducer);
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getIdProducer() {
        return idProducer;
    }

    public void insert() {
        String str = "INSERT INTO watch (brand, type, price, amount, producerid) VALUES('" +
                this.brand + "', '" + this.type + "', '"+ this.price + "', '"+ this.amount + "', '" + this.idProducer + "')";
        connectionDB.execute(str);
    }
    public String find(){
        String str = "SELECT * From producer Where brand = '" + this.brand + "'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        String status = "";
        for (String[] item: result)
            status = item[1];
        return status;
    }
}
