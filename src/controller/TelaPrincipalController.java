package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Funcionario;
import view.TelaCadastroProdutos;
import view.TelaGerenciaProdutos;
import view.TelaGerenciaRequisicao;
import view.TelaRequisicao;
import view.ViewCadastraFuncionario;
import view.ViewPrincipalFuncionario;

public class TelaPrincipalController implements ActionListener {

	private JMenuItem cadastrarFuncionario;
	private JMenuItem consultarFuncionario;
	private JMenuItem adicionarMateriais;
	private JMenuItem consultarMateriais;
	private JMenuItem solicitaRequisicao;
	private JMenuItem consultaRequisicao;
	private JMenuItem sobre;
	private JLabel usuarioLogado;

	Funcionario funcionarioLogado = new Funcionario();
	int nivelAcesso = funcionarioLogado.getNivelAcesso();
	String nome;
	public TelaPrincipalController() {

	}

	public TelaPrincipalController(String nome) {
		this.nome = nome;
	}
	
	public void mostra(){
		System.out.println(nome);
	}


	public TelaPrincipalController(JMenuItem cadastrarFuncionario, JMenuItem consultarFuncionario,
			JMenuItem adicionarMateriais, JMenuItem consultarMateriais, JMenuItem solicitaRequisicao,
			JMenuItem consultaRequisicao, JMenuItem sobre, JLabel usuarioLogado) {
		this.cadastrarFuncionario = cadastrarFuncionario;
		this.consultarFuncionario = consultarFuncionario;
		this.adicionarMateriais = adicionarMateriais;
		this.consultarMateriais = consultarMateriais;
		this.solicitaRequisicao = solicitaRequisicao;
		this.consultaRequisicao = consultaRequisicao;
		this.sobre = sobre;
		this.usuarioLogado = usuarioLogado;

	}
	
	
	public void logado(){
		usuarioLogado.setText(funcionarioLogado.getNomeFuncionario());
	}

	public void telaFuncionario(JPanel panelFuncionario) {
		panelFuncionario.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				if (nivelAcesso == 1 || nivelAcesso == 0) {
					ViewPrincipalFuncionario telaFuncionario = new ViewPrincipalFuncionario();
					telaFuncionario.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Você não tem permissão para gerenciar funcionaro",
							"Sem permissão", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
	}

	public void telaMaterias(JPanel panelMaterias) {
		panelMaterias.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				if (nivelAcesso == 1 || nivelAcesso == 3 || nivelAcesso == 0) {
					TelaGerenciaProdutos gerenciaProdutos = new TelaGerenciaProdutos();
					gerenciaProdutos.show();
				} else {
					JOptionPane.showMessageDialog(null, "Você não tem permissão para gerenciar produtos",
							"Sem permissão", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
	}

	public void telaRequisicao(JPanel panelRequisicao) {
		panelRequisicao.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				if (nivelAcesso == 1 || nivelAcesso == 2 || nivelAcesso == 0) {
					TelaGerenciaRequisicao telaRequisicao = new TelaGerenciaRequisicao();
					telaRequisicao.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Você não tem permissão para solicitar requisição",
							"Sem permissão", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	

		if (e.getSource() == cadastrarFuncionario) {
			if (nivelAcesso == 1) {
				ViewCadastraFuncionario cadastraFunc = new ViewCadastraFuncionario();
				cadastraFunc.show();
			} else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para gerenciar funcionaro", "Sem permissão",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == consultarFuncionario) {
			if (nivelAcesso == 1) {
				ViewPrincipalFuncionario telaFuncionario = new ViewPrincipalFuncionario();
				telaFuncionario.show();
			} else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para gerenciar funcionaro", "Sem permissão",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == adicionarMateriais) {
			if (nivelAcesso == 1 || nivelAcesso == 3 || nivelAcesso == 0) {
				TelaCadastroProdutos cadastraProdutos = new TelaCadastroProdutos();
				cadastraProdutos.show();
			} else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para gerenciar produtos", "Sem permissão",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == consultarMateriais) {
			if (nivelAcesso == 1 || nivelAcesso == 3) {
				TelaGerenciaProdutos gerenciaProdutos = new TelaGerenciaProdutos();
				gerenciaProdutos.show();
			} else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para gerenciar produtos", "Sem permissão",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == solicitaRequisicao) {
			if (nivelAcesso == 1 || nivelAcesso == 2 || nivelAcesso == 0) {
				TelaRequisicao telaRequisicao = new TelaRequisicao();
				telaRequisicao.show();
			} else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para solicitar requisição", "Sem permissão",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (e.getSource() == consultaRequisicao) {
			if (nivelAcesso == 1 || nivelAcesso == 2 || nivelAcesso == 0) {
				TelaGerenciaRequisicao gerenciaRequisicao = new TelaGerenciaRequisicao();
				gerenciaRequisicao.show();
			} else {
				JOptionPane.showMessageDialog(null, "Você não tem permissão para solicitar requisição", "Sem permissão",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == sobre){
			String msg = "Sistema desenvolvido pelos alunos da Fatec Zona Leste - 2016 \n\nGuilherme Jatobá \nLeandro Vieira \nMateus Andrade ";
			JOptionPane.showMessageDialog(null, msg, "Desenvolvimento",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
