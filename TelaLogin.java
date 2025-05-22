package login;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JFrame{

	private static final long serialVersionUID = 1L;
	private final JPanel panelTela;
	private final JTextField txtUsuario;
	private final JPasswordField pswSenha;
	
	private boolean usuarioValido;
	
	@SuppressWarnings("deprecation")
	public TelaLogin() {
		setLocationRelativeTo(null);
		
		setResizable(false);
		
		setTitle("login - FatecSR");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(500, 200, 426, 212);
		
		panelTela = new JPanel();
		
		panelTela.setBackground(SystemColor.gray);
		setContentPane(panelTela);
		
		panelTela.setLayout(null);
		
		JLabel lblIdentificacao = new JLabel("IDENTIFICAÇÃO");
		
		lblIdentificacao.setBounds(144, 0, 160, 39);
		
		lblIdentificacao.setFont(new Font("Arial", 3, 19));
		
		panelTela.add(lblIdentificacao);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(24, 65, 70, 15);
		panelTela.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(24, 92, 70, 15);
		panelTela.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(112, 63, 219, 19);
		panelTela.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(112, 90 ,219, 19);
		panelTela.add(pswSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(200, 136, 117, 25);
		panelTela.add(btnEntrar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(50,136 ,117, 25);
		panelTela.add(btnCadastrar);
		

		btnEntrar.addActionListener((ActionEvent e) -> {
			
			
			Usuario usu = new Usuario();
			
			usu.setUsuario(txtUsuario.getText());
			usu.setSenha(pswSenha.getText());
			
			if("".equals(txtUsuario.getText())) {
				
				
				JOptionPane.showMessageDialog(null, 
						"Campo usuário precisa ser informado!",
						"Atenção",
						JOptionPane.ERROR_MESSAGE);
				
				txtUsuario.grabFocus();
			}else if("".equals(pswSenha.getText())) {
				
				
				JOptionPane.showMessageDialog(null, 
						"Campo Senha precisa ser informado!",
						"Atenção",
						JOptionPane.ERROR_MESSAGE);
				
				pswSenha.grabFocus();
			}else {
				
				usuarioValido = usu.verificaUsuario(usu.getUsuario(), usu.getSenha());
				
				if(usuarioValido == true) {
					
					JOptionPane.showMessageDialog(null, 
							"Usuário válido em nossa base de dados",
							"Atenção",
							JOptionPane.INFORMATION_MESSAGE);
					
					TelaInicio telaInicio = new TelaInicio();
					telaInicio.abreTela();
					
					dispose();
				}else {
					
					
					JOptionPane.showMessageDialog(null, 
							"Usuário inválido ou inexistente",
							"Atenção",
							JOptionPane.ERROR_MESSAGE);
					
					
					limpaText();
					
					
					txtUsuario.grabFocus();
				}
			}
		});
		
		btnCadastrar.addActionListener((ActionEvent e) -> {
			TelaCadastro tCadastro = new TelaCadastro();
			tCadastro.abreTela();
			dispose();
		});
	}
	
	public void abreTela() {
		TelaLogin tela = new TelaLogin();
		tela.setVisible(true);
	}
	
	public void limpaText() {
		txtUsuario.setText("");
		pswSenha.setText("");
	}
}
