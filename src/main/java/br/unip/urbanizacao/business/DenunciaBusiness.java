package br.unip.urbanizacao.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.unip.urbanizacao.dao.DenunciaDAO;
import br.unip.urbanizacao.dao.LocalizacaoDAO;
import br.unip.urbanizacao.dao.TipoDenunciaDAO;
import br.unip.urbanizacao.dao.TratativaDAO;
import br.unip.urbanizacao.entidade.DenunciaEntity;
import br.unip.urbanizacao.entidade.LocalizacaoEntity;
import br.unip.urbanizacao.entidade.TipoDenunciaEntity;
import br.unip.urbanizacao.entidade.TratativaEntity;
import br.unip.urbanizacao.exception.APIException;
import br.unip.urbanizacao.provider.EMProvider;
import br.unip.urbanizacao.resource.DenunciaResource;
import br.unip.urbanizacao.resource.TratativaResource;

public class DenunciaBusiness {

	private final EntityManager manager;
	private final DenunciaDAO denunciaDAO;
	private final LocalizacaoDAO localizacaoDAO;
	private final TipoDenunciaDAO tipoDenunciaDAO;
	private final TratativaDAO tratativaDAO;

	public DenunciaBusiness() {
		this.manager = EMProvider.getEntityManager();
		this.denunciaDAO = new DenunciaDAO(this.manager);
		this.localizacaoDAO = new LocalizacaoDAO(this.manager);
		this.tipoDenunciaDAO = new TipoDenunciaDAO(this.manager);
		this.tratativaDAO = new TratativaDAO(this.manager);
	}

	public List<DenunciaResource> listarDenuncias() throws APIException {
		try {
			final List<DenunciaResource> denunciasResource = new ArrayList<DenunciaResource>();
			for (final DenunciaEntity denuncia : this.denunciaDAO.list()) {
				denunciasResource.add(new DenunciaResource(denuncia));
			}
			return denunciasResource;
		} catch (final PersistenceException e) {
			throw new APIException("Erro ao listar as denúncias.", e);
		}
	}

	public DenunciaResource obterPorCodigo(final Long codigo) throws APIException {
		try {
			final DenunciaEntity denuncia = this.denunciaDAO.find(DenunciaEntity.class, codigo);

			if (denuncia == null) {
				throw new APIException("Não encontrado", 404);
			}

			final DenunciaResource denunciaResource = new DenunciaResource(denuncia);

			final List<TratativaResource> tratativasResource = new ArrayList<TratativaResource>();
			for (final TratativaEntity tratativa : this.tratativaDAO.obterPorDenuncia(codigo)) {
				tratativasResource.add(new TratativaResource(tratativa));
			}
			denunciaResource.setTratativas(tratativasResource);
			return denunciaResource;
		} catch (final PersistenceException e) {
			throw new APIException("Erro ao obter denúncia por código.", e);
		}
	}

	public DenunciaResource salvarDenuncia(final DenunciaResource denunciaResource) throws APIException {
		try {

			final TipoDenunciaEntity tipoDenuncia = this.tipoDenunciaDAO.find(TipoDenunciaEntity.class,
					denunciaResource.getTipo().getCodigo());

			if (tipoDenuncia == null) {
				throw new APIException("Tipo denúncia não encontrado", 404);
			}

			final LocalizacaoEntity localizacao = new LocalizacaoEntity();
			localizacao.setLogradouro(denunciaResource.getLocalizacao().getLogradouro());
			localizacao.setNumero(denunciaResource.getLocalizacao().getNumero());
			localizacao.setComplemento(denunciaResource.getLocalizacao().getComplemento());
			localizacao.setBairro(denunciaResource.getLocalizacao().getBairro());
			localizacao.setPontoReferencia(denunciaResource.getLocalizacao().getPontoReferencia());
			localizacao.setLongitude(denunciaResource.getLocalizacao().getLongitude());
			localizacao.setLatitude(denunciaResource.getLocalizacao().getLatitude());
			localizacao.setCidade(denunciaResource.getLocalizacao().getCidade());
			localizacao.setEstado(denunciaResource.getLocalizacao().getEstado());
			this.localizacaoDAO.persist(localizacao);

			final DenunciaEntity denuncia = new DenunciaEntity();
			denuncia.setData(denunciaResource.getData());
			denuncia.setDelator(denunciaResource.getDelator());
			denuncia.setDescricao(denunciaResource.getDescricao());
			denuncia.setLocalizacao(localizacao);
			denuncia.setTipo(tipoDenuncia);
			this.denunciaDAO.persist(denuncia);

			return new DenunciaResource(denuncia);
		} catch (final PersistenceException e) {
			throw new APIException("Erro ao salvar denúncia.", e);
		}
	}
}
