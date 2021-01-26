package db;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmloyeesTable extends AbstractTableModel {

    private int colnum=9;
    private int rownum;

    private String[] colNames =
            {
                    "ID", "Фамилия", "Имя", "Отчество", "Пол", "Дата рождения", "Адрес прописки", "Должность", "Подразделение"
            };

    private ArrayList<String[]> ResultSets;

    public EmloyeesTable(ResultSet rs)
    {
        ResultSets = new ArrayList<>();
        try
        {
            while(rs.next())
            {
                String[] row =
                        {
                                rs.getString("idEmployee"), rs.getString("surname"), rs.getString("name"), rs.getString("secondname"),
                                rs.getString("gen"), rs.getString("birth"), rs.getString("address"), rs.getString("position"), rs.getString("subdivision")
                        };
                ResultSets.add(row);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in EmloyeesTable");
        }
    }


    @Override
    public int getRowCount() {
        return ResultSets.size();
    }

    @Override
    public int getColumnCount() {
        return colnum;
    }
    @Override
    public String getColumnName(int param)
    {
        return colNames[param];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] row = ResultSets.get(rowIndex);
        return row[columnIndex];
    }
}
