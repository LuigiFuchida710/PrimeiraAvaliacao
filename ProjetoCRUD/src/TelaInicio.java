// Tela principal CRUD
import javax.swing.*;

public class TelaInicio extends JFrame {
    public TelaInicio() {
        setTitle("CRUD de Produtos");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel lbl = new JLabel("Bem-vindo, " + Usuario.nomeUsuario);
        add(lbl);
    }
}
