package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Funcionario;
import persistence.FuncionarioDao;
import persistence.IFuncionariosDao;


/* FEITO POR Mateus Andrade da Costa Neri */

public class BotaoCadastraFuncionarioController implements ActionListener  {

	private JTextField txtNomeFuncionario;
	private JTextField txtRGFuncionario;
	private JTextField txtCPFFuncionario;
	private JTextField txtTelefoneFuncionario;
	private JTextField txtEmailFuncionario;
	private JTextField txtSenha;
	private JTextField txtConfirmaSenha;
	private JRadioButton rdbtnGerencial;
	private JRadioButton rdbtnProfessor;
	private JRadioButton rdbtnEstoquista;
	
	public BotaoCadastraFuncionarioController(JTextField txtNomeFuncionario, JTextField txtRGFuncionario,
			JTextField txtCPFFuncionario, JTextField txtTelefoneFuncionario, JTextField txtEmailFuncionario,
			JTextField txtSenha, JTextField txtConfirmaSenha, JRadioButton rdbtnGerencial, JRadioButton rdbtnProfessor,
			JRadioButton rdbtnEstoquista) {
		this.txtNomeFuncionario = txtNomeFuncionario;
		this.txtRGFuncionario = txtRGFuncionario;
		this.txtCPFFuncionario = txtCPFFuncionario;
		this.txtTelefoneFuncionario = txtTelefoneFuncionario;
		this.txtEmailFuncionario = txtEmailFuncionario;
		this.txtSenha = txtSenha;
		this.txtConfirmaSenha = txtConfirmaSenha;
		this.rdbtnGerencial = rdbtnGerencial;
		this.rdbtnProfessor = rdbtnProfessor;
		this.rdbtnEstoquista = rdbtnEstoquista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		verificaNivelAcessoSelecionado(rdbtnEstoquista,rdbtnGerencial,rdbtnProfessor);
		
//		cadastrarFuncionario(funcionario);
		
	}
	
	private int verificaNivelAcessoSelecionado(JRadioButton rdbtnEstoquista, JRadioButton rdbtnGerencial,JRadioButton rdbtnProfessor) {
		
		if(rdbtnEstoquista.isSelected())
		{
			return 1;
		}
		else if(rdbtnGerencial.isSelected())
		{
			return 2;
		}
		else if(rdbtnProfessor.isSelected())
		{
			return 3;
		}
		
		return 0;
	}

	private void exibe(){
		System.out.println();
	}
	
	private void cadastrarFuncionario(Funcionario funcionario){
		
		IFuncionariosDao fDao = new FuncionarioDao();
		
		try {
			fDao.insereFuncionario(funcionario);
			JOptionPane.showMessageDialog(null,"Funcionário Inserido com Sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
	}


}
