// Classe de modelo e métodos de usuário
public class Usuario {
    private String usuario;
    private String nome;
    private String senha;
    
    public static String nomeUsuario;
    public static String usuarioSistema;

    // Getters e setters
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    // Métodos de interação com o banco
    public boolean verificaUsuario(String usuario, String senha) {
        // lógica de verificação
        return true;
    }
}
