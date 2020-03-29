package com.github.fggreeff.connector;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import eventstore.akka.Settings;
import eventstore.j.EsConnection;
import eventstore.j.EsConnectionFactory;
import eventstore.j.SettingsBuilder;
import eventstore.akka.tcp.ConnectionActor;

import java.net.InetSocketAddress;

import static com.github.fggreeff.config.Constants.*;

public class EventStoreConnector {
    public static ActorRef getActorRefConnection(final ActorSystem system) {
        final Settings settings = new SettingsBuilder()
                .address(new InetSocketAddress(HOST_URL, PORT))
                .defaultCredentials(USERNAME, PASSWORD)
                .build();
        final ActorRef connection = system.actorOf(ConnectionActor.getProps(settings));
        return connection;
    }

    public static EsConnection getESConnection(final ActorSystem system) {
        final Settings settings = new SettingsBuilder()
                .address(new InetSocketAddress(HOST_URL, PORT))
                .defaultCredentials(USERNAME, PASSWORD)
                .build();
        final EsConnection connection = EsConnectionFactory.create(system, settings);
        return connection;
    }
}
