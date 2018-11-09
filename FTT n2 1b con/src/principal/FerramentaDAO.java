package principal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FerramentaDAO {
	
	private Connection connection;

	public FerramentaDAO() {
		connection = DbUtil.getConnection();
	}
	

	public Ferramenta PesquisarNome(String nome) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM TB_FERRMENTA WHERE NOME_FERRAMENTA LIKE '%?%'");

			stmt.setString(1, nome);

			ResultSet result = stmt.executeQuery();

			result.next();

			Ferramenta aux = new Ferramenta(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Ferramenta PesquisarCodigo(int codigo) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM TB_FERRAMENTA WHERE COD_FERRAMENTA = ?");

			stmt.setInt(1, codigo);

			ResultSet result = stmt.executeQuery();

			result.next();

			Ferramenta aux = new Ferramenta(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Ferramenta> BuscarFerramentas() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_FERRAMENTA");

			ResultSet result = stmt.executeQuery();

			ArrayList<Ferramenta> ferramentas = new ArrayList<Ferramenta>();

			while (result.next())
				ferramentas.add(new Ferramenta(result));

			return ferramentas;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean Incluir(Ferramenta ferramenta) {
		try {
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO TB_FERRAMENTA "
					+ "(COD_FORNECEDOR, NOME_FERRAMENTA, DATA_COMPRADA, "
					+ "GARANTIA_FERRAMENTA, VALOR_FERRAMENTA, MARCA_FERRAMENTA) "
					+ "VALUES (?, '?' , '?', ?, ?, '?')");
			
			//stmt.setInt(1, ferramenta.getCodigo());
			stmt.setInt(1, ferramenta.getFornecedor().getCodigo());
			stmt.setString(2, ferramenta.getNome());
			stmt.setDate(3, (Date) ferramenta.getDataComprada());
			stmt.setDouble(4, ferramenta.getGarantia());
			stmt.setDouble(5, ferramenta.getValor());
			stmt.setString(6, ferramenta.getMarca());
			
			return stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean Alterar(Ferramenta ferramenta) {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE TB_FERRAMENTA SET "
					+ "COD_FORNECEDOR = ?, NOME_FERRAMENTA = '?', DATA_COMPRADA = '?', "
					+ "GARANTIA_FERRAMENTA = ?, VALOR_FERRAMENTA = ?, MARCA_FERRAMENTA = '?' "
					+ "WHERE COD_FERRAMENTA = ?");

			stmt.setInt(1, ferramenta.getFornecedor().getCodigo());
			stmt.setString(2, ferramenta.getNome());
			stmt.setDate(3, (Date) ferramenta.getDataComprada());
			stmt.setDouble(4, ferramenta.getGarantia());
			stmt.setDouble(5, ferramenta.getValor());
			stmt.setString(6, ferramenta.getMarca());
			stmt.setInt(7, ferramenta.getCodigo());
			
			return stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean Excluir(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE TB_FERRAMENTA WHERE COD_FERRAMENTA = ?");

			stmt.setInt(1, codigo);
			
			return stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
