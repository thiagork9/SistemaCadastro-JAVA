package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import model.Requisicao;
import persistence.RequisicaoDao;
import view.TelaRequisicao;

public class RequisicaoTableController implements ActionListener {

	private DefaultTableModel model;
	private JButton btnSolicitar;

	public RequisicaoTableController(DefaultTableModel model, JButton btnSolicitar) {
		this.model = model;
		this.btnSolicitar = btnSolicitar;
	}
	
	
	public void carregaTabela() throws ClassNotFoundException, SQLException{
		RequisicaoDao rDao = new RequisicaoDao();
		List<Requisicao> listaRequisicao = rDao.retornaRequisicoes();
		
		model.setRowCount(0);

		for(Requisicao requisicao: listaRequisicao){
			Object[] linha = new Object[3];
			linha[0] = requisicao.getCodigoRequiscao();
			linha[1] = requisicao.getFuncionario().getNomeFuncionario();
			linha[2] = requisicao.getDataRequisicao();
			model.addRow(linha);
		}
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnSolicitar){
			new TelaRequisicao().setVisible(true);
		}
		
	}
	
	
}
