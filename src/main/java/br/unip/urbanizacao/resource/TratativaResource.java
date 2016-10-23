package br.unip.urbanizacao.resource;

import java.util.Calendar;

import br.unip.urbanizacao.entidade.TratativaEntity;

public class TratativaResource {

	private Long codigo;

	private DenunciaResource denuncia;

	private String descricao;

	private String responsavel;

	private Calendar data;

	public TratativaResource() {
		super();
	}

	public TratativaResource(final TratativaEntity entity) {
		this.codigo = entity.getCodigo();
		this.descricao = entity.getDescricao();
		this.responsavel = entity.getResponsavel();
		this.data = entity.getData();
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
	}

	public DenunciaResource getDenuncia() {
		return this.denuncia;
	}

	public void setDenuncia(final DenunciaResource denuncia) {
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
