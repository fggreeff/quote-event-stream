package com.github.fggreeff.transformers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eventstore.core.Content;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
  *  eventToQuote deserialize the json received from the event to a Java domain object
 */
public class Transformer<T> {

    final ObjectMapper objectMapper = new ObjectMapper();
    static Logger logger = Logger.getLogger(Transformer.class);


    public T deserializeEvent(final String jsonObject, Class<T> classType) throws IOException {

            T object = (T) objectMapper.readValue(jsonObject, classType);
            logger.info("Deserializing json to object:  " + object.getClass().getName());

            return object;
    }

    public String payloadString(Content content) {
        String payloadString = "";

        if ("ContentType.Json".equals(content.contentType().toString())) {
            payloadString = content.value().utf8String();
        }
        return payloadString;
    }
}
