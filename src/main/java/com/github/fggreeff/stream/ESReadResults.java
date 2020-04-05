package com.github.fggreeff.stream;

import akka.actor.AbstractActor;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.github.fggreeff.processors.FeeApplied;
import com.github.fggreeff.transform.Transform;
import eventstore.core.Content;
import eventstore.core.EsException;
import eventstore.core.Event;
import eventstore.core.ReadEventCompleted;

public class ESReadResults extends AbstractActor {

    final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    Transform trans = new Transform();

    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(ReadEventCompleted.class, m -> {
                    final Event event = m.event();
                    log.info("event: {}", event);

                    String eventType = event.data().eventType();
                    log.info("eventType: {}", eventType);

                    String eventOccurred_at = event.created().toString();
                    log.info("eventOccurred_at: {}", eventOccurred_at);

                    Content content = event.data().data();
                    if (content.contentType().toString() == "ContentType.Json") {
                        final String payloadString = content.value().utf8String();
                        trans.parseJsonToObject(payloadString, FeeApplied.class);
                    }

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
