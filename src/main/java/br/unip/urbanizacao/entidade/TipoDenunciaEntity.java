package br.unip.urbanizacao.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tipodenuncia")
@NamedQueries({
		@NamedQuery(
				name = TipoDenunciaEntity.LISTAR,
				query = "SELECT td FROM TipoDenunciaEntity td")
})
public class TipoDenunciaEntity {

	public final static String LISTAR = "TipoDenunciaEntity.listar";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@Column(name = "descricao", unique = true, nullable = false)
	private String descricao;

	public TipoDenunciaEntity() {
		super();
	}

	public TipoDenunciaEntity(final String descricao) {
		super();
		this.descricao = descricao;
	}

	public TipoDenunciaEntity(final long codigo, final String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(final long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (this.codigo ^ this.codigo >>> 32);
		result = prime * result
				+ (this.descricao == null ? 0 : this.descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final TipoDenunciaEntity other = (TipoDenunciaEntity) obj;
		if (this.codigo != other.codigo) {
			return false;
		}
		if (this.descricao == null) {
			if (other.descricao != null) {
				return false;
			}
		} else if (!this.descricao.equals(other.descricao)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TipoDenuncia [codigo=" + this.codigo + ", descricao="
				+ this.descricao + "]";
	}

}
