package com.github.fggreeff.streams;

import akka.actor.ActorSystem;
import java.io.Closeable;
import java.io.IOException;

import eventstore.j.EsConnection;
import eventstore.core.IndexedEvent;
import eventstore.akka.SubscriptionObserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.fggreeff.connectors.EventStoreConnector;

public class EventStoreSubscribeToAll {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventStoreSubscribeToAll.class);

    private Closeable closeable;
    private ActorSystem system;

    public void subscribeToAll() {
        system = ActorSystem.create();
        final EsConnection connection = EventStoreConnector.getESConnection(system);
        closeable = connection.subscribeToAll(new SubscriptionObserver<IndexedEvent>() {

            @Override
            public void onLiveProcessingStart(Closeable subscription) {
                LOGGER.info("Live processing started for subscription {}", subscription);
            }

            @Override
            public void onEvent(IndexedEvent event, Closeable subscription) {
                LOGGER.info("Event received {}", event);
                LOGGER.info("Event eventId {} eventType {} metadata {} data {} streamId {}",
                        event.event().data().eventId(),
                        event.event().data().eventType(),
                        event.event().data().metadata(),
                        event.event().data().data(),
                        event.event().streamId().streamId());

                final String streamId = event.event().streamId().streamId();

                // skip streams that contain $
                if (streamId.contains("$")) {
                    LOGGER.info("skipping " + streamId);
                    return;
                }
            }


            @Override
            public void onError(Throwable e) {
                LOGGER.error("Error received {}", e.getMessage());
            }

            @Override
            public void onClose() {
                LOGGER.info("Closing eventstore subscription");
            }
        }, false, null);
    }

    public void closeSubscriber() {
        LOGGER.info("Closing subscription...");
        try {
            closeable.close();
        } catch (IOException e) {
            LOGGER.error("Cannot close eventstore subscription", e.getMessage());
            throw new RuntimeException(e);
        }
        closeable = null;
    }
}
