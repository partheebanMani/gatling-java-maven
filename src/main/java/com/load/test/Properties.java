package com.load.test;

import com.load.test.propsconverter.TestEnvConverter;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:env",
        "system:properties",
        "classpath:general.properties",
        "classpath:${test.env}.properties"
})
public interface Properties extends Config {

    Properties PROPERTIES = ConfigFactory.create(Properties.class);

    @Key("test.env")
    @ConverterClass(TestEnvConverter.class)
    TestEnv testEnv();

    @Key("application.url")
    String applicationUrl();

    @Key("max.response.time")
    Integer maxResponseTime();

    @Key("success.percent")
    Double successResponsePercent();

    @Key("max.users")
    Integer maxUsers();

    @Key("duration")
    Integer duration();


}
