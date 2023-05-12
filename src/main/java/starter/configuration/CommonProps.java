package starter.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;
@Sources({
        "system:properties",
        "classpath:properties/${env}.properties"
})
@LoadPolicy(LoadType.MERGE)
public interface CommonProps extends Config {

    @Key("url")
    String baseUrl();

}
