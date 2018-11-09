package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PaisDAO {

	private Connection connection;

	public PaisDAO() {
		connection = DbUtil.getConnection();
	}

	public Pais PesquisarCodigo(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_PAIS WHERE COD_PAIS = ?");

			stmt.setInt(1, codigo);

			ResultSet result = stmt.executeQuery();

			result.next();

			Pais aux = new Pais(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Pais PesquisarNome(String nome) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_PAIS WHERE DESC_PAIS LIKE '%?%'");

			stmt.setString(1, nome);

			ResultSet result = stmt.executeQuery();

			result.next();

			Pais aux = new Pais(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Pais> BuscarMarcas() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_PAIS");

			ResultSet result = stmt.executeQuery();

			ArrayList<Pais> paises = new ArrayList<Pais>();

			while (result.next())
				paises.add(new Pais(result));

			return paises;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean Incluir(Pais pais) {
		try {

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO TB_PAIS (DESC_PAIS) VALUES ('?')");

			stmt.setString(1, pais.getNome());

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean Alterar(Pais pais) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE TB_PAIS SET DESC_PAIS = '?' WHERE COD_PAIS = ?");

			stmt.setString(1, pais.getNome());
			stmt.setInt(2, pais.getCodigo());

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean Excluir(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE TB_PAIS WHERE COD_PAIS = ?");

			stmt.setInt(1, codigo);

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
