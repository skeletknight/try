import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlScriptExecutor {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/dummy-data-pg";
        String username = "postgres";
        String password = "1234";
        String scriptFilePath = "\"C:\\Users\\Sepanta\\Desktop\\AP_to read\\dummy-pg\\dummy-data-pg.sql\""; // Update with the actual file path

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             BufferedReader reader = new BufferedReader(new FileReader(scriptFilePath))) {

            StringBuilder scriptContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                scriptContent.append(line).append("\n");
            }

            // Execute the entire script
            try (Statement statement = connection.createStatement()) {
                statement.execute(scriptContent.toString());
                System.out.println("SQL script executed successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
