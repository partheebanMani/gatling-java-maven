package com.load.test.simulation;

import com.load.test.protocol.HttpProtocols;
import com.load.test.scenario.UsersScenario;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimulationHooks extends Simulation {

    ScenarioBuilder getUserScenario = UsersScenario.getUsersScenario();

    ScenarioBuilder createUserScenario = UsersScenario.createUsersScenario();
    HttpProtocolBuilder getUserHttpProtocol = HttpProtocols.getHttpProtocol();

    @Override
    public void before() {
        log.info("Simulation about to start...");
    }

    @Override
    public void after() {
        log.info("Simulation ends successfully...");
    }
}
