package com.github.fggreeff.streams;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.github.fggreeff.connectors.EventStoreConnector;
import eventstore.core.ReadEvent;
import eventstore.j.ReadEventBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.fggreeff.akkaspring.SpringExtension.SPRING_EXTENSION_PROVIDER;

public class ESReadEvent {

    private static final Logger log = LoggerFactory.getLogger(ESReadEvent.class);

    public void readEvent(final String streamName, final Integer eventNumber) {
        log.info("Reading event - stream name [{}].", streamName);

        final ActorSystem system = ActorSystem.create();
        final ActorRef connection = EventStoreConnector.getActorRefConnection(system);
        final ActorRef readResult = system.actorOf(SPRING_EXTENSION_PROVIDER.get(system).props("ESReadResult").create(ESReadResult.class));


        final ReadEvent readEvent = new ReadEventBuilder(streamName)
                .number(eventNumber)
                .resolveLinkTos(false)
                .requireMaster(true)
                .build();

        connection.tell(readEvent, readResult);
        log.info("Read event.");
    }
}
