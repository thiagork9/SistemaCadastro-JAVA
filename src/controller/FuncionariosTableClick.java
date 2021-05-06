package controller;

/* MATEUS ANDRADE DA COSTA NERI RA 1420143 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Funcionario;
import persistence.FuncionarioDao;
import view.ViewCadastraFuncionario;

public class FuncionariosTableClick implements MouseListener {

	private JTable tblFuncionarios;
	private DefaultTableModel model;
	
	public FuncionariosTableClick(JTable tblFuncionarios, DefaultTableModel model) {
		this.tblFuncionarios = tblFuncionarios;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent evento) {
		int linha = tblFuncionarios.rowAtPoint(evento.getPoint());
//		int coluna = tblMaterias.columnAtPoint(evento.getPoint());
		int coluna = 2;
		Funcionario func  = new Funcionario();
		String id =  (String) model.getValueAt(linha,coluna);
		func.setCpfFuncionario(id);
		FuncionarioDao fDao = new FuncionarioDao();

		if (evento.getClickCount() == 1)
		{
			ViewCadastraFuncionario cadFunc = new ViewCadastraFuncionario();
			
			try {
				func = fDao.consultaFuncionario(func);
				cadFunc.funcionarioToForm(func, 2);
				
				cadFunc.setVisible(true);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (evento.getClickCount() == 2)
		{
			try {
				fDao.excluirFuncionario(func);
				JOptionPane.showMessageDialog(null,"Funcionário Excluido com Sucesso.");
				if (tblFuncionarios.getSelectedRow() >= 0)
				{  
	              model.removeRow(tblFuncionarios.getSelectedRow());  
	              tblFuncionarios.setModel(model);  
	            }
				
				System.out.println(func.getNomeFuncionario());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
