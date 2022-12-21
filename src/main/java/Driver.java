import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {

        Connection connection = null;

        try {

            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "developer";

            connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();


            String newColumn = "ALTER TABLE students ADD country varchar(30);";

            statement.executeUpdate(newColumn);

            System.out.println("Table!");

            String insertItaliaId1 = "UPDATE newdb.students\n" +
                    "SET country='Italia'\n" +
                    "WHERE student_id=1;";

            String insertItaliaId2 = "UPDATE newdb.students\n" +
                    "SET country='Italia'\n" +
                    "WHERE student_id=2;";

            String insertGermaniaId3 = "UPDATE newdb.students\n" +
                    "SET country='Germania'\n" +
                    "WHERE student_id=3;";

            String insertGermaniaId4 = "UPDATE newdb.students\n" +
                    "SET country='Germania'\n" +
                    "WHERE student_id=4;";

            statement.executeUpdate(insertItaliaId1);
            statement.executeUpdate(insertItaliaId2);
            statement.executeUpdate(insertGermaniaId3);
            statement.executeUpdate(insertGermaniaId4);

            System.out.println("The column country was poupolated");

            statement.close();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {

            try {
                if (connection != null)
                    connection.close();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
