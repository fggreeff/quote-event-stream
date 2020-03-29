package com.github.fggreeff.stream;

import akka.actor.AbstractActor;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import eventstore.core.EsException;
import eventstore.core.Event;
import eventstore.core.ReadEventCompleted;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ESReadResults extends AbstractActor {

    final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(ReadEventCompleted.class, m -> {
                    final Event event = m.event();
                    log.info("event: {}", event);

                    String eventType = event.data().eventType();
                    log.info("eventType: {}", eventType);

                    String eventRecord = event.record().toString();
                    log.info("eventRecord: {}", eventRecord);

                    String eventOccurred_at = event.created().toString();
                    log.info("eventOccurred_at: {}", eventOccurred_at);

                    String jsonBody = event.data().data().toString();
                    log.info("jsonBODY: {}", jsonBody);

                    String json = new String(event.data().data().value().toArray());
                    log.info("json: {}", json);

                    context().system().terminate();
                })
                .match(Status.Failure.class, f -> {
                    final EsException exception = (EsException) f.cause();
                    log.error(exception, exception.toString());
                    context().system().terminate();
                })
                .build();
    }
}
