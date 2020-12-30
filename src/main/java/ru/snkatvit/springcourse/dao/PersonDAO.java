package ru.snkatvit.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.snkatvit.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int COUNT = 0;
    List<Person> personList;

    {
        personList = new ArrayList<>();
        personList.add(new Person(COUNT++, "Jon", 18, "jon@mail.com"));
        personList.add(new Person(COUNT++, "Vasy", 40, "vasya@mail.com"));
        personList.add(new Person(COUNT++, "Mish", 30, "misha@mail.com"));
        personList.add(new Person(COUNT++, "Jack", 23, "jack@mail.com"));
        personList.add(new Person(COUNT++, "Bob", 34, "bob@mail.com"));
        personList.add(new Person(COUNT++, "Lena", 41, "lena@mail.com"));
    }

    public void save(Person person) {
        person.setId(COUNT++);
        personList.add(person);
    }

    public List<Person> index() {
        return personList;
    }

    public Person show(int id) {
        return personList.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void update(int id, Person personUpdate) {
        personList.removeIf(person -> person.getId() == id);
        personList.add(personUpdate);
    }

    public void delete(int id) {
        personList.removeIf(person -> person.getId() == id);
    }
}
