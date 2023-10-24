package com.load.test.simulation;

import static com.load.test.Properties.PROPERTIES;
import static io.gatling.javaapi.core.CoreDsl.global;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;

public class CreateUsers_RampUsers extends SimulationHooks {

    public CreateUsers_RampUsers() {
        setUp(
                createUserScenario.injectOpen(rampUsers(PROPERTIES.maxUsers())
                                .during(PROPERTIES.duration()))
                        .protocols(getUserHttpProtocol)
        ).assertions(
                global().responseTime().max().gte(PROPERTIES.maxResponseTime()),
                global().successfulRequests().percent().gte(PROPERTIES.successResponsePercent())
        );
    }

}
