package com.load.test.simulation;

import io.gatling.javaapi.core.OpenInjectionStep;

import static com.load.test.Properties.PROPERTIES;
import static io.gatling.javaapi.core.CoreDsl.global;

public class GetUsers_AtOnceUsers extends SimulationHooks {

    public GetUsers_AtOnceUsers() {
        setUp(
                getUserScenario.injectOpen(OpenInjectionStep.atOnceUsers(PROPERTIES.maxUsers()))
                        .protocols(getUserHttpProtocol)
        ).assertions(
                global().responseTime().max().gte(PROPERTIES.maxResponseTime()),
                global().successfulRequests().percent().gte(PROPERTIES.successResponsePercent())
        );

    }
}
