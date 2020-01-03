package br.com.yurekesley.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GenericDAO<T> implements DAO<T> {

    private Logger logger = LoggerFactory.getLogger(GenericDAO.class);

    public void findAll() {
	logger.debug("findAll");
    }
}
