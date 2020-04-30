package com.github.fggreeff;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.github.fggreeff.akkaspring.SpringAkkaExtension;
import com.github.fggreeff.connectors.EventStoreConnector;
import com.github.fggreeff.streams.ESReadEvent;
import com.github.fggreeff.streams.ESReadResult;
import com.github.fggreeff.streams.EventStoreSubscribeToAll;
import eventstore.core.ReadEvent;
import eventstore.j.ReadEventBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static com.github.fggreeff.config.Constants.DEFAULT_EVENT_STREAM;

@SpringBootApplication
public class RunEventStore {

    static Logger logger = Logger.getLogger(RunEventStore.class);

    public static void main(String[] args) {

        // setting up actor system
        ConfigurableApplicationContext context = SpringApplication.run(RunEventStore.class, args);
        ActorSystem system = context.getBean(ActorSystem.class);
        SpringAkkaExtension springAkkaExtension = context.getBean(SpringAkkaExtension.class);



        logger.info("Starting app...");

        // TODO: Not necessary to subscribe to all topics
        // Subscribe to all streams.
//        EventStoreSubscribeToAll esSubscriber = new EventStoreSubscribeToAll();
//        esSubscriber.subscribeToAll();

        // Read the events from a stream
        //ESReadEvent esReadEvent = new ESReadEvent();
        //esReadEvent.readEvent(DEFAULT_EVENT_STREAM, 997);


        final ActorRef connection = EventStoreConnector.getActorRefConnection(system);
        final ActorRef readResult = system.actorOf(springAkkaExtension.props(SpringAkkaExtension.classNameToSpringName(ESReadResult.class)));
        final ReadEvent readEvent = new ReadEventBuilder(DEFAULT_EVENT_STREAM)
            .number(997)
            .resolveLinkTos(false)
            .requireMaster(true)
            .build();

        connection.tell(readEvent, readResult);




        //        esSubscriber.closeSubscriber();
        logger.info("Closing app...");
    }
}
