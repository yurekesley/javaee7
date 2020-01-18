package br.com.yurekesley.feature.extensions;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ObserverMethod;
import javax.enterprise.inject.spi.ProcessObserverMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventoAssincronoExtension implements Extension {

    private Logger logger = LoggerFactory.getLogger(EventoAssincronoExtension.class);

    public void analisaObservers(@Observes ProcessObserverMethod pom) {
	ObserverMethod observerMethod = pom.getObserverMethod();
	logger.info("Método {} é um observer" + observerMethod);
    }

}
