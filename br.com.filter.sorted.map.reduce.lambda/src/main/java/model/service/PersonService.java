package model.service;

import entities.Person;

import java.util.List;
import java.util.function.Predicate;

public class PersonService {
    public double filteredSum(List<Person> personList, Predicate<Person> criteria) {
        double sum = 0.0;
        for (Person p : personList) {
            if (criteria.test(p)) {
                sum += p.getSalary();
            }
        }
        return sum;
    }
}
