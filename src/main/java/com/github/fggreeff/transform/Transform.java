package com.github.fggreeff.transform;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fggreeff.processors.FeeApplied;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Transform<T> {

    final ObjectMapper objectMapper = new ObjectMapper();
    static Logger logger = Logger.getLogger(FeeApplied.class);

    public void parseJsonToObject(final String jsonObject, T eventProcessorClass) throws JsonProcessingException {
        try {
             // TODO: Make this accept a generic class
            FeeApplied fee_applied = objectMapper.readValue(jsonObject, FeeApplied.class);
            logger.info("getQuoteId: " + fee_applied.getQuoteId() + " getFee " + fee_applied.getFee());

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
