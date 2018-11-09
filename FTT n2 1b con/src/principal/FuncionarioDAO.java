package principal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioDAO {

	private Connection connection;

	public FuncionarioDAO() {
		connection = DbUtil.getConnection();
	}
	
	public Funcionario PesquisarCodigo(int codigo) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM TB_FUNCIONARIO WHERE COD_FUNCIONARIO = ?");

			stmt.setInt(1, codigo);

			ResultSet result = stmt.executeQuery();

			result.next();

			Funcionario aux = new Funcionario(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Funcionario PesquisarNome(String nome) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM TB_FUNCIONARIO WHERE NOME_FUNCIONARIO LIKE '%?%'");

			stmt.setString(1, nome);

			ResultSet result = stmt.executeQuery();

			result.next();

			Funcionario aux = new Funcionario(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Funcionario> BuscarFuncionarios() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_FUNCIONARIO");

			ResultSet result = stmt.executeQuery();

			ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

			while (result.next())
				funcionarios.add(new Funcionario(result));

			return funcionarios;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean Incluir(Funcionario funcionario) {
		try {

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO TB_FUNCIONARIO "
					+ "(NOME_FUNCIONARIO, EMAIL_FUNCIONARIO, CPF_FUNCIONARIO, CELULAR_FUNCIONARIO, "
					+ "TELEFONE_FUNCIONARIO, DATA_NASC_FUNCIONARIO, CIDADE_FUNCIONARIO, ESTADO_FUNCIONARIO, "
					+ "BAIRRO_FUNCIONARIO, ENDERECO_FUNCIONARIO, NUMERO_END_FUNCIONARIO, SALARIO_FUNCIONARIO) "
					+ "VALUES ('?', '?', '?' , '?', '?', '?', '?', '?', '?', '?', ?, ?)");

			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getEmail());
			stmt.setString(3, funcionario.getCpf());
			stmt.setString(4, funcionario.getCelular());
			stmt.setString(5, funcionario.getTelefone());
			stmt.setDate(6, (Date) funcionario.getDataNascimento());
			stmt.setString(7, funcionario.getCidade());
			stmt.setString(8, funcionario.getEstado());
			stmt.setString(9, funcionario.getBairro());
			stmt.setString(10, funcionario.getEndereco());
			stmt.setInt(11, funcionario.getNumero());
			stmt.setDouble(12, funcionario.getSalario());

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean Alterar(Funcionario funcionario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE TB_FORNECEDOR SET "
					+ "NOME_FUNCIONARIO = '?', EMAIL_FUNCIONARIO = '?', CPF_FUNCIONARIO = '?', "
					+ "CELULAR_FUNCIONARIO = '?', TELEFONE_FUNCIONARIO = '?', DATA_NASC_FUNCIONARIO = '?', "
					+ "CIDADE_FUNCIONARIO = '?', ESTADO_FUNCIONARIO = '?', BAIRRO_FUNCIONARIO = '?', "
					+ "ENDERECO_FUNCIONARIO = '?', NUMERO_END_FUNCIONARIO = ?, "
					+ "SALARIO_FUNCIONARIO = ? WHERE COD_FUNCIONARIO = ?");

			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getEmail());
			stmt.setString(3, funcionario.getCpf());
			stmt.setString(4, funcionario.getCelular());
			stmt.setString(5, funcionario.getTelefone());
			stmt.setDate(6, (Date) funcionario.getDataNascimento());
			stmt.setString(7, funcionario.getCidade());
			stmt.setString(8, funcionario.getEstado());
			stmt.setString(9, funcionario.getBairro());
			stmt.setString(10, funcionario.getEndereco());
			stmt.setInt(11, funcionario.getNumero());
			stmt.setInt(12, funcionario.getCodigo());
			stmt.setDouble(13, funcionario.getSalario());
			stmt.setInt(14, funcionario.getCodigo());
			
			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean Excluir(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE TB_FUNCIONARIO WHERE COD_FUNCIONARIO = ?");

			stmt.setInt(1, codigo);

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
