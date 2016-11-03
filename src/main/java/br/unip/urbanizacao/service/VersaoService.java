package br.unip.urbanizacao.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("versao")
@Produces(MediaType.APPLICATION_JSON)
public class VersaoService {

	@GET
	public Response obterVersao() {
		return Response.ok("{\"api\":\"Urbanização\", \"versao\":\"1.0.0\"}").build();
	}
}
