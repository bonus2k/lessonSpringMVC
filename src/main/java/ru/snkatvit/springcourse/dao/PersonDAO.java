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
        personList.add(new Person(COUNT++, "Jon"));
        personList.add(new Person(COUNT++, "Vasy"));
        personList.add(new Person(COUNT++, "Mish"));
        personList.add(new Person(COUNT++, "Jack"));
        personList.add(new Person(COUNT++, "Bob"));
        personList.add(new Person(COUNT++, "Lena"));
    }

    public List<Person> index(){
        return personList;
    }

    public Person show(int id){
        return personList.stream()
                .filter(person->person.getId()==id)
                .findAny()
                .orElse(null);
    }
}
