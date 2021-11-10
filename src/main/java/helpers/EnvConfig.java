package helpers;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({"classpath:${env}.properties"})
public interface EnvConfig extends Config {

    EnvConfig ENV_CONFIG = ConfigFactory.create(EnvConfig.class, System.getenv(), System.getProperties());

    @Key("apiUrl")
    String getApiUrl();
}
