package login;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	public Connection con = null;
	public Statement stmt = null;
	public ResultSet resultset = null;
	
	private final String servidor = "jdbc:mysql://127.0.0.1:3306/Login_P";
	private final String usuario = "eu1234";
	private final String senha = "meulogin";
	private final String driver = "com.mysql.cj.jdbc.Driver";
	
	public Connection abrirConexao() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(servidor, usuario, senha);
			stmt = con.createStatement();
			
			System.out.println("Conexão aberta com sucesso");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro ao acessar o banco de dados, verifique! " + e.getMessage());
		}
		return con;
	}
	
	public void fecharConexao() {
		try {
			con.close();
			System.out.println("Conexão finalizada com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao encerrar conexão " + e.getMessage());
		}
	}
}
