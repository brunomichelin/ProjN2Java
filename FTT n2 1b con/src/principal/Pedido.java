package principal;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private Date dataPedido;
	private Date dataFinalizado;
	private double custo;
	private double valor;
	private double horas;
	private boolean pago;
	private Cliente cliente;
	private Veiculo veiculo;
	private Servico[] servicos;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Date getDataPedido() {
		return dataPedido;
	}
	
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	public Date getDataFinalizado() {
		return dataFinalizado;
	}
	
	public void setDataFinalizado(Date dataFinalizado) {
		this.dataFinalizado = dataFinalizado;
	}
	
	public double getCusto() {
		return custo;
	}
	
	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getHoras() {
		return horas;
	}
	
	public void setHoras(double horas) {
		this.horas = horas;
	}
	
	public boolean isPago() {
		return pago;
	}
	
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Servico[] getServicos() {
		return servicos;
	}

	public void setServicos(Servico[] servicos) {
		this.servicos = servicos;
	}
	
	
}
