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
		lblItens.setText("Mat�rias para devolu��o");
		lblData.setText("Data de devolu��o");
	}

	private void montaTelaRequisicao() {
		lblItens.setText("Mat�rias para requisi��o");
		lblData.setText("Data de emiss�o");
		
	}


	
	
	
	
	
	
	
	
	
}
