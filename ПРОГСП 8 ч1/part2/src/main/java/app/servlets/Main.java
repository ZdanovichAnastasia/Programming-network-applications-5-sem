package app.servlets;

import app.entities.Result;
import app.model.Model;

import java.util.List;

public class Main {
    public static void main(String [] args){
        String size = "5";
        String amount = "2";
        Result result = new Result(size, amount);
        Model model = Model.getInstance();
        model.add(result);
        Main.show();
    }
    public static void show(){
        Model model = Model.getInstance();
        List<String> results = model.list();
        List<String> size = model.size();
        //model.getSize();

        System.out.println(results.get(0));
        System.out.println(size.get(0));
    }
}
