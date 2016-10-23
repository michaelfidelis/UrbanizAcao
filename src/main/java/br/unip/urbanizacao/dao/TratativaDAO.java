package br.unip.urbanizacao.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.unip.urbanizacao.entidade.DenunciaEntity;
import br.unip.urbanizacao.entidade.TratativaEntity;

public class TratativaDAO extends AbstractDAO<DenunciaEntity, Long> {

	public TratativaDAO(final EntityManager manager) {
		super(manager);
	}

	public List<TratativaEntity> obterPorDenuncia(final Long denuncia) {
		return this.manager
				.createNamedQuery(TratativaEntity.OBTER_POR_DENUNCIA, TratativaEntity.class)
				.setParameter("denuncia", denuncia)
				.getResultList();
	}
}
