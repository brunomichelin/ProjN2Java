package principal;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private String nome;
	private String email;
	private String celular;
	private String telefone;
	private String dataNascimento;

	private final SimpleStringProperty nomeC;
	private final SimpleStringProperty emailC;
	private final SimpleStringProperty celularC;
	private final SimpleStringProperty telefoneC;
	private final SimpleStringProperty dataNascimentoC;

	public Cliente(String nomeC, String emailC, String celularC, String telefoneC, String dataNascimentoC) {
		this.nomeC = new SimpleStringProperty(nomeC);
		this.emailC = new SimpleStringProperty(emailC);
		this.celularC = new SimpleStringProperty(celularC);
		this.telefoneC = new SimpleStringProperty(telefoneC);
		this.dataNascimentoC = new SimpleStringProperty(dataNascimentoC);
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

	public String getNomeC() {
		return nomeC.get();
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	
	public String getEmailC() {
		return emailC.get();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}
	
	public String getCelularC() {
		return celularC.get();
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public String getTelefoneC() {
		return telefoneC.get();
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public String getDataNascimentoC() {
		return dataNascimentoC.get();
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Cliente(ResultSet result) {
		
		try {
			setCodigo(result.getInt("COD_CLIENTE"));
			setNome(result.getString("NOME_CLIENTE"));
			setEmail(result.getString("EMAIL_CLIENTE"));
			setCelular(result.getString("CELULAR_CLIENTE"));
			setTelefone(result.getString("TELEFONE_CLIENTE"));
			setDataNascimento(result.getString("DATA_NASC_CLIENTE"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.nomeC = new SimpleStringProperty(getNome());
		this.emailC = new SimpleStringProperty(getEmail());
		this.celularC = new SimpleStringProperty(getCelular());
		this.telefoneC = new SimpleStringProperty(getTelefone());
		this.dataNascimentoC = new SimpleStringProperty(getDataNascimento().toString());
	}

	public Cliente() {
		this.nomeC = new SimpleStringProperty("");
		this.emailC = new SimpleStringProperty("");
		this.celularC = new SimpleStringProperty("");
		this.telefoneC = new SimpleStringProperty("");
		this.dataNascimentoC = new SimpleStringProperty("");
	}
}
