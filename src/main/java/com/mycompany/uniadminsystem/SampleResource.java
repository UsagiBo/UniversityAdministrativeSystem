package com.mycompany.uniadminsystem;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//import org.eclipse.microprofile.config.inject.ConfigProperty;
//@ApplicationPath("UniAdminSystem")
@Path("sample")
public class SampleResource {

	//@Inject
	//@ConfigProperty(name = "message") 
	private String message;

	@GET
        @Produces("text/html")
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
    }
	/*public Response message() {
		return Response.ok(message).build();
	}*/

}
