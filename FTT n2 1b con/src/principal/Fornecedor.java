package principal;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private String email;
	private String celular;
	private String telefone;
	private String cnpj;
	private Pais pais;
	private String cidade;
	private String estado;
	private String bairro;
	private String endereco;
	private int numero;
	
	public Fornecedor(ResultSet result) {
		try {
			setCodigo(result.getInt("COD_FONECEDOR"));
			setNome(result.getString("NOME_FORNECEDOR"));
			setEmail(result.getString("EMAIL_FORNECEDOR"));
			setCnpj(result.getString("CNPJ_FORNECEDOR"));
			setCelular(result.getString("CELULAR_FORNECEDOR"));
			setTelefone(result.getString("TELEFONE_FORNECEDOR"));
			setPais((new PaisDAO()).PesquisarCodigo(result.getInt("COD_PAIS")));
			setCidade(result.getString("CIDADE_FORNECEDOR"));
			setEstado(result.getString("ESTADO_FORNECEDOR"));
			setBairro(result.getString("BAIRRO_FORNECEDOR"));
			setEndereco(result.getString("ENDERECO_FORNECEDOR"));
			setNumero(result.getInt("NUMERO_END_FORNECEDOR"));	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Fornecedor() {
		
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
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Pais getPais() {
		return pais;
	}
	
	public void setPais(Pais pais) {
		this.pais = pais;
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
	
	
}
