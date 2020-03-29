package com.github.fggreeff.stream;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import eventstore.akka.Settings;
import eventstore.akka.tcp.ConnectionActor;
import eventstore.core.EsException;
import eventstore.core.Event;
import eventstore.core.ReadEvent;
import eventstore.core.ReadEventCompleted;
import eventstore.j.ReadEventBuilder;
import eventstore.j.SettingsBuilder;
import org.apache.log4j.Logger;

import java.net.InetSocketAddress;

public class EventStoreStream {

    static Logger logger = Logger.getLogger(EventStoreStream.class);

    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create();
        final Settings settings = new SettingsBuilder()
                .address(new InetSocketAddress("127.0.0.1", 1113))
                .defaultCredentials("admin", "changeit")
                .build();
        final ActorRef connection = system.actorOf(ConnectionActor.getProps(settings));
        final ActorRef readResult = system.actorOf(Props.create(EventStoreStream.ReadResult.class));

//        System.out.println(readResult.toString());

        final ReadEvent readEvent = new ReadEventBuilder("my-stream")
                .first()
                .resolveLinkTos(false)
                .requireMaster(true)
                .build();

        connection.tell(readEvent, readResult);
    }

    public static class ReadResult extends AbstractActor {
        final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(ReadEventCompleted.class, m -> {
                        final Event event = m.event();
                        log.info("event: {}", event);
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
}
    }
}
