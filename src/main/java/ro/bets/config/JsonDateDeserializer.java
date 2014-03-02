package ro.bets.config;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * Created by yozmo on 3/1/14.
 */
@Component
public class JsonDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public synchronized Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        return new Date();

    }

}
