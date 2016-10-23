package br.unip.urbanizacao.dao;

import javax.persistence.EntityManager;

import br.unip.urbanizacao.entidade.LocalizacaoEntity;

public class LocalizacaoDAO extends AbstractDAO<LocalizacaoEntity, Long> {

	public LocalizacaoDAO(final EntityManager manager) {
		super(manager);
	}
}
