package principal;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private String email;
	private String celular;
	private String telefone;
	private Date dataNascimento;
	private String cpf;
	private String cidade;
	private String estado;
	private String bairro;
	private String endereco;
	private int numero;
	private double salario;
	
	public Funcionario(ResultSet result) {
		try {
			setCodigo(result.getInt("COD_FUNCIONARIO"));
			setNome(result.getString("NOME_FUNCIONARIO"));
			setEmail(result.getString("EMAIL_FUNCIONARIO"));
			setCpf(result.getString("CPF_FUNCIONARIO"));
			setCelular(result.getString("CELULAR_FUNCIONARIO"));
			setTelefone(result.getString("TELEFONE_FUNCIONARIO"));
			setDataNascimento(result.getDate("DATA_NASC_FUNCIONARIO"));
			setCidade(result.getString("CIDADE_FUNCIONARIO"));
			setEstado(result.getString("ESTADO_FUNCIONARIO"));
			setBairro(result.getString("BAIRRO_FUNCIONARIO"));
			setEndereco(result.getString("ENDERECO_FUNCIONARIO"));
			setNumero(result.getInt("NUMERO_END_FUNCIONARIO"));
			setSalario(result.getDouble("SALARIO_FUNCIONARIO"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Funcionario() {
		
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
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
	
}
