package db;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    InsertTable form = new InsertTable();
                    form.pack();
                    form.setLocationRelativeTo(null);
                    form.setVisible(true);
                }
                catch(Exception e){}
            }
        });
    }
}
