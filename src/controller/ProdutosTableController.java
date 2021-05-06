package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Produtos;
import persistence.IProdutosDao;
import persistence.ProdutosDao;

//Classe que determina que cada linha da tabela recebe um objeto da classe, al�m de um m�todo para pesquisa de materiais

public class ProdutosTableController {

	private DefaultTableModel model;
	
	public ProdutosTableController(DefaultTableModel model) {
		this.model = model;
	}
	
	public void preencheTable()throws SQLException{
		IProdutosDao pDao = new ProdutosDao();
		List<Produtos> listaProdutos = pDao.consultaProdutos();
		model.setRowCount(0);
		for (Produtos prod : listaProdutos){
			Object[] linha = new Object[3];
			linha[0] = prod.getCodigoProduto();
			linha[1] = prod.getNomeProduto();
			linha[2] = prod.getQtdeProduto();
			model.addRow(linha);
		}
	}
	
	public List<Produtos> pesquisar(String nome) throws SQLException{
		IProdutosDao ipDao = new ProdutosDao();
		ProdutosController pController = new ProdutosController();
		List<Produtos> listaProdutos = new ArrayList<Produtos>();
		listaProdutos = ipDao.parametrosPesquisa1(nome);
		pController.listaProdutos(listaProdutos);
		return listaProdutos;
	}
	
	
}
