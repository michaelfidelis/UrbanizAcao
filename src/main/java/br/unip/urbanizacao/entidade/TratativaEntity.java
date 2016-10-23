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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tratativa")
@NamedQueries({
	@NamedQuery(name = TratativaEntity.OBTER_POR_DENUNCIA,
				query = "SELECT t FROM TratativaEntity t WHERE t.denuncia.codigo = :denuncia")
})
public class TratativaEntity {

	public static final String OBTER_POR_DENUNCIA = "TratativaEntity.obterPorDenuncia";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "denuncia_fk")
	private DenunciaEntity denuncia;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "responsavel", nullable = false)
	private String responsavel;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable = false)
	private Calendar data;

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
	}

	public DenunciaEntity getDenuncia() {
		return this.denuncia;
	}

	public void setDenuncia(final DenunciaEntity denuncia) {
		this.denuncia = denuncia;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(final String responsavel) {
		this.responsavel = responsavel;
	}

	public Calendar getData() {
		return this.data;
	}

	public void setData(final Calendar data) {
		this.data = data;
	}

}
