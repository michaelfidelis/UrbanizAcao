package br.unip.urbanizacao.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.unip.urbanizacao.dao.TratativaDAO;
import br.unip.urbanizacao.entidade.TratativaEntity;
import br.unip.urbanizacao.exception.APIException;
import br.unip.urbanizacao.provider.EMProvider;
import br.unip.urbanizacao.resource.TratativaResource;

public class TratativaBusiness {

	private final EntityManager manager;
	private final TratativaDAO tratativaDAO;

	public TratativaBusiness() {
		this.manager = EMProvider.getEntityManager();
		this.tratativaDAO = new TratativaDAO(this.manager);
	}

	public List<TratativaResource> obterTratativas(final Long denuncia) throws APIException {
		try {
			final List<TratativaResource> tratativasResource = new ArrayList<TratativaResource>();
			for (final TratativaEntity tratativa : this.tratativaDAO.obterPorDenuncia(denuncia)) {
				tratativasResource.add(new TratativaResource(tratativa));
			}
			return tratativasResource;
		} catch (final PersistenceException e) {
			throw new APIException("Erro ao listar as tratativas por denúncia.", e);
		}
	}

}
