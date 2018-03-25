
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class BenchGRPCStream extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:3000")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

    val uri1 = "http://localhost:3000/test_stream"

  val scn = scenario("BenchGRPC").repeat(1000) {
    exec(http("request_0").get("/test_stream"))
  }

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}