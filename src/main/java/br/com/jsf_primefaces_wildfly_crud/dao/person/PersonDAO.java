package br.com.jsf_primefaces_wildfly_crud.dao.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jsf_primefaces_wildfly_crud.dao.common.GenericDAOInterface;
import br.com.jsf_primefaces_wildfly_crud.dao.common.ConvertDAODTO;
import br.com.jsf_primefaces_wildfly_crud.dao.common.GenericDAO;
import br.com.jsf_primefaces_wildfly_crud.dto.common.GenericDTO;
import br.com.jsf_primefaces_wildfly_crud.dto.person.PersonDTO;
import br.com.jsf_primefaces_wildfly_crud.models.LogEntity;
import br.com.jsf_primefaces_wildfly_crud.models.Person;

@Stateless
//EJB para controlar a transação automaticamente
//@Stateless para não salvar o objeto após a chamada, é o normalmente utilizado
//@Stateful para manter o objeto na sessão, utilizado para carrinho de compras por exemplo
//@Startup @Singleton para executar somente uma vez na inicialização do sistema
//https://www.devmedia.com.br/ejb-introducao-ao-novo-enterprise-javabeans-3-2/30807
@LocalBean
//it's a way to permit to use implements class
public class PersonDAO extends GenericDAO implements Serializable, GenericDAOInterface<PersonDTO, Person>{

	private static final long serialVersionUID = -6321526905232236895L;
	
	public void save(PersonDTO personDTO) throws PersonDAOException{
		Person person = convertFromDTO(personDTO);
		
		if(person.getIdPerson() == null) {
			persist(person);
		}else {
			merge(person);
		}
	}
	
	public List<PersonDTO> listAll() {
		List<Person> listPerson = listAll(Person.class);
		List<PersonDTO> listPersonDTO = new ArrayList<PersonDTO>();
		for (Person person : listPerson) {
			listPersonDTO.add(convertFromEntity(person));
		}
		
		return listPersonDTO;
	}

	@Override
	public Person convertFromDTO(PersonDTO dto) {
		Person person = new Person();
		person.setIdPerson(dto.getIdPerson());
		person.setCpf(dto.getCpf());
		person.setDateBirth(dto.getDateBirth());
		person.setEmail(dto.getEmail());
		person.setName(dto.getName());
		person.setPhone(dto.getPhone());
		person.setLogEntity(ConvertDAODTO.convertLogDTOToLogEntity(dto.getLogDTO()));
		
		return person;
	}

	@Override
	public PersonDTO convertFromEntity(Person entity) {
		PersonDTO personDTO = new PersonDTO(
				entity.getIdPerson(), entity.getCpf(), entity.getDateBirth(), entity.getEmail(),
				entity.getName(), entity.getPhone()
		);
		personDTO.setLogDTO(ConvertDAODTO.convertLogEntityToLogDTO(entity.getLogEntity()));
		
		return personDTO;
	}

}
