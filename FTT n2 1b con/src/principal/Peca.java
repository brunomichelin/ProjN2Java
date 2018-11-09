package principal;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Peca implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private Fornecedor fornecedor;
	private String nome;
	private Date dataComprada;
	private double garantia;
	private double valor;
	private String marca;

	public Peca() {

	}

	public Peca(ResultSet result) {
		try {
			setCodigo(result.getInt("COD_PECA"));
			setFornecedor((new FornecedorDAO()).PesquisarCodigo(result.getInt("COD_FORNECEDOR")));
			setNome(result.getString("NOME_PECA"));
			setDataComprada(result.getDate("DATA_COMPRADA"));
			setGarantia(result.getDouble("GARANTIA_PECA"));
			setValor(result.getDouble("VALOR_PECA"));
			setMarca(result.getString("MARCA_PECA"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataComprada() {
		return dataComprada;
	}

	public void setDataComprada(Date dataComprada) {
		this.dataComprada = dataComprada;
	}

	public double getGarantia() {
		return garantia;
	}

	public void setGarantia(double garantia) {
		this.garantia = garantia;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
