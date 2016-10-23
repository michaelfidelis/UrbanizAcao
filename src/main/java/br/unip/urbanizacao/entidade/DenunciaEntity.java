package br.unip.urbanizacao.entidade;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "denuncia")
@NamedQueries({
		@NamedQuery(
				name = DenunciaEntity.LISTAR,
				query = "SELECT d FROM DenunciaEntity d")
})
public class DenunciaEntity {

	public final static String LISTAR = "DenunciaEntity.listar";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@Column(name = "delator", nullable = true)
	private String delator;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "tipodenuncia_fk")
	private TipoDenunciaEntity tipo;

	@ManyToOne
	@JoinColumn(name = "localizacao_fk")
	private LocalizacaoEntity localizacao;

	@Column(name = "data", nullable = false)
	private Calendar data;

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(final long codigo) {
		this.codigo = codigo;
	}

	public String getDelator() {
		return this.delator;
	}

	public void setDelator(final String delator) {
		this.delator = delator;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public TipoDenunciaEntity getTipo() {
		return this.tipo;
	}

	public void setTipo(final TipoDenunciaEntity tipo) {
		this.tipo = tipo;
	}

	public Calendar getData() {
		return this.data;
	}

	public void setData(final Calendar data) {
		this.data = data;
	}

	public LocalizacaoEntity getLocalizacao() {
		return this.localizacao;
	}

	public void setLocalizacao(final LocalizacaoEntity localizacao) {
		this.localizacao = localizacao;
	}

	@Override
	public String toString() {
		return "Denuncia [codigo=" + this.codigo + ", descricao="
				+ this.descricao + ", tipo=" + this.tipo + ", data="
				+ this.data + "]";
	}

}
