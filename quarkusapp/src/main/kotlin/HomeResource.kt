import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/")
class HomeResource {
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/")
    fun home(): Response {
        return Response.ok("Hello, World!").build()
    }
}