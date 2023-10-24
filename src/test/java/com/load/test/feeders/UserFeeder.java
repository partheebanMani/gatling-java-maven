package com.load.test.feeders;

import io.gatling.javaapi.core.FeederBuilder;

import static com.load.test.Constants.USER_PAYLOAD_PATH;
import static io.gatling.javaapi.core.CoreDsl.jsonFile;

public class UserFeeder {

    public static FeederBuilder.FileBased<Object> userFeeder() {
        return jsonFile(USER_PAYLOAD_PATH).circular();
    }
}
