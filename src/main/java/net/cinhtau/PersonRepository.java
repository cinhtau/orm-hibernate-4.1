package net.cinhtau;

import net.cinhtau.domain.Person;

public interface PersonRepository {

    Person save(Person person);

    Person read(Long id);

    void delete(Long personId);

    void addWorkHours(Long id, Long hours);
}
