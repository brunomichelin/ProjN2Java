package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MarcaDAO {

	private Connection connection;

	public MarcaDAO() {
		connection = DbUtil.getConnection();
	}

	public Marca PesquisarCodigo(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_MARCA WHERE COD_MARCA = ?");

			stmt.setInt(1, codigo);

			ResultSet result = stmt.executeQuery();

			result.next();

			Marca aux = new Marca(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Marca PesquisarNome(String nome) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_MARCA WHERE DESC_MARCA LIKE '%?%'");

			stmt.setString(1, nome);

			ResultSet result = stmt.executeQuery();

			result.next();

			Marca aux = new Marca(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Marca> BuscarMarcas() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_MARCA");

			ResultSet result = stmt.executeQuery();

			ArrayList<Marca> marcas = new ArrayList<Marca>();

			while (result.next())
				marcas.add(new Marca(result));

			return marcas;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean Incluir(Marca marca) {
		try {

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO TB_MARCA (DESC_MARCA) VALUES ('?')");

			stmt.setString(1, marca.getDescricao());

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean Alterar(Marca marca) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE TB_MARCA SET DESC_MARCA = '?' WHERE COD_MARCA = ?");

			stmt.setString(1, marca.getDescricao());
			stmt.setInt(2, marca.getCodigo());

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean Excluir(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE TB_MARCA WHERE COD_MARCA = ?");

			stmt.setInt(1, codigo);

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
