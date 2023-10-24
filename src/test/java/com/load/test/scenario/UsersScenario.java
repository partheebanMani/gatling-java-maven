package com.load.test.scenario;

import com.load.test.Constants;
import com.load.test.feeders.UserFeeder;
import com.load.test.payload.UserPayload;
import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;

public class UsersScenario {

    public static ScenarioBuilder getUsersScenario() {
        return scenario("GET USER SCENARIO").exec(getUserChainBuilder());
    }

    public static ScenarioBuilder createUsersScenario() {
        return scenario("CREATE USER SCENARIO")
                .feed(UserFeeder.userFeeder()).exec(createUserChainBuilder());
    }

    public static ChainBuilder getUserChainBuilder() {
        return exec(
                http("GET USERS")
                        .get(Constants.USERS_PATH)
                        .asJson()
                        .check(status().is(HTTP_OK))
        );
    }

    public static ChainBuilder createUserChainBuilder() {
        return exec(
                http("CREATE USERS")
                        .post(Constants.USERS_PATH)
                        .asJson()
                        .body(StringBody(UserPayload.CREATE_PAYLOAD))
                        .check(status().is(HTTP_CREATED))
        );
    }

}
