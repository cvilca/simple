package pe.edu.unmsm.tesis;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pe.edu.unmsm.tesis.core.Parser;
import pe.edu.unmsm.tesis.model.CatalogoSintomas;
import pe.edu.unmsm.tesis.model.RequestEntity;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("service")
public class Service {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/catalogo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCatalogoSintomas() {
    	return Response.status(200).entity(CatalogoSintomas.catalogo).build();
    }
    
    
//    { "sintomas" :[{"nombre":"delirio"}]}
    
    @POST
    @Path("/evaluar")
    @Consumes(MediaType.APPLICATION_JSON)
	public Response evaluarSintomas(RequestEntity object) throws JSONException {
    	String initialFacts = null;
    	
    	try {
    		System.out.println("json object : " + object);
        	Parser parser = new Parser(object.getSintomas());
        	initialFacts = parser.getInitialFacts();
        	System.out.println("initial facts \n"+ initialFacts);	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
			
		}
    	
    	Ejecutor e = new Ejecutor(initialFacts);
    	String diagnostico = e.execute();
        return Response.status(200).entity(diagnostico).build();
	}
    
    
}
