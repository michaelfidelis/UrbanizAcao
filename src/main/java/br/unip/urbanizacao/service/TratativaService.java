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

import br.unip.urbanizacao.business.TratativaBusiness;
import br.unip.urbanizacao.exception.APIException;
import br.unip.urbanizacao.resource.DenunciaResource;
import br.unip.urbanizacao.resource.TratativaResource;

@Path("denuncias/{codigo:\\d+}/tratativas")
@Produces(MediaType.APPLICATION_JSON)
public class TratativaService {

	@GET
	public Response obterDenuncia(@PathParam("codigo") final Long codigo) {
		try {
			final TratativaBusiness tratativaBusiness = new TratativaBusiness();
			final List<TratativaResource> tratativas = tratativaBusiness.obterTratativas(codigo);

			return Response.ok(tratativas).build();
		} catch (final APIException e) {
			return Response.status(e.getErrorCode()).entity(e.getResouce()).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarDenuncia(@PathParam("codigo") final Long codigo, final TratativaResource tratativaResource) {
		try {
			final TratativaBusiness tratativaBusiness = new TratativaBusiness();
			tratativaResource.setDenuncia(new DenunciaResource(codigo));
			final TratativaResource tratativaGravada = tratativaBusiness.salvarTratativa(tratativaResource);
			return Response.ok(tratativaGravada).build();
		} catch (final APIException e) {
			return Response.status(e.getErrorCode()).entity(e.getResouce()).build();
		}
	}
}
