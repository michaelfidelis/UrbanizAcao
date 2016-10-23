package br.unip.urbanizacao.resource;

import br.unip.urbanizacao.entidade.LocalizacaoEntity;

public class LocalizacaoResouce {

	private String logradouro;
	private String bairro;
	private long numero;
	private String complemento;
	private String cidade;
	private String estado;
	private String pontoReferencia;
	private double latitude;
	private double longitude;

	public LocalizacaoResouce() {
		super();
	}

	public LocalizacaoResouce(final LocalizacaoEntity entity) {
		this.logradouro = entity.getLogradouro();
		this.bairro = entity.getBairro();
		this.numero = entity.getNumero();
		this.complemento = entity.getComplemento();
		this.pontoReferencia = entity.getPontoReferencia();
		this.latitude = entity.getLatitude();
		this.longitude = entity.getLongitude();
		this.cidade = entity.getCidade();
		this.estado = entity.getEstado();
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(final String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(final String bairro) {
		this.bairro = bairro;
	}

	public long getNumero() {
		return this.numero;
	}

	public void setNumero(final long numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(final String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(final String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}

	public String getPontoReferencia() {
		return this.pontoReferencia;
	}

	public void setPontoReferencia(final String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(final double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(final double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Localizacao [logradouro=" + this.logradouro + ", numero="
				+ this.numero + ", complemento=" + this.complemento + "]";
	}

}
