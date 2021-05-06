package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.ItensRequisicao;
import model.Requisicao;
import persistence.ItensRequisicaoDao;
import persistence.RequisicaoDao;
import view.TelaItensRequisicao;

public class RequisicaoTableClick implements MouseListener {

	private DefaultTableModel modelItensRequisicao;
	private DefaultTableModel modelRequisicao;
	private JTextField txtFuncionario;
	private JTextField txtRequisicao;
	private JTextField txtData;
	private JTable  tableItens;
	private JTable tableRequisicao;

	
	public RequisicaoTableClick(DefaultTableModel modelRequisicao, JTable tableRequisicao) {
		this.modelRequisicao = modelRequisicao;
		this.tableRequisicao = tableRequisicao;
	}

	public RequisicaoTableClick(JTable tableItens, DefaultTableModel  modelItensRequisicao, JTextField txtFuncionario, JTextField txtRequisicao,
			JTextField txtData) {
		this.tableItens = tableItens;
		this.modelItensRequisicao = modelItensRequisicao;
		this.txtFuncionario = txtFuncionario;
		this.txtRequisicao = txtRequisicao;
		this.txtData = txtData;
	}

	public void mouseClicked(MouseEvent e) {
		
		int coluna = 0;
		Requisicao requisicao = new Requisicao();
		int linha = tableRequisicao.rowAtPoint(e.getPoint());
		int codigo = (int) modelRequisicao.getValueAt(linha, coluna);
		requisicao.setCodigoRequiscao(codigo);
		new TelaItensRequisicao().setVisible(true);
		
		try {
			RequisicaoDao rDao = new RequisicaoDao();
			Requisicao r2 = new Requisicao();
			r2 = rDao.consultaRequisicao(requisicao);
			ItensRequisicaoDao itensDao = new ItensRequisicaoDao();

			List<ItensRequisicao> listaItens = itensDao.retornaItensRequisicao(r2);
			
			if(tableItens != null) {
				 modelItensRequisicao =  (DefaultTableModel) tableItens.getModel();
				if( modelItensRequisicao.getRowCount() > 0){
					 modelItensRequisicao.setRowCount(0);
				}
		
			for (ItensRequisicao itensRequisicao : listaItens) {
				Object[] vetor = new Object[3];
				vetor[0] = itensRequisicao.getProduto().getNomeProduto();
				vetor[1] = itensRequisicao.getProduto().getNomeProduto();
				vetor[2] = itensRequisicao.getQuantidadeSolicitado();
				 modelItensRequisicao.addRow(vetor);
			}

			
			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String data = sdf.format((r2.getDataRequisicao()));
			txtData.setText(data);
			txtFuncionario.setText(r2.getFuncionario().getNomeFuncionario());
			txtRequisicao.setText(String.valueOf(r2.getCodigoRequiscao()));
			
			
			
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	

}
