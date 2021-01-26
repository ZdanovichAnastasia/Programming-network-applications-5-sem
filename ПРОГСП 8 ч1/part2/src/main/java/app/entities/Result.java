package app.entities;

public class Result {
    private int size;
    private int amount;
    private String str = "Let him do whatever he wants";
    private String res = "";

    public Result() {
    }

    public Result(String size, String amount) {
        this.size = Integer.parseInt(size);
        this.amount = Integer.parseInt(amount);
    }

    public String getmasStr() {
        for(int i = 0; i < amount; i++){
            res+= str + " /";
        }
        return res;
    }

    public String getSize() {
        return String.valueOf(size);
    }
}
