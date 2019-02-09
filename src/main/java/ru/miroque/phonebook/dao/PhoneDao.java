package ru.miroque.phonebook.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityGraph;
import javax.persistence.criteria.CriteriaQuery;

import ru.miroque.phonebook.dto.DtoFullPhoneRecord;
import ru.miroque.phonebook.entities.Phone;

@RequestScoped
public class PhoneDao extends DaoImpl<Phone, Integer> implements Serializable {
	private static final long serialVersionUID = 5567454653205368551L;

	public PhoneDao() {
		super(Phone.class);
	}

	public List<Phone> getForView() {
		final EntityGraph<Phone> entityGraph = em().createEntityGraph(Phone.class);
		entityGraph.addAttributeNodes("division");
		final CriteriaQuery<Phone> criteriaQuery = em().getCriteriaBuilder().createQuery(Phone.class);
		criteriaQuery.select(criteriaQuery.from(Phone.class));
		return em().createQuery(criteriaQuery).setHint("javax.persistence.fetchgraph", entityGraph) .getResultList();
	}

	public List<DtoFullPhoneRecord> getAllPhonesForView() {
		List<DtoFullPhoneRecord> postDTOs = em()
				.createQuery(
				    "select new " +
				    "   ru.miroque.phonebook.dto.DtoFullPhoneRecord(" +
				    "       a.fio, " +
				    "       p.number, " +
				    "       p.code, " +
				    "       d.name " +
				    "   ) " +
				    "from Phone p " +
				    "left join p.division d " +
				    "left join Account a on a.phone = p", DtoFullPhoneRecord.class)
				.getResultList();
		
		return postDTOs;
	}
}
