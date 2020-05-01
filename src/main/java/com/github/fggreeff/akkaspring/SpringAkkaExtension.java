package com.github.fggreeff.akkaspring;

import akka.actor.Extension;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/*
Example of spring + akka in:
  https://github.com/chriniko13/spring-boot-akka-example/blob/master/src/main/java/com/chriniko/example/
 */
@Component
public class SpringAkkaExtension implements Extension {

  private ApplicationContext applicationContext;

  public void initialize(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  public Props props(String actorBeanName) {
    return Props.create(SpringActorProducer.class, applicationContext, actorBeanName);
  }

  public static String classNameToSpringName(Class<?> clazz) {

    String simpleName = clazz.getSimpleName();

    return simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);
  }
}
