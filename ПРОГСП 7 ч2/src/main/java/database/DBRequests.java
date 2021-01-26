package database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBRequests extends HttpServlet {
    private ArrayList<String> paths;
    private ArrayList<String> countFiles;
    private ArrayList<String> memory;


/*
    public ArrayList<String> showFullPath(String str) throws SQLException {
        String string="SELECT * FROM subcatalog a LEFT JOIN catalog b ON a.idCatalog = b.idCatalog LEFT JOIN file c ON a.idSubcatalog = c.idCatalog";
        Subcatalog catal=new Subcatalog();
        ResultSet list= catal.leftJoin();
        paths=new ArrayList<>();
        int flag=0;
        while (list.next()) {

            if(list.getString("titleSubcatalog")!=null) {
                int k=0;
                if (list.getString("titleSubcatalog").equals(str)) {
                    String path = "/" + list.getString("titleCatalog") + "/" + list.getString("titleSubcatalog");
                    for(String s:paths){
                        if(path.equals(s)){
                            k++;
                        }
                    }
                    if(k==0)
                        paths.add(path);
                    flag++;
                }
            }
            if(list.getString("titleCatalog")!=null) {
                int k=0;
                if (list.getString("titleCatalog").equals(str)) {
                    String path = "/" + list.getString("titleCatalog");
                    for(String s:paths){
                        if(path.equals(s)){
                            k++;
                        }
                    }
                    if(k==0)
                    paths.add(path);
                    flag++;
                }
            }
            if(list.getString("titleFile")!=null) {
                int k=0;
                if (list.getString("titleFile").equals(str)) {
                    String path = "/" + list.getString("titleCatalog") + "/" + list.getString("titleSubcatalog") + "/" + list.getString("titleFile");
                    for(String s:paths){
                        if(path.equals(s)){
                            k++;
                        }
                    }
                    if(k==0)
                        paths.add(path);
                    flag++;
                }
            }

        }
        if(paths.isEmpty()){
            paths.add("No results");
        }
        return paths;
    }

    public ArrayList<String> countInnerFiles(String tit) throws SQLException {
        Subcatalog catal=new Subcatalog();
        Catalog cat=new Catalog();
        countFiles=new ArrayList<>();
        if(!catal.findSubcatalog(tit)){
            ResultSet list = catal.leftJoinWhereSubcatalog(tit);
            int flag=0;
            while (list.next()) {
                if(list.getString("titleFile")!=null){
                    flag++;
                }
            }
            countFiles.add(String.valueOf(flag));
        }
        else if(!cat.findCatalog(tit)){
        ResultSet list = catal.leftJoinWhereCatalog(tit);
        int flag=0;
        while (list.next()) {
            if(list.getString("titleFile")!=null){
                flag++;
            }
        }
        countFiles.add(String.valueOf(flag));
        }
        else countFiles.add("This is a file!");
        if(countFiles.isEmpty()){
            countFiles.add("No results");
        }
        return countFiles;
    }

    public ArrayList<String> countMemory(String tit) throws SQLException {
        Subcatalog catal=new Subcatalog();
        Catalog cat=new Catalog();
        memory=new ArrayList<>();
        if(!catal.findSubcatalog(tit)){
            ResultSet list = catal.leftJoinMemorySubcatalog(tit);
            float flag=0;
            while (list.next()) {
                if(list.getString("titleFile")!=null){
                    flag=flag+list.getFloat("memory");
                }
            }
            memory.add(String.valueOf(flag));
        }
        if(!cat.findCatalog(tit)){
            ResultSet list = catal.leftJoinMemoryCatalog(tit);
            float flag=0;
            while (list.next()) {
                if(list.getString("titleFile")!=null){
                    flag=flag+list.getFloat("memory");
                }
            }
            memory.add(String.valueOf(flag));
        }
        if(memory.isEmpty()){
            memory.add("No results");
        }
        return memory;
    }


*/


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("Results", paths);
        req.setAttribute("Count", countFiles);
        req.setAttribute("Memory", memory);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("show.jsp");
        requestDispatcher.forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title=req.getParameter("title1");
        //try {

            //paths = showFullPath(title);
           // countFiles=countInnerFiles(title);
           // memory=countMemory(title);

       // } catch (SQLException throwables) {
          //  throwables.printStackTrace();
      //  }
    }
}
