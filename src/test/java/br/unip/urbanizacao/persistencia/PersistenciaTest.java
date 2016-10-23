package br.unip.urbanizacao.persistencia;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import br.unip.urbanizacao.entidade.DenunciaEntity;
import br.unip.urbanizacao.entidade.LocalizacaoEntity;
import br.unip.urbanizacao.entidade.TipoDenunciaEntity;
import br.unip.urbanizacao.provider.EMProvider;

public class PersistenciaTest {

	private EntityManager entityManager;

	@Before
	public void before() {
		this.entityManager = EMProvider.getEntityManager();
	}

	public void insereTipos() {
		this.entityManager.getTransaction().begin();

		this.entityManager.persist(new TipoDenunciaEntity("Desmatamento"));
		this.entityManager.persist(new TipoDenunciaEntity(
				"Descarte indevido de lixo"));
		this.entityManager.persist(new TipoDenunciaEntity(
				"Falta de saneamento básico"));
		this.entityManager.persist(new TipoDenunciaEntity(
				"Falta de cestos de lixo em vias publicas"));

		this.entityManager.getTransaction().commit();

		final List<TipoDenunciaEntity> tiposDenuncia = this.entityManager
				.createQuery("SELECT td FROM TipoDenunciaEntity td",
						TipoDenunciaEntity.class).getResultList();

		for (final TipoDenunciaEntity tipoDenunciaEntity : tiposDenuncia) {
			System.out.println(tipoDenunciaEntity);
		}
	}

	public void insereLocalizacao() {
		this.entityManager.getTransaction().begin();
		final LocalizacaoEntity localizacao = new LocalizacaoEntity();
		localizacao.setLogradouro("Rua Joao Esparza");
		localizacao.setNumero(4);
		localizacao.setComplemento("B");
		localizacao.setPontoReferencia("Creche Clementino");
		localizacao.setBairro("Jardim Ipanema");
		this.entityManager.persist(localizacao);
		this.entityManager.getTransaction().commit();

		final List<LocalizacaoEntity> tiposDenuncia = this.entityManager
				.createQuery("SELECT l FROM LocalizacaoEntity l",
						LocalizacaoEntity.class).getResultList();

		for (final LocalizacaoEntity localizacaoEntity : tiposDenuncia) {
			System.out.println(localizacaoEntity);
		}
	}

	@Test
	public void testaInsercaoDenuncia() {
		try {

			final TipoDenunciaEntity tipo = this.entityManager.find(
					TipoDenunciaEntity.class, 1L);

			final LocalizacaoEntity localizacao = this.entityManager.find(
					LocalizacaoEntity.class, 1L);

			System.out.println("TipoEncontrado: " + tipo);
			this.entityManager.getTransaction().begin();

			final DenunciaEntity denuncia = new DenunciaEntity();
			denuncia.setData(Calendar.getInstance());
			denuncia.setDescricao("Lixo jogado na calçada");

			denuncia.setTipo(tipo);
			denuncia.setLocalizacao(localizacao);
			this.entityManager.persist(denuncia);
			this.entityManager.getTransaction().commit();

			final List<DenunciaEntity> denuncias = this.entityManager
					.createQuery("SELECT d FROM DenunciaEntity d",
							DenunciaEntity.class).getResultList();

			for (final DenunciaEntity denunciaEncontrada : denuncias) {
				System.out.println(denunciaEncontrada);
			}
		} catch (final Exception e) {
			this.entityManager.getTransaction().rollback();
			e.printStackTrace();

		}
	}

}
