package br.com.jsf_primefaces_wildfly_crud.dao.common;

import javax.ejb.Stateless;

import br.com.jsf_primefaces_wildfly_crud.dto.common.GenericDTO;
import br.com.jsf_primefaces_wildfly_crud.models.GenericEntity;

@Stateless
public interface GenericDAOInterface<DTO extends GenericDTO, ENT extends GenericEntity> {
	
	public abstract ENT convertFromDTO(DTO dto);
	public abstract DTO convertFromEntity(ENT entity);

}
