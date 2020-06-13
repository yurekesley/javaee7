package br.com.yurekesley.feature.interceptors;

import javax.inject.Inject;

import org.slf4j.Logger;

@Auditavel
public class AuditavelImpl implements IAuditavel{
    
    @Inject
    Logger logger;
    
    public void metodoAuditado() {
	logger.info("Executando o médodo interceptado");
    }

}
