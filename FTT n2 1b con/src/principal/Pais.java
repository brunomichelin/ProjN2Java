package principal;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	
	public Pais(ResultSet result) {
		try {
			setCodigo(result.getInt("COD_PAIS"));
			setNome(result.getString("DESC_PAIS"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Pais() {
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
