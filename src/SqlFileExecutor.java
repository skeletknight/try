import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlFileExecutor {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "1234";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();

            // Read SQL queries from the file
            String sqlFilePath = "C:\\Users\\Sepanta\\Desktop\\AP_to read\\dummy-pg\\dummy-data-pg.sql";
            BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                statement.execute(line);
            }

            reader.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
