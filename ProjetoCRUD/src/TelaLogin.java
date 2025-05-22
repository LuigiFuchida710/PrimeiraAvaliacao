// Tela de Login
import javax.swing.*;

public class TelaLogin extends JFrame {
    public TelaLogin() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextField txtUsuario = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JButton btnLogin = new JButton("Entrar");
        
        btnLogin.addActionListener(e -> {
            Usuario u = new Usuario();
            if(u.verificaUsuario(txtUsuario.getText(), new String(txtSenha.getPassword()))) {
                new TelaInicio().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Login inválido!");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Usuário:"));
        panel.add(txtUsuario);
        panel.add(new JLabel("Senha:"));
        panel.add(txtSenha);
        panel.add(btnLogin);
        add(panel);
    }
}
