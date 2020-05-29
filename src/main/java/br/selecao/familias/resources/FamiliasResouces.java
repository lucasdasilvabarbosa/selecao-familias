package br.selecao.familias.resources;

import br.selecao.familias.resources.dto.FamiliaDTO;
import br.selecao.familias.service.FamiliaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("familias")
@Api(value = "Familias", protocols = "http", tags = "Familias")
public class FamiliasResouces {

    @EJB
    private FamiliaService familiaService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Logs de integração com CRD",
            notes = "buscar categoria por id",
            response = Response.class)
    public Response testeFamilias(List<FamiliaDTO> familias) {
        return Response.ok().entity(familiaService.aplicarPontuacao(familias)).build();
    }
}
