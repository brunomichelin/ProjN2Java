package principal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VeiculoDAO {

	private Connection connection;

	public VeiculoDAO() {
		connection = DbUtil.getConnection();
	}

	public Veiculo PesquisarCodigo(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_VEICULO WHERE COD_VEICULO = ?");

			stmt.setInt(1, codigo);

			ResultSet result = stmt.executeQuery();

			result.next();

			Veiculo aux = new Veiculo(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Veiculo PesquisarNome(String nome) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM TB_VEICULO WHERE DESC_MODELO LIKE '%?%'");

			stmt.setString(1, nome);

			ResultSet result = stmt.executeQuery();

			result.next();

			Veiculo aux = new Veiculo(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Veiculo> BuscarVeiculos() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_VEICULO");

			ResultSet result = stmt.executeQuery();

			ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

			while (result.next())
				veiculos.add(new Veiculo(result));

			return veiculos;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int Incluir(Veiculo veiculo) {
		try {

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO TB_VEICULO "
					+ "(COD_CLIENTE, COD_MARCA, DESC_MODELO, DATA_CONSERTO, ANO_FABRICADO, ANO_MODELO)"
					+ "VALUES (?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, veiculo.getCliente().getCodigo());
			stmt.setInt(2, veiculo.getMarca().getCodigo());
			stmt.setString(3, veiculo.getModelo());
			stmt.setString(4, veiculo.getConserto());
			stmt.setInt(5, veiculo.getAnoFabricado());
			stmt.setInt(6, veiculo.getAnoModelo());

			stmt.executeUpdate();

			stmt = connection.prepareStatement("SELECT MAX(COD_VEICULO) FROM TB_VEICULO");

			ResultSet rs = (stmt.executeQuery());

			rs.next();

			return rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int Alterar(Veiculo veiculo) {
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE TB_VEICULO SET " + "COD_CLIENTE = ?, COD_MARCA = ?, DESC_MODELO = ?, DATA_CONSERTO = ?, "
							+ "ANO_FABRICADO = ?, ANO_MODELO = ? WHERE COD_VEICULO = ?");

			stmt.setInt(1, veiculo.getCliente().getCodigo());
			stmt.setInt(2, veiculo.getMarca().getCodigo());
			stmt.setString(3, veiculo.getModelo());
			stmt.setString(4, veiculo.getConserto());
			stmt.setInt(5, veiculo.getAnoFabricado());
			stmt.setInt(6, veiculo.getAnoModelo());
			stmt.setInt(7, veiculo.getCodigo());

			return stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int Excluir(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE TB_VEICULO WHERE COD_VEICULO = ?");

			stmt.setInt(1, codigo);

			return stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
}
