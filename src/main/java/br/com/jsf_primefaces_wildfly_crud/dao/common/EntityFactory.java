package br.com.jsf_primefaces_wildfly_crud.dao.common;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@ApplicationScoped
public class EntityFactory {

    @PersistenceContext(unitName = "jsf-primefaces-wildfly-crud")
    private EntityManager em;
	
	public EntityFactory() {
		// TODO Auto-generated constructor stub
	}
	
    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        return em;
    }

}
