package net.cinhtau;

import net.cinhtau.domain.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryImplTest extends JPAHibernateTest {

    private static PersonRepositoryImpl personRepository;

    static Long testPersonId;
    static Long deletePersonId;
    static Long updatePersonId;

    @BeforeAll
    static void initPersonRepository() {
        personRepository = new PersonRepositoryImpl();
        personRepository.em = em;

        Person barry = new Person();
        barry.setFirstName("Barry");
        barry.setLastName("Dylan");
        personRepository.save(barry);
        testPersonId = barry.getId();

        Person otherBarry = new Person();
        otherBarry.setFirstName("OtherBarry");
        otherBarry.setLastName("Bionic");
        personRepository.save(otherBarry);
        deletePersonId = otherBarry.getId();

        Person sterling = new Person();
        sterling.setFirstName("Sterling");
        sterling.setLastName("Archer");
        personRepository.save(sterling);
        updatePersonId = sterling.getId();
    }

    @Test
    void create() {
        // given
        Person person = new Person();
        person.setFirstName("Vinh");
        person.setLastName("Nguyen");
        // when
        Person actual = personRepository.save(person);
        // then
        assertNotNull(actual.getId(), "Unique Id is set");
        assertNotNull(actual.getVersion(), "Version is set");
    }

    @Test
    void read() {
        // given

        // when
        Person barry = personRepository.read(testPersonId);
        // then
        assertEquals("Barry", barry.getFirstName());
        assertEquals("Dylan", barry.getLastName());
    }

    @Test
    void update() {
        // given
        Person person = personRepository.read(updatePersonId);
        person.setFirstName("Arthur");
        person.setLastName("Woodhouse");
        // when
        Person actual = personRepository.save(person);
        // then
        assertEquals("Woodhouse", actual.getLastName());
    }

    @Test
    void delete() {
        // given
        personRepository.delete(deletePersonId);
        // when
        Person otherBarry = personRepository.read(deletePersonId);
        // then
        assertNull(otherBarry, "Other Barry does not exists");
    }
}