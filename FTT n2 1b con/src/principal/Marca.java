package principal;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Marca implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigo;
	private String descricao;

	public Marca(ResultSet result) {
		try {
			setCodigo(result.getInt("COD_MARCA"));
			setDescricao(result.getString("DESC_MARCA"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Marca() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
