package br.unip.urbanizacao.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.unip.urbanizacao.entidade.TipoDenunciaEntity;

public class TipoDenunciaDAO extends AbstractDAO<TipoDenunciaEntity, Long> {

	public TipoDenunciaDAO(final EntityManager manager) {
		super(manager);
	}

	public List<TipoDenunciaEntity> list() {
		return this.manager
				.createNamedQuery(TipoDenunciaEntity.LISTAR, TipoDenunciaEntity.class)
				.getResultList();
	}
}
