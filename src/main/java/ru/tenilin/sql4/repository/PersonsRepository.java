package ru.tenilin.sql4.repository;

import org.springframework.stereotype.Repository;
import ru.tenilin.sql4.entity.Persons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Persons> getPersonByCity(String city) {
        Query query = entityManager.createQuery("select p from Persons p where p.cityOfLiving = :city", Persons.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}
