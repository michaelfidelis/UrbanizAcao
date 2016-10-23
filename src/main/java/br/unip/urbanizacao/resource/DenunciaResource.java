package br.unip.urbanizacao.resource;

import java.util.Calendar;
import java.util.List;

import br.unip.urbanizacao.entidade.DenunciaEntity;

public class DenunciaResource {

	private long codigo;

	private String delator;

	private String descricao;

	private TipoDenunciaResource tipo;

	private LocalizacaoResouce localizacao;

	private Calendar data;

	private List<TratativaResource> tratativas;

	public DenunciaResource(final DenunciaEntity entity) {
		super();
		this.codigo = entity.getCodigo();
		this.delator = entity.getDelator();
		this.descricao = entity.getDescricao();
		this.tipo = new TipoDenunciaResource(entity.getTipo());
		this.localizacao = new LocalizacaoResouce(entity.getLocalizacao());
		this.data = entity.getData();
	}

	public DenunciaResource() {
		super();
	}

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

	public TipoDenunciaResource getTipo() {
		return this.tipo;
	}

	public void setTipo(final TipoDenunciaResource tipo) {
		this.tipo = tipo;
	}

	public LocalizacaoResouce getLocalizacao() {
		return this.localizacao;
	}

	public void setLocalizacao(final LocalizacaoResouce localizacao) {
		this.localizacao = localizacao;
	}

	public Calendar getData() {
		return this.data;
	}

	public void setData(final Calendar data) {
		this.data = data;
	}

	public List<TratativaResource> getTratativas() {
		return this.tratativas;
	}

	public void setTratativas(final List<TratativaResource> tratativas) {
		this.tratativas = tratativas;
	}

	@Override
	public String toString() {
		return "DenunciaResource [codigo=" + this.codigo + ", descricao="
				+ this.descricao + ", tipo=" + this.tipo + ", localizacao="
				+ this.localizacao + ", data=" + this.data + "]";
	}

}
