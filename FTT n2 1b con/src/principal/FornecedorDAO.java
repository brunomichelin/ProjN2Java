package principal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FornecedorDAO {
	
	private Connection connection;
	
	public FornecedorDAO () {
		connection = DbUtil.getConnection();
	}
	
	public Fornecedor PesquisarCodigo(int codigo) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM TB_FORNECEDOR WHERE COD_FORNECEDOR = ?");

			stmt.setInt(1, codigo);

			ResultSet result = stmt.executeQuery();

			result.next();

			Fornecedor aux = new Fornecedor(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Fornecedor PesquisarNome(String nome) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM TB_FORNECEDOR WHERE NOME_FORNECEDOR LIKE '%?%'");

			stmt.setString(1, nome);

			ResultSet result = stmt.executeQuery();

			result.next();

			Fornecedor aux = new Fornecedor(result);

			return aux;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public ArrayList<Fornecedor> BuscarFornecedores() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TB_FORNECEDOR");

			ResultSet result = stmt.executeQuery();

			ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

			while (result.next())
				fornecedores.add(new Fornecedor(result));

			return fornecedores;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean Incluir(Fornecedor fornecedor) {
		try {
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO TB_FORNECEDOR "
					+ "(NOME_FORNECEDOR, EMAIL_FORNECEDOR, CNPJ_FORNECEDOR, CELULAR_FORNECEDOR, "
					+ "TELEFONE_FORNECEDOR, COD_PAIS, CIDADE_FORNECEDOR, ESTADO_FORNECEDOR, "
					+ "BAIRRO_FORNECEDOR, ENDERECO_FORNECEDOR, NUMERO_END_FORNECEDOR) "
					+ "VALUES ('?', '?', '?' , '?', '?', ?, '?', '?', '?', '?', ?)");
			
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getEmail());
			stmt.setString(3, fornecedor.getCnpj());
			stmt.setString(4, fornecedor.getCelular());
			stmt.setString(5, fornecedor.getTelefone());
			stmt.setInt(6, fornecedor.getPais().getCodigo());
			stmt.setString(7, fornecedor.getCidade());
			stmt.setString(8, fornecedor.getEstado());
			stmt.setString(9, fornecedor.getBairro());
			stmt.setString(10, fornecedor.getEndereco());
			stmt.setInt(11, fornecedor.getNumero());
			
			return stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean Alterar(Fornecedor fornecedor) {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE TB_FORNECEDOR SET "
					+ "NOME_FORNECEDOR = '?', EMAIL_FORNECEDOR = '?', CNPJ_FORNECEDOR = '?', "
					+ "CELULAR_FORNECEDOR = '?', TELEFONE_FORNECEDOR = '?', COD_PAIS = ?, "
					+ "CIDADE_FORNECEDOR = '?', ESTADO_FORNECEDOR = '?', BAIRRO_FORNECEDOR = '?', "
					+ "ENDERECO_FORNECEDOR = '?', NUMERO_END_FORNECEDOR = ?"
					+ "WHERE COD_FORNECEDOR = ?");
			
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getEmail());
			stmt.setString(3, fornecedor.getCnpj());
			stmt.setString(4, fornecedor.getCelular());
			stmt.setString(5, fornecedor.getTelefone());
			stmt.setInt(6, fornecedor.getPais().getCodigo());
			stmt.setString(7, fornecedor.getCidade());
			stmt.setString(8, fornecedor.getEstado());
			stmt.setString(9, fornecedor.getBairro());
			stmt.setString(10, fornecedor.getEndereco());
			stmt.setInt(11, fornecedor.getNumero());
			stmt.setInt(12, fornecedor.getCodigo());
			
			return stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean Excluir(int codigo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE TB_FORNECEDOR WHERE COD_FORNECEDOR = ?");

			stmt.setInt(1, codigo);
			
			return stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
