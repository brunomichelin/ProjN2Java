package principal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {
		connection = DbUtil.getConnection();
	}

	public Cliente PesquisarNome(String nome) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM TB_CLIENTE WHERE NOME_CLIENTE LIKE '%?%'");

			stmt.setString(1, nome);

			ResultSet result = stmt.executeQuery();

			result.next();

			Cliente aux = new Cliente(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Cliente PesquisarCodigo(int codigo) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM TB_CLIENTE WHERE COD_CLIENTE = ?");

			stmt.setInt(1, codigo);

			ResultSet result = stmt.executeQuery();

			result.next();

			Cliente aux = new Cliente(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Cliente> BuscarClientes() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_CLIENTE");

			ResultSet result = stmt.executeQuery();

			ArrayList<Cliente> clientes = new ArrayList<Cliente>();

			while (result.next())
				clientes.add(new Cliente(result));

			return clientes;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean Incluir(Cliente cliente) {
		try {
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO TB_CLIENTE "
					+ "(NOME_CLIENTE, EMAIL_CLIENTE, CELULAR_CLIENTE, TELEFONE_CLIENTE, DATA_NASC_CLIENTE) "
					+ "VALUES ('?', '?' , '?', '?', '?')");
			
			//stmt.setInt(1, cliente.getCodigo());
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getCelular());
			stmt.setString(4, cliente.getTelefone());
			stmt.setDate(5, (Date) cliente.getDataNascimento());
			
			return stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean Alterar(Cliente cliente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE TB_CLIENTE SET "
					+ "NOME_CLIENTE = '?', EMAIL_CLIENTE = '?', CELULAR_CLIENTE = '?', "
					+ "TELEFONE_CLIENTE ='?', DATA_NASC_CLIENTE = '?' "
					+ "WHERE COD_CLIENTE = ?");
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getCelular());
			stmt.setString(4, cliente.getTelefone());
			stmt.setDate(5, (Date) cliente.getDataNascimento()); //Convert util for sql librarys.
			stmt.setInt(6, cliente.getCodigo());
			
			return stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean Excluir(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE TB_CLIENTE WHERE COD_CLIENTE = ?");

			stmt.setInt(1, codigo);
			
			return stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
