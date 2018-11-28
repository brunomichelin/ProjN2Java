package principal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServicoDAO {

	private Connection connection;
	
	public ServicoDAO() {
		connection = DbUtil.getConnection();
	}
	
	public Servico PesquisarCodigo(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_SERVICO WHERE COD_SERVICO = ?");

			stmt.setInt(1, codigo);

			ResultSet result = stmt.executeQuery();

			result.next();

			Servico aux = new Servico(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Servico PesquisarNome(String nome) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_SERVICO WHERE NOME_SERVICO LIKE '%?%'");

			stmt.setString(1, nome);

			ResultSet result = stmt.executeQuery();

			result.next();

			Servico aux = new Servico(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Servico> BuscarServicos() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_SERVICO");

			ResultSet result = stmt.executeQuery();

			ArrayList<Servico> pecas = new ArrayList<Servico>();

			while (result.next())
				pecas.add(new Servico(result));

			return pecas;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean Incluir(Servico servico) {
		try {

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO TB_SERVICO "
					+ "(COD_FORNECEDOR, NOME_PECA, DATA_COMPRADA, GARANTIA_PECA, VALOR_PECA, MARCA_PECA "
					+ "VALUES (?, '?', '?' , ?, ?, '?')");

			stmt.setString(2, servico.getNome());

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean Alterar(Servico servico) {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE TB_SERVICO SET "
					+ "COD_FORNECEDOR = ?, NOME_PECA = '?', DATA_COMPRADA = '?', GARANTIA_PECA = ?, "
					+ "VALOR_PECA = ?, MARCA_PECA = '?' WHERE COD_PECA = ?");

			stmt.setInt(1, servico.getCodigo());
			stmt.setString(2, servico.getNome());
			stmt.setDouble(5, servico.getValor());
			stmt.setInt(7, servico.getCodigo());

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean Excluir(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE TB_SERVICO WHERE COD_SERVICO = ?");

			stmt.setInt(1, codigo);

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
