package app.DB;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<String[]> res = new ArrayList<>();
        String[] str1 = new String[2];
        str1[0] = "12";
        str1[1] = "pass";
        res.add(str1);
        String[] str2 = new String[2];
        str2[0] = "1";
        str2[1] = "pass";
        res.add(str2);
        String[] str3 = new String[2];
        str3[0] = "14";
        str3[1] = "notpass";
        res.add(str3);
        for(String[] resL: res){
            if(resL[0].equals("1")){
                res.remove(resL);
            }
        }

        for(String[] resL: res){
            System.out.println("after: " + resL[0]);
        }
    }
}
