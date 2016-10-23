package br.unip.urbanizacao.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unip.urbanizacao.business.DenunciaBusiness;
import br.unip.urbanizacao.exception.APIException;
import br.unip.urbanizacao.resource.DenunciaResource;
import br.unip.urbanizacao.resource.ErrorResource;

@Path("/denuncias")
@Produces(MediaType.APPLICATION_JSON)
public class DenunciaService {

	@GET
	public Response listarDenuncias() {
		try {
			final DenunciaBusiness denunciaBusiness = new DenunciaBusiness();
			final List<DenunciaResource> denuncias = denunciaBusiness.listarDenuncias();
			return Response.ok(denuncias).build();
		} catch (final APIException e) {
			return Response.status(e.getErrorCode()).entity(e.getResouce()).build();
		}
	}

	@GET
	@Path("{codigo:\\d+}")
	public Response obterDenuncia(@PathParam("codigo") final Long codigo) {
		try {
			final DenunciaBusiness denunciaBusiness = new DenunciaBusiness();
			final DenunciaResource denuncia = denunciaBusiness.obterPorCodigo(codigo);
			return Response.ok(denuncia).build();
		} catch (final APIException e) {
			return Response.status(e.getErrorCode()).entity(e.getResouce()).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarDenuncia(final DenunciaResource denunciaResource) {
		try {

			if (denunciaResource.getLocalizacao() == null) {
				return Response.status(Status.BAD_REQUEST)
						.entity(new ErrorResource(Status.BAD_REQUEST.getStatusCode(), "Localização não informada."))
						.build();
			}

			if (denunciaResource.getTipo() == null) {
				return Response.status(Status.BAD_REQUEST)
						.entity(new ErrorResource(Status.BAD_REQUEST.getStatusCode(), "Tipo de denúncia não informada."))
						.build();
			}

			final DenunciaBusiness denunciaBusiness = new DenunciaBusiness();
			final DenunciaResource denunciaGravada = denunciaBusiness.salvarDenuncia(denunciaResource);
			return Response.ok(denunciaGravada).build();
		} catch (final APIException e) {
			return Response.status(e.getErrorCode()).entity(e.getResouce()).build();
		}
	}
}
