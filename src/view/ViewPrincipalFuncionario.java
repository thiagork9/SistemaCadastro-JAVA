package view;

/* MATEUS ANDRADE DA COSTA NERI RA 1420143 */

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.FuncionariosTableClick;
import controller.FuncionariosTableController;
import controller.PadraoTableModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewPrincipalFuncionario extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblFuncionarios;
	private JTextField txtFiltro;
	private JTextField btnCadastrar;
	private JTextField btnExcluir;
	private JTextField btnAlterar;
	private JTextField btnPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipalFuncionario frame = new ViewPrincipalFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewPrincipalFuncionario() {
		setTitle("Gerenciamento de Funcion\u00E1rio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object[][] dados = new Object[][]{};
		String[] cabecalho = new String[3];		
		cabecalho[0] = "Nome";
		cabecalho[1] = "Email";
		cabecalho[2] = "CPF";
		
		DefaultTableModel model = new PadraoTableModel(dados, cabecalho);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 51, 576, 350);
		contentPane.add(scrollPane);
		
		tblFuncionarios = new JTable();
		scrollPane.setViewportView(tblFuncionarios);
		tblFuncionarios.setModel(model);
		
		JPanel panelPesquisar = new JPanel();
		panelPesquisar.setBounds(39, 11, 576, 30);
		contentPane.add(panelPesquisar);
		panelPesquisar.setLayout(null);
		
		JLabel lblPesquisar = new JLabel("Filtrar Pesquisa:");
		lblPesquisar.setBounds(0, 8, 120, 14);
		panelPesquisar.add(lblPesquisar);
		
		txtFiltro = new JTextField();
		txtFiltro.setBounds(103, 5, 362, 20);
		panelPesquisar.add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(475, 4, 99, 23);
		panelPesquisar.add(btnPesquisar);
		btnPesquisar.setEnabled(false);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(39,415,99,23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(270,415,99,23);
		contentPane.add(btnAlterar);
		btnAlterar.setEnabled(false);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(515,415,99,23);
		contentPane.add(btnExcluir);
		btnExcluir.setEnabled(false);
		
		JLabel lblProximaVersao = new JLabel("*1- Click Atualizar Registro 2 - Clicks Excluir Registro");
		lblProximaVersao.setBounds(39,440,500,23);
		contentPane.add(lblProximaVersao);
		
		btnCadastrar.addActionListener(this);
		
		FuncionariosTableController tmController = new FuncionariosTableController(model);
		
		try {
			tmController.preencheTabela();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MouseListener evento = new FuncionariosTableClick(tblFuncionarios, model);
		
		tblFuncionarios.addMouseListener(evento);

	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		if("Cadastrar".equals(cmd))
		{
			new ViewCadastraFuncionario().setVisible(true);
		}
		else if("Pesquisar".equals(cmd))
		{

		}
	}
	
	
}
