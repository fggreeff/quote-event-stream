package com.github.fggreeff.streams;

import akka.actor.AbstractActor;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.github.fggreeff.domains.QuoteProductsUpdated;
import com.github.fggreeff.domains.QuoteStarted;
import com.github.fggreeff.processors.ToMapProcessor;
import com.github.fggreeff.transformers.Transformer;
import eventstore.core.EsException;
import eventstore.core.Event;
import eventstore.core.ReadEventCompleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ESReadResult extends AbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private Transformer trans = new Transformer();

    @Autowired
    private ToMapProcessor mapProcessor;// TODO: This class needs to be instantiated with spring

//    public ESReadResult(ToMapProcessor mapProcessor) {
//        this.mapProcessor = mapProcessor;
//    }

    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(ReadEventCompleted.class, m -> {
                    final Event event = m.event();
                    String eventType = event.data().eventType();
                    log.info("eventType: {}", eventType);
                    String jsonEventObject = trans.payloadString(event.data().data());

                    // TODO: Look at akka actors for pattern matching of different class
                    if ("quote_started".equals(eventType)) {
                            QuoteStarted quoteStarted = (QuoteStarted) trans.deserializeEvent(jsonEventObject, QuoteStarted.class);
                            log.info(quoteStarted.toString());
                            mapProcessor.processQuoteStarted(quoteStarted, eventType);

                    } else if ("quote_products_updated".equals(eventType)) {
                        QuoteProductsUpdated quoteProductsUpdated = (QuoteProductsUpdated) trans.deserializeEvent(jsonEventObject, QuoteProductsUpdated.class);
                        log.info(quoteProductsUpdated.toString());
                        mapProcessor.processQuoteStarted(quoteProductsUpdated);
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
