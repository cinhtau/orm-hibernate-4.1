package net.cinhtau;

import net.cinhtau.domain.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;

public class PersonRepositoryImpl implements PersonRepository {

    private static final Logger logger = LogManager.getLogger(PersonRepositoryImpl.class);

    EntityManager em;

    @Override
    public Person save(Person person) {
        this.em.persist(person);

        return person;
    }

    @Override
    public Person read(final Long id) {
        return this.em.find(Person.class, id);
    }

    @Override
    public void delete(final Long personId) {
        Person person = read(personId);

        this.em.remove(person);
        logger.info("Record {} removed", personId);
    }

    @Override
    public void addWorkHours(final Long id, final Long hours) {
        Person person = read(id);
        person.addHours(hours);
    }
}
