package principal;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;

public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private Cliente cliente;
	private Marca marca;
	private String modelo;
	private String conserto;
	private int anoFabricado;
	private int anoModelo;

	private final SimpleStringProperty clienteC;
	private final SimpleStringProperty marcaC;
	private final SimpleStringProperty modeloC;
	private final SimpleStringProperty consertoC;
	private final SimpleStringProperty anoFabricadoC;
	private final SimpleStringProperty anoModeloC;

	public Veiculo(String clienteC, String marcaC, String modeloC, String consertoC, String anoFabricadoC,
			String anoModeloC) {
		this.clienteC = new SimpleStringProperty(clienteC);
		this.marcaC = new SimpleStringProperty(marcaC);
		this.modeloC = new SimpleStringProperty(modeloC);
		this.consertoC = new SimpleStringProperty(consertoC);
		this.anoFabricadoC = new SimpleStringProperty(anoFabricadoC);
		this.anoModeloC = new SimpleStringProperty(anoModeloC);
	}

	public Veiculo() {
		this.clienteC = new SimpleStringProperty("");
		this.marcaC = new SimpleStringProperty("");
		this.modeloC = new SimpleStringProperty("");
		this.consertoC = new SimpleStringProperty("");
		this.anoFabricadoC = new SimpleStringProperty("");
		this.anoModeloC = new SimpleStringProperty("");
	}

	public Veiculo(ResultSet result) {
		try {
			setCodigo(result.getInt("COD_VEICULO"));
			setCliente((new ClienteDAO()).PesquisarCodigo(result.getInt("COD_CLIENTE")));
			setMarca((new MarcaDAO()).PesquisarCodigo(result.getInt("COD_MARCA")));
			setModelo(result.getString("DESC_MODELO"));
			setConserto(result.getString("DATA_CONSERTO"));
			setAnoFabricado(result.getInt("ANO_FABRICADO"));
			setAnoModelo(result.getInt("ANO_MODELO"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.clienteC = new SimpleStringProperty(getCliente().getNome());
		this.marcaC = new SimpleStringProperty(getMarca().getDescricao());
		this.modeloC = new SimpleStringProperty(getModelo());
		this.consertoC = new SimpleStringProperty(getConserto());
		this.anoFabricadoC = new SimpleStringProperty(String.valueOf(getAnoFabricado()));
		this.anoModeloC = new SimpleStringProperty(String.valueOf(getAnoModelo()));
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
	
	public String getNomeClienteC() {
		return clienteC.get();
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Marca getMarca() {
		return marca;
	}
	
	public String getMarcaC() {
		return marcaC.get();
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}
	
	public String getModeloC() {
		return modeloC.get();
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getConserto() {
		return conserto;
	}
	
	public String getConsertoC() {
		return consertoC.get();
	}

	public void setConserto(String conserto) {
		this.conserto = conserto;
	}

	public int getAnoFabricado() {
		return anoFabricado;
	}
	
	public String getAnoFabricadoC() {
		return anoFabricadoC.get();
	}

	public void setAnoFabricado(int anoFabricado) {
		this.anoFabricado = anoFabricado;
	}

	public int getAnoModelo() {
		return anoModelo;
	}
	
	public String getAnoModeloC() {
		return anoModeloC.get();
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

}
