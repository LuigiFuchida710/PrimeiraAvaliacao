// Classe DAO para Produto
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public void inserir(Produto produto) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPreco());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> lista = new ArrayList<>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT * FROM produto";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("preco"));
            lista.add(p);
        }
        rs.close();
        stmt.close();
        con.close();
        return lista;
    }
}
