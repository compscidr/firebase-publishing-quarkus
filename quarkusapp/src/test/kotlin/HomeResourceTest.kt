import io.quarkus.test.common.http.TestHTTPEndpoint
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import jakarta.ws.rs.core.Response
import org.junit.jupiter.api.Test

@QuarkusTest
@TestHTTPEndpoint(HomeResource::class)
class HomeResourceTest {

    @Test
    fun `Test home endpoint`() {
        RestAssured.given()
            .`when`().get().then()
            .statusCode(Response.Status.OK.statusCode)
    }
}