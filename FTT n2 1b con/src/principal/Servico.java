package principal;

import java.io.Serializable;

public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private double custo;
	private double valor;
	private double horas;
	private Funcionario[] funcionarios;
	private Ferramenta[] ferramentas;
	private Peca[] pecas;
	
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

	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario[] funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Ferramenta[] getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(Ferramenta[] ferramentas) {
		this.ferramentas = ferramentas;
	}

	public Peca[] getPecas() {
		return pecas;
	}

	public void setPecas(Peca[] pecas) {
		this.pecas = pecas;
	}
	
	
}
