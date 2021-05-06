package controller;

/* MATEUS ANDRADE DA COSTA NERI RA 1420143 */

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Funcionario;
import persistence.FuncionarioDao;
import persistence.IFuncionariosDao;
import view.TelaPrincipal;
import view.ViewLogin;

public class ControllerFuncionario {


	private IFuncionariosDao fDAO = new FuncionarioDao();
	private Funcionario f = new Funcionario();
	
	public ControllerFuncionario() {
	}


	public void cadastarFuncionario(Funcionario func) {

		try {
			fDAO.insereFuncionario(func);
			JOptionPane.showMessageDialog(null, "Funcionário Cadastrado com Sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir o Funcionário\n" + e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void atualizarFuncionario(Funcionario func) {
		try {
			fDAO.atualizaFuncionario(func);
			JOptionPane.showMessageDialog(null, "Funcionário Atualizado com Sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o Funcionário\n" + e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void verificaAcesso(ViewLogin viewLogin, JTextField txtLogin, JPasswordField txtSenha) {
		char[] chars = txtSenha.getPassword();
		String senha = String.valueOf(chars);

		try {
			if (fDAO.verificaLogin(txtLogin.getText(), senha)) {
				JOptionPane.showMessageDialog(null, "Login Realizado com Sucesso", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
				
				viewLogin.dispose();
				this.f = fDAO.consultaFuncionarioCpf(txtLogin.getText());
				System.out.println("A"+f.getNomeFuncionario());
				TelaPrincipalController tController = new TelaPrincipalController(f.getNomeFuncionario());
				new TelaPrincipal().setVisible(true);
				
			} else {
				System.out.println("ERRO");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Login e ou Senha Invalidos\n" + e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public Funcionario getFuncionario(){
		return this.f;
	}
	
	

}
