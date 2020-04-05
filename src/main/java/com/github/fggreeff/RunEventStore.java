package com.github.fggreeff;

import com.github.fggreeff.streams.ESReadEvent;
import com.github.fggreeff.streams.EventStoreSubscribeToAll;
import org.apache.log4j.Logger;

import static com.github.fggreeff.config.Constants.DEFAULT_EVENT_STREAM;

public class RunEventStore {

    static Logger logger = Logger.getLogger(RunEventStore.class);

    public static void main(String[] args) {
        logger.info("Starting app...");

        // TODO: Not necessary to subscribe to all topics
        // Subscribe to all streams.
//        EventStoreSubscribeToAll esSubscriber = new EventStoreSubscribeToAll();
//        esSubscriber.subscribeToAll();

        // Read the events from a stream
        ESReadEvent esReadEvent = new ESReadEvent();
        esReadEvent.readEvent(DEFAULT_EVENT_STREAM, 997);

        //        esSubscriber.closeSubscriber();
        logger.info("Closing app...");
    }
}
