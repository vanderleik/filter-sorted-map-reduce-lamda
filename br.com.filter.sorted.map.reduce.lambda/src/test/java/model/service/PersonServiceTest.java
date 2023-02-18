package model.service;

import entities.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PersonServiceTest {

    @Test
    void testFilteredSum() {
        PersonService ps = new PersonService();
        Person person1 = new Person();
        person1.setName("Vanderlei");
        person1.setEmail("vanderlei@vanderlei.com.br");
        person1.setSalary(2000.0);

        Person person2 = new Person();
        person2.setName("Gabi Gol");
        person2.setEmail("gabigol@gabigol.com.br");
        person2.setSalary(3000.0);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);

        double sum = ps.filteredSum(personList, p -> p.getName().charAt(0) == 'V');

        assertEquals(person1.getSalary(), sum);
        assertNotEquals(person2.getSalary(), sum);
    }

}