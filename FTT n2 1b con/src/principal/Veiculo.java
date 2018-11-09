package principal;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private Cliente cliente;
	private Marca marca;
	private String modelo;
	private Date conserto;
	private int anoFabricado;
	private int anoModelo;

	public Veiculo() {

	}

	public Veiculo(ResultSet result) {
		try {
			setCodigo(result.getInt("COD_VEICULO"));
			setCliente((new ClienteDAO()).PesquisarCodigo(result.getInt("COD_CLIENTE")));
			setMarca((new MarcaDAO()).PesquisarCodigo(result.getInt("COD_MARCA")));
			setModelo(result.getString("DESC_MODELO"));
			setConserto(result.getDate("DATA_CONSERTO"));
			setAnoFabricado(result.getInt("ANO_FABRICADO"));
			setAnoModelo(result.getInt("ANO_MODELO"));
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getConserto() {
		return conserto;
	}

	public void setConserto(Date conserto) {
		this.conserto = conserto;
	}

	public int getAnoFabricado() {
		return anoFabricado;
	}

	public void setAnoFabricado(int anoFabricado) {
		this.anoFabricado = anoFabricado;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

}
