package com.load.test.simulation;

import static com.load.test.Properties.PROPERTIES;
import static io.gatling.javaapi.core.CoreDsl.global;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;

public class GetUsers_RampUsers extends SimulationHooks {

    public GetUsers_RampUsers() {
        setUp(
                getUserScenario.injectOpen(rampUsers(PROPERTIES.maxUsers())
                                .during(PROPERTIES.duration()))
                        .protocols(getUserHttpProtocol)
        ).assertions(
                global().responseTime().max().lte(PROPERTIES.maxResponseTime()),
                global().successfulRequests().percent().gte(PROPERTIES.successResponsePercent())
        );
    }

}
