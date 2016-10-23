package br.unip.urbanizacao.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.unip.urbanizacao.entidade.DenunciaEntity;

public class DenunciaDAO extends AbstractDAO<DenunciaEntity, Long> {

	public DenunciaDAO(final EntityManager manager) {
		super(manager);
	}

	public List<DenunciaEntity> list() {
		return this.manager
				.createNamedQuery(DenunciaEntity.LISTAR, DenunciaEntity.class)
				.getResultList();
	}
}
