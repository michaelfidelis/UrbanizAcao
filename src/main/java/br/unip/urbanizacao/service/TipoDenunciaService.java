package br.unip.urbanizacao.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unip.urbanizacao.business.TipoDenunciaBusiness;
import br.unip.urbanizacao.exception.APIException;
import br.unip.urbanizacao.resource.TipoDenunciaResource;

@Path("/tiposdenuncia")
@Produces(MediaType.APPLICATION_JSON)
public class TipoDenunciaService {

	@GET
	public Response listarTiposDenuncias() {
		try {
			final TipoDenunciaBusiness tipoDenunciaBusiness = new TipoDenunciaBusiness();
			final List<TipoDenunciaResource> tiposDenuncia = tipoDenunciaBusiness.listarTiposDenuncia();
			return Response.ok(tiposDenuncia).build();
		} catch (final APIException e) {
			return Response.status(e.getErrorCode()).entity(e.getResouce()).build();
		}
	}

	@GET
	@Path("{codigo:\\d+}")
	public Response obterTipoDenuncia(@PathParam("codigo") final Long codigo) {
		try {
			final TipoDenunciaBusiness tipoDenunciaBusiness = new TipoDenunciaBusiness();
			final TipoDenunciaResource tipoDenuncia = tipoDenunciaBusiness.obterPorCodigo(codigo);
			return Response.ok(tipoDenuncia).build();
		} catch (final APIException e) {
			return Response.status(e.getErrorCode()).entity(e.getResouce()).build();
		}
	}

}
