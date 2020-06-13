package br.com.yurekesley.service;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.com.yurekesley.dao.DAO;
import lombok.Data;
import lombok.Getter;

public abstract @Data class Service<T> implements IService<T> {

    @Inject
    private Logger logger;

    @Inject
    @Getter
    protected DAO<T> dao;

    public void findAll() {
	this.getDao().findAll();
    }

}
