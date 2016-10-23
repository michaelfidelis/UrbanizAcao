package br.unip.urbanizacao.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.unip.urbanizacao.dao.TipoDenunciaDAO;
import br.unip.urbanizacao.entidade.TipoDenunciaEntity;
import br.unip.urbanizacao.exception.APIException;
import br.unip.urbanizacao.provider.EMProvider;
import br.unip.urbanizacao.resource.TipoDenunciaResource;

public class TipoDenunciaBusiness {

	private final EntityManager manager;
	private final TipoDenunciaDAO tipoDenunciaDAO;

	public TipoDenunciaBusiness() {
		this.manager = EMProvider.getEntityManager();
		this.tipoDenunciaDAO = new TipoDenunciaDAO(this.manager);
	}

	public List<TipoDenunciaResource> listarTiposDenuncia() throws APIException {
		try {
			final List<TipoDenunciaResource> tiposDenunciaResource = new ArrayList<TipoDenunciaResource>();
			for (final TipoDenunciaEntity tipoDenuncia : this.tipoDenunciaDAO.list()) {
				tiposDenunciaResource.add(new TipoDenunciaResource(tipoDenuncia));
			}
			return tiposDenunciaResource;
		} catch (final PersistenceException e) {
			throw new APIException("Erro ao listar tipos de denúncias.", e);
		}
	}

	public TipoDenunciaResource obterPorCodigo(final Long codigo) throws APIException {
		try {
			final TipoDenunciaEntity tipoDenuncia = this.tipoDenunciaDAO.find(TipoDenunciaEntity.class, codigo);

			if (tipoDenuncia == null) {
				throw new APIException("Não encontrado", 404);
			}

			return new TipoDenunciaResource(tipoDenuncia);
		} catch (final PersistenceException e) {
			throw new APIException("Erro ao obter tipo de denúncia por código.", e);
		}
	}
}
