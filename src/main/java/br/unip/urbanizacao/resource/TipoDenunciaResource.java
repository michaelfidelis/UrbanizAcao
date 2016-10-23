package br.unip.urbanizacao.resource;

import br.unip.urbanizacao.entidade.TipoDenunciaEntity;

public class TipoDenunciaResource {

	private long codigo;

	private String descricao;

	public TipoDenunciaResource() {
		super();
	}

	public TipoDenunciaResource(final TipoDenunciaEntity entity) {
		this.codigo = entity.getCodigo();
		this.descricao = entity.getDescricao();
	}

	public TipoDenunciaResource(final long codigo, final String descricao) {
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
		final TipoDenunciaResource other = (TipoDenunciaResource) obj;
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
