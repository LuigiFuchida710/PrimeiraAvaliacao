// Tela de Cadastro
import javax.swing.*;

public class TelaCadastro extends JFrame {
    public TelaCadastro() {
        setTitle("Cadastro");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextField txtUsuario = new JTextField();
        JTextField txtNome = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JButton btnCadastrar = new JButton("Cadastrar");
        
        btnCadastrar.addActionListener(e -> {
            Usuario u = new Usuario();
            u.setUsuario(txtUsuario.getText());
            u.setNome(txtNome.getText());
            u.setSenha(new String(txtSenha.getPassword()));
            JOptionPane.showMessageDialog(this, "Usuário cadastrado!");
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Usuário:"));
        panel.add(txtUsuario);
        panel.add(new JLabel("Nome:"));
        panel.add(txtNome);
        panel.add(new JLabel("Senha:"));
        panel.add(txtSenha);
        panel.add(btnCadastrar);
        add(panel);
    }
}
