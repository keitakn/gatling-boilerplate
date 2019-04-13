package qiita

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class FetchUsersItemsSimulation extends Simulation {
  val userFeeder = csv("qiita/users.csv").circular

  val httpProtocol = http
    .baseUrl("https://qiita.com")
    .acceptHeader("application/json")

  val scn = scenario("Fetch Qiita Users")
    .feed(userFeeder)
    .exec(
      http("fetch_user_request")
        .get("/api/v2/users/${userId}")
        .check(status.is(200))
        .check(jsonPath("$.id").saveAs("responseId")))
    .exec(
      session => {
        val responseUserId = session("responseId").as[String]
        println("fetch user response id = " + responseUserId)
        session
      }
    )
    .exec(
      http("fetch_user_items_request")
        .get("/api/v2/users/${responseId}/items")
        .check(status.is(200)))

  setUp(scn.inject(atOnceUsers(3)).protocols(httpProtocol))
}
