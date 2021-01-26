package server1;

public class data {
    private String Surname;
    private int Id;
    data(){}
    data(String surname, int id){
        Surname = surname;
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public String getSurname() {
        return Surname;
    }
}
