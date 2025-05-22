// Classe de conexão com o banco de dados
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/seubanco";
        String user = "root";
        String password = "senha";
        return DriverManager.getConnection(url, user, password);
    }
}
