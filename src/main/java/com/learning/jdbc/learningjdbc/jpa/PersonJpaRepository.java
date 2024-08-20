package com.learning.jdbc.learningjdbc.jpa;

import com.learning.jdbc.learningjdbc.data.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    //connect to db
    //entityManager

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id)
    {
        return entityManager.find(Person.class,id);
    }

    public Person update(Person person)
    {
        return entityManager.merge(person);
    }

    public void insertPerson(Person person)
    {
        entityManager.persist(person);
    }

    public void deleteById(int id)
    {
        Person person = findById(id);
        entityManager.remove(person);
    }

    public List<Person> findAll()
    {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons",Person.class);
        return namedQuery.getResultList();
    }


}
