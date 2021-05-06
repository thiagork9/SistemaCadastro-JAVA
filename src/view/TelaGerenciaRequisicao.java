package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.PadraoTableModel;
import controller.RequisicaoTableClick;
import controller.RequisicaoTableController;
import javafx.scene.control.TableSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class TelaGerenciaRequisicao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8477129137225892085L;
	private JPanel contentPane;
	private JTextField txtBuscaRequisicao;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TelaGerenciaRequisicao frame = new TelaGerenciaRequisicao();
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
	public TelaGerenciaRequisicao() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Gerenciamento de requisi\u00E7\u00F5es");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lblPesquisaRequisio = new JLabel("PESQUISA REQUISI\u00C7\u00C3O");
		panelSuperior.add(lblPesquisaRequisio);
		
		txtBuscaRequisicao = new JTextField();
		panelSuperior.add(txtBuscaRequisicao);
		txtBuscaRequisicao.setColumns(10);
		
		JPanel panelInferior = new JPanel();
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		
		JButton btnSolicitar = new JButton("Solicitar");
		panelInferior.add(btnSolicitar);
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 774, 478);
		panelCentral.add(scrollPane);
		
		
		table = new JTable();
		Object[][] dados = new Object[][]{};
		String[] cabecalho = new String[3];
		cabecalho[0] = "Código";
		cabecalho[1] = "Funcionario";
		cabecalho[2] = "Data";
		
		DefaultTableModel model = new PadraoTableModel(dados, cabecalho);

		table.setModel(model);
		

		MouseListener tableClique = new RequisicaoTableClick(model, table);
		table.addMouseListener(tableClique);

		
		table.getColumnModel().getColumn(0).setPreferredWidth(87);
		table.getColumnModel().getColumn(1).setPreferredWidth(479);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		scrollPane.setViewportView(table);
		
		RequisicaoTableController tableController = new RequisicaoTableController(model,btnSolicitar);
		btnSolicitar.addActionListener(tableController);
		
		try {
			tableController.carregaTabela();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
