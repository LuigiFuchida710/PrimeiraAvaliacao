package login;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import static login.Usuario.usuarioSistema;

public class TelaAlteracao extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private final JPanel tela;
	private final JTextField txtNome;
	private final JPasswordField passAtual;
	private final JPasswordField passSenha;
	private final JPasswordField confPassSenha;
	
	private boolean atualizacaoValida;
	
	public TelaAlteracao() {
		
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Fatec São Roque - Alteração");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 426, 212);
		
		tela = new JPanel();
		tela.setBackground(SystemColor.gray);
		setContentPane(tela);
		tela.setLayout(null);
		
		JLabel lblIdentificacao = new JLabel("Informar campos para alteração");
		lblIdentificacao.setBounds(60, 0, 500, 39);
		lblIdentificacao.setFont(new Font("Arial", 3, 19));
		tela.add(lblIdentificacao);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(19, 35, 100, 15);
		tela.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(120, 35, 218, 20);
		tela.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSenhaAtual = new JLabel("Senha Atual");
		lblSenhaAtual.setBounds(19, 60, 70, 15);
		tela.add(lblSenhaAtual);
		
		passAtual = new JPasswordField();
		passAtual.setBounds(120, 60, 219, 19);
		tela.add(passAtual);
		
		JLabel lblNovaSenha = new JLabel("Nova Senha");
		lblNovaSenha.setBounds(19, 85, 70, 15);
		tela.add(lblNovaSenha);
		
		passSenha = new JPasswordField();
		passSenha.setBounds(120, 85, 219, 19);
		tela.add(passSenha);
		
		JLabel lblConfSenha = new JLabel("Confirmar Senha");
		lblConfSenha.setBounds(19, 110, 100, 15);
		tela.add(lblConfSenha);
		
		confPassSenha = new JPasswordField();
		confPassSenha.setBounds(120, 110, 219, 19);
		tela.add(confPassSenha);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(200, 136, 117, 25);
		tela.add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(50, 136, 117, 25);
		tela.add(btnCancelar);
		
		btnCancelar.addActionListener((ActionEvent e) -> {
			TelaInicio telaIni = new TelaInicio();
			telaIni.setVisible(true);
			dispose();
		});
		
		btnAlterar.addActionListener((ActionEvent e) -> {
			try {
				
				Usuario usu = new Usuario();
				
				usu.setSenha(confPassSenha.getText());
				usu.setUsuario(usuarioSistema);
				
				
				if("".equals(usu.getNome())) {
					
					JOptionPane.showMessageDialog(null, "Campo nome do usuário precisa ser informado!",
											            "Atenção", JOptionPane.ERROR_MESSAGE);
					
					txtNome.grabFocus();
					
										
				} else if ("".equals(usu.getSenha())){
					
					JOptionPane.showMessageDialog(null, "Campo senha precisa ser informado!",
														"Atenção", JOptionPane.ERROR_MESSAGE);
					
					passSenha.grabFocus();
					
				} else if(usu.verificaUsuario(usu.getUsuario(), passAtual.getText()) == false) {
					
					JOptionPane.showMessageDialog(null, "Senha inválida, verifique!", "Atenção", JOptionPane.ERROR_MESSAGE);
					
					passSenha.grabFocus();
					
				}else if(!passSenha.getText().equals(confPassSenha.getText())) {
					
					JOptionPane.showMessageDialog(null, "Campos de Senha e confirmação de senha não coincidem",
														"Atenção", JOptionPane.ERROR_MESSAGE);
					passSenha.grabFocus();
					
				} else {
					
					atualizacaoValida = 
									usu.alteraUsuario(txtNome.getText(), usu.getUsuario(), usu.getSenha());
					
					if (atualizacaoValida == true) {
						
						JOptionPane.showMessageDialog(null, "Dado(s) do usuário alterado(s) retornaremos " 
															+ "a tela de login.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
						
						
						TelaLogin tLogin = new TelaLogin();
						tLogin.abreTela();
						
						
						dispose();
					} else {
				
						JOptionPane.showMessageDialog(null, "Problemas ao atualizar o usuário", 
															"Atenção", JOptionPane.ERROR_MESSAGE);
					}
				}
			} catch (HeadlessException ec) {
				System.out.println("Error ao alterar  usuário " + ec.getMessage());
			}
		});
		
		
		txtNome.setText(Usuario.nomeUsuario);
	}
	
	public void abreTela() {
		TelaAlteracao telaAlteracao = new TelaAlteracao();
		telaAlteracao.setVisible(true);
	}
}
