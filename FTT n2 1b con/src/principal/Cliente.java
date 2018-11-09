package principal;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private String email;
	private String celular;
	private String telefone;
	private Date dataNascimento;
	
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Cliente(ResultSet result) {
		try {
			
			setCodigo(result.getInt("COD_CLIENTE"));
			setNome(result.getString("NOME_CLIENTE"));
			setEmail(result.getString("EMAIL_CLIENTE"));
			setCelular(result.getString("CELULAR_CLIENTE"));
			setTelefone(result.getString("TELEFONE_CLIENTE"));
			setDataNascimento(result.getDate("DATA_NASC_CLIENTE"));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Cliente() {
		
	}
}
