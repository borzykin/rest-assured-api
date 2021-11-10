package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.EnvConfig.ENV_CONFIG;

public class BaseService {
    protected final RequestSpecification requestSpec;
    protected final ResponseSpecification responseSpec;

    public BaseService() {
        var config = RestAssuredConfig.config()
                .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON));
        this.requestSpec = new RequestSpecBuilder()
                .setConfig(config)
                .setBaseUri(ENV_CONFIG.getApiUrl())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        this.responseSpec = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
