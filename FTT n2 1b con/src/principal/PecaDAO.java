package principal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PecaDAO {

	private Connection connection;

	public PecaDAO() {
		connection = DbUtil.getConnection();
	}

	public Peca PesquisarCodigo(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_PECA WHERE COD_PECA = ?");

			stmt.setInt(1, codigo);

			ResultSet result = stmt.executeQuery();

			result.next();

			Peca aux = new Peca(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Peca PesquisarNome(String nome) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_PECA WHERE NOME_PECA LIKE '%?%'");

			stmt.setString(1, nome);

			ResultSet result = stmt.executeQuery();

			result.next();

			Peca aux = new Peca(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Peca> BuscarPecas() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_PECA");

			ResultSet result = stmt.executeQuery();

			ArrayList<Peca> pecas = new ArrayList<Peca>();

			while (result.next())
				pecas.add(new Peca(result));

			return pecas;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean Incluir(Peca peca) {
		try {

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO TB_PECA "
					+ "(COD_FORNECEDOR, NOME_PECA, DATA_COMPRADA, GARANTIA_PECA, VALOR_PECA, MARCA_PECA "
					+ "VALUES (?, '?', '?' , ?, ?, '?')");

			stmt.setInt(1, peca.getFornecedor().getCodigo());
			stmt.setString(2, peca.getNome());
			stmt.setDate(3, (Date) peca.getDataComprada());
			stmt.setDouble(4, peca.getGarantia());
			stmt.setDouble(5, peca.getValor());
			stmt.setString(6, peca.getMarca());

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean Alterar(Peca peca) {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE TB_PECA SET "
					+ "COD_FORNECEDOR = ?, NOME_PECA = '?', DATA_COMPRADA = '?', GARANTIA_PECA = ?, "
					+ "VALOR_PECA = ?, MARCA_PECA = '?' WHERE COD_PECA = ?");

			stmt.setInt(1, peca.getFornecedor().getCodigo());
			stmt.setString(2, peca.getNome());
			stmt.setDate(3, (Date) peca.getDataComprada());
			stmt.setDouble(4, peca.getGarantia());
			stmt.setDouble(5, peca.getValor());
			stmt.setString(6, peca.getMarca());
			stmt.setInt(7, peca.getCodigo());

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean Excluir(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE TB_PECA WHERE COD_PECA = ?");

			stmt.setInt(1, codigo);

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
