package br.unip.urbanizacao.persistencia;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.unip.urbanizacao.entidade.DenunciaEntity;
import br.unip.urbanizacao.entidade.TipoDenunciaEntity;
import br.unip.urbanizacao.provider.EMProvider;

public class Main {

	private static EntityManager entityManager;

	public static void main(final String[] args) {
		entityManager = EMProvider.getEntityManager();

		entityManager.getTransaction().begin();
		final TipoDenunciaEntity tipo = new TipoDenunciaEntity("Desmatamento");
		entityManager.persist(tipo);

		System.out.println("TipoEncontrado: " + tipo);

		final DenunciaEntity denuncia = new DenunciaEntity();
		denuncia.setData(Calendar.getInstance());
		denuncia.setDescricao("Lixo jogado na calçada");
		denuncia.setTipo(tipo);

		entityManager.persist(denuncia);
		entityManager.getTransaction().commit();

		final List<DenunciaEntity> denuncias = entityManager.createQuery(
				"SELECT d FROM DenunciaEntity d", DenunciaEntity.class)
				.getResultList();

		for (final DenunciaEntity denunciaEncontrada : denuncias) {
			System.out.println(denunciaEncontrada);
		}

	}

}
