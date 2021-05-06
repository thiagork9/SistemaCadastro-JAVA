package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class RadioRequisicaoController implements ActionListener {



	private JRadioButton rdbtnRequisicao;
	private JRadioButton rdbtnDevolucacao;
	private JLabel       lblItens;
	private JLabel       lblData;

	public RadioRequisicaoController(JRadioButton rdbtnRequisicao, JRadioButton rdbtnDevolucacao, JLabel lblItens,
			JLabel lblData) {
		this.rdbtnRequisicao = rdbtnRequisicao;
		this.rdbtnDevolucacao = rdbtnDevolucacao;
		this.lblItens = lblItens;
		this.lblData = lblData;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(rdbtnRequisicao.isSelected()){
			montaTelaRequisicao();
		} 
		if(rdbtnDevolucacao.isSelected()){
			montaTelaDevolucao();
		}
		
		
	}

	private void montaTelaDevolucao() {
		lblItens.setText("Matérias para devolução");
		lblData.setText("Data de devolução");
	}

	private void montaTelaRequisicao() {
		lblItens.setText("Matérias para requisição");
		lblData.setText("Data de emissão");
		
	}


	
	
	
	
	
	
	
	
	
}
