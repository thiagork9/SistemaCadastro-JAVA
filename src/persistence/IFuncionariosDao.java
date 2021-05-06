package persistence;

/* MATEUS ANDRADE DA COSTA NERI RA 1420143 */

import java.sql.SQLException;
import java.util.List;

import model.Funcionario;

public interface IFuncionariosDao {

	public void insereFuncionario(Funcionario funcionario) throws SQLException;
	public void atualizaFuncionario(Funcionario funcionario) throws SQLException;
	public void excluirFuncionario(Funcionario funcionario) throws SQLException;
	public List<Funcionario> consultaFuncionarios() throws SQLException;
	public Funcionario consultaFuncionario(Funcionario funcionario) throws SQLException;
	public boolean verificaLogin(String text, String senha) throws SQLException;
	public Funcionario consultaFuncionarioCpf(String cpf) throws SQLException;
	
}
