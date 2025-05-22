package login;

import java.sql.SQLException;

public class Usuario {
	private String usuario;
	private String nome;
	private String senha;
	
	static String nomeUsuario;
	static String usuarioSistema;
	static boolean resultAlteracao;
	static boolean resultExclusao;
	
	private boolean resultUsuario;
	private boolean resultCadastro;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean verificaUsuario(String usuario, String senha) {
		Conexao banco = new Conexao();
		
		try {
			banco.abrirConexao();
			
			banco.stmt = banco.con.createStatement();
			
			banco.resultset =
						banco.stmt.executeQuery("select * from usuario "
												+ "where usuario = '" + usuario + "'"
												+ "AND senha = md5('" + senha + "')");
			if	(banco.resultset.next()) {
				resultUsuario = true;
				
				setUsuario (banco.resultset.getString(1));
				setNome (banco.resultset.getString(2));
				
				nomeUsuario = getNome();
				usuarioSistema = getUsuario();
			}else {
				resultUsuario = false;
			}
			
			banco.fecharConexao(); 
		} catch (SQLException ec) {
			System.out.println("Erro ao consultar usuário " + ec.getMessage());
		}	
		return resultUsuario;
	}
	
	public boolean verificaUsuario(String usuario) {
		Conexao banco = new Conexao();
		
		try {
			banco.abrirConexao();
			
			banco.stmt = banco.con.createStatement();
			
			banco.resultset = banco.stmt.executeQuery("SELECT * FROM usuario " 
													 + "WHERE usuario = ' " + usuario + "'");
			
			if (banco.resultset.next()) {

				resultUsuario = true;
			}else {
				resultUsuario = false;
			}
			
			banco.fecharConexao(); 
		} catch (SQLException ec) {
			System.out.println("Erro ao consultar usuário " + ec.getMessage());
		}
		return resultUsuario;
	}
	
	public boolean cadastraUsuario(String nome, String usuario, String senha) {
		Conexao banco = new Conexao();
		
		try {
			banco.abrirConexao();
			
			banco.stmt = banco.con.createStatement();
			
			banco.stmt.execute("INSERT INTO usuario (nome, usuario, senha)"
							  + "VALUES ('" + nome + "','" + usuario + "', md5('" + senha + "'))");
			resultCadastro = true;
		} catch (SQLException ec) {
			System.out.println("Erro ao inserir o usuário " + ec.getMessage());
			resultCadastro = false;
		}
		return resultCadastro;
	}
	
	public boolean alteraUsuario(String nome, String usuario, String senha) {
		
		Conexao banco = new Conexao();
		
		try {
			banco.abrirConexao();
			
			banco.stmt = banco.con.createStatement();
			
			banco.stmt.execute("UPDATE usuario SET nome = '" + nome +
					"', senha = md5('" + senha + "') WHERE usuario = '" +
					usuario + "'");
			resultAlteracao = true;
			
		} catch (Exception ec) {
			System.out.println("Erro ao atualizar o usuário " + ec.getMessage());
			resultAlteracao = false;
		}
		
		banco.fecharConexao();
		
		return resultAlteracao;
	}
	
	public boolean excluiUsuario(String usuario) {
		Conexao banco = new Conexao();
		
		try {
			banco.abrirConexao();
			
			banco.stmt = banco.con.createStatement();
			
			banco.stmt.execute("DELETE FROM usuario WHERE usuario = '"
							   + usuario + "'");
			
			resultExclusao = true;
			
		} catch (Exception ec) {
			System.out.println("Erro ao excluir usuário " + ec.getMessage());
			resultExclusao = false;
		}
		banco.fecharConexao();
		return resultExclusao;
	}
}